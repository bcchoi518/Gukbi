package com.cbc.springPortfolio.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.tika.Tika;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

public class MultipartUpload {
	String attachPath = Constants.ATTACH_PATH;
	int maxUpload = Constants.MAX_UPLOAD;

/*
	Servers > server.xml
	<Context docBase="파일 저장경로" path="/프로젝트명/attach" reloadable="true" />
	
	appServlet > servlet-context.xml
	<!-- 파일업로드에 필요한 bean -->
	<beans:bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
	<!-- max upload size in bytes / 10MB 10*1024*1024 -->
    <!-- <beans:property name="maxUploadSize" value="10485760" /> -->
	    
    <!-- 디스크에 임시 파일을 생성하기 전에 메모리에 보관할수있는 최대 바이트 크기  (in bytes) / 1MB -->
    <!-- <beans:property name="maxInMemorySize" value="1048576" /> -->
			<beans:property name="defaultEncoding" value="utf-8" />
		 </beans:bean>
*/
	
	private int createDirectory(String uploadPath)
	{
		File isDir = new File(uploadPath);
		if (!isDir.isDirectory()) {
			isDir.mkdirs();
		}//if
		int result = 0;
		if (isDir.exists()) {
			result++;
		}//if
		return result;
	}//createDirectory
	
	//파일 이름이 중복되지 않도록 처리
	private String attachFileReName(String originalFileName, byte[] fileData, String uploadPath)
	{
		if (originalFileName.lastIndexOf(".") == -1) {
			return "";
		}//if
		
		String ext = originalFileName.substring(originalFileName.lastIndexOf(".")).toLowerCase();
		
		//UUID생성 (Universal Unique IDentifier, 범용 고유 식별자)
		UUID uuid = UUID.randomUUID();
		
		String newFileName = uuid.toString() + ext;
		
		File f1 = new File(uploadPath, newFileName);
		
		try {
			//임시 디렉토리에 저장된 업로드된 파일을 지정된 디렉토리로 복사
			//FileCopyUtils.copy(바이트배열, 파일객체);
			FileCopyUtils.copy(fileData, f1);
		} catch (Exception e) {
			e.printStackTrace();
		}//try-catch
		
		return newFileName;
	}//attachFileReName
	
	public List<String> attachProc(List<MultipartFile> multiFileList, String savePath)
	{
		String uploadPath = attachPath + savePath; // savePath: /springStudy/member (프로젝트별, 단위프로그램별 폴더를 별도로 구성하기 위함)
		
		int createDirResult = createDirectory(uploadPath);
		if (createDirResult <= 0) {
			System.out.println("디렉토리가 존재하지 않습니다.");
		}//if
		
		List<String> list = new ArrayList<>();
		
		for (int i = 0; i < multiFileList.size(); i++) {
			MultipartFile file = multiFileList.get(i);
			
			String originalFileName = "";
			String newFileName = "";
			long fileSize = 0;
			String contentType ="";
			String mimeType = "";
			try {
				originalFileName = file.getOriginalFilename();
				newFileName = attachFileReName(originalFileName, file.getBytes(), uploadPath);
				fileSize = file.getSize();
				contentType = file.getContentType();
				
				InputStream inputStream;
				inputStream = file.getInputStream();
				Tika tika = new Tika();
				mimeType = tika.detect(inputStream);
			} catch (Exception e) {
				e.printStackTrace();
			}//try-catch
			
			if (contentType.equals(mimeType) && !newFileName.equals("")) {
				String msg = "";
				msg += originalFileName + ",";
				msg += newFileName + ",";
				msg += fileSize + ",";
				msg += contentType + ",";
				msg += mimeType;
				list.add(msg);
			} else {
				File deleteFile = new File(uploadPath + "/" + newFileName);
				if (deleteFile.exists()) {
					deleteFile.delete();
				}//if
			}//if
		}//for
		return list;
	}//attachProc
	
	public void attachDownload(
			HttpServletResponse response,
			String originalName,
			String saveName,
			String savePath
			) 
	{
		try {
			String uploadPath = attachPath + savePath + "/" + saveName;
			
			File file = new File(uploadPath);
			originalName = new String(originalName.getBytes("UTF-8"), "ISO-8859-1"); // Chrome, Opera, FireFox 한글깨짐 방지
        	response.setHeader("Content-Disposition", "attachment;filename=" + originalName);
        	
        	FileInputStream fileInputStream = new FileInputStream(uploadPath);
        	OutputStream out = response.getOutputStream();
        	
        	int read = 0;
            byte[] buffer = new byte[1024];
            while ((read = fileInputStream.read(buffer)) != -1) {
            	out.write(buffer, 0, read);
            }//while
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("download error...");
		}//try-catch
	}//attachDownload
}//MultipartUpload

package com.cbc.springStudy._common;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.tika.Tika;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

public class MultipartUpload {
	String attachPath = Constants.ATTACH_PATH;
	int maxUpload = Constants.MAX_UPLOAD;

/*
	Servers > server.xml
	<Context docBase="파일 저장경로" path="/프로젝트명/attach" reloadable="true" />
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
			
			if (contentType.equals(mimeType)) {
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
}//MultipartUpload

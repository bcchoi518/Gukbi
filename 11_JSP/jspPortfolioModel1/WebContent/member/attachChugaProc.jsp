<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "_inc_top.jsp" %>

<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>

<%@page import="java.io.File"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.UUID"%>

<%@page import="member.model.dto.MemberDTO"%>
<%@page import="member.model.dao.MemberDAO"%>

<%
	request.setCharacterEncoding("UTF-8");

	String attachPath = "C:/cbc/attach";
	String uploadPath = attachPath + request.getContextPath() + "/member";
	int maxUpload = 1024 * 1024 * 100;
	String encoding = "UTF-8";
	
	// MultipartRequest 인스턴스 생성 (cos.jar의 라이브러리)
	MultipartRequest multi = new MultipartRequest(
		request,
		uploadPath,	//파일저장경로
		maxUpload,	//파일최대용량
		encoding,	//인코딩타입
		new DefaultFileRenamePolicy()	//중복파일처리(동일파일명 업로드시 뒤에 숫자를 붙임)
	);
	
	String id = multi.getParameter("id");
	String passwd = multi.getParameter("passwd");
	String passwdChk = multi.getParameter("passwdChk");
	String name = multi.getParameter("name");
	String phone = multi.getParameter("phone");
	String email = multi.getParameter("email");
	String jumin1 = multi.getParameter("jumin1");
	String jumin2 = multi.getParameter("jumin2");
	String juso1 = multi.getParameter("juso1");
	String juso2 = multi.getParameter("juso2");
	String juso3 = multi.getParameter("juso3");
	String juso4 = multi.getParameter("juso4");
	String grade = multi.getParameter("grade");

	String jumin = jumin1 + "-" + jumin2;
	
	if (juso4 == null || juso4.trim().equals("")) {
		juso4 = "-";
	}//if
	
	String attachInfo = "";
	try {
		Enumeration<String> files = multi.getFileNames();	//전송한 전체 파일이름을 가져온다
		while (files.hasMoreElements()) {
			String tagName = "";
			String fileOriginalName = "";
			String fileSavedName = "";
			String fileType = "";
			String fileSize = "";
			String fileExtName = ""; // .png .jpg .jpeg .gif
			String newFileName = "";
			
			// form 태그에서 <input type="file" name="[지정된이름]" />을 가져온다
			tagName = (String) files.nextElement();
			// input file name에 해당하는 실제 파일을 가져옴
			File fileObj = multi.getFile(tagName);
			
			String imsiResult = "";
			if (fileObj != null) { // 해당 tagName에 파일을 첨부했으면...
				fileOriginalName = multi.getOriginalFileName(tagName);
				fileSavedName = multi.getFilesystemName(tagName);
				fileType = multi.getContentType(tagName);
				fileSize = String.valueOf(fileObj.length());
				fileExtName = fileSavedName.substring(fileSavedName.lastIndexOf(".") + 1);
				
				int errorImgCounter = 0;
				if (fileExtName.toLowerCase().equals("png")) {
					
				} else if (fileExtName.toLowerCase().equals("jpg")) {
					
				} else if (fileExtName.toLowerCase().equals("jpeg")) {
					
				} else if (fileExtName.toLowerCase().equals("gif")) {
					
				} else {
					errorImgCounter++;
				}//if
				
				if (errorImgCounter > 0) {
					String deleteFilePath = uploadPath + "/" + fileSavedName;
					java.io.File f = new java.io.File(deleteFilePath);
					if (f.delete()) {
						//파일 삭제 성공..
					} else {
						//파일 삭제 실패..
					}//if
					
					fileOriginalName = "";
					fileSavedName = "";
					fileType = "";
					fileSize = "";
					continue;
				}//if
				
				newFileName = UUID.randomUUID().toString() + "." + fileExtName; //새로 생성할 파일이름..
				String oldFilePath = uploadPath + "/" + fileSavedName;	//기존에 저정된 파일..
				String newFilePath = uploadPath + "/" + newFileName;	//기존에 저장된 파일을 여기이름으로 바꿔서 저장..
				File f1 = new File(oldFilePath);
				if (f1.exists()) {
					File newFile = new File(newFilePath);
					f1.renameTo(newFile);
					fileSavedName = newFileName;
				}//if
				
				if (!attachInfo.trim().equals("")) {
					attachInfo += ",";
				}//if
				attachInfo += fileOriginalName + "|";
				attachInfo += fileSavedName + "|";
				attachInfo += fileType + "|";
				attachInfo += fileSize;
			}//if
		}//while
		out.println(attachInfo);
		out.println("<br>");
	} catch (Exception e) {
		e.printStackTrace();	
	}//try-catch
	
	MemberDTO memberArguDto = new MemberDTO();
	memberArguDto.setId(id);
	memberArguDto.setPasswd(passwd);
	memberArguDto.setName(name);
	memberArguDto.setPhone(phone);
	memberArguDto.setEmail(email);
	memberArguDto.setJumin(jumin);
	memberArguDto.setJuso1(juso1);
	memberArguDto.setJuso2(juso2);
	memberArguDto.setJuso3(juso3);
	memberArguDto.setJuso4(juso4);
	memberArguDto.setGrade(grade);
	memberArguDto.setAttachInfo(attachInfo);
	
	MemberDAO memberDao = new MemberDAO();
	int result = memberDao.setInsert(memberArguDto);
	
	if (result > 0) {
		out.println("<script>");
		out.println("location.href='main.jsp?menuGubun=member_list';");
		out.println("</script>");
	} else {
		out.println("<script>");
		out.println("alert('등록 중 오류가 발생했습니다.');");
		out.println("location.href='main.jsp?menuGubun=member_attachChuga';");
		out.println("</script>");
	}//if
%>
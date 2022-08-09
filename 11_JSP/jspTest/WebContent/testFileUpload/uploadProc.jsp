<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.Enumeration"%>

<%@ page import="com.oreilly.servlet.*" %>
<%@ page import="com.oreilly.servlet.multipart.*" %>

<%@ page import="config.Constants"%>

<%
	request.setCharacterEncoding("UTF-8");

	String name = "";
	String subject = "";
	String fileName1 = "";
	String fileName2 = "";
	long fileSize1 = 0L;
	long fileSize2 = 0L;

	String attachPath = Constants.ATTACH_PATH;
	String uploadPath = attachPath + request.getContextPath() + "/testUpload";
	int maxUpload = Constants.MAX_UPLOAD;

	try {
		MultipartRequest multi = new MultipartRequest(
				request,
				uploadPath,	// 파일 저장 경로
				maxUpload,	//파일 최대 크기
				"UTF-8",	//언어 셋
				new DefaultFileRenamePolicy()	//파일이름 중복 방지
				);

		name = multi.getParameter("name");
		subject = multi.getParameter("subject");
		
		Enumeration files = multi.getFileNames();
		String file1 = (String) files.nextElement();
		String file2 = (String) files.nextElement();
		
		fileName1 = multi.getFilesystemName(file1);
		java.io.File f1 = multi.getFile(file1);
		fileSize1 = f1.length();

		fileName2 = multi.getFilesystemName(file2);
		java.io.File f2 = multi.getFile(file2);
		fileSize2 = f2.length();
		
	} catch (Exception e) {
// 		e.printStackTrace();
	}//try-catch
%>

이름: <%=name %><br>
제목: <%=subject %><br>

파일이름1: <%=fileName1 %><br>
파일용량1: <%=fileSize1 %><br>

파일이름2: <%=fileName2 %><br>
파일용량2: <%=fileSize2 %><br>
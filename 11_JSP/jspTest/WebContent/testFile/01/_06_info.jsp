<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>파일 정보</h2>
	<%
		// attach 폴더까지의 경로
		String attachPath = "D:/Developement/attach";// -Unix D:\\Developement\\attach - windows
		// 파일이 저장되는 폴더의 경로
		String uploadPath = attachPath + "/testFile/aaa";
		// 저장되는 파일명
		String uploadFile = uploadPath + "/test01.txt";
		
		java.io.File f = new java.io.File(uploadFile);
		
		if (f.exists()) {
			String fileName = f.getName();
			String absPath = f.getAbsolutePath();
			long fileSize = f.length(); // 용량단위: byte
			
			out.println("파일명: " + fileName + "<br>");
			out.println("절대경로: " + absPath + "<br>");
			out.println("파일용량: " + fileSize + "<br>");
		} else {
			out.println("파일 존재 안함..");
		}//end if
	%>
</body>
</html>
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
		
		if (f.delete()) {
			out.println("파일 삭제 됨: " + f.getName());
		} else {
			out.println("파일 삭제 안됨..");
		}//end if
	%>
	
</body>
</html>
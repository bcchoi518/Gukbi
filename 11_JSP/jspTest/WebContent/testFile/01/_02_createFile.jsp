<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.io.File" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>파일 만들기</h2>
	<%
		// attach 폴더까지의 경로
		String attachPath = "D:/Developement/attach";//-Unix D:\\Developement\\attach - windows
		// 파일이 저장되는 폴더의 경로
		String uploadPath = attachPath + "/testFile/aaa";
		// 저장되는 파일명
		String uploadFile = uploadPath + "/test01.txt";
		
		File f = new File(uploadFile);
		
		// 파일 존재여부 체크
		if (f.exists()) {
			System.out.println("파일이 존재함..");
		} else {
			System.out.println("파일이 존재안함..");
		}//end if
		
		// 파일 존재여부 체크해서 존재하지않으면 파일생성
		if (f.createNewFile()) {
			System.out.println("파일 생성됨: " + f.getName());
		} else {
			System.out.println("파일 생성안됨");
		}//end if
	%>
</body>
</html>
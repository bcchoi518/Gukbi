<%@page import="java.nio.file.Paths"%>
<%@page import="java.nio.file.Files"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h2>Test</h2>
	<%
		String attachPath = "D:/Developement/attach";
		String uploadPath = attachPath + "/testFile/jspTest";
		String uploadFile = uploadPath + "/sample.txt";
	
		List<String> lines = Files.readAllLines(Paths.get(uploadFile));
		for (String line : lines) {
			out.println(line + "<br>");
		}//end while
	%>
</body>
</html>
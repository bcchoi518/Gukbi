<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="java.io.*"%>
<%@page import="java.nio.file.Files"%>
<%@page import="java.nio.file.Paths"%>
<%@page import="java.util.List"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>파일 읽기</h2>
	
	<%
		// attach 폴더까지의 경로
		String attachPath = "D:/Developement/attach";// -Unix D:\\Developement\\attach - windows
		// 파일이 저장되는 폴더의 경로
		String uploadPath = attachPath + "/testFile/aaa";
		// 저장되는 파일명
		String uploadFile = uploadPath + "/test01.txt";
		
		try {
			List<String> lines = Files.readAllLines(Paths.get(uploadFile));
			out.println(lines + "<br>");
			
			out.println("-----------------------------------------<br>");
			
			byte[] bytes = Files.readAllBytes(Paths.get(uploadFile));
			out.println(new String(bytes));
			
			out.println("<br>-----------------------------------------<br>");
			
			String str = Files.readString(Paths.get(uploadFile));
			out.println(str + "<br>");
		} catch (Exception e) {
			//e.printStackTrace();
		}//end try-catch
	%>
</body>
</html>
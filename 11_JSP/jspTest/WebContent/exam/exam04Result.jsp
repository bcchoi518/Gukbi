<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = request.getParameter("name");
	String id = request.getParameter("id");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>회원가입완료</title>
</head>
<body>
	<h2>회원가입완료</h2>
	
	<%=name %>(<%=id %>)님 회원가입을 환영합니다.
	<br>
	즐겁게 이용하세요...
</body>
</html>
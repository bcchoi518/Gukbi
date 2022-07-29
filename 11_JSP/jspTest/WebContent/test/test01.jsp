<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test01.jsp</title>
</head>
<body>
<h2>test01.jsp</h2>
<%
	String name = "홍길동";
	int age = 19;
	String gender = "여자";
%>
당신의 이름은 <% out.print(name); %>입니다.<br>
당신의 나이는 <% out.print(age); %>세입니다.<br>
당신의 성별은 <%=gender%>입니다.
</body>
</html>
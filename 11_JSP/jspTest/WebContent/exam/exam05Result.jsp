<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	
	String name = request.getParameter("name");
	String age = request.getParameter("age");
	String gender = request.getParameter("gender");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exam05Result.jsp</title>
</head>
<body>

	<h2>exam05Result.jsp</h2>
	
	당신의 이름은 <%=name %>입니다.<br>
	당신의 나이는 <%=age %>세입니다.<br>
	당신의 성별은 <%=gender %>입니다.<br>
</body>
</html>
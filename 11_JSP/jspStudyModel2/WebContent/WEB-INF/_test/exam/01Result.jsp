<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@ include file = "../../_include/inc_menu.jsp" %>
	
	<h2>01Result</h2>
	
	<table border="1">
		<tr>
			<td>이름 : </td>
			<td>${requestScope.name }</td>
		</tr>
		<tr>
			<td>주소 : </td>
			<td>${requestScope.address }</td>
		</tr>
		<tr>
			<td>나이 : </td>
			<td>${requestScope.age }</td>
		</tr>
	</table>
	
</body>
</html>
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

	<h2>08Result</h2>
	
	<table border="1">
		<tr>
			<td>이름 : </td>
			<td>${requestScope.map.name }</td>
		</tr>
		<tr>
			<td>주소 : </td>
			<td>${requestScope.map.address }</td>
		</tr>
		<tr>
			<td>나이 : </td>
			<td>${requestScope.map.age }</td>
		</tr>
		<tr>
			<td>숫자1 : </td>
			<td>${requestScope.map.num1 }</td>
		</tr>
		<tr>
			<td>숫자2 : </td>
			<td>${requestScope.map.num2 }</td>
		</tr>
		<tr>
			<td>결과 : </td>
			<td>${requestScope.map.result }</td>
		</tr>
	</table>

</body>
</html>
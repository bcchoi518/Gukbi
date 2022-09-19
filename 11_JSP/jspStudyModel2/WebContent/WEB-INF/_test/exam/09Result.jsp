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

	<h2>09Result</h2>
	
	<table border="1">
		<tr>
			<td>이름 : </td>
			<td>${requestScope.map.name }</td>
		</tr>
		<tr>
			<td>국어 : </td>
			<td>${requestScope.map.kor }</td>
		</tr>
		<tr>
			<td>영어 : </td>
			<td>${requestScope.map.eng }</td>
		</tr>
		<tr>
			<td>수학 : </td>
			<td>${requestScope.map.mat }</td>
		</tr>
		<tr>
			<td>총점 : </td>
			<td>${requestScope.map.tot }</td>
		</tr>
		<tr>
			<td>평균 : </td>
			<td>${requestScope.map.avg }</td>
		</tr>
	</table>

</body>
</html>
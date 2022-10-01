<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "../../_include/inc_header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@ include file = "../../_include/inc_menu.jsp" %>
	
	<h2>${requestScope.title }</h2>
	
	<table border="1">
		<tr>
			<td>이름</td>
			<td>${requestScope.dto.name }</td>
		</tr>
		<tr>
			<td>국어</td>
			<td>${requestScope.dto.kor }</td>
		</tr>
		<tr>
			<td>영어</td>
			<td>${requestScope.dto.eng }</td>
		</tr>
		<tr>
			<td>수학</td>
			<td>${requestScope.dto.mat }</td>
		</tr>
		<tr>
			<td>과학</td>
			<td>${requestScope.dto.sci }</td>
		</tr>
		<tr>
			<td>역사</td>
			<td>${requestScope.dto.his }</td>
		</tr>
		<tr>
			<td>총점</td>
			<td>${requestScope.dto.tot }</td>
		</tr>
		<tr>
			<td>평균</td>
			<td>${requestScope.dto.avg }</td>
		</tr>
	</table>
	
</body>
</html>
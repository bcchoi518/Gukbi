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
	
	<h2>02Result</h2>
<!-- 이름, 출생연도 입력받고 이름, 출생연도, 나이 출력 -->
	<table border="1">
		<tr>
			<td>이름 : </td>
			<td>${requestScope.name }</td>
		</tr>
		<tr>
			<td>출생연도 : </td>
			<td>${requestScope.birthYear }</td>
		</tr>
		<tr>
			<td>나이 : </td>
			<td>${requestScope.age }</td>
		</tr>
	</table>
</body>
</html>
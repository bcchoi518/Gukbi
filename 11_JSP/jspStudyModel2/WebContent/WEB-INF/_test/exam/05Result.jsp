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
	
	<h2>05Result</h2>
	<table border="1">
		<tr>
			<td>이름 : </td>
			<td>
				${requestScope.map.name }
				<hr>
				${fn:replace(requestScope.map.name, ',', '<br>') }
			</td>
			
		</tr>
		<tr>
			<td>성별 : </td>
			<td>${requestScope.map.gender }</td>
		</tr>
		<tr>
			<td>연령대 : </td>
			<td>${requestScope.map.aboutAge }</td>
		</tr>
		<tr>
			<td>관심분야 : </td>
			<td>
				${requestScope.map.hobby }
				<hr>
				${fn:replace(requestScope.map.hobby, ',', '<br>') }
			</td>
		</tr>
		<tr>
			<td>나이 : </td>
			<td>${requestScope.map.age }</td>
		</tr>
		<tr>
			<td>하고 싶은 말 : </td>
			<td>${requestScope.map.memo }</td>
		</tr>
		<tr>
			<td>생일 : </td>
			<td>${requestScope.map.birthDay }</td>
		</tr>
	</table>
</body>
</html>
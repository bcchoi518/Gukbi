<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>exam03.jsp</title>
</head>
<body>

	<h2>exam03.jsp</h2>
	
	<form name="personForm" method="post" action="exam03Proc.jsp">
		<table>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>주민번호</td>
				<td><input type="text" name="jumin" /></td>
			</tr>
			<tr>
				<td>연락처</td>
				<td><input type="text" name="phone" /></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="email" name="email" /></td>
			</tr>
			<tr>
				<td colspan="2"><button type="submit">등록</button></td>
			</tr>
		</table>
	</form>
</body>
</html>
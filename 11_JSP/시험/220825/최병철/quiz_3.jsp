<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>quiz_3</title>
<style>
	* {
		font-size: 1.5rem;
	}
</style>
</head>
<body>
	<table border="1" align="center">
		<caption>문제3. 정답</caption>
		<tr>
			<td>일련번호</td>
			<td>일련번호의 합계</td>
		</tr>
		<%
			int sum = 0;
			for (int i = 1; i <= 10; i++) {
				sum += i;
		%>
			<tr>
				<td><%=i %></td>
				<td><%=sum %></td>
			</tr>
		<%		
			}//for
		%>
	</table>
</body>
</html>
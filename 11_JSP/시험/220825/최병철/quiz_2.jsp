<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>quiz_2</title>
<style>
	* {
		font-size: 1.5rem;
	}
</style>
</head>
<body>
		<%
			int sum = 0;
			for (int i = 1; i <= 100; i++) {
				if (i % 3 != 0) {
					continue;
				}//if
				sum += i;
			}//for
		%>
	<table border="1" align="center">
		<caption>문제2. 정답</caption>
		<tr>
			<td>3의 배수의 합 : </td>
			<td><%=sum %></td>
		</tr>
	</table>
</body>
</html>
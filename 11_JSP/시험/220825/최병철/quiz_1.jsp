<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>quiz_1</title>
<style>
	* {
		font-size: 1.5rem;
	}
</style>
</head>
<body>
		<%
			int oddSum = 0;
			int evenSum = 0;
			for (int i = 1; i <= 100; i++) {
				if (i % 2 == 0) {
					evenSum += i;
				} else {
					oddSum += i;
				}//if
			}//for
		%>
	<table border="1" align="center">
		<caption>문제1. 정답</caption>
		<tr>
			<td>홀수의 합 : </td>
			<td><%=oddSum %></td>
		</tr>
		<tr>
			<td>짝수의 합 : </td>
			<td><%=evenSum %></td>
		</tr>
	</table>
</body>
</html>
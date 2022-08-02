<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String[] gwamoks = new String[5];
	gwamoks[0] = "국어";
	gwamoks[1] = "영어";
	gwamoks[2] = "수학";
	gwamoks[3] = "과학";
	gwamoks[4] = "역사";
	
	int[] jumsus = new int[5];
	jumsus[0] = 90;
	jumsus[1] = 80;
	jumsus[2] = 70;
	jumsus[3] = 60;
	jumsus[4] = 50;
%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>test05.jsp</title>
</head>
<body>

	<h2>test05.jsp</h2>

	<table border="1">
		<tr>
			<td>과목</td>
			<td>점수</td>
		</tr>
		<%
			for (int i = 0; i < gwamoks.length; i++) {
		%>
			<tr>
				<td><%=gwamoks[i] %></td>
				<td><%=jumsus[i] %></td>
			</tr>
		<%	
			}
		%>
	</table>

</body>
</html>
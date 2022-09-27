<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="java.util.ArrayList"%>
<%@page import="sj.model.dao.SjDAO"%>
<%@page import="sj.model.dto.SjDTO"%>
    
<%
	SjDAO dao = new SjDAO();
	ArrayList<SjDTO> sjList = dao.getSelectAll();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>성적목록</h2>
	<p>
		문제 1번 정답 : 1<br>
		문제 2번 정답 : 2<br>
		문제 3번 정답 : 3<br>
		문제 4번 정답 : 4<br>
		문제 5번 정답 : 3
	</p>
	<table border="1" width="80%">
		<tr>
			<td>이름</td>
			<td>시험명</td>
			<td>문제1</td>
			<td>문제2</td>
			<td>문제3</td>
			<td>문제4</td>
			<td>문제5</td>
			<td>점수</td>
		</tr>
		<% for (SjDTO resultSjDto : sjList) { %>
			<tr>
				<td><%=resultSjDto.getName() %></td>
				<td><%=resultSjDto.getsName() %></td>
				<td><%=resultSjDto.getMun_1() %> (<%=resultSjDto.getMun_ox_1() %>)</td>
				<td><%=resultSjDto.getMun_2() %> (<%=resultSjDto.getMun_ox_2() %>)</td>
				<td><%=resultSjDto.getMun_3() %> (<%=resultSjDto.getMun_ox_3() %>)</td>
				<td><%=resultSjDto.getMun_4() %> (<%=resultSjDto.getMun_ox_4() %>)</td>
				<td><%=resultSjDto.getMun_5() %> (<%=resultSjDto.getMun_ox_5() %>)</td>
				<td><%=resultSjDto.getJumsu() %></td>
			<tr>
		<% }//for %>
	</table>
</body>
</html>
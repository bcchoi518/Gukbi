<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="java.util.ArrayList"%>
<%@page import="member.model.dao.DAO"%>
<%@page import="member.model.dto.DTO"%>
    
<%
	DAO dao = new DAO();
	ArrayList<DTO> memberList = dao.getSelectAll();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원목록</h2>
	<table border="1" width="80%">
		<tr>
			<td>아이디</td>
			<td>비밀번호</td>
			<td>이름</td>
			<td>전화번호</td>
			<td>직업</td>
		</tr>
		<% for (DTO resultDto : memberList) { %>
			<tr>
				<td><%=resultDto.getId() %></td>
				<td><%=resultDto.getPwd() %></td>
				<td><%=resultDto.getName() %></td>
				<td><%=resultDto.getPhone() %></td>
				<td><%=resultDto.getJob() %></td>
			<tr>
		<% }//for %>
	</table>
</body>
</html>
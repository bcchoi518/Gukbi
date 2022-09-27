<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("UTF-8");

	String name = request.getParameter("name");
	String address = request.getParameter("address");
	String age_ = request.getParameter("age");
	String imsi = age_;
	int age = 0;	
	
	if (age_ != null && !age_.trim().equals("")) {
		for (int i = 0; i < 10; i++) {
			imsi = imsi.replace(i + "", "");
		}//for
		
		if (imsi.length() == 0) {
			age = Integer.parseInt(age_);
		}//if
	}//if
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>quiz_4</title>
<style>
	* {
		font-size: 1.5rem;
	}
</style>
</head>
<body>
	<form name="form" method="post" action="">
	<table border="0" align="center">
		<tr>
			<td>이름 : </td>
			<td><input type="text" name="name" /></td>
		</tr>
		<tr>
			<td>주소 : </td>
			<td><input type="text" name="address" /></td>
		</tr>
		<tr>
			<td>나이 : </td>
			<td><input type="text" name="age" /></td>
		</tr>
		<tr>
			<td><input type="submit" value="출력" /></td>
		</tr>
	</table>
	</form>
	<% if (name != null && !name.trim().equals("")) { %>
		<hr>
		<table border="1" align="center">
			<tr>
				<th>이름</th>
				<th>주소</th>
				<th>나이</th>
			</tr>
			<tr>
				<td><%=name %></td>
				<td><%=address %></td>
				<td><%=age %></td>
			</tr>
		</table>
	<% }//if %>
</body>
</html>
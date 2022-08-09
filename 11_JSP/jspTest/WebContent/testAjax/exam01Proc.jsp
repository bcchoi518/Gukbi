<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");

	String dbId = "hong";
	String dbPw = "1234";
	
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	
	String result = "로그인 실패";
	if (id.equals(dbId) && passwd.equals(dbPw)) {
		result = "로그인 성공";
	}//if
%>

<font style="color:red; font-weight:bold;"><%=result %></font>
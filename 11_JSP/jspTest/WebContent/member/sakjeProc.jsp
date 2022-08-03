<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	
	String passwd = request.getParameter("passwd");
	
	if (passwd == null || passwd.equals("")) {
		out.print("비밀번호 비정상..");
		return;
	}//end if
	
	out.print("passwd: " + passwd + "<br>");
	
	response.sendRedirect("list.jsp");
%>
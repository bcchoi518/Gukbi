<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "../_include/inc_sessionChk.jsp" %>
<%@ include file = "../_include/inc_header.jsp" %>

<%
	String sessionChk = "O";
	if ((fileName.equals("list") || fileName.equals("listSearch")) && sessionNo <= 0) {
		sessionChk = "X";
	}//if
	
// 	if (sessionChk.equals("O") && sessionNo <= 0) {
// 		out.println("<script>");
// 		out.println("alert('로그인 후 이용하세요.');");
// 		out.println("location.href='"+ request.getContextPath() +"';");
// 		out.println("</script>");
// 		return;
// 	}//if
%>
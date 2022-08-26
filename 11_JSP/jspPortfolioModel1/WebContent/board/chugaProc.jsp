<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "_inc_top.jsp" %>

<%
	request.setCharacterEncoding("UTF-8");

	String writer = request.getParameter("writer");
	String email = request.getParameter("email");
	String passwd = request.getParameter("passwd");
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");
	String noticeGubun = request.getParameter("noticeGubun");
	String secretGubun = request.getParameter("secretGubun");
	
	int num = 0;
	String tbl = "-";
	int refNo = 0;
	int stepNo = 1;
	int levelNo = 1;
	int parentNo = 0;
	int hit = 0;
	//String ip = "";
	int memberNo = sessionNo;
	int noticeNo = 0;
	String attachInfo = "-";
	
%>

<h2>추가처리</h2>
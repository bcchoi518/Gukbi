<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	String hobby1 = request.getParameter("hobby1");
	String hobby2 = request.getParameter("hobby2");
	String hobby3 = request.getParameter("hobby3");
	String hobby4 = request.getParameter("hobby4");
	String hobby5 = request.getParameter("hobby5");
	String hobby6 = request.getParameter("hobby6");
	String hobby7 = request.getParameter("hobby7");
	String hobby8 = request.getParameter("hobby8");
	String hobby9 = request.getParameter("hobby9");
	
	out.print("hobby1: " + hobby1 + "<br>");
	out.print("hobby2: " + hobby2 + "<br>");
	out.print("hobby3: " + hobby3 + "<br>");
	out.print("hobby4: " + hobby4 + "<br>");
	out.print("hobby5: " + hobby5 + "<br>");
	out.print("hobby6: " + hobby6 + "<br>");
	out.print("hobby7: " + hobby7 + "<br>");
	out.print("hobby8: " + hobby8 + "<br>");
	out.print("hobby9: " + hobby9 + "<br>");
	
	String hobby = "";
	if (hobby1 != null) { hobby += hobby1; }
	if (hobby2 != null) { hobby += "," + hobby2; }
	if (hobby3 != null) { hobby += "," + hobby3; }
	if (hobby4 != null) { hobby += "," + hobby4; }
	if (hobby5 != null) { hobby += "," + hobby5; }
	if (hobby6 != null) { hobby += "," + hobby6; }
	if (hobby7 != null) { hobby += "," + hobby7; }
	if (hobby8 != null) { hobby += "," + hobby8; }
	if (hobby9 != null) { hobby += "," + hobby9; }
	
	out.println("hobby: " + hobby);
%>
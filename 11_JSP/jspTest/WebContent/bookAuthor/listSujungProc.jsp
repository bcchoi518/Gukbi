<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
	String totalCounter_ = request.getParameter("totalCounter");
	int totalCounter = Integer.parseInt(totalCounter_);
	
	for (int i = 0; i < totalCounter; i++) {
		String imsi = request.getParameter("author_" + i);
		String imsiNo_ = request.getParameter("authorNo_" + i);
		int imsiNo = Integer.parseInt(imsiNo_);
		out.println("author: " + i + " : " + imsi + ":" + imsiNo_ + "<br>");
	}//for
%>
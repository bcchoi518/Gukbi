<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	String[] names = request.getParameterValues("name");
	String grade = request.getParameter("grade");
	
	String name = "";
	for (int i = 0; i < names.length; i++) {
		if (names[i].equals("")) {
			continue;
		}//end if
		name += names[i];
		if (names.length - 1 != i) {
			name += ", ";
		}//end if
	}//end for
	out.println("names: " + name + "<br>");
	out.println("grade: " + grade + "<br>");
%>
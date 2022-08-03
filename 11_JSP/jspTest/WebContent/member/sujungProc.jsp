<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	
	String passwd = request.getParameter("passwd");
	String phone = request.getParameter("phone");
	String email = request.getParameter("email");
	String address = request.getParameter("address");
	
	if (passwd == null || passwd.equals("")) {
		out.print("비밀번호 비정상..");
		return;
	}//end if
	if (phone == null || phone.equals("")) {
		out.print("전화번호 비정상..");
		return;
	}//end if
	if (email == null || email.equals("")) {
		out.print("이메일 비정상..");
		return;
	}//end if
	if (address == null || address.equals("")) {
		out.print("주소 비정상..");
		return;
	}//end if
	
	out.print("passwd: " + passwd + "<br>");
	out.print("phone: " + phone + "<br>");
	out.print("email: " + email + "<br>");
	out.print("address: " + address + "<br>");
	
	response.sendRedirect("view.jsp");
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
	
	String name = request.getParameter("name");
	String jumin = request.getParameter("jumin");
	String phone = request.getParameter("phone");
	String email = request.getParameter("email");
	String gender_ = jumin.substring(7, 8);
	String age_ = jumin.substring(0, 2);

	int age = 0;
	if (gender_.equals("1") || gender_.equals("2")) {
		age = 2022 - (Integer.parseInt(age_) + 1900);
	} else {
		age = 2022 - (Integer.parseInt(age_) + 2000);
	}//end if
	
	String gender = "여자";
	if (gender_.equals("1") || gender_.equals("3")) {
		gender = "남자";
	}//end if
%>

당신의 이름은 <%=name %>입니다.<br>
당신의 주민번호는 <%=jumin %>입니다.<br>
당신의 연락처는 <%=phone %>입니다.<br>
당신의 이메일은 <%=email %>입니다.<br>
당신의 성별은 <%=gender %>입니다.<br>
당신의 나이는 <%=age %>입니다.<br>
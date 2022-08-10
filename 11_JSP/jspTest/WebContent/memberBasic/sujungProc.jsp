<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="memberBasic.MemberBasicDTO"%>
<%@ page import="memberBasic.MemberBasicDAO"%>

<%
	request.setCharacterEncoding("UTF-8");
	String arg1 = request.getParameter("arg1");
	
	String passwd = request.getParameter("passwd");
	String phone = request.getParameter("phone");
	String email = request.getParameter("email");
	String jumin1 = request.getParameter("jumin1");
	String jumin2 = request.getParameter("jumin2");
	String juso1 = request.getParameter("juso1");
	String juso2 = request.getParameter("juso2");
	String juso3 = request.getParameter("juso3");
	String juso4 = request.getParameter("juso4");
	
	int failCounter = 0;
	if (passwd == null || passwd.trim().equals("")) {
		failCounter++;
	} else if (phone == null || phone.trim().equals("")) {
		failCounter++;
	} else if (email == null || email.trim().equals("")) {
		failCounter++;
	} else if (jumin1 == null || jumin1.trim().equals("")) {
		failCounter++;
	} else if (jumin2 == null || jumin2.trim().equals("")) {
		failCounter++;
	} else if (juso1 == null || juso1.trim().equals("")) {
		failCounter++;
	} else if (juso2 == null || juso2.trim().equals("")) {
		failCounter++;
	} else if (juso3 == null || juso3.trim().equals("")) {
		failCounter++;
	} else if (juso4 == null || juso4.trim().equals("")) {
		juso4 = "";
	}//if
	
	if (jumin1.trim().length() != 6 || jumin2.trim().length() != 7) {
		failCounter++;
	}//if
	
	if (failCounter > 0) {
		out.println("<script>");
		out.println("alert('입력한 값이 정확하지 않습니다.');");
		out.println("location.href='sujung.jsp?arg1=" + arg1 + "';");
		out.println("</script>");
		return;
	}//if
	
	String jumin = jumin1 + jumin2;
	
	MemberBasicDAO dao = new MemberBasicDAO();
	MemberBasicDTO dto = new MemberBasicDTO();
	
	dto.setId(arg1);
	dto.setPasswd(passwd);
	dto.setPhone(phone);
	dto.setEmail(email);
	dto.setJumin(jumin);
	dto.setJuso1(juso1);
	dto.setJuso2(juso2);
	dto.setJuso3(juso3);
	dto.setJuso4(juso4);
	
	int result = dao.setUpdate(dto);
	
	String ment = "수정 중 오류가 발생했습니다.";
	String moveUrl = "sujung.jsp?arg1=" + arg1;
	if (result > 0) {
		ment = "정상적으로 수정되었습니다.";
		moveUrl = "view.jsp?arg1=" + arg1;
	}//if
	
	out.println("<script>");
	out.println("alert('"+ ment +"');");
	out.println("location.href='"+ moveUrl +"';");
	out.println("</script>");
%>
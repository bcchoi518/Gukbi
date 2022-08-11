<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="memberBasic.MemberBasicDTO"%>
<%@ page import="memberBasic.MemberBasicDAO"%>

<%
	request.setCharacterEncoding("UTF-8");
	
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	String passwdChk = request.getParameter("passwdChk");
	String name = request.getParameter("name");
	String phone = request.getParameter("phone");
	String email = request.getParameter("email");
	String jumin1 = request.getParameter("jumin1");
	String jumin2 = request.getParameter("jumin2");
	String juso1 = request.getParameter("juso1");
	String juso2 = request.getParameter("juso2");
	String juso3 = request.getParameter("juso3");
	String juso4 = request.getParameter("juso4");
	
	int failCounter = 0;
	if (id == null || id.trim().equals("")) {
		failCounter++;
	} else if (passwd == null || passwd.trim().equals("")) {
		failCounter++;
	} else if (passwdChk == null || passwdChk.trim().equals("")) {
		failCounter++;
	} else if (name == null || name.trim().equals("")) {
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
		juso4 = "-";
	}//if
	
	if (!passwd.equals(passwdChk)) {
		failCounter++;
	} else if (jumin1.trim().length() != 6 || jumin2.trim().length() != 7) {
		failCounter++;
	}//if
	
	if (failCounter > 0) {
		out.println("<script>");
		out.println("alert('입력한 값이 정확하지 않습니다.');");
		out.println("location.href='chuga.jsp';");
		out.println("</script>");
		return;
	}//if
	
	String jumin = jumin1 + jumin2;
	
	MemberBasicDTO dto = new MemberBasicDTO();
	dto.setId(id);
	dto.setPasswd(passwd);
	dto.setName(name);
	dto.setPhone(phone);
	dto.setEmail(email);
	dto.setJumin(jumin);
	dto.setJuso1(juso1);
	dto.setJuso2(juso2);
	dto.setJuso3(juso3);
	dto.setJuso4(juso4);
	
	MemberBasicDAO dao = new MemberBasicDAO();
	int result = dao.setInsert(dto);
	
	String ment = "등록 처리중 오류가 발생했습니다.";
	String moveUrl = "chuga.jsp";
	if (result > 0) {
		ment = "정상적으로 등록되었습니다.";
		moveUrl = "list.jsp";
	}//if
	
	out.println("<script>");
	out.println("alert('"+ ment +"');");
	out.println("location.href='"+ moveUrl +"';");
	out.println("</script>");
%>
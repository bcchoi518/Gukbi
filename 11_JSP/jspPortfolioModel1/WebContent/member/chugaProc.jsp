<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "_inc_top.jsp" %>
<%@ include file = "../_include/inc_header.jsp" %>

<%@ page import="member.model.dao.MemberDAO"%>
<%@ page import="member.model.dto.MemberDTO"%>

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
	String grade = request.getParameter("grade");

	String jumin = jumin1 + "-" + jumin2;
	
	if (juso4 == null || juso4.trim().equals("")) {
		juso4 = "-";
	}//if
	
	MemberDTO memberArguDto = new MemberDTO();
	memberArguDto.setId(id);
	memberArguDto.setPasswd(passwd);
	memberArguDto.setName(name);
	memberArguDto.setPhone(phone);
	memberArguDto.setEmail(email);
	memberArguDto.setJumin(jumin);
	memberArguDto.setJuso1(juso1);
	memberArguDto.setJuso2(juso2);
	memberArguDto.setJuso3(juso3);
	memberArguDto.setJuso4(juso4);
	memberArguDto.setGrade(grade);
	
	MemberDAO memberDao = new MemberDAO();
	int result = memberDao.setInsert(memberArguDto);
	
	if (result > 0) {
		out.println("<script>");
		out.println("location.href='main.jsp?menuGubun=member_list';");
		out.println("</script>");
	} else {
		out.println("<script>");
		out.println("alert('등록 중 오류가 발생했습니다.');");
		out.println("location.href='main.jsp?menuGubun=member_chuga';");
		out.println("</script>");
	}//if
%>
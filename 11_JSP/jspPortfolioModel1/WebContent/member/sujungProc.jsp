<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="member.model.dao.MemberDAO"%>
<%@ page import="member.model.dto.MemberDTO"%>

<%
	request.setCharacterEncoding("UTF-8");

	String no_ = request.getParameter("no");
	String passwd = request.getParameter("passwd");
	String phone = request.getParameter("phone");
	String email = request.getParameter("email");
	String juso1 = request.getParameter("juso1");
	String juso2 = request.getParameter("juso2");
	String juso3 = request.getParameter("juso3");
	String juso4 = request.getParameter("juso4");
	String grade = request.getParameter("grade");

	if (juso4 == null || juso4.trim().equals("")) {
		juso4 = "-";
	}//if
	
	int no = Integer.parseInt(no_);
	
	MemberDTO memberArguDto = new MemberDTO();
	memberArguDto.setNo(no);
	memberArguDto.setPasswd(passwd);
	memberArguDto.setPhone(phone);
	memberArguDto.setEmail(email);
	memberArguDto.setJuso1(juso1);
	memberArguDto.setJuso2(juso2);
	memberArguDto.setJuso3(juso3);
	memberArguDto.setJuso4(juso4);
	memberArguDto.setGrade(grade);
	
	MemberDAO memberDao = new MemberDAO();
	int result = memberDao.setUpdate(memberArguDto);
	
	if (result > 0) {
		out.println("<script>");
		out.println("location.href='main.jsp?menuGubun=member_view&no="+ no +"';");
		out.println("</script>");
	} else {
		out.println("<script>");
		out.println("alert('수정 중 오류가 발생했습니다.');");
		out.println("location.href='main.jsp?menuGubun=member_sujung&no="+ no +"';");
		out.println("</script>");
	}//if
%>
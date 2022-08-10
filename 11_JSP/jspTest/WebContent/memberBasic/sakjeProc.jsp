<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="memberBasic.MemberBasicDTO"%>
<%@ page import="memberBasic.MemberBasicDAO"%>

<%
	request.setCharacterEncoding("UTF-8");
	String arg1 = request.getParameter("arg1");
	String passwd = request.getParameter("passwd");
	
	if (passwd == null || passwd.trim().equals("")) {
		out.println("<script>");
		out.println("alert('입력한 값이 정확하지 않습니다.');");
		out.println("location.href='sakje.jsp?arg1=" + arg1 + "';");
		out.println("</script>");
		return;
	}//if
	
	MemberBasicDAO dao = new MemberBasicDAO();
	MemberBasicDTO dto = new MemberBasicDTO();
	dto.setId(arg1);
	dto.setPasswd(passwd);
	
	int result = dao.setDelete(dto);
	
	String ment = "삭제 중 오류가 발생했습니다.";
	String moveUrl = "sakje.jsp?arg1=" + arg1;
	if (result > 0) {
		ment = "정상적으로 삭제되었습니다.";
		moveUrl = "list.jsp";
	}//if
	
	out.println("<script>");
	out.println("alert('"+ ment +"');");
	out.println("location.href='"+ moveUrl +"';");
	out.println("</script>");
%>
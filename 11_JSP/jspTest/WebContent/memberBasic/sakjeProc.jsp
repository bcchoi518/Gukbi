<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="memberBasic.MemberBasicDTO"%>
<%@ page import="memberBasic.MemberBasicDAO"%>

<%
	request.setCharacterEncoding("UTF-8");
	String no_ = request.getParameter("no");
	String passwd = request.getParameter("passwd");

	int failCounter = 0;
	if (no_ == null || no_.trim().equals("")) {
		failCounter++;
	}//if
	
	int no = 0;
	try {
		no = Integer.parseInt(no_);
	} catch (Exception e) {
// 		e.printStackTrace();
		no = 0;
		failCounter++;
	}//try-catch
	
	if (failCounter > 0) {
		out.println("<script>");
		out.println("alert('정상적인 접속이 아닙니다.');");
		out.println("location.href='list.jsp';");
		out.println("</script>");
		return;
	}//if
	
	if (passwd == null || passwd.trim().equals("")) {
		out.println("<script>");
		out.println("alert('입력한 값이 정확하지 않습니다.');");
		out.println("location.href='sakje.jsp?no=" + no + "';");
		out.println("</script>");
		return;
	}//if
	
	MemberBasicDAO dao = new MemberBasicDAO();
	MemberBasicDTO dto = new MemberBasicDTO();
	dto.setNo(no);
	dto.setPasswd(passwd);
	
	int result = dao.setDelete(dto);
	
	String ment = "삭제 처리중 오류가 발생했습니다.";
	String moveUrl = "sakje.jsp?no=" + no;
	if (result > 0) {
		ment = "정상적으로 삭제되었습니다.";
		moveUrl = "list.jsp";
	}//if
	
	out.println("<script>");
	out.println("alert('"+ ment +"');");
	out.println("location.href='"+ moveUrl +"';");
	out.println("</script>");
%>
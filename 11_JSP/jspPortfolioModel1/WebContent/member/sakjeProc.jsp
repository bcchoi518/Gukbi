<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="member.model.dao.MemberDAO"%>
<%@ page import="member.model.dto.MemberDTO"%>

<%
	request.setCharacterEncoding("UTF-8");

	String no_ = request.getParameter("no");
	String passwd = request.getParameter("passwd");
	
	int no = Integer.parseInt(no_);
	
	MemberDTO memberArguDto = new MemberDTO();
	memberArguDto.setNo(no);
	memberArguDto.setPasswd(passwd);
	
	MemberDAO memberDao = new MemberDAO();
	int result = memberDao.setDelete(memberArguDto);
	
	String imsiMsg = "삭제 중 오류가 발생했습니다.";
	String imsiUrl = "main.jsp?menuGubun=member_sakje&no=" + no;
	if (result > 0) {
		imsiMsg = "삭제 성공..";
		imsiUrl = "main.jsp?menuGubun=member_list";
	}//if
	
	out.println("<script>");
	if (result <= 0) {
		out.println("alert('"+ imsiMsg +"');");
	}//if
	out.println("location.href='"+ imsiUrl +"';");
	out.println("</script>");
%>
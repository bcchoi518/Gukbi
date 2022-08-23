<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="member.model.dao.MemberDAO"%>
<%@page import="member.model.dto.MemberDTO"%>

<%
	request.setCharacterEncoding("UTF-8");
	
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	
	MemberDTO arguMemberDto = new MemberDTO();
	arguMemberDto.setId(id);
	arguMemberDto.setPasswd(passwd);
	
	MemberDAO memberDao = new MemberDAO();
	MemberDTO returnDto = memberDao.getLogin(arguMemberDto);
	
	//세션(Session) - 서버에 저장..
	if (returnDto.getNo() > 0) {
		// 세션에 로그인한 회원의 정보를 담는다
		session.setAttribute("sessionNo", returnDto.getNo()); // 회원번호
		session.setAttribute("sessionId", id); // 회원아이디
		session.setAttribute("sessionName", returnDto.getName()); // 회원이름
		session.setAttribute("sessionGrade", returnDto.getGrade()); // 회원등급
		
		out.println("<script>");
		out.println("alert('로그인 성공..');");
		out.println("location.href='main.jsp?menuGubun=dashBoard_list';");
		out.println("</script>");
	} else {
		out.println("<script>");
		out.println("alert('등록된 정보가 없습니다.\\n확인 후 다시 로그인 해주세요.');");
		out.println("location.href='main.jsp?menuGubun=noLogin_login';");
		out.println("</script>");
	}//if
%>
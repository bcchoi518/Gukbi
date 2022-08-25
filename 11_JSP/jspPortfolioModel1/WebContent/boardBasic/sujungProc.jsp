<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "_inc_top.jsp" %>
 
<%@page import="config.Util"%>
<%@ page import="boardBasic.model.dao.BoardBasicDAO"%>
<%@ page import="boardBasic.model.dto.BoardBasicDTO"%>

<%
	request.setCharacterEncoding("UTF-8");

	String no_ = request.getParameter("no");
	String writer = request.getParameter("writer");
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");
	String email = request.getParameter("email");
	String passwd = request.getParameter("passwd");

	int no = Integer.parseInt(no_);
	
	Util util = new Util();
	
	writer = util.getNullBlankCheck(writer, "-");
	writer = util.getCheckString(writer);
	subject = util.getNullBlankCheck(subject, "-");
	subject = util.getCheckString(subject);
	email = util.getNullBlankCheck(email, "-");
	email = util.getCheckString(email);
	content = util.getNullBlankCheck(content, "-");
	content = util.getCheckString(content);
	
	BoardBasicDTO arguBoardBasicDto = new BoardBasicDTO();
	arguBoardBasicDto.setNo(no);
	arguBoardBasicDto.setWriter(writer);
	arguBoardBasicDto.setSubject(subject);
	arguBoardBasicDto.setContent(content);
	arguBoardBasicDto.setEmail(email);
	arguBoardBasicDto.setPasswd(passwd);
	
	BoardBasicDAO boardBasicDao = new BoardBasicDAO();
	
	BoardBasicDTO returnBoardBasicDto = boardBasicDao.getSelectOne(arguBoardBasicDto);
	if (!passwd.equals(returnBoardBasicDto.getPasswd())) {
		out.println("<script>");
		out.println("alert('입력한 비밀번호가 다릅니다.');");
		out.println("location.href='main.jsp?menuGubun=boardBasic_sujung&no="+ no +"';");
		out.println("</script>");
		return;
	}//if
	
	int result = boardBasicDao.setUpdate(arguBoardBasicDto);
	
	if (result > 0) {
		out.println("<script>");
		out.println("location.href='main.jsp?menuGubun=boardBasic_view&no="+ no +"';");
		out.println("</script>");
	} else {
		out.println("<script>");
		out.println("alert('수정 중 오류가 발생했습니다.');");
		out.println("location.href='main.jsp?menuGubun=boardBasic_sujung&no="+ no +"';");
		out.println("</script>");
	}//if
%>
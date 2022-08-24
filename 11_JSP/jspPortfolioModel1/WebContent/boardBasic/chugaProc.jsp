<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "../_include/inc_sessionChk.jsp" %>
<%@ include file = "_inc_top.jsp" %>
    
<%@ page import="config.Util"%>
<%@ page import="boardBasic.model.dao.BoardBasicDAO"%>
<%@ page import="boardBasic.model.dto.BoardBasicDTO"%>

<%
	request.setCharacterEncoding("UTF-8");

	String writer = request.getParameter("writer");
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");
	String email = request.getParameter("email");
	String passwd = request.getParameter("passwd");
	int num = 0;
	int refNo = 0;
	int stepNo = 0;
	int levelNo = 0;
	int hit = 0;

	Util util = new Util();
	
	writer = util.getNullBlankCheck(writer, "-");
	writer = util.getCheckString(writer);
	subject = util.getNullBlankCheck(subject, "-");
	subject = util.getCheckString(subject);
	email = util.getNullBlankCheck(email, "-");
	email = util.getCheckString(email);
	content = util.getNullBlankCheck(content, "-");
	content = util.getCheckString(content);
	passwd = util.getNullBlankCheck(passwd, "-");
	passwd = util.getCheckString(passwd);
	
	BoardBasicDAO boardBasicDao = new BoardBasicDAO();
	num = boardBasicDao.getMaxNum() + 1;
	
	BoardBasicDTO arguBoardBasicDto = new BoardBasicDTO();
	arguBoardBasicDto.setNum(num);
	arguBoardBasicDto.setWriter(writer);
	arguBoardBasicDto.setSubject(subject);
	arguBoardBasicDto.setContent(content);
	arguBoardBasicDto.setEmail(email);
	arguBoardBasicDto.setPasswd(passwd);
	arguBoardBasicDto.setRefNo(refNo);
	arguBoardBasicDto.setStepNo(stepNo);
	arguBoardBasicDto.setLevelNo(levelNo);
	arguBoardBasicDto.setHit(hit);
	
	int result = boardBasicDao.setInsert(arguBoardBasicDto);
	
	if (result > 0) {
		out.println("<script>");
		out.println("location.href='main.jsp?menuGubun=boardBasic_list';");
		out.println("</script>");
	} else {
		out.println("<script>");
		out.println("alert('등록 중 오류가 발생했습니다.');");
		out.println("location.href='main.jsp?menuGubun=boardBasic_chuga';");
		out.println("</script>");
	}//if
%>
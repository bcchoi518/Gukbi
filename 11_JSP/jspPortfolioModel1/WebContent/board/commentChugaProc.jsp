<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="config.Util"%>

<%@ page import="board.model.dto.BoardCommentDTO"%>
<%@ page import="board.model.dao.BoardDAO"%>

<%@ include file = "../_include/inc_header.jsp" %>
<%@ include file = "../_include/inc_sessionChk.jsp" %>

<%
	String procGubun = request.getParameter("procGubun");
	String no_ = request.getParameter("no");
	String commentNo_ = request.getParameter("commentNo");
	String writer = request.getParameter("writer");	
	String passwd = request.getParameter("passwd");	
	String content = request.getParameter("content");	
	
	Util util = new Util();
	no_ = util.getNullBlankCheck(no_, "0");
	int no = Integer.parseInt(no_);
	commentNo_ = util.getNullBlankCheck(commentNo_, "0");
	int commentNo = Integer.parseInt(commentNo_);
	
	int memberNo = sessionNo;
// 	String ip = "";
	
	BoardCommentDTO arguBoardCommentDto = new BoardCommentDTO();
	arguBoardCommentDto.setCommentNo(commentNo);
	arguBoardCommentDto.setBoardNo(no);
	arguBoardCommentDto.setWriter(writer);
	arguBoardCommentDto.setPasswd(passwd);
	arguBoardCommentDto.setContent(content);
	arguBoardCommentDto.setMemberNo(memberNo);
	arguBoardCommentDto.setIp(ip);
	
	BoardDAO boardDao = new BoardDAO();
	
	int result = 0;
	if (procGubun.equals("chugaProc")) {
		result = boardDao.setCommentInsert(arguBoardCommentDto);
	} else if (procGubun.equals("sujungProc")) {
		result = boardDao.setCommentUpdate(arguBoardCommentDto);
	} else if (procGubun.equals("sakjeProc")) {
		result = boardDao.setCommentDelete(arguBoardCommentDto);
	}//if
	
	out.println(result);
%>
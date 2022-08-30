<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="java.util.ArrayList"%>

<%@page import="board.model.dao.BoardDAO"%>
<%@page import="board.model.dto.BoardDTO"%>
<%@page import="config.Util"%>

<%@ include file = "../_include/inc_header.jsp" %>
<%@ include file = "../_include/inc_sessionChk.jsp" %>

<%
	BoardDTO arguBoardDto = new BoardDTO();
	BoardDTO resultBoardDto = new BoardDTO();
	BoardDAO boardDao = new BoardDAO();
	
	String pageTitle = "";
	String pageSubject = "";
	String pageContent = "";

	if (fileName.equals("chuga") || fileName.equals("chugaProc") || fileName.equals("view") || fileName.equals("sujung") || fileName.equals("sujungProc") || fileName.equals("sakje") || fileName.equals("sakjeProc")) {
		String no_ = request.getParameter("no");
		if (no_ == null || no_.trim().equals("")) {
			no_ = "0";
		}//if
				
		int no = Integer.parseInt(no_);
		
		arguBoardDto.setNo(no);
		
		if (fileName.equals("view")) {
			boardDao.setUpdateHit(arguBoardDto);
		}//if

		resultBoardDto = boardDao.getSelectOne(arguBoardDto);
		
		if (fileName.equals("chuga")) {
			pageTitle = "글쓰기";
			if (resultBoardDto.getNo() > 0) {
				pageTitle = "답변쓰기";
				pageSubject = resultBoardDto.getSubject();
				pageContent = resultBoardDto.getContent();
			}//if
		}//if
	}//if
%>

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
	Util util = new Util();
	
	String pageNumber_ = request.getParameter("pageNumber"); 
	pageNumber_ = util.getNullBlankCheck(pageNumber_, "1");
	int pageNumber = Integer.parseInt(pageNumber_);
	
	//search start
	String searchValue = "O";
	String searchGubun = request.getParameter("searchGubun");
	String searchData = request.getParameter("searchData");
	
	searchGubun = util.getNullBlankCheck(searchGubun, "");
	searchData = util.getNullBlankCheck(searchData, "");
	searchData = util.getCheckString(searchData);
	
	if (searchGubun.equals("") || searchData.equals("")) {
		searchValue = "X";
		searchGubun = "";
		searchData = "";
	}//if
	arguBoardDto.setSearchGubun(searchGubun);
	arguBoardDto.setSearchData(searchData);
	//search end
	
	if (fileName.equals("chuga") || fileName.equals("chugaProc") || fileName.equals("view") || fileName.equals("sujung") || fileName.equals("sujungProc") || fileName.equals("sakje") || fileName.equals("sakjeProc")) {
		String no_ = request.getParameter("no");
		if (no_ == null || no_.trim().equals("") || !util.isNumber(no_)) {
			no_ = "0";
		}//if

		int no = Integer.parseInt(no_);
		arguBoardDto.setNo(no);

		resultBoardDto = boardDao.getSelectOne(arguBoardDto);
		
		if (no > 0) {//일부러 이상한 값을 입력한 경우를 잡아내자
			if (resultBoardDto.getNo() <= 0) {
				out.println("<script> alert('잘못된 접근입니다.'); location.href='main.jsp?menuGubun=board_list'; </script>");
				return;
			}//if
		}//if
	}//if
%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "_inc_top.jsp" %>

<%
	String procGubun = request.getParameter("procGubun");
	String boardChkNo_ = request.getParameter("boardChkNo");
	String tbl = request.getParameter("tbl");
	String tblName = request.getParameter("tblName");
	
	Util util = new Util();
	procGubun = util.getNullBlankCheck(procGubun, "");
	boardChkNo_ = util.getNullBlankCheck(boardChkNo_, "0");
	tbl = util.getNullBlankCheck(tbl, "");
	tblName = util.getNullBlankCheck(tblName, "");
	
	int boardChkNo = Integer.parseInt(boardChkNo_);

	int errorCounter = 0;
	if (procGubun.length() <= 0) { errorCounter++; }//if
	if (tbl.length() <= 0) { errorCounter++; }//if
	if (tblName.length() <= 0) { errorCounter++; }//if

	if (errorCounter > 0) {
		out.println("<script>");
		out.println("alert('입력한 값이 정확하지않습니다.');");
		out.println("location.href='main.jsp?menuGubun=boardChk_list';");
		out.println("</script>");
		return;
	}//if
	
	// tbl => 중복체크필요
	
	BoardChkDTO arguBoardChkDto = new BoardChkDTO();
	arguBoardChkDto.setBoardChkNo(boardChkNo);
	arguBoardChkDto.setTbl(tbl);
	arguBoardChkDto.setTblName(tblName);
	
	BoardChkDAO boardChkDao = new BoardChkDAO();
	int result = 0;
	if (procGubun.equals("chugaProc")) {
		result = boardChkDao.setInsert(arguBoardChkDto);
	} else if (procGubun.equals("sujungProc")) {
		result = boardChkDao.setUpdate(arguBoardChkDto);
	} else if (procGubun.equals("sakjeProc")) {
		result = boardChkDao.setDelete(arguBoardChkDto);
	}//if
	
	String resultPage = "boardChk_list";
	out.println("<script>");
	if (result <= 0) {
		out.println("alert('등록 처리 중 오류가 발생했습니다.');");
	}//if
	out.println("location.href = 'main.jsp?menuGubun=" + resultPage + "';");
	out.println("</script>");
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "_inc_top.jsp" %>

<%
	String passwd = request.getParameter("passwd");

	int failCounter = 0;
	passwd = util.getNullBlankCheck(passwd, "");
	passwd = util.getCheckString(passwd);
	if (passwd.length() <= 0) { failCounter++; }//if
	
	if (!resultBoardDto.getPasswd().equals(passwd)) { failCounter++; }
	
	if (failCounter > 0) {
		out.println("<script>");
		out.println("alert('입력한 값이 정확하지않습니다.');");
		out.println("location.href='main.jsp?menuGubun=board_list';");
		out.println("</script>");
		return;
	}//if
	
	arguBoardDto.setNo(resultBoardDto.getNo());
	arguBoardDto.setPasswd(passwd);
	
	int resultReply = boardDao.getCheckReply(arguBoardDto);
	int result = 0;
	
	if (resultReply <= 0) {
		result = boardDao.setDelete(arguBoardDto);
	}//if 

	String ment = "";
	String addr = "";
	
	if (resultReply > 0) {
		ment = "답글이 존재하여 삭제가 되지 않았습니다.";
		addr = "main.jsp?menuGubun=board_list";
	} else if (result > 0) {
		ment = "";
		addr = "main.jsp?menuGubun=board_list";
	} else {
		ment = "수정 처리 중 오류가 발생했습니다.";
		addr = "main.jsp?menuGubun=board_sakje&no="+ resultBoardDto.getNo();
	}//if
	
	out.println("<script>");
	if (result > 0) {
		
	} else {
		out.println("alert('"+ ment +"');");
	}//if
	out.println("location.href='"+ addr +"';");
	out.println("</script>");
%>
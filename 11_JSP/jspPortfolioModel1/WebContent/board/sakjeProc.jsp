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
		out.println("location.href='main.jsp?menuGubun=board_list&searchGubun=" + searchGubun + "&searchData=" + searchData + "';");
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

	String imsiQueryString = "searchGubun="+ searchGubun +"&searchData="+ searchData;
	String resultPage = "board_list";
	out.println("<script>");
	if (resultReply > 0) {
		out.println("alert('답글이 존재하여 삭제가 되지 않았습니다.');");
 	} else if (result <= 0) {
		out.println("alert('삭제 처리 중 오류가 발생했습니다.');");
		resultPage = "board_sakje&no="+ resultBoardDto.getNo() + "&pageNumber="+ pageNumber;
	}//if
	out.println("location.href = 'main.jsp?menuGubun=" + resultPage + "&"+ imsiQueryString +"';");
	out.println("</script>");
%>
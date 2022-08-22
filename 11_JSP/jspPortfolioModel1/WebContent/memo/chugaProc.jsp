<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="config.Util"%>

<%@page import="memo.model.dto.MemoDTO"%>
<%@page import="memo.model.dao.MemoDAO"%>

<%
	request.setCharacterEncoding("UTF-8");

	String writer = request.getParameter("writer");
	String content = request.getParameter("content");
	
	// 값을 받으면 체크해야 하는 부분
	// 1. null, black 처리
	// 2. html entity 처리
	// < (&lt;), > (&gt;), & (&amp;), " (&quot;), ' (&apos;)
	Util util = new Util();
	
	writer = util.getNullBlankCheck(writer, "-");
	writer = util.getCheckString(writer);
	
	content = util.getNullBlankCheck(content, "-");
	content = util.getCheckString(content);
	
	MemoDTO arguMemoDto = new MemoDTO();
	arguMemoDto.setWriter(writer);
	arguMemoDto.setContent(content);
	
	MemoDAO memoDao = new MemoDAO();
	int result = memoDao.setInsert(arguMemoDto);
	
	if (result > 0) {
		out.println("<script>");
		out.println("location.href='main.jsp?menuGubun=memo_list';");
		out.println("</script>");
	} else {
		out.println("<script>");
		out.println("alert('등록 중 오류가 발생했습니다.');");
		out.println("location.href='main.jsp?menuGubun=memo_chuga';");
		out.println("</script>");
	}//if
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="config.Util"%>

<%@page import="memo.model.dto.MemoDTO"%>
<%@page import="memo.model.dao.MemoDAO"%>

<%
	request.setCharacterEncoding("UTF-8");

	String no_ = request.getParameter("no");
	String writer = request.getParameter("writer");
	String content = request.getParameter("content");
	
	Util util = new Util();
	
	writer = util.getNullBlankCheck(writer, "-");
	writer = util.getCheckString(writer);
	
	content = util.getNullBlankCheck(content, "-");
	content = util.getCheckString(content);
	
	int no = Integer.parseInt(no_);
	
	MemoDTO arguMemoDto = new MemoDTO();
	arguMemoDto.setNo(no);
	arguMemoDto.setWriter(writer);
	arguMemoDto.setContent(content);
	
	MemoDAO memoDao = new MemoDAO();
	int result = memoDao.setUpdate(arguMemoDto);
	
	if (result > 0) {
		out.println("<script>");
		out.println("location.href='main.jsp?menuGubun=memo_list';");
		out.println("</script>");
	} else {
		out.println("<script>");
		out.println("alert('수정 중 오류가 발생했습니다.');");
		out.println("location.href='main.jsp?menuGubun=memo_sujung&no="+ no +"';");
		out.println("</script>");
	}//if
%>
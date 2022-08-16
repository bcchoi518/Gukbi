<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.sql.Date"%>

<%@page import="bookInfo.model.dao.BookInfoDAO"%>
<%@page import="bookInfo.model.dto.BookInfoDTO"%>

<%
	request.setCharacterEncoding("UTF-8");

	String infoNo_ = request.getParameter("infoNo");
	
	int infoNo = Integer.parseInt(infoNo_);
	
	BookInfoDTO infoArguDto = new BookInfoDTO();
	infoArguDto.setInfoNo(infoNo);
	
	BookInfoDAO infoDao = new BookInfoDAO();
	int result = infoDao.setDelete(infoArguDto);
	
	if (result > 0) {
		out.println("<script>");
		out.println("location.href = 'list.jsp';");
		out.println("</script>");
	} else {
		out.println("<script>");
		out.println("alert('삭제 처리중 오류가 발생했습니다.');");
		out.println("location.href = 'sakje.jsp?infoNo="+ infoNo +"';");
		out.println("</script>");
	}//if
%>
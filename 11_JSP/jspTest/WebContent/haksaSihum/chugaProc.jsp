<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="java.sql.Date"%>

<%@page import="haksaSihum.model.dao.HaksaSihumDAO"%>
<%@page import="haksaSihum.model.dto.HaksaSihumDTO"%>

<%
	request.setCharacterEncoding("UTF-8");

	String sihumName = request.getParameter("sihumName");
	String sihumDate_ = request.getParameter("sihumDate");
	Date sihumDate = Date.valueOf(sihumDate_);
	
	HaksaSihumDTO sihumDto = new HaksaSihumDTO();
	sihumDto.setSihumName(sihumName);
	sihumDto.setSihumDate(sihumDate);
	
	HaksaSihumDAO sihumDao = new HaksaSihumDAO();
	int result = sihumDao.setInsert(sihumDto);
	
	if (result > 0) {
		out.println("<script>");
		out.println("location.href='list.jsp';");
		out.println("</script>");
	} else {
		out.println("<script>");
		out.println("alert('등록 처리 중 오류가 발생했습니다.');");
		out.println("location.href='chuga.jsp';");
		out.println("</script>");
	}//if
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="java.sql.Date"%>

<%@page import="haksaSungjuk.model.dao.HaksaSungjukDAO"%>
<%@page import="haksaSungjuk.model.dto.HaksaSungjukDTO"%>

<%
	request.setCharacterEncoding("UTF-8");

	String arg1_ = request.getParameter("arg1");

	int arg1 = Integer.parseInt(arg1_);
	
	HaksaSungjukDTO sungjukDto = new HaksaSungjukDTO();
	sungjukDto.setSungjukNo(arg1);
	
	HaksaSungjukDAO sungjukDao = new HaksaSungjukDAO();
	int result = sungjukDao.setDelete(sungjukDto);

	if (result > 0) {
		out.println("<script>");
		out.println("location.href='list.jsp';");
		out.println("</script>");
	} else {
		out.println("<script>");
		out.println("alert('삭제 처리 중 오류가 발생했습니다.');");
		out.println("location.href='sakje.jsp?arg1="+ arg1 +"';");
		out.println("</script>");
	}//if
%>
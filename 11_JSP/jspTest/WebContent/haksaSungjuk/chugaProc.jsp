<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="java.sql.Date"%>

<%@page import="haksaSungjuk.model.dao.HaksaSungjukDAO"%>
<%@page import="haksaSungjuk.model.dto.HaksaSungjukDTO"%>

<%
	request.setCharacterEncoding("UTF-8");

	String hakbun_ = request.getParameter("hakbun");
	String sihumNo_ = request.getParameter("sihumNo");
	String kor_ = request.getParameter("kor");
	String eng_ = request.getParameter("eng");
	String mat_ = request.getParameter("mat");
	String sci_ = request.getParameter("sci");
	String his_ = request.getParameter("his");

	int hakbun = Integer.parseInt(hakbun_);
	int sihumNo = Integer.parseInt(sihumNo_);
	int kor = Integer.parseInt(kor_);
	int eng = Integer.parseInt(eng_);
	int mat = Integer.parseInt(mat_);
	int sci = Integer.parseInt(sci_);
	int his = Integer.parseInt(his_);
	
	HaksaSungjukDTO sungjukDto = new HaksaSungjukDTO();
	sungjukDto.setHakbun(hakbun);
	sungjukDto.setSihumNo(sihumNo);
	sungjukDto.setKor(kor);
	sungjukDto.setEng(eng);
	sungjukDto.setMat(mat);
	sungjukDto.setSci(sci);
	sungjukDto.setHis(his);
	sungjukDto.setTot();
	sungjukDto.setAvg();
	sungjukDto.setGrade();
	
	HaksaSungjukDAO sungjukDao = new HaksaSungjukDAO();
	int result = sungjukDao.setInsert(sungjukDto);

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
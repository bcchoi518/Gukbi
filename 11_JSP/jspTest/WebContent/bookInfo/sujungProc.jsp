<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        
<%@ page import="java.sql.Date"%>

<%@page import="bookInfo.model.dao.BookInfoDAO"%>
<%@page import="bookInfo.model.dto.BookInfoDTO"%>

<%
	request.setCharacterEncoding("UTF-8");

	String infoNo_ = request.getParameter("infoNo");
	String subject = request.getParameter("subject");
	String authorNo_ = request.getParameter("authorNo");
	String created_ = request.getParameter("created");
	String profileNo_ = request.getParameter("profileNo");
	
	int infoNo = Integer.parseInt(infoNo_);
	int authorNo = Integer.parseInt(authorNo_);
	int profileNo = Integer.parseInt(profileNo_);
	Date created = Date.valueOf(created_); 
	
	BookInfoDTO infoArguDto = new BookInfoDTO();
	infoArguDto.setInfoNo(infoNo);
	infoArguDto.setSubject(subject);
	infoArguDto.setAuthorNo(authorNo);
	infoArguDto.setCreated(created);
	infoArguDto.setProfileNo(profileNo);
	
	BookInfoDAO infoDao = new BookInfoDAO();
	int result = infoDao.setUpdate(infoArguDto);
	
	if (result > 0) {
		out.println("<script>");
		out.println("location.href = 'view.jsp?infoNo="+ infoNo +"';");
		out.println("</script>");
	} else {
		out.println("<script>");
		out.println("alert('수정 처리중 오류가 발생했습니다.');");
		out.println("location.href = 'sujung.jsp?infoNo="+ infoNo +"';");
		out.println("</script>");
	}//if
%>
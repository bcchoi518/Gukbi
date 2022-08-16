<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.sql.Date"%>

<%@page import="bookInfo.model.dto.BookInfoDTO"%>
<%@page import="bookInfo.model.dao.BookInfoDAO"%>

<%
	request.setCharacterEncoding("UTF-8");

	String subject = request.getParameter("subject");
	String authorNo_ = request.getParameter("authorNo");
	String created_ = request.getParameter("created");
	String profileNo_ = request.getParameter("profileNo");
	
	//날짜형식으로 넘어오는지 체크 필요
	Date created = Date.valueOf(created_);
	int authorNo = Integer.parseInt(authorNo_);
	int profileNo = Integer.parseInt(profileNo_);
	
	BookInfoDAO dao = new BookInfoDAO();
	BookInfoDTO arguDto = new BookInfoDTO();
	
	arguDto.setSubject(subject);
	arguDto.setAuthorNo(authorNo);
	arguDto.setCreated(created);
	arguDto.setProfileNo(profileNo);
	int result = dao.setInsert(arguDto);
	
	if (result > 0) {
		out.println("<script>");
		out.println("location.href = 'list.jsp';");
		out.println("</script>");
	} else {
		out.println("<script>");
		out.println("alert('추가 처리중 오류가 발생했습니다.');");
		out.println("location.href = 'chuga.jsp';");
		out.println("</script>");
	}//if
%>
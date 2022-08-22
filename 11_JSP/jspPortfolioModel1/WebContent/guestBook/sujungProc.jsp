<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="guestBook.model.dao.GuestBookDAO"%>
<%@ page import="guestBook.model.dto.GuestBookDTO"%>

<%
	request.setCharacterEncoding("UTF-8");

	String no_ = request.getParameter("no");
	String passwd = request.getParameter("passwd");
	String email = request.getParameter("email");
	String content = request.getParameter("content");

	int no = Integer.parseInt(no_);
	
	GuestBookDTO guestBookArguDto = new GuestBookDTO();
	guestBookArguDto.setNo(no);
	guestBookArguDto.setPasswd(passwd);
	guestBookArguDto.setEmail(email);
	guestBookArguDto.setContent(content);
	
	GuestBookDAO guestBookDao = new GuestBookDAO();
	int result = guestBookDao.setUpdate(guestBookArguDto);
	
	if (result > 0) {
		out.println("<script>");
		out.println("location.href='main.jsp?menuGubun=guestBook_view&no="+ no +"';");
		out.println("</script>");
	} else {
		out.println("<script>");
		out.println("alert('수정 중 오류가 발생했습니다.');");
		out.println("location.href='main.jsp?menuGubun=guestBook_sujung&no="+ no +"';");
		out.println("</script>");
	}//if
%>
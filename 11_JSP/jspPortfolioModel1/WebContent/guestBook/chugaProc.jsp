<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "../_include/inc_sessionChk.jsp" %>
    
<%@ page import="config.Util"%>
<%@ page import="guestBook.model.dao.GuestBookDAO"%>
<%@ page import="guestBook.model.dto.GuestBookDTO"%>

<%
	request.setCharacterEncoding("UTF-8");

	String name = request.getParameter("name");
	String passwd = request.getParameter("passwd");
	String email = request.getParameter("email");
	String content = request.getParameter("content");

	Util util = new Util();
	
	name = util.getNullBlankCheck(name, "-");
	name = util.getCheckString(name);
	email = util.getNullBlankCheck(email, "-");
	email = util.getCheckString(email);
	content = util.getNullBlankCheck(content, "-");
	content = util.getCheckString(content);
	
	GuestBookDTO arguGuestBookDto = new GuestBookDTO();
	arguGuestBookDto.setName(name);
	arguGuestBookDto.setPasswd(passwd);
	arguGuestBookDto.setEmail(email);
	arguGuestBookDto.setContent(content);
	arguGuestBookDto.setMemberNo(sessionNo);
	
	GuestBookDAO guestBookDao = new GuestBookDAO();
	int result = guestBookDao.setInsert(arguGuestBookDto);
	
	if (result > 0) {
		out.println("<script>");
		out.println("location.href='main.jsp?menuGubun=guestBook_list';");
		out.println("</script>");
	} else {
		out.println("<script>");
		out.println("alert('등록 중 오류가 발생했습니다.');");
		out.println("location.href='main.jsp?menuGubun=guestBook_chuga';");
		out.println("</script>");
	}//if
%>
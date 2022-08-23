<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="guestBook.model.dao.GuestBookDAO"%>
<%@ page import="guestBook.model.dto.GuestBookDTO"%>

<%
	request.setCharacterEncoding("UTF-8");

	String no_ = request.getParameter("no");
	String passwd = request.getParameter("passwd");
	
	int no = Integer.parseInt(no_);
	
	GuestBookDTO arguGuestBookDto = new GuestBookDTO();
	arguGuestBookDto.setNo(no);
	arguGuestBookDto.setPasswd(passwd);
	
	GuestBookDAO guestBookDao = new GuestBookDAO();
	
	GuestBookDTO returnGuestBookDto = guestBookDao.getSelectOne(arguGuestBookDto);
	if (!passwd.equals(returnGuestBookDto.getPasswd())) {
		out.println("<script>");
		out.println("alert('입력한 비밀번호가 다릅니다.');");
		out.println("location.href='main.jsp?menuGubun=guestBook_sujung&no="+ no +"';");
		out.println("</script>");
		return;
	}//if
	
	int result = guestBookDao.setDelete(arguGuestBookDto);
	
	String imsiMsg = "삭제 중 오류가 발생했습니다.";
	String imsiUrl = "main.jsp?menuGubun=guestBook_sakje&no=" + no;
	if (result > 0) {
		imsiMsg = "삭제 성공..";
		imsiUrl = "main.jsp?menuGubun=guestBook_list";
	}//if
	
	out.println("<script>");
	if (result <= 0) {
		out.println("alert('"+ imsiMsg +"');");
	}//if
	out.println("location.href='"+ imsiUrl +"';");
	out.println("</script>");
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "_inc_top.jsp" %>

<%
	String cartNo_ = request.getParameter("cartNo");
	cartNo_ = util.getNullBlankCheck(cartNo_, "0");
	int cartNo = Integer.parseInt(cartNo_);
	
	CartDTO arguCartDto = new CartDTO();
	arguCartDto.setCartNo(cartNo);
	
	CartDAO cartDao = new CartDAO();
	int result = cartDao.setDelete(arguCartDto);
	
	String resultPage = "shopCart_list";
	String ment = "삭제성공..";
	out.println("<script>");
	if (result <= 0) {
		ment = "삭제 처리 중 오류가 발생했습니다.";
	}//if
	out.println("alert('"+ ment +"');");
	out.println("location.href = 'main.jsp?menuGubun=" + resultPage + "';");
	out.println("</script>");
%>
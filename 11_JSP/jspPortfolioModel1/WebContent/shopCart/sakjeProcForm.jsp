<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "_inc_top.jsp" %>

<%
	String[] chkArray = request.getParameterValues("chk");
	
	if (chkArray == null) {
		out.println("<script>");
		out.println("alert('선택한 항목이 없습니다.');");
		out.println("location.href = 'main.jsp?menuGubun=shopCart_list';");
		out.println("</script>");
		return;
	}//if
	
	for (int i = 0; i < chkArray.length; i++) {
		int cartNo = Integer.parseInt(chkArray[i]);
		CartDTO arguCartDto = new CartDTO();
		arguCartDto.setCartNo(cartNo);
		
		CartDAO cartDao = new CartDAO();
		int result = cartDao.setDelete(arguCartDto);
	}//for
	
	out.println("<script>");
	out.println("location.href = 'main.jsp?menuGubun=shopCart_list';");
	out.println("</script>");
%>
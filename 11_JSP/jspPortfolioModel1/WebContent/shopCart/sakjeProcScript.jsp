<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "_inc_top.jsp" %>

<%
	String sunteakNo = request.getParameter("sunteakNo");
	
	if (sunteakNo == null || sunteakNo.trim().equals("")) {
		out.println("<script>");
		out.println("alert('선택한 항목이 없습니다.');");
		out.println("location.href = 'main.jsp?menuGubun=shopCart_list';");
		out.println("</script>");
		return;
	}//if
	
// 	String[] sunteakArray = sunteakNo.split(",");
// 	for (int i = 0; i < sunteakArray.length; i++) {
// 		int cartNo = Integer.parseInt(sunteakArray[i]);
// 		CartDTO arguCartDto = new CartDTO();
// 		out.println(cartNo);
// 		arguCartDto.setCartNo(cartNo);
		
// 		CartDAO cartDao = new CartDAO();
// 		int result = cartDao.setDelete(arguCartDto);
// 	}//for
	
	String[] sunteakArray = sunteakNo.split(",");
	CartDAO cartDao = new CartDAO();
	int result = cartDao.setDeleteBatch(sunteakArray);
		
	out.println("<script>");
	out.println("alert('"+ result +"');");
	out.println("location.href = 'main.jsp?menuGubun=shopCart_list';");
	out.println("</script>");
%>
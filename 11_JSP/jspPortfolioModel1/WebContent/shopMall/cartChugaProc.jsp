<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "_inc_top.jsp" %>

<%
	String productCode_ = request.getParameter("productCode");
	productCode_ = util.getNullBlankCheck(productCode_, "0");
	int productCode = Integer.parseInt(productCode_);
	
	String amount_ = request.getParameter("amount");
	productCode_ = util.getNullBlankCheck(amount_, "0");
	int amount = Integer.parseInt(amount_);
	
	CartDTO arguCartDto = new CartDTO();
	arguCartDto.setProductCode(productCode);
	arguCartDto.setAmount(amount);
	arguCartDto.setMemberNo(sessionNo);
	
	CartDAO cartDao = new CartDAO();
	int result = cartDao.setInsert(arguCartDto);
	
	String resultPage = "shopMall_view&productCode=" + productCode;
	String ment = "장바구니에 담겼습니다.";
	out.println("<script>");
	if (result <= 0) {
		ment = "장바구니에 담는 중 오류가 발생했습니다.";
		resultPage = "shopMall_view&productCode=" + productCode;
	}//if
	out.println("alert('"+ ment +"');");
	out.println("location.href = 'main.jsp?menuGubun=" + resultPage + "';");
	out.println("</script>");
%>
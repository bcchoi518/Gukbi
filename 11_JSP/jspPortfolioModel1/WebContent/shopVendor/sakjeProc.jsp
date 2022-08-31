<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "_inc_top.jsp" %>

<%
	String vendorCode_ = request.getParameter("vendorCode");

	vendorCode_ = util.getNullBlankCheck(vendorCode_, "0");

	int vendorCode = Integer.parseInt(vendorCode_);
	
	ShopVendorDTO arguShopVendorDto = new ShopVendorDTO();
	arguShopVendorDto.setVendorCode(vendorCode);
	
	ShopVendorDAO shopVendorDao = new ShopVendorDAO();
	int result = shopVendorDao.setDelete(arguShopVendorDto);
	
	String resultPage = "shopVendor_list";
	out.println("<script>");
	if (result <= 0) {
		out.println("alert('삭제 처리 중 오류가 발생했습니다.');");
		resultPage = "shopVendor_sakje&vendorCode=" + vendorCode;
	}//if
	out.println("location.href = 'main.jsp?menuGubun=" + resultPage + "';");
	out.println("</script>");
%>
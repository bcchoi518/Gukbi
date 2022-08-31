<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "_inc_top.jsp" %>

<%
	String vendorCode_ = request.getParameter("vendorCode");
	String vendorName = request.getParameter("vendorName");

	vendorCode_ = util.getNullBlankCheck(vendorCode_, "0");
	vendorName = util.getNullBlankCheck(vendorName, "");
	vendorName = util.getCheckString(vendorName);

	int vendorCode = Integer.parseInt(vendorCode_);
	
	ShopVendorDTO arguShopVendorDto = new ShopVendorDTO();
	arguShopVendorDto.setVendorCode(vendorCode);
	arguShopVendorDto.setVendorName(vendorName);
	
	ShopVendorDAO shopVendorDao = new ShopVendorDAO();
	int result = shopVendorDao.setUpdate(arguShopVendorDto);
	
	String resultPage = "shopVendor_list";
	out.println("<script>");
	if (result <= 0) {
		out.println("alert('수정 처리 중 오류가 발생했습니다.');");
		resultPage = "shopVendor_sujung&vendorCode=" + vendorCode;
	}//if
	out.println("location.href = 'main.jsp?menuGubun=" + resultPage + "';");
	out.println("</script>");
%>
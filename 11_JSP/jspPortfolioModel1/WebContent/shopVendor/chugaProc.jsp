<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "_inc_top.jsp" %>

<%
	String vendorName = request.getParameter("vendorName");
	
	vendorName = util.getNullBlankCheck(vendorName, "");
	vendorName = util.getCheckString(vendorName);

	ShopVendorDTO arguShopVendorDto = new ShopVendorDTO();
	arguShopVendorDto.setVendorName(vendorName);
	
	ShopVendorDAO shopVendorDao = new ShopVendorDAO();
	int result = shopVendorDao.setInsert(arguShopVendorDto);
	
	String resultPage = "shopVendor_list";
	out.println("<script>");
	if (result <= 0) {
		out.println("alert('등록 처리 중 오류가 발생했습니다.');");
		resultPage = "shopVendor_chuga";
	}//if
	out.println("location.href = 'main.jsp?menuGubun=" + resultPage + "';");
	out.println("</script>");
%>
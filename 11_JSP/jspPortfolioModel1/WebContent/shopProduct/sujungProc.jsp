<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "_inc_top.jsp" %>

<%
	String productCode_ = request.getParameter("productCode");
	String productName = request.getParameter("productName");
	String productPrice_ = request.getParameter("productPrice");
	String vendorCode_ = request.getParameter("vendorCode");
	
	productCode_ = util.getNullBlankCheck(productCode_, "0");
	
	productName = util.getNullBlankCheck(productName, "");
	productName = util.getCheckString(productName);
	
	productPrice_ = util.getNullBlankCheck(productPrice_, "0");
	productPrice_ = util.getCheckString(productPrice_);
	
	vendorCode_ = util.getNullBlankCheck(vendorCode_, "0");
	
	int productCode = Integer.parseInt(productCode_);
	int productPrice = Integer.parseInt(productPrice_);
	int vendorCode = Integer.parseInt(vendorCode_);
	String attachInfo = "-";
	
	ShopProductDTO arguShopProductDto = new ShopProductDTO();
	arguShopProductDto.setProductCode(productCode);
	arguShopProductDto.setProductName(productName);
	arguShopProductDto.setProductPrice(productPrice);
	arguShopProductDto.setVendorCode(vendorCode);
	arguShopProductDto.setAttachInfo(attachInfo);
	
	ShopProductDAO shopProductDao = new ShopProductDAO();
	int result = shopProductDao.setUpdate(arguShopProductDto);
	
	String resultPage = "shopProduct_list";
	out.println("<script>");
	if (result <= 0) {
		out.println("alert('수정 처리 중 오류가 발생했습니다.');");
		resultPage = "shopProduct_sujung&productCode=" + productCode;
	}//if
	out.println("location.href = 'main.jsp?menuGubun=" + resultPage + "';");
	out.println("</script>");
%>
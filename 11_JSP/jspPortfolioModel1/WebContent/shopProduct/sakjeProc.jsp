<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "_inc_top.jsp" %>

<%
	String productCode_ = request.getParameter("productCode");

	productCode_ = util.getNullBlankCheck(productCode_, "0");

	int productCode = Integer.parseInt(productCode_);
	
	ShopProductDTO arguShopProductDto = new ShopProductDTO();
	arguShopProductDto.setProductCode(productCode);
	
	ShopProductDAO shopProductDao = new ShopProductDAO();
	ShopProductDTO resultShopProductDto = shopProductDao.getSelectOne(arguShopProductDto);
	String attachInfo = resultShopProductDto.getAttachInfo();
	
	int result = shopProductDao.setDelete(arguShopProductDto);
	
	if (result > 0) {
		if (!attachInfo.equals("-")) {
			//파일 삭제 처리..
			String[] imsiArray01 = attachInfo.split(",");
			for (int i = 0; i < imsiArray01.length; i++) {
				String[] imsiArray02 = imsiArray01[i].split("[|]");
				String uploadFile = uploadPath + "/" + imsiArray02[1];
				java.io.File f = new java.io.File(uploadFile);
				if (f.delete()) {
					//파일 삭제 성공..
				} else {
					//파일 삭제 실패..
				}//if
			}//for
		}//if
	}//if
	
	String resultPage = "shopProduct_list";
	out.println("<script>");
	if (result <= 0) {
		out.println("alert('삭제 처리 중 오류가 발생했습니다.');");
		resultPage = "shopProduct_sakje&productCode=" + productCode;
	}//if
	out.println("location.href = 'main.jsp?menuGubun=" + resultPage + "';");
	out.println("</script>");
%>
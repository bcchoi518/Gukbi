<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "_inc_top.jsp" %>

<%
	File isDir = new File(uploadPath);
	if (isDir.exists()) {
		try {
			isDir.mkdirs();	
		} catch (Exception e) {
			e.printStackTrace();
		}//try-catch
	}//if

	// MultipartRequest 인스턴스 생성 (cos.jar의 라이브러리)
	MultipartRequest multipartRequest = new MultipartRequest(
		request,
		uploadPath,
		maxUpload,
		encoding,
		new DefaultFileRenamePolicy()
	);

	String productName = multipartRequest.getParameter("productName");
	String productPrice_ = multipartRequest.getParameter("productPrice");
	String vendorCode_ = multipartRequest.getParameter("vendorCode");
	String attachCounter_ = multipartRequest.getParameter("attachCounter");

	productPrice_ = util.getNullBlankCheck(productPrice_, "0");
	vendorCode_ = util.getNullBlankCheck(vendorCode_, "0");
	attachCounter_ = util.getNullBlankCheck(attachCounter_, "0");
				
	int productPrice = Integer.parseInt(productPrice_);
	int vendorCode = Integer.parseInt(vendorCode_);
	int attachCounter = Integer.parseInt(attachCounter_);
	String attachInfo = "";

	for (int i = 1; i <= attachCounter; i++) {
		String originalName = multipartRequest.getOriginalFileName("attachFile" + i);
		String savedName = multipartRequest.getFilesystemName("attachFile" + i);
		String fileType = multipartRequest.getContentType("attachFile" + i);
		
		if (originalName == null || savedName == null || fileType == null) {
			originalName = "-";
			savedName = "-";
			fileType = "-";
		}//if
		
		attachInfo += "," + originalName + "|" + savedName + "|" + fileType;
	}//for
	attachInfo = attachInfo.substring(1);
	out.println(attachInfo);
/*
	String originalName_1 = multipartRequest.getOriginalFileName("attachFile1");
	String savedName_1 = multipartRequest.getFilesystemName("attachFile1");
	String fileType_1 = multipartRequest.getContentType("attachFile1");
	if (originalName_1 == null || savedName_1 == null || fileType_1 == null) {
		originalName_1 = "-";
		savedName_1 = "-";
		fileType_1 = "-";
	}//if
	attachInfo += "," + originalName_1 + "|" + savedName_1 + "|" + fileType_1;
	
	String originalName_2 = multipartRequest.getOriginalFileName("attachFile2");
	String savedName_2 = multipartRequest.getFilesystemName("attachFile2");
	String fileType_2 = multipartRequest.getContentType("attachFile2");
	if (originalName_2 == null || savedName_2 == null || fileType_2 == null) {
		originalName_2 = "-";
		savedName_2 = "-";
		fileType_2 = "-";
	}//if
	attachInfo += "," + originalName_2 + "|" + savedName_2 + "|" + fileType_2;
	
	String originalName_3 = multipartRequest.getOriginalFileName("attachFile3");
	String savedName_3 = multipartRequest.getFilesystemName("attachFile3");
	String fileType_3 = multipartRequest.getContentType("attachFile3");
	if (originalName_3 == null || savedName_3 == null || fileType_3 == null) {
		originalName_3 = "-";
		savedName_3 = "-";
		fileType_3 = "-";
	}//if
	attachInfo += "," + originalName_3 + "|" + savedName_3 + "|" + fileType_3;
	
	attachInfo = attachInfo.substring(1);

	ShopProductDTO arguShopProductDto = new ShopProductDTO();
	arguShopProductDto.setProductName(productName);
	arguShopProductDto.setProductPrice(productPrice);
	arguShopProductDto.setVendorCode(vendorCode);
	arguShopProductDto.setAttachInfo(attachInfo);
	
	ShopProductDAO shopProductDao = new ShopProductDAO();
	int result = shopProductDao.setInsert(arguShopProductDto);
	
	String resultPage = "shopProduct_list";
	out.println("<script>");
	if (result <= 0) {
		out.println("alert('등록 처리 중 오류가 발생했습니다.');");
		resultPage = "shopProduct_chuga";
	}//if
	out.println("location.href = 'main.jsp?menuGubun=" + resultPage + "';");
	out.println("</script>");
*/
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "_inc_top.jsp" %>

<%
	// MultipartRequest 인스턴스 생성 (cos.jar의 라이브러리)
	MultipartRequest multipartRequest = new MultipartRequest(
		request,
		uploadPath,	//파일저장경로
		maxUpload,	//파일최대용량
		encoding,	//인코딩타입
		new DefaultFileRenamePolicy()	//중복파일처리(동일파일명 업로드시 뒤에 숫자를 붙임)
	);

	String productName = multipartRequest.getParameter("productName");
	String productPrice_ = multipartRequest.getParameter("productPrice");
	String vendorCode_ = multipartRequest.getParameter("vendorCode");
	
	productName = util.getNullBlankCheck(productName, "");
	productName = util.getCheckString(productName);
	
	productPrice_ = util.getNullBlankCheck(productPrice_, "0");
	productPrice_ = util.getCheckString(productPrice_);
	
	vendorCode_ = util.getNullBlankCheck(vendorCode_, "0");
	vendorCode_ = util.getCheckString(vendorCode_);

	int productPrice = Integer.parseInt(productPrice_);
	int vendorCode = Integer.parseInt(vendorCode_);
	
	String attachInfo = "";
	try {
		Enumeration<String> files = multipartRequest.getFileNames();
		while (files.hasMoreElements()) {
			String tagName = "";
			String fileOriginalName = "";
			String fileSavedName = "";
			String fileType = "";
			String fileSize = "";
			String fileExtName = ""; // .png .jpg .jpeg .gif
			String newFileName = "";
			
			tagName = files.nextElement();
			File fileObj = multipartRequest.getFile(tagName);
			
			if (fileObj != null) {
				fileOriginalName = multipartRequest.getOriginalFileName(tagName);
				fileSavedName = multipartRequest.getFilesystemName(tagName);
				fileType = multipartRequest.getContentType(tagName);
				fileSize = String.valueOf(fileObj.length());
				fileExtName = fileSavedName.substring(fileSavedName.lastIndexOf(".") + 1);
				
				int errorImgCounter = 0;
				if (fileExtName.equalsIgnoreCase("jpg")) {
					
				} else if (fileExtName.equalsIgnoreCase("jpeg")) {
					
				} else if (fileExtName.equalsIgnoreCase("png")) {
					
				} else if (fileExtName.equalsIgnoreCase("gif")) {
					
				} else {
					errorImgCounter++;
				}//if
				
				if (errorImgCounter > 0) {
					String deleteFilePath = uploadPath + "/" + fileSavedName;
					File deleteFile = new File(deleteFilePath);
					if (deleteFile.delete()) {
						//파일 삭제 성공..
					} else {
						//파일 삭제 실패..
					}//if
					
					fileOriginalName = "";
					fileSavedName = "";
					fileType = "";
					fileSize = "";
					continue;
				}//if
				
				newFileName = UUID.randomUUID().toString() + "." + fileExtName;
				String oldFilePath = uploadPath + "/" + fileSavedName;
				String newFilePath = uploadPath + "/" + newFileName;
				File renameFile = new File(oldFilePath);
				if (renameFile.exists()) {
					File newFile = new File(newFilePath);
					renameFile.renameTo(newFile);
					fileSavedName = newFileName;
				}//if
				
				if (!attachInfo.trim().equals("")) {
					attachInfo += ",";
				}//if
				attachInfo += fileOriginalName + "|";
				attachInfo += fileSavedName + "|";
				attachInfo += fileType + "|";
				attachInfo += fileSize;
			}//if
		}//while
	} catch (Exception e) {
		e.printStackTrace();
	}//try-catch
	
	attachInfo = util.getNullBlankCheck(attachInfo, "-");
	
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
%>
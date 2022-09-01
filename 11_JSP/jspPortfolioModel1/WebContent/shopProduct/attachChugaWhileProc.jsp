<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "_inc_top.jsp" %>

<%
	File isDir = new File(uploadPath);
	if (!isDir.exists()) {
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
	
	String[] array = new String[attachCounter];

	Enumeration files = multipartRequest.getFileNames(); //첨부파일의 집합
	while (files.hasMoreElements()) {
		String originalName = "-";
		String saveName = "-";
		long fileSize = 0;
		String fileType = "-";
		String mimeType = "-"; //Tika 라이브러리 필요함
		
		String tagName = (String) files.nextElement();
		File file = multipartRequest.getFile(tagName);
		if (file != null) {
			originalName = multipartRequest.getOriginalFileName(tagName);
			saveName = multipartRequest.getFilesystemName(tagName);
			fileSize = file.length();
			fileType = multipartRequest.getContentType(tagName);
			Tika tika = new Tika();
			mimeType = tika.detect(file);
			
			if (fileType.equals(mimeType)) {//첨부파일 정상
				String ext = saveName.substring(saveName.lastIndexOf("."));
				String newFileName = UUID.randomUUID().toString() + ext; //실제 저장될 새로운 파일이름..

				File newFile = new File(uploadPath + "/" + newFileName);
				file.renameTo(newFile); // saveName -> newFileName
				
				saveName = newFileName; // saveName -> newFileName
			} else {//첨부파일 비정상
				File deleteFile = new File(uploadPath + "/" + saveName);
				if (deleteFile.exists()) {
					deleteFile.delete();
				}//if
				
				originalName = "-";
				saveName = "-";
				fileSize = 0;
				fileType = "-";
				mimeType = "-";
			}//if
		}//if
		
		String imsiOneFileInfo = "";
		imsiOneFileInfo += originalName + "|";
		imsiOneFileInfo += saveName + "|";
		imsiOneFileInfo += fileSize + "|";
		imsiOneFileInfo += fileType + "|";
		imsiOneFileInfo += mimeType;
		
		String imsiName = tagName.replace("attachFile", "");
		int intTagName = Integer.parseInt(imsiName);
		array[intTagName - 1] = imsiOneFileInfo;
	}//while

	String attachInfo = "";
	
	for (int i = 0; i < array.length; i++) {
		if (!attachInfo.equals("")) {
			attachInfo += ",";
		}//if
		attachInfo += array[i];
	}//for
	
	if (attachInfo.equals("-|-|0|-|-,-|-|0|-|-,-|-|0|-|-")) {
		attachInfo = "-";
	}//if
	
	ShopProductDTO arguShopProductDto = new ShopProductDTO();
	arguShopProductDto.setProductName(productName);
	arguShopProductDto.setProductPrice(productPrice);
	arguShopProductDto.setVendorCode(vendorCode);
	arguShopProductDto.setAttachInfo(attachInfo);
	
	ShopProductDAO shopProductDao = new ShopProductDAO();
	int result = shopProductDao.setInsert(arguShopProductDto);
	
	if (result <= 0) {
		for (int i = 0; i < array.length; i++) {
			if (!array[i].equals("-|-|0|-|-")) {
				String[] deletefileInfo = array[i].split("[|]");
				File deleteFile = new File(uploadPath + "/" + deletefileInfo[1]);
				if (deleteFile.exists()) {
					deleteFile.delete();
				}//if
			}//if
		}//for
	}//if
	
	String resultPage = "shopProduct_list";
	out.println("<script>");
	if (result <= 0) {
		out.println("alert('등록 처리 중 오류가 발생했습니다.');");
		resultPage = "shopProduct_attachChugaWhile";
	}//if
	out.println("location.href = 'main.jsp?menuGubun=" + resultPage + "';");
	out.println("</script>");

%>
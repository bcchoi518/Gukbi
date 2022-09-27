<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="product.model.dto.ProductDTO"%>
<%@page import="product.model.dao.ProductDAO"%>

<%
	request.setCharacterEncoding("UTF-8");
	
	String cate = request.getParameter("cate");
	String pName = request.getParameter("pName");
	String price_ = request.getParameter("price");
	
	int errCounter = 0;
	if (cate == null || cate.trim().equals("")) {
		errCounter++;
	} else if (pName == null || pName.trim().equals("")) {
		errCounter++;
	} else if (price_ == null || price_.trim().equals("")) {
		price_ = "0";
		errCounter++;
	}//if
	
	if (errCounter > 0) {
		out.println("<script>");
		out.println("alert('정상적인 값이 입력되지 않았습니다.');");
		out.println("location.href = 'product.jsp';");
		out.println("</script>");
		return;
	}//if
	
	int price = Integer.parseInt(price_);
	
	ProductDTO arguProductDto = new ProductDTO();
	arguProductDto.setCate(cate);
	arguProductDto.setpName(pName);
	arguProductDto.setPrice(price);
	
	ProductDAO productDao = new ProductDAO();
	int result = productDao.setInsert(arguProductDto);
	
	if (result > 0) {
		out.println("<script>");
		out.println("alert('등록이 정상적으로 완료되었습니다.');");
		out.println("location.href = 'product.jsp';");
		out.println("</script>");
	} else {
		out.println("<script>");
		out.println("alert('등록 처리 중 오류가 발생했습니다.');");
		out.println("location.href = 'product.jsp';");
		out.println("</script>");
	}//if
%>
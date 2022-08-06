<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.PreparedStatement"%>

<%@ include file = "../include/inc_dbInfo.jsp" %>

<%
	request.setCharacterEncoding("UTF-8");

	String arg1_ = request.getParameter("arg1");
	
	String tmp = arg1_;
	for (int i = 0; i < 10; i++) {
		tmp = tmp.replace(i + "", "");
	}//end for
	
	if (arg1_ == null || arg1_.trim().equals("") || tmp.length() > 0) {
		out.println("<script>");
		out.println("alert('정상적인 접속이 아닙니다.');");
		out.println("location.href='../main/main.jsp?menuGubun=product2_list';");
		out.println("</script>");
		return;
	}//end if
	
	int arg1 = Integer.parseInt(arg1_);

	String productName = request.getParameter("productName");
	String productPrice_ = request.getParameter("productPrice");
	String productContent = request.getParameter("productContent");
	String productCategory = request.getParameter("productCategory");
	String vendor = request.getParameter("vendor");
	
	if (productName == null || productName.trim().equals("")) {
		out.println("<script>");
		out.println("alert('상품이름이 입력되지 않았습니다.');");
		out.println("location.href='../main/main.jsp?menuGubun=product2_sujung&arg1=" + arg1 + "';");
		out.println("</script>");
		return;
	} else if (productPrice_ == null || productPrice_.trim().equals("")) {
		out.println("<script>");
		out.println("alert('상품가격이 입력되지 않았습니다.');");
		out.println("location.href='../main/main.jsp?menuGubun=product2_sujung&arg1=" + arg1 + "';");
		out.println("</script>");
		return;
	} else if (productContent == null || productContent.trim().equals("")) {
		out.println("<script>");
		out.println("alert('상품내용이 입력되지 않았습니다.');");
		out.println("location.href='../main/main.jsp?menuGubun=product2_sujung&arg1=" + arg1 + "';");
		out.println("</script>");
		return;
	} else if (productCategory == null || productCategory.trim().equals("")) {
		out.println("<script>");
		out.println("alert('상품분류가 입력되지 않았습니다.');");
		out.println("location.href='../main/main.jsp?menuGubun=product2_sujung&arg1=" + arg1 + "';");
		out.println("</script>");
		return;
	} else if (vendor == null || vendor.trim().equals("")) {
		out.println("<script>");
		out.println("alert('제조사가 입력되지 않았습니다.');");
		out.println("location.href='../main/main.jsp?menuGubun=product2_sujung&arg1=" + arg1 + "';");
		out.println("</script>");
		return;
	}//end if
	
	tmp = productPrice_;
	for (int i = 0; i < 10; i++) {
		tmp = tmp.replace(i + "", "");
	}//end for
	
	int productPrice = 0;
	if (tmp.length() > 0) {
		out.println("<script>");
		out.println("alert('숫자만 입력 가능합니다.');");
		out.println("location.href='../main/main.jsp?menuGubun=product2_sujung&arg1=" + arg1 + "';");
		out.println("</script>");
		return;
	} else {
		productPrice = Integer.parseInt(productPrice_);
	}//end if
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	int result = 0;
	try {
		Class.forName(dbDriver);
		conn = DriverManager.getConnection(dbUrl, dbId, dbPw);
		System.out.println("오라클 접속 성공..");
		//----------------------------------------------------
		String sql = "UPDATE product SET productName = ?, productPrice = ?, productContent = ?, productCategory = ?, vendor = ? WHERE productCode = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, productName);
		pstmt.setInt(2, productPrice);
		pstmt.setString(3, productContent);
		pstmt.setString(4, productCategory);
		pstmt.setString(5, vendor);
		pstmt.setInt(6, arg1);
		result = pstmt.executeUpdate();
		//----------------------------------------------------
	} catch (Exception e) {
		System.out.println("오라클 접속 실패..");
	} finally {
		if (pstmt != null) { pstmt.close(); }
		if (conn != null) { conn.close(); }
		System.out.println("오라클 접속 해제..");
	}//end try-catch-finally
	
	if (result > 0) {
		out.println("<script>");
		out.println("location.href='../main/main.jsp?menuGubun=product2_view&arg1=" + arg1 + "';");
		out.println("</script>");
	} else {
		out.println("<script>");
		out.println("alert('수정 처리 중 오류가 발생했습니다.');");
		out.println("location.href='../main/main.jsp?menuGubun=product2_sujung&arg1=" + arg1 + "';");
		out.println("</script>");
	}//end if
%>
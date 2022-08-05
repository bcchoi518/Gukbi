<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %> 

<%@ include file = "../include/inc_dbInfo.jsp" %>

<%
	request.setCharacterEncoding("UTF-8");

	String arg1_ = request.getParameter("arg1");
	if (arg1_ == null || arg1_.trim().equals("")) {
		out.println("<script>");
		out.println("alert('정상적인 접속이 아닙니다.');");
		out.println("location.href='list.jsp';");
		out.println("</script>");
		return;
	}//end if
	int arg1 = Integer.parseInt(arg1_);
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	int result = 0;
	try {
		Class.forName(dbDriver);
		conn = DriverManager.getConnection(dbUrl, dbId, dbPw);
		System.out.println("오라클 접속 성공..");
		//-------------------------------------------------------
		String sql = "DELETE FROM product WHERE productCode = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, arg1);
		result = pstmt.executeUpdate();
		//-------------------------------------------------------
	} catch (Exception e) {
	//	e.printStackTrace();
		System.out.println("오라클 접속 실패..");
	} finally {
		if (pstmt != null) { pstmt.close(); }
		if (conn != null) { conn.close(); }
		System.out.println("오라클 접속 해제..");
	}//end try-catch-finally
	
	if (result > 0) {
		out.println("<script>");
		out.println("location.href='list.jsp';");
		out.println("</script>");
	} else {
		out.println("<script>");
		out.println("alert('삭제 처리 중 오류가 발생했습니다.');");
		out.println("location.href='sakje.jsp?arg1=" + arg1 + "';");
		out.println("</script>");
	}//end if
%>
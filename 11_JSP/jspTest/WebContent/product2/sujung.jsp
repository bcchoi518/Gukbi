<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.sql.Date"%>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.PreparedStatement" %> 

<%@ include file = "../include/inc_dbInfo.jsp" %>

<%
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
	
	String productCode = "";
	String productName = "";
	int productPrice = 0;
	String productContent = "";
	String productCategory = "";
	String vendor = "";
	Date regiDate = null;
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	int result = 0;
	try {
		Class.forName(dbDriver);
		conn = DriverManager.getConnection(dbUrl, dbId, dbPw);
		System.out.println("오라클 접속 성공..");
		//-------------------------------------------------------
		String sql = "SELECT * FROM product WHERE productCode = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, arg1);
		rs = pstmt.executeQuery();
		if (rs.next()) {
			productCode = rs.getString("productCode");
			productName = rs.getString("productName");
			productPrice = rs.getInt("productPrice");
			productContent = rs.getString("productContent");
			productCategory = rs.getString("productCategory");
			vendor = rs.getString("vendor");
			regiDate = rs.getDate("regiDate");
		}//end if
		//-------------------------------------------------------
	} catch (Exception e) {
	//	e.printStackTrace();
		System.out.println("오라클 접속 실패..");
	} finally {
		if (rs != null) { rs.close(); }
		if (pstmt != null) { pstmt.close(); }
		if (conn != null) { conn.close(); }
		System.out.println("오라클 접속 해제..");
	}//end try-catch-finally
%>
	
	<h2>상품정보수정</h2>
	<form name="sujungForm">
		<input type="hidden" name="arg1" value="<%=productCode %>" />
		<table border="1" align="center">
			<tr>
				<th>상품이름</th>
				<td><input type="text" name="productName" value="<%=productName %>"/></td>
			</tr>
			<tr>
				<th>상품가격</th>
				<td><input type="text" name="productPrice" value="<%=productPrice %>"/></td>
			</tr>
			<tr>
				<th>상품내용</th>
				<td><textarea name="productContent" style="width: 300px; height: 100px;"><%=productContent %></textarea></td>
			</tr>
			<tr>
				<th>상품분류</th>
				<td><input type="text" name="productCategory" value="<%=productCategory %>"/></td>
			</tr>
			<tr>
				<th>제조사</th>
				<td><input type="text" name="vendor" value="<%=vendor %>"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="button" onClick="sujung();">수정하기</button>
				</td>
			</tr>
		</table>
	</form>
	<script>
		function sujung() {
			document.sujungForm.action = '../main/mainProc.jsp?menuGubun=product2_sujungProc';
			document.sujungForm.method = 'post';
			document.sujungForm.submit();
		}//end formSubmit
	</script>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.Date"%>

<%@ page import="java.util.ArrayList"%>

<%@ include file = "../include/inc_dbInfo.jsp" %>

<%
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	ArrayList<String> list = new ArrayList<>();
	try {
		Class.forName(dbDriver);
		conn = DriverManager.getConnection(dbUrl, dbId, dbPw);
		System.out.println("오라클 접속 성공..");
		//-----------------------------------------------------
		String sql = "SELECT * FROM product ORDER BY regiDate DESC";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			int productCode = rs.getInt("productCode");
			String productName = rs.getString("productName");
			int productPrice = rs.getInt("productPrice");
			String productCategory = rs.getString("productCategory");
			String vendor = rs.getString("vendor");
			Date regiDate = rs.getDate("regiDate");
			
			String msg = productCode + "/" + productName + "/" + productPrice + "/" + productCategory + "/" + vendor + "/" + regiDate;
			list.add(msg);
		}//end while
		//-----------------------------------------------------
	} catch (Exception e) {
		System.out.println("오라클 접속 실패..");
	} finally {
		if (rs != null) { rs.close(); }
		if (pstmt != null) { pstmt.close(); }
		if (conn != null) { conn.close(); }
		System.out.println("오라클 접속 해제..");
	}//end try-catch-finally
%>

	<h2>상품목록</h2>
	<table border="1" width="70%">
		<tr>
			<th>순번</th>
			<th>상품이름</th>
			<th>상품가격</th>
			<th>상품분류</th>
			<th>제조사</th>
			<th>등록일</th>
		</tr>
		<%
			int totalCount = list.size();
			for (String item : list) {
				String[] itemArr = item.split("/");
		%>
		<tr>
			<td><%=totalCount-- %> (<%=itemArr[0] %>)</td>
			<td><a href="#" onClick="move('product2_view', '<%=itemArr[0] %>')"><%=itemArr[1] %></a></td>
			<td><%=itemArr[2] %></td>
			<td><%=itemArr[3] %></td>
			<td><%=itemArr[4] %></td>
			<td><%=itemArr[5] %></td>
		</tr>
		<%	} %>
	</table>
	<div style="width:70%; text-align:right; margin-top:10px">
	|
	<a href="#" onClick="move('product2_list')">목록</a>
	|
	<a href="#" onClick="move('product2_chuga')">등록</a>
	|
	</div>
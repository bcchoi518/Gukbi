
<%@page import="java.sql.Date"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.ResultSet"%>

<%@ include file = "../include/inc_dbInfo.jsp" %>
<%@ include file = "_inc_top.jsp" %>

<%
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	ArrayList<String> list = new ArrayList<>();
	int result = 0;
	try {
		Class.forName(dbDriver);
		conn = DriverManager.getConnection(dbUrl, dbId, dbPw);
		System.out.println("오라클 접속 성공..");
		//-------------------------------------------------------
		String sql = "SELECT * FROM product ORDER BY regiDate DESC";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			int productCode = rs.getInt("productCode");
			String productName = rs.getString("productName");
			int productPrice = rs.getInt("productPrice");
			String productContent = rs.getString("productContent");
			String productCategory = rs.getString("productCategory");
			String vendor = rs.getString("vendor");
			Date regiDate = rs.getDate("regiDate");
			
			String msg = productCode + "/" + productName + "/" + productPrice + "/" + productContent + "/" + productCategory + "/" + vendor + "/" + regiDate;
			list.add(msg);
		}//end while
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

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>상품목록</title>
</head>
<body>
	<table border="1" width="80%" align="center">
		<tr>
			<td height="100px" align="center">
<!-- 		상단 메뉴 시작 -->
				<%@ include file ="../include/inc_menu.jsp" %>
<!-- 		상단 메뉴 종료 -->
			</td>
		</tr>
		<tr>
			<td height="300px" align="center">
<!-- 		본문 내용 시작 -->
				<h2>상품목록</h2>
				<table border="1" align="center" width="70%">
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
						String[] imsiArray= item.split("/");
%>
						<tr>
							<td><%=totalCount-- %>(<%=imsiArray[0] %>)</td>
							<td><a href="#" onClick="move('view.jsp', '<%=imsiArray[0] %>');"><%=imsiArray[1] %></a></td>
							<td><%=imsiArray[2] %></td>
							<td><%=imsiArray[4] %></td>
							<td><%=imsiArray[5] %></td>
							<td><%=imsiArray[6] %></td>
						</tr>
<%
					}
%>					
				</table>
				
				<div style="border: 0px solid blue; width: 70%; margin-top: 10px;" align="right">
				|
				<a href="#" onClick="move('list.jsp');">목록</a>
				|
				<a href="#" onClick="move('chuga.jsp');">등록</a>
				|
				</div>
<!-- 		본문 내용 종료 -->
			</td>
		</tr>
		<tr>
			<td height="100px" align="center">
				<%@ include file ="../include/inc_bottom.jsp" %>
			</td>
		</tr>
	</table>
	<script>
		function move(value1, value2) {
			if (value2 != undefined) {
				location.href = value1 + '?arg1=' + value2;
			} else {
				location.href = value1;
			}//end if
		}//end move
	</script>
</body>
</html>
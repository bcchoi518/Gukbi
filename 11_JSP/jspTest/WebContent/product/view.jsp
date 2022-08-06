<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.sql.Date"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.PreparedStatement" %> 

<%@ include file = "../include/inc_dbInfo.jsp" %>
<%@ include file = "_inc_top.jsp" %>

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
		out.println("location.href='list.jsp';");
		out.println("</script>");
		return;
	}//end if
	
	int arg1 = Integer.parseInt(arg1_);
	
	int productCode = 0;
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
			productCode = rs.getInt("productCode");
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
	productContent = productContent.replace("\n", "<br>");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품상세조회</title>
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
				<h2>상품상세조회</h2>
				<table border="1" align="center" width="50%">
					<tr>
						<th>상품코드</th>
						<td><%=productCode %></td>
					</tr>
					<tr>
						<th>상품이름</th>
						<td><%=productName %></td>
					</tr>
					<tr>
						<th>상품가격</th>
						<td><%=productPrice %></td>
					</tr>
					<tr>
						<th>상품내용</th>
						<td><%=productContent %></td>
					</tr>
					<tr>
						<th>상품분류</th>
						<td><%=productCategory %></td>
					</tr>
					<tr>
						<th>제조사</th>
						<td><%=vendor %></td>
					</tr>
					<tr>
						<th>등록일</th>
						<td><%=regiDate %></td>
					</tr>
				</table>
				<div style="border: 0px solid blue; width: 50%; margin-top: 10px;" align="right">
				|
				<a href="#" onClick="move('list.jsp');">목록</a>
				|
				<a href="#" onClick="move('chuga.jsp');">등록</a>
				|
				<a href="#" onClick="move('sujung.jsp', '<%=arg1 %>');">수정</a>
				|
				<a href="#" onClick="move('sakje.jsp', '<%=arg1 %>');">삭제</a>
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
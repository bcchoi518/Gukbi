<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.sql.Date"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.PreparedStatement" %> 

<%@ include file = "../include/inc_dbInfo.jsp" %>

<%
	String arg1 = request.getParameter("arg1");
	if (arg1 == null || arg1.trim().equals("")) {
		out.println("<script>");
		out.println("alert('정상적인 접속이 아닙니다.');");
		out.println("location.href='list.jsp';");
		out.println("</script>");
		return;
	}//end if
	
	String id = "";
	String passwd = "";
	String name = "";
	String phone = "";
	String email = "";
	String address = "";
	Date regiDate;
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	int result = 0;
	try {
		Class.forName(dbDriver);
		conn = DriverManager.getConnection(dbUrl, dbId, dbPw);
		System.out.println("오라클 접속 성공..");
		//-------------------------------------------------------
		String sql = "SELECT * FROM member WHERE id = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, arg1);
		rs = pstmt.executeQuery();
		if (rs.next()) {
			id = rs.getString("id");
			passwd = rs.getString("passwd");
			name = rs.getString("name");
			phone = rs.getString("phone");
			email = rs.getString("email");
			address = rs.getString("address");
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
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>회원정보수정</title>
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
				<h2>회원정보수정</h2>
				<form name="sujungForm">
				<input type="hidden" name="arg1" value="<%=id %>" />
					<table border="1">
						<tr>
							<td>아이디</td>
							<td><%=id %></td>
						</tr>
						<tr>
							<td>비밀번호</td>
							<td><input type="password"	name="passwd"></td>
						</tr>
						<tr>
							<td>이름</td>
							<td><%=name %></td>
						</tr>
						<tr>
							<td>전화번호</td>
							<td><input type="text"	name="phone" value="<%=phone %>"></td>
						</tr>
						<tr>
							<td>이메일</td>
							<td><input type="email"	name="email" value="<%=email %>"></td>
						</tr>
						<tr>
							<td>주소</td>
							<td><input type="text"	name="address" value="<%=address %>"></td>
						</tr>
						<tr>
							<td colspan="2">
							<button type="button" onClick="sujung();">수정하기</button>
							</td>
						</tr>
					</table>
				</form>
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
		function sujung() {
			document.sujungForm.action = "sujungProc.jsp";
			document.sujungForm.method = "post";
			document.sujungForm.submit();
		}//end join
	</script>
</body>
</html>
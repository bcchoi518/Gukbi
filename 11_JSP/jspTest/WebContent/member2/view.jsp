<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %> 
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Date"%>

<%@ include file = "../include/inc_dbInfo.jsp" %>
   
<%
	String arg1 = request.getParameter("arg1");
	
	if (arg1 == null || arg1.trim().equals("")) {
		out.println("<script>");
		out.println("alert('정상적인 접속이 아닙니다.');");
		out.println("location.href='main.jsp?menuGubun=member2_list';");
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

	<h2>회원상세보기</h2>
		<table border="1" align="center" width="50%">
			<tr>
				<td>아이디</td>
				<td><%=id %></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><%=name %></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><%=phone %></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><%=email %></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><%=address %></td>
			</tr>
		</table>
	<div style="border: 0px solid blue; width: 50%; margin-top: 10px;" align="right">
	|
	<a href="#" onClick="move('member2_list');">목록</a>
	|
	<a href="#" onClick="move('member2_chuga');">등록</a>
	|
	<a href="#" onClick="move('member2_sujung', '<%=id %>');">수정</a>
	|
	<a href="#" onClick="move('member2_sakje', '<%=id %>');">삭제</a>
	|
	</div>
	<script>
		function move(value1, value2) {
			if (value2 != undefined) {
				location.href = 'main.jsp?menuGubun=' + value1 + '&arg1=' + value2;
			} else {
				location.href = 'main.jsp?menuGubun=' + value1;
			}//end if
		}//end move
	</script>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	String passwdChk = request.getParameter("passwdChk");
	String name = request.getParameter("name");
	String phone = request.getParameter("phone");
	String email = request.getParameter("email");
	String address = request.getParameter("address");
	
	if (id == null || id.equals("")) {
// 		out.print("아이디 비정상..");
// 		response.sendRedirect("chuga.jsp"); //페이지 이동

// 		out.println("<script>");
// 		out.println("function move() {");
// 		out.println("location.href = 'chuga.jsp';");
// 		out.println("}//end move");
// 		out.println("move();");
// 		out.println("</script>");
%>

<%-- 	<a href="chuga.jsp">[가입페이지로 이동]</a> --%>

 		<script>
 			function move() {
 				alert('아이디를 입력하세요.');
//  			location.href = 'chuga.jsp';
// 				history.back();
				history.go(-1);
			}//end move
 			move();
		</script>
<%
		return;
	}//end if
	if (passwd == null || passwd.equals("")) {
		out.print("비밀번호 비정상..");
		return;
	}//end if
	if (passwdChk == null || passwdChk.equals("")) {
		out.print("비밀번호확인 비정상..");
		return;
	}//end if
	if (!passwd.equals(passwdChk)) {
		out.print("비밀번호 동일하지 않음..");
		return;
	}//end if
	if (name == null || name.equals("")) {
		out.print("이름 비정상..");
		return;
	}//end if
	if (phone == null || phone.equals("")) {
		out.print("전화번호 비정상..");
		return;
	}//end if
	if (email == null || email.equals("")) {
		out.print("이메일 비정상..");
		return;
	}//end if
	if (address == null || address.equals("")) {
		out.print("주소 비정상..");
		return;
	}//end if
	
// 	out.print("id: " + id + "<br>");
// 	out.print("passwd: " + passwd + "<br>");
// 	out.print("passwdChk: " + passwdChk + "<br>");
// 	out.print("name: " + name + "<br>");
// 	out.print("phone: " + phone + "<br>");
// 	out.print("email: " + email + "<br>");
// 	out.print("address: " + address + "<br>");

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try {
		String dbDriver = "oracle.jdbc.driver.OracleDriver";
		String dbUrl = "jdbc:oracle:thin:@localhost:1521/xe";
		String dbId = "javaOracle";
		String dbPw = "1234";
		
		Class.forName(dbDriver);
		conn = DriverManager.getConnection(dbUrl, dbId, dbPw);
		System.out.println("오라클 접속 성공..");
	} catch (Exception e) {
// 		e.printStackTrace();
		System.out.println("오라클 접속 실패..");
	} finally {
		if (rs != null) { rs.close(); }
		if (pstmt != null) { pstmt.close(); }
		if (conn != null) { conn.close(); }
	}//end try-catch-finally
	
	out.println("-- End --");
	
// 	response.sendRedirect("list.jsp");
%>
<%--
	<script>
		function movePage() {
			location.href = 'list.jsp';
		}//end movePage
		movePage();
	</script>
--%>

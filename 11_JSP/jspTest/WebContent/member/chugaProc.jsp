<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.PreparedStatement"%>

<%@ include file = "../include/inc_dbInfo.jsp" %>

<%
	request.setCharacterEncoding("UTF-8");
	
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	String passwdChk = request.getParameter("passwdChk");
	String name = request.getParameter("name");
	String phone = request.getParameter("phone");
	String email = request.getParameter("email");
	String address = request.getParameter("address");
	
	if (id == null || id.trim().equals("")) {
// 		out.print("아이디 비정상..");
// 		response.sendRedirect("chuga.jsp"); //페이지 이동
		out.println("<script>");
		out.println("alert('비밀번호를 입력하지 않았습니다.');");
		out.println("location.href='chuga.jsp';");
		out.println("</script>");
%>

<%-- 	<a href="chuga.jsp">[가입페이지로 이동]</a> --%>
<%-- 
 		<script>
 			function move() {
 				alert('아이디를 입력하세요.');
//  			location.href = 'chuga.jsp';
// 				history.back();
				history.go(-1);
			}//end move
		</script>
--%>
<%
		return;
	}//end if
	if (passwd == null || passwd.trim().equals("")) {
		out.println("<script>");
		out.println("alert('비밀번호를 입력하지 않았습니다.');");
		out.println("location.href='chuga.jsp';");
		out.println("</script>");
		return;
	}//end if
	if (passwdChk == null || passwdChk.trim().equals("")) {
		out.print("비밀번호확인 비정상..");
		return;
	}//end if
	if (!passwd.equals(passwdChk)) {
		out.print("비밀번호 동일하지 않음..");
		return;
	}//end if
	if (name == null || name.trim().equals("")) {
		out.print("이름 비정상..");
		return;
	}//end if
	if (phone == null || phone.trim().equals("")) {
		out.print("전화번호 비정상..");
		return;
	}//end if
	if (email == null || email.trim().equals("")) {
		out.print("이메일 비정상..");
		return;
	}//end if
	if (address == null || address.trim().equals("")) {
		out.print("주소 비정상..");
		return;
	}//end if
	
	Connection conn = null;
	PreparedStatement pstmt = null;

	int result = 0;
	try {
		Class.forName(dbDriver);
		conn = DriverManager.getConnection(dbUrl, dbId, dbPw);
		System.out.println("오라클 접속 성공..");
		//-------------------------------------------------------
		String sql = "INSERT INTO member (id, passwd, name, phone, email, address, regiDate) VALUES (?, ?, ?, ?, ?, ?, SYSDATE)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, passwd);
		pstmt.setString(3, name);
		pstmt.setString(4, phone);
		pstmt.setString(5, email);
		pstmt.setString(6, address);
		result = pstmt.executeUpdate();
	} catch (Exception e) {
// 		e.printStackTrace();
		System.out.println("오라클 접속 실패..");
	} finally {
		if (pstmt != null) { pstmt.close(); }
		if (conn != null) { conn.close(); }
		System.out.println("오라클 접속 해제..");
	}//end try-catch-finally
	
	if (result > 0) {
		//response.sendRedirect("list.jsp");
		out.println("<script>location.href='list.jsp';</script>");
	} else {
		//response.sendRedirect("chuga.jsp");
		out.println("<script>");
		out.println("alert('추가 처리 중 오류가 발생했습니다.');");
		out.println("location.href='chuga.jsp';");
		out.println("</script>");
	}//end if
%>
<%--
	<script>
		function movePage() {
			location.href = 'list.jsp';
		}//end movePage
		movePage();
	</script>
--%>
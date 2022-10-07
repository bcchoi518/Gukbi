<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "../_include/inc_top.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	h2 {
		text-align:center;
	}
	table {
		margin: 0 auto;
	}
</style>
</head>
<body>

	<h2>로그인</h2>
	
	<form name="DirForm">
		<table border="1">
			<tr>
				<td>아이디 : </td>
				<td><input type="text" name="id" /></td>
			</tr>
			<tr>
				<td>비밀번호 : </td>
				<td><input type="password" name="passwd" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="button" onclick="login()">로그인</button>
					<button type="button" onclick="location.href='${path }/signUp'">회원가입</button>
				</td>
			</tr>
		</table>
	</form>
	
	<script>
		function login() {
			if (confirm('signIn OK?')) {
				document.DirForm.action = '${path }/signInProc';
				document.DirForm.method = 'post';
				document.DirForm.submit();
			}//if
		}//login
	</script>
	
</body>
</html>
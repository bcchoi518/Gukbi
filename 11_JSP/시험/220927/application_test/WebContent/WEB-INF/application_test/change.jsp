<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>${sessionScope.sessionId }님 환영합니다. <a href="${requestScope.path }/logout">[로그아웃]</a></h1>

	<h1>비밀번호 수정 페이지입니다.</h1>

	<form name="DirForm">
		<input type="hidden" name="id" value="${sessionScope.sessionId }">
		<table border="1">
			<tr>
				<td>비밀번호 : </td>
				<td><input type="password" name="passwd" /></td>
			</tr>
			<tr>
				<td>비밀번호 확인 : </td>
				<td><input type="password" name="passwdChk" /></td>
			</tr>
			<tr>
				<td colspan="2"><button type="button" onclick="changePasswd()">비밀번호변경하기</button></td>
			</tr>
		</table>
	</form>
	
	<script>
		function changePasswd() {
			const frm = document.DirForm;
			
			if (frm.passwd.value.length <= 0) {
				alert('비밀번호를 입력해 주세요.');
				frm.passwd.focus();
				return;
			} else if (frm.passwdChk.value.length <= 0) {
				alert('비밀번호 확인을 입력해 주세요.');
				frm.passwdChk.focus();
				return;
			}//if
			
			if (confirm('password change OK?')) {
				frm.action = '${requestScope.path }/changeProc';
				frm.method = 'post';
				frm.submit();
			}//if
		}//login
	</script>
	
</body>
</html>
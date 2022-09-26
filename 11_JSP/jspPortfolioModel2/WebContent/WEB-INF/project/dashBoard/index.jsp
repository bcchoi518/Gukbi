<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "../include/inc_header.jsp" %>

<div style="border: 0px solid red; width: 60%">
	<font style="font-size:100px; font-weight:bold;">Here<br>We<br>Go !!!</font>
	<c:if test="${sessionScope.sessionNo == null || sessionScope.sessionNo == '' || sessionScope.sessionNo == 0 }">
		<div style="padding: 20px 0px">
			<form name="DirForm">
				아이디: <input type="text" name="id" style="width: 80px;"> &nbsp;
				비밀번호: <input type="password" name="passwd" style="width: 80px;"> &nbsp;
				<button type="button" onClick="login()">로그인</button>
			</form>
		</div>
	</c:if>
	<script>
		function login() {
			if (confirm('로그인할까요?')) {
				document.DirForm.action = '${requestScope.path }/noLogin_servlet/noLogin_loginProc.do';
				document.DirForm.method = 'post';
				document.DirForm.submit();
			}//if
		}//login
	</script>
</div>
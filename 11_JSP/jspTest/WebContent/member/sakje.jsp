<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원삭제</title>
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
				<form name="sakjeForm">
					<table border="1">
						<tr>
							<td>아이디</td>
							<td>hong</td>
						</tr>
						<tr>
							<td>비밀번호</td>
							<td><input type="password"	name="passwd"></td>
						</tr>
						<tr>
							<td>이름</td>
							<td>홍길동</td>
						</tr>
						<tr>
							<td>전화번호</td>
							<td>010-1111-1111</td>
						</tr>
						<tr>
							<td>이메일</td>
							<td>hong@mail.com</td>
						</tr>
						<tr>
							<td>주소</td>
							<td>대구</td>
						</tr>
						<tr>
							<td colspan="2">
							<button type="button" onClick="sakje();">삭제하기</button>
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
		function sakje() {
			document.sakjeForm.action = "sakjeProc.jsp";
			document.sakjeForm.method = "post";
			document.sakjeForm.submit();
		}//end join
	</script>
</body>
</html>
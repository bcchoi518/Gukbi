<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>회원상세보기</title>
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
				<h2>회원상세보기</h2>
					<table border="1" align="center" width="50%">
						<tr>
							<td>아이디</td>
							<td>hong</td>
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
					</table>
				<div style="border: 0px solid blue; width: 50%; margin-top: 10px;" align="right">
				|
				<a href="#" onClick="move('list.jsp');">목록</a>
				|
				<a href="#" onClick="move('chuga.jsp');">등록</a>
				|
				<a href="#" onClick="move('sujung.jsp');">수정</a>
				|
				<a href="#" onClick="move('sakje.jsp');">삭제</a>
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
		function move(url) {
			location.href = url;
		}//end move
	</script>
</body>
</html>
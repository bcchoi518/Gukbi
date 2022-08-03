<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>회원목록</title>
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
				<h2>회원목록</h2>
				
				<table border="1" align="center" width="70%">
					<tr>
						<th>순번</th>
						<th>아이디</th>
						<th>이름</th>
						<th>전화번호</th>
						<th>주소</th>
						<th>등록일</th>
					</tr>
					<tr>
						<td>5</td>
						<td><a href="#" onClick="move('view.jsp');">hong</a></td>
						<td>홍길동</td>
						<td>010-1111-1111</td>
						<td>대구</td>
						<td>2022-08-03</td>
					</tr>
					<tr>
						<td>4</td>
						<td><a href="#" onClick="move('view.jsp');">hong</a></td>
						<td>홍길동</td>
						<td>010-1111-1111</td>
						<td>대구</td>
						<td>2022-08-03</td>
					</tr>
					<tr>
						<td>3</td>
						<td><a href="#" onClick="move('view.jsp');">hong</a></td>
						<td>홍길동</td>
						<td>010-1111-1111</td>
						<td>대구</td>
						<td>2022-08-03</td>
					</tr>
					<tr>
						<td>2</td>
						<td><a href="#" onClick="move('view.jsp');">hong</a></td>
						<td>홍길동</td>
						<td>010-1111-1111</td>
						<td>대구</td>
						<td>2022-08-03</td>
					</tr>
					<tr>
						<td>1</td>
						<td><a href="#" onClick="move('view.jsp');">hong</a></td>
						<td>홍길동</td>
						<td>010-1111-1111</td>
						<td>대구</td>
						<td>2022-08-03</td>
					</tr>
				</table>
				
				<div style="border: 0px solid blue; width: 70%; margin-top: 10px;" align="right">
				|
				<a href="#" onClick="move('list.jsp');">목록</a>
				|
				<a href="#" onClick="move('chuga.jsp');">등록</a>
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
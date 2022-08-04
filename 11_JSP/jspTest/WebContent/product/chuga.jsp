<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품등록</title>
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
				<h2>상품등록</h2>
				<form name="insertForm">
					<table border="1" align="center">
						<tr>
							<th>상품이름</th>
							<td><input type="text" name="productName" /></td>
						</tr>
						<tr>
							<th>상품가격</th>
							<td><input type="text" name="productPrice" /></td>
						</tr>
						<tr>
							<th>상품설명</th>
							<td><textarea name="productContent" rows="3" cols="14"></textarea></td>
						</tr>
						<tr>
							<th>상품분류</th>
							<td><input type="text" name="productCategory" /></td>
						</tr>
						<tr>
							<th>제조사</th>
							<td><input type="text" name="vendor" /></td>
						</tr>
						<tr>
							<td colspan="2">
								<button type="button" onClick="insert();">등록하기</button>
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
		function insert() {
			document.insertForm.action = "chugaProc.jsp";
			document.insertForm.method = "post";
			document.insertForm.submit();
		}//end move
	</script>
</body>
</html>
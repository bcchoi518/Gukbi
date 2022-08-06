<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<h2>상품등록</h2>
	<form name="chugaForm">
		<table border="1">
			<tr>
				<th>상품이름</th>
				<td><input type="text" name="productName" /></td>
			</tr>
			<tr>
				<th>상품가격</th>
				<td><input type="text" name="productPrice" /></td>
			</tr>
			<tr>
				<th>상품내용</th>
				<td><textarea name="productContent" style="width:300px; height:100px"></textarea></td>
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
				<td colspan="2"><button type="button" onClick="chuga()">등록하기</button></td>
			</tr>
		</table>
	</form>
	<script>
		function chuga() {
			document.chugaForm.action = '../main/mainProc.jsp?menuGubun=product2_chugaProc';
			document.chugaForm.method = 'post';
			document.chugaForm.submit();
		}//end formSubmit
	</script>
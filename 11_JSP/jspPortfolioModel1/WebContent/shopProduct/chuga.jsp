<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "_inc_top.jsp" %>

<h2>상품 등록</h2>
<form name="inputForm">
	<table border="1">
		<tr>
			<td>상품명</td>	
			<td><input type="text" name="productName" /></td>
		</tr>
		<tr>
			<td>상품가격</td>	
			<td><input type="text" name="productPrice" /></td>
		</tr>
		<tr>
			<td>제조사</td>	
			<td>
				<select name="vendorCode">
					<option value="">-- 선택 --</option>
				<% 
					ShopVendorDAO shopVendorDao = new ShopVendorDAO();
					ArrayList<ShopVendorDTO> resultShopVendorList = shopVendorDao.getSelectAll();
					for (int i = 0; i < resultShopVendorList.size(); i++) {
						ShopVendorDTO resultShopVendorDto = resultShopVendorList.get(i);
				%>
					<option value="<%=resultShopVendorDto.getVendorCode() %>"><%=resultShopVendorDto.getVendorName() %></option>
				<%
					}//for
				%>
				</select>
			</td>
		</tr>
		<tr>
			<td>상품이미지</td>	
			<td>
				<input type="file" name="attachFile1" class="fileUp"/><br>
				<input type="file" name="attachFile2" class="fileUp"/><br>
				<input type="file" name="attachFile3" class="fileUp"/>
			</td>	
		</tr>
		<tr>
			<td>
				<button type="button" onclick="formSubmit()">등록하기</button>
				<button type="button" onclick="location.href='main.jsp?menuGubun=shopProduct_list';">목록으로</button>
			</td>	
		</tr>
	</table>
</form>

<script>
	function formSubmit() {
		if (confirm('등록할까요?')) {
			document.inputForm.enctype = 'multipart/form-data';
			document.inputForm.action = 'mainProc.jsp?menuGubun=shopProduct_chugaProc';
			document.inputForm.method = 'post';
 			document.inputForm.submit();
		}//if
	}//formSubmit
</script>
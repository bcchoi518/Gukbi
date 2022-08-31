<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "_inc_top.jsp" %>

<%
	String productCode_ = request.getParameter("productCode");
	
	productCode_ = util.getNullBlankCheck(productCode_, "0");
	
	int productCode = Integer.parseInt(productCode_);

	ShopProductDTO arguShopProductDto = new ShopProductDTO();
	arguShopProductDto.setProductCode(productCode);
	
	ShopProductDAO shopProductDao = new ShopProductDAO();
	ShopProductDTO resultShopProductDto = shopProductDao.getSelectOne(arguShopProductDto);
%>

<h2>상품 수정</h2>
<form name="inputForm">
	<input type="hidden" name="productCode" value="<%=resultShopProductDto.getProductCode() %>" />
	<table border="1">
		<tr>
			<td>상품명</td>	
			<td><input type="text" name="productName" value="<%=resultShopProductDto.getProductName() %>"/></td>	
		</tr>
		<tr>
			<td>상품가격</td>	
			<td><input type="text" name="productPrice" value="<%=resultShopProductDto.getProductPrice() %>"/></td>	
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
					<option value="<%=resultShopVendorDto.getVendorCode() %>" <% if (resultShopVendorDto.getVendorCode() == resultShopProductDto.getVendorCode()) { out.println("selected"); } %>><%=resultShopVendorDto.getVendorName() %></option>
				<%
					}//for
				%>
				</select>
			</td>
		</tr>
		<tr>
			<td>상품이미지</td>	
			<td>
				<input type="file" name="attachInfo" /><br>
				<input type="file" name="attachInfo" /><br>
				<input type="file" name="attachInfo" />
			</td>	
		</tr>
		<tr>
			<td>
				<button type="button" onclick="formSubmit()">수정하기</button>
				<button type="button" onclick="location.href='main.jsp?menuGubun=shopProduct_list';">목록으로</button>
			</td>	
		</tr>
	</table>
</form>

<script>
	function formSubmit() {
		if (confirm('수정할까요?')) {
			document.inputForm.action = 'mainProc.jsp?menuGubun=shopProduct_sujungProc';
			document.inputForm.method = 'post';
			document.inputForm.submit();
		}//if
	}//formSubmit
</script>
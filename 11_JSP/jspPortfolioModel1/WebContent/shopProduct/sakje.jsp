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

<h2>상품 삭제</h2>
<form name="inputForm">
	<input type="hidden" name="productCode" value="<%=resultShopProductDto.getProductCode() %>" />
	<table border="1">
		<tr>
			<td>상품이미지</td>	
			<td>
			<%
				if (resultShopProductDto.getAttachInfo() == null || resultShopProductDto.getAttachInfo().equals("-")) {
					out.println("&nbsp;");
				} else {
					String[] attachArray = resultShopProductDto.getAttachInfo().split(",");
					for (int j = 0; j < attachArray.length; j++) {
						String[] imsiArray2 = attachArray[j].split("[|]");
						
						String imsiImgPath = "";
						imsiImgPath += request.getContextPath();
						imsiImgPath += "/attach";
						imsiImgPath += request.getContextPath();
						imsiImgPath += "/shopProduct/";
						imsiImgPath += imsiArray2[1];
						
						out.println("<img src=\""+ imsiImgPath + "\" width=\"70\" height=\"70\">");
					}//for
				}//if
			%>
			</td>	
		</tr>
		<tr>
			<td>상품명</td>	
			<td><%=resultShopProductDto.getProductName() %></td>	
		</tr>
		<tr>
			<td>상품가격</td>	
			<td><%=resultShopProductDto.getProductPrice() %></td>	
		</tr>
		<tr>
			<td>제조사</td>	
			<td><%=resultShopProductDto.getVendorCode() %></td>
		</tr>
		<tr>
			<td>
				<button type="button" onclick="formSubmit()">삭제하기</button>
				<button type="button" onclick="location.href='main.jsp?menuGubun=shopProduct_list';">목록으로</button>
			</td>	
		</tr>
	</table>
</form>

<script>
	function formSubmit() {
		if (confirm('삭제할까요?')) {
			document.inputForm.action = 'mainProc.jsp?menuGubun=shopProduct_sakjeProc';
			document.inputForm.method = 'post';
			document.inputForm.submit();
		}//if
	}//formSubmit
</script>
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

<h2>상품 상세보기</h2>
<form name="inputForm">
	<table border="1">
		<tr>
			<td>상품코드</td>	
			<td><%=resultShopProductDto.getProductCode() %></td>	
		</tr>
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
			<td>등록일</td>	
			<td><%=resultShopProductDto.getRegiDate() %></td>	
		</tr>
	</table>
</form>

<div style="border:0px solid red; width:80%; text-align:right; margin-top: 20px;">
|
<a href="#" onclick="move('shopProduct_list')">목록</a>
|
<a href="#" onclick="move('shopProduct_chuga')">등록</a>
|
<a href="#" onclick="move('shopProduct_sujung','<%=resultShopProductDto.getProductCode() %>')">수정</a>
|
<a href="#" onclick="move('shopProduct_sakje','<%=resultShopProductDto.getProductCode() %>')">삭제</a>
|
</div>

<script>
	function move(addr, productCode) {
		let linkAddr = 'main.jsp?menuGubun=' + addr;
		if (productCode != undefined) {
			linkAddr += '&productCode=' + productCode;
		}//if
		location.href = linkAddr;
	}//if
</script>
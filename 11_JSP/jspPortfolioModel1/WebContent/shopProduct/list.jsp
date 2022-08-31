<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "_inc_top.jsp" %>

<%
	ShopProductDAO shopProductDao = new ShopProductDAO();

	ArrayList<ShopProductDTO> shopProductList = shopProductDao.getSelectAll();
%>

<h2>상품 목록</h2>
<table border="1">
	<tr>
		<th>순번</th>
		<th>상품이미지</th>
		<th>상품명</th>
		<th>상품가격</th>
		<th>제조사코드</th>
		<th>등록일</th>
	</tr>
<%
		if (shopProductList.size() == 0) {
			out.println("<tr>");
			out.println("<td colspan=\"6\" height=\"100px\" style=\"text-align:center;\">저장된 정보가 없습니다.</td>");
			out.println("</tr>");
		}//if
%>
<%
	for (int i = 0; i < shopProductList.size(); i++) {
		ShopProductDTO resultShopProductDto = shopProductList.get(i);
%>
	<tr>
		<td><%=resultShopProductDto.getProductCode() %></td>
		<td>
		<%
			if (resultShopProductDto.getAttachInfo() == null || resultShopProductDto.getAttachInfo().equals("-")) {
				out.println("&nbsp;");
			} else {
				String[] attachArray = resultShopProductDto.getAttachInfo().split(",");
// 				for (int j = 0; j < attachArray.length; j++) {
					String[] imsiArray2 = attachArray[0].split("[|]");
					
					String imsiImgPath = "";
					imsiImgPath += request.getContextPath();
					imsiImgPath += "/attach";
					imsiImgPath += request.getContextPath();
					imsiImgPath += "/shopProduct/";
					imsiImgPath += imsiArray2[1];
					
					out.println("<img src=\""+ imsiImgPath + "\" width=\"70\" height=\"70\">");
// 				}//for
			}//if
		%>
		</td>
		<td><a href="#" onclick="move('shopProduct_view','<%=resultShopProductDto.getProductCode() %>')"><%=resultShopProductDto.getProductName() %></a></td>
		<td><%=resultShopProductDto.getProductPrice() %></td>
		<td><%=resultShopProductDto.getVendorCode() %></td>
		<td><%=resultShopProductDto.getRegiDate() %></td>
	</tr>
<%
	}//for 
%>
</table>

<div style="border:0px solid red; width:80%; text-align:right; margin-top: 20px;">
|
<a href="#" onclick="move('shopProduct_list')">목록</a>
|
<a href="#" onclick="move('shopProduct_attachChuga')">등록</a>
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
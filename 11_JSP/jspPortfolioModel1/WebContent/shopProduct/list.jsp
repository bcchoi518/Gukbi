<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "_inc_top.jsp" %>

<%
//search start
	String searchValue = "O";
	String searchGubun = request.getParameter("searchGubun");
	String searchData = request.getParameter("searchData");
	
	searchGubun = util.getNullBlankCheck(searchGubun, "");
	searchData = util.getNullBlankCheck(searchData, "");
	searchData = util.getCheckString(searchData);
	
	if (searchGubun.equals("") || searchData.equals("")) {
		searchValue = "X";
		searchGubun = "";
		searchData = "";
	}//if
//search end	

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
 				for (int j = 0; j < attachArray.length; j++) {
 					if (!attachArray[j].equals("-|-|0|-|-")) {
 						String[] imsiArray2 = attachArray[j].split("[|]");
 						
 						String imsiImgPath = "";
 						imsiImgPath += request.getContextPath();
 						imsiImgPath += "/attach";
 						imsiImgPath += request.getContextPath();
 						imsiImgPath += "/shopProduct/";
 						imsiImgPath += imsiArray2[1];
 						
 						out.println("<img src=\""+ imsiImgPath + "\" width=\"70\" height=\"70\">");
 					}//if
 					if (j == 0) {
 						break;
 					}//if
 				}//for
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
<a href="#" onclick="move('shopProduct_attachChugaWhile')">등록(while)</a>
|
</div>

<!-- search start -->
<div style="border: 0px solid red; padding-top:20px; width:80%;">
	<form name="searchForm" style="padding:0px;">
		<div style="margin:0px; padding:0px; display:flex; justify-content: center;">
			<select name="searchGubun" style="border:0px; padding:0px 10px; height:30px; border-radius:10px 0px 0px 10px;">
				<option value="">-- 선택 --</option>
				<option value="productCode" <% if (searchGubun.equals("productCode")) { out.println("selected"); } %>>상품코드</option>
				<option value="productName" <% if (searchGubun.equals("productName")) { out.println("selected"); } %>>상품명</option>
				<option value="productPrice" <% if (searchGubun.equals("productPrice")) { out.println("selected"); } %>>상품가격</option>
				<option value="productCode_productName_productPrice" <% if (searchGubun.equals("productCode_productName_productPrice")) { out.println("selected"); } %>>상품코드+상품명+상품가격</option>
			</select>
			<input type="text" name="searchData" value="<%=searchData %>" style="border:0px; margin:0px; padding:0px; height:30px; width:200px;"/>
			<button type="button" onclick="search()" style="border:0px; border-radius:0px 10px 10px 0px; margin:0px; padding:0px 10px; height:30px; font-size:1rem;">검색</button>
		</div>
	</form>
</div>
<!-- search end -->

<script>
	function move(addr, productCode) {
		let linkAddr = 'main.jsp?menuGubun=' + addr;
		if (productCode != undefined) {
			linkAddr += '&productCode=' + productCode;
		}//if
		location.href = linkAddr;
	}//if
</script>
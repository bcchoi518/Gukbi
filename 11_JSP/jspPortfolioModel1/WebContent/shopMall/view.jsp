<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="_inc_top.jsp"%>

<%
	String productCode_ = request.getParameter("productCode");
	productCode_ = util.getNullBlankCheck(productCode_, "0");
	int productCode = Integer.parseInt(productCode_);
	
	ShopProductDTO arguShopProductDto = new ShopProductDTO();
	arguShopProductDto.setProductCode(productCode);
	
	ShopProductDAO shopProductDao = new ShopProductDAO();
	ShopProductDTO resultShopProductDto = shopProductDao.getSelectOne(arguShopProductDto);
%>

<h2>쇼핑몰 상세보기</h2>
<table border="1">
	<tr>
		<td>상품번호</td>	
		<td><%=resultShopProductDto.getProductCode() %></td>	
	</tr>
	<tr>
		<td>상품이미지</td>	
		<td>
		<%
			if (resultShopProductDto.getAttachInfo() == null || resultShopProductDto.getAttachInfo().equals("-")) {
				out.println("이미지없음..");
			} else {
				String[] attachInfoArray = resultShopProductDto.getAttachInfo().split(",");
				for (int j = 0; j < attachInfoArray.length; j++) {
					if (!attachInfoArray[j].equals("-|-|0|-|-")) {
						String[] attachFileArray = attachInfoArray[j].split("[|]");
						
						String imsiImgPath = "";
						imsiImgPath += request.getContextPath();
						imsiImgPath += "/attach";
						imsiImgPath += request.getContextPath();
						imsiImgPath += "/shopProduct/";
						imsiImgPath += attachFileArray[1];
						
						out.println("<img src=\""+ imsiImgPath + "\" width=\"150\" height=\"150\">");
 					}//if
				}//for
			}//if
		%>
		</td>	
	</tr>
	<tr>
		<td>상품이름</td>	
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
	<tr>
		<td colspan="2" style="padding:20px">
			<select name="jumunSu">
				<option value="0">-- 선택 --</option>
				<% for (int i = 1; i <= 20; i++) { %>
					<option value="<%=i %>"><%=i %></option>
				<% }//for %>
			</select>
			&nbsp;
			<button type="button">장바구니담기</button>
			<button type="button">바로구매</button>
			<button type="button">계속쇼핑</button>
			<button type="button">장바구니보기</button>
		</td>
	</tr>
</table>

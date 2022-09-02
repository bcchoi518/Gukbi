<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<%@ include file="_inc_top.jsp"%>

<%
	ShopProductDAO shopProductDao = new  ShopProductDAO();
	ArrayList<ShopProductDTO> shopProductlist = shopProductDao.getSelectAll();
	
	int productCounter = shopProductlist.size();
	int cellCounter = 3; //가로로 배열할 상품의 개수
	
	int imsiMok = productCounter / cellCounter;
	int imsiNa = productCounter % cellCounter;
	
	int rowCounter = 0;
	if (imsiNa > 0) {
	    rowCounter = imsiMok + 1;
	} else {
	    rowCounter = imsiMok;
	}//if
%>

<h2>쇼핑몰 목록</h2>

<table border="0">
<%
	int idx = 0;
	for (int i = 0; i < rowCounter; i++) {
%>
	<tr>
	<%
		for (int j = 0; j < cellCounter; j++) {
			String idxExist = "X"; //상품이 없을 경우
			if (idx < productCounter) {
				idxExist = "O"; //상품이 있을경우
			}//if

			int imsiCode = 0;
			String imsiName = "";
			int imsiPrice = 0;
			String imsiImg = "";
		   
			if (idxExist.equals("O")) {
				ShopProductDTO resultShopProductDto = shopProductlist.get(idx);
		  	 
				imsiCode = resultShopProductDto.getProductCode();
				imsiName = resultShopProductDto.getProductName();
				imsiPrice = resultShopProductDto.getProductPrice();
				
				String[] imsiAttachArray01 = resultShopProductDto.getAttachInfo().split(",");
				String[] imsiAttachArray02 = imsiAttachArray01[0].split("[|]");
				imsiImg = imsiAttachArray02[1];
				if (imsiImg.equals("-")) {
					imsiImg = "이미지없음...";
				} else {
					String imsiImgPath = "";
					imsiImgPath += request.getContextPath();
					imsiImgPath += "/attach";
					imsiImgPath += request.getContextPath();
					imsiImgPath += "/shopProduct/";
					imsiImgPath += imsiImg;
					
					imsiImg = "<img src=\""+ imsiImgPath + "\" width=\"150\" height=\"150\">";
				}//if
			}//if
	%>
			<td style="padding:20px 20px;">
				<% if (idxExist.equals("O")) { %>
					<table border="0" style="width:200px;" align="center">
						<tr>
						   <td height="100">
								<a href="#" onclick="move('shopMall_view','<%=imsiCode %>')"><%=imsiImg %></a>
						   </td>
						</tr>
						<tr>
				   			<td><%=imsiName %> (<%=imsiCode %>)</td>
						</tr>
						<tr>
						   <td ><%=imsiPrice %></td>
						</tr>
					</table>
				<% } else { %>
					&nbsp;
				<% }//if %> 
			</td>
	<%
		idx++;
		}//for
	%>
	</tr>
<%
	}//for
%>
</table>
<script>
	function move(value1,value2) {
		location.href = 'main.jsp?menuGubun=' + value1 + '&productCode=' + value2;
	}//move
</script>
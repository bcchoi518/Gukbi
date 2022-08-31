<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "_inc_top.jsp" %>

<%
	ShopVendorDAO shopVendorDao = new ShopVendorDAO();

	ArrayList<ShopVendorDTO> shopVendorList = shopVendorDao.getSelectAll();
%>

<h2>제조사 목록</h2>
<table border="1">
	<tr>
		<th>순번</th>
		<th>제조사명</th>
		<th>등록일</th>
		<th>비고</th>
	</tr>
<%
		if (shopVendorList.size() == 0) {
			out.println("<tr>");
			out.println("<td colspan=\"4\" height=\"100px\" style=\"text-align:center;\">저장된 정보가 없습니다.</td>");
			out.println("</tr>");
		}//if
%>
<%
	for (int i = 0; i < shopVendorList.size(); i++) {
		ShopVendorDTO resultShopVendorDto = shopVendorList.get(i);
%>
	<tr>
		<td><%=resultShopVendorDto.getVendorCode() %></td>
		<td><%=resultShopVendorDto.getVendorName() %></td>
		<td><%=resultShopVendorDto.getRegiDate() %></td>
		<td>
			<a href="#" onclick="move('shopVendor_sujung','<%=resultShopVendorDto.getVendorCode() %>')">[수정]</a>
			/
			<a href="#" onclick="move('shopVendor_sakje','<%=resultShopVendorDto.getVendorCode() %>')">[삭제]</a>
		</td>
	</tr>
<%
	}//for 
%>
</table>

<div style="border:0px solid red; width:80%; text-align:right; margin-top: 20px;">
|
<a href="#" onclick="move('shopVendor_list')">목록</a>
|
<a href="#" onclick="move('shopVendor_chuga')">등록</a>
|
</div>

<script>
	function move(addr, vendorCode) {
		let linkAddr = 'main.jsp?menuGubun=' + addr;
		if (vendorCode != undefined) {
			linkAddr += '&vendorCode=' + vendorCode;
		}//if
		location.href = linkAddr;
	}//if
</script>
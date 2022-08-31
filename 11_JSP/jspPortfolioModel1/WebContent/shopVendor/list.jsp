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

<!-- search start -->
<div style="border: 0px solid red; padding-top:20px; width:80%;">
	<form name="searchForm" style="padding:0px;">
		<div style="margin:0px; padding:0px; display:flex; justify-content: center;">
			<select name="searchGubun" style="border:0px; padding:0px 10px; height:30px; border-radius:10px 0px 0px 10px;">
				<option value="">-- 선택 --</option>
				<option value="vendorCode" <% if (searchGubun.equals("vendorCode")) { out.println("selected"); } %>>제조사코드</option>
				<option value="vendorName" <% if (searchGubun.equals("vendorName")) { out.println("selected"); } %>>제조사명</option>
				<option value="vendorCode_vendorName" <% if (searchGubun.equals("vendorCode_vendorName")) { out.println("selected"); } %>>제조사코드+제조사명</option>
			</select>
			<input type="text" name="searchData" value="<%=searchData %>" style="border:0px; margin:0px; padding:0px; height:30px; width:200px;"/>
			<button type="button" onclick="search()" style="border:0px; border-radius:0px 10px 10px 0px; margin:0px; padding:0px 10px; height:30px; font-size:1rem;">검색</button>
		</div>
	</form>
</div>
<!-- search end -->

<script>
	function move(addr, vendorCode) {
		let linkAddr = 'main.jsp?menuGubun=' + addr;
		if (vendorCode != undefined) {
			linkAddr += '&vendorCode=' + vendorCode;
		}//if
		location.href = linkAddr;
	}//if
</script>
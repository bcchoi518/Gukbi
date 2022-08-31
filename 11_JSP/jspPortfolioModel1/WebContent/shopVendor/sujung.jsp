<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "_inc_top.jsp" %>

<%
	String vendorCode_ = request.getParameter("vendorCode");
	
	vendorCode_ = util.getNullBlankCheck(vendorCode_, "0");
	
	int vendorCode = Integer.parseInt(vendorCode_);

	ShopVendorDTO arguShopVendorDto = new ShopVendorDTO();
	arguShopVendorDto.setVendorCode(vendorCode);
	
	ShopVendorDAO shopVendorDao = new ShopVendorDAO();
	ShopVendorDTO resultShopVendorDto = shopVendorDao.getSelectOne(arguShopVendorDto);
%>

<h2>제조사 수정</h2>

<form name="inputForm">
	<input type="hidden" name="vendorCode" value="<%=resultShopVendorDto.getVendorCode() %>" />
	<table border="1">
		<tr>
			<td>제조사명</td>	
			<td><input type="text" name="vendorName" value="<%=resultShopVendorDto.getVendorName() %>"/></td>	
		</tr>
		<tr>
			<td>
				<button type="button" onclick="formSubmit()">수정하기</button>
				<button type="button" onclick="location.href='main.jsp?menuGubun=shopVendor_list';">목록으로</button>
			</td>	
		</tr>
	</table>
</form>

<script>
	function formSubmit() {
		if (confirm('수정할까요?')) {
			document.inputForm.action = 'mainProc.jsp?menuGubun=shopVendor_sujungProc';
			document.inputForm.method = 'post';
			document.inputForm.submit();
		}//if
	}//formSubmit
</script>
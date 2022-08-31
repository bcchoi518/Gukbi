<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "_inc_top.jsp" %>

<h2>제조사 등록</h2>

<form name="inputForm">
	<table border="1">
		<tr>
			<td>제조사명</td>	
			<td><input type="text" name="vendorName" /></td>	
		</tr>
		<tr>
			<td>
				<button type="button" onclick="formSubmit()">등록하기</button>
				<button type="button" onclick="location.href='main.jsp?menuGubun=shopVendor_list';">목록으로</button>
			</td>	
		</tr>
	</table>
</form>

<script>
	function formSubmit() {
		if (confirm('등록할까요?')) {
			document.inputForm.action = 'mainProc.jsp?menuGubun=shopVendor_chugaProc';
			document.inputForm.method = 'post';
			document.inputForm.submit();
		}//if
	}//formSubmit
</script>
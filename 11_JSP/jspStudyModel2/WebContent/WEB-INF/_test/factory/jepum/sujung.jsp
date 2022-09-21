<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "../../../_include/inc_header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@ include file = "../../../_include/inc_menu.jsp" %>
	
	<h2>제품정보수정</h2>
	
	<form name="DirForm">
		<input type="hidden" name="code" value="${requestScope.dto.code }" />
		<table border="1" width="80%">
			<tr>
				<td>code</td>
				<td><input type="text" name="code" value="${requestScope.dto.code }"/></td>
			</tr>
			<tr>
				<td>name</td>
				<td><input type="text" name="name" value="${requestScope.dto.name }"/></td>
			</tr>
			<tr>
				<td>standard</td>
				<td><input type="text" name="standard" value="${requestScope.dto.standard }"/></td>
			</tr>
			<tr>
				<td>unit</td>
				<td><input type="text" name="unit" value="${requestScope.dto.unit }"/></td>
			</tr>
			<tr>
				<td>barcode</td>
				<td><input type="text" name="barcode" value="${requestScope.dto.barcode }"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="button" onclick="save()">수정하기</button>
				</td>
			</tr>
		</table>
	</form>
	
	<script>
		function save() {
			if (confirm('수정하시겠습니까?')) {
				document.DirForm.action = '${path }/jepum_servlet/sujungProc.do';
				document.DirForm.method = 'post';
				document.DirForm.submit();
			}//if
		}//save
	</script>
	
</body>
</html>
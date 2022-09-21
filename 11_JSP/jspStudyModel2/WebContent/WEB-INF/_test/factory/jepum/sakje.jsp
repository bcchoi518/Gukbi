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
	
	<h2>제품정보삭제</h2>
	
	<form name="DirForm">
		<input type="hidden" name="code" value="${requestScope.dto.code }" />
		<table border="1" width="80%">
			<tr>
				<td>code</td>
				<td>${requestScope.dto.code }</td>
			</tr>
			<tr>
				<td>name</td>
				<td>${requestScope.dto.name }</td>
			</tr>
			<tr>
				<td>standard</td>
				<td>${requestScope.dto.standard }</td>
			</tr>
			<tr>
				<td>unit</td>
				<td>${requestScope.dto.unit }</td>
			</tr>
			<tr>
				<td>barcode</td>
				<td>${requestScope.dto.barcode }</td>
			</tr>
			<tr>
				<td>wdate</td>
				<td>${requestScope.dto.wdate }</td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="button" onclick="save()">삭제하기</button>
				</td>
			</tr>
		</table>
	</form>
	
	<script>
		function save() {
			if (confirm('삭제하시겠습니까?')) {
				document.DirForm.action = '${path }/jepum_servlet/sakjeProc.do';
				document.DirForm.method = 'post';
				document.DirForm.submit();
			}//if
		}//save
	</script>
</body>
</html>
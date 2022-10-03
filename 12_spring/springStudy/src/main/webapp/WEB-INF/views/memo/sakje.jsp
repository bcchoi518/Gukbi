<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "../_include/inc_header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@ include file = "../_include/inc_menu.jsp" %>
	
	<h2>${requestScope.title }</h2>
	
	<form name="DirForm">
		<input type="hidden" name="no" value="${requestScope.dto.no }" />
		<table border="1" width="50%">
			<tr>
				<td>작성자</td>
				<td>${requestScope.dto.writer }</td>
			</tr>
			<tr>
				<td>내용</td>
				<td>${fn:replace(requestScope.dto.content, newLineChar, '<br>') }</td>
			</tr>
			<tr>
				<td colspan="2"><button type="button" onclick="save()" >삭제</button></td>
			</tr>
		</table>
	</form>
	
	<script>
		function save() {
			if (confirm('OK?')) {
				document.DirForm.action = '${path }/memo/sakjeProc';
				document.DirForm.method = 'post';
				document.DirForm.submit();
			}//if
		}//save
	</script>
	
</body>
</html>
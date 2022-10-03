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
				<td><input type="text" name="writer" value="${requestScope.dto.writer }"/></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="content" style="width:99%; height:150px;">${requestScope.dto.content }</textarea></td>
			</tr>
			<tr>
				<td colspan="2"><button type="button" onclick="save()" >수정</button></td>
			</tr>
		</table>
	</form>
	
	<script>
		function save() {
			if (confirm('OK?')) {
				document.DirForm.action = '${path }/memo/sujungProc';
				document.DirForm.method = 'post';
				document.DirForm.submit();
			}//if
		}//save
	</script>
	
</body>
</html>
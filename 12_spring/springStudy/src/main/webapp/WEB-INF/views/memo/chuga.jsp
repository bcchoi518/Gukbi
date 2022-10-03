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
		<table border="1" width="50%">
			<tr>
				<td>작성자</td>
				<td><input type="text" name="writer" /></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="content" style="width:99%; height:150px;"></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><button type="button" onclick="save()" >확인</button></td>
			</tr>
		</table>
	</form>
	
	<script>
		function save() {
			if (confirm('OK?')) {
				document.DirForm.action = '${path }/memo/chugaProc';
				document.DirForm.method = 'post';
				document.DirForm.submit();
			}//if
		}//save
	</script>
	
</body>
</html>
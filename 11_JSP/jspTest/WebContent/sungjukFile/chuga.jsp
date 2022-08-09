<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "_inc_fileInfo.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적관리</title>
</head>
<body>
	<h2>성적관리(등록)</h2>
	<form name="chugaForm">
		<table border="1">
			<tr>
				<th>이름</th>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<th>국어</th>
				<td><input type="text" name="kor" /></td>
			</tr>
			<tr>
				<th>영어</th>
				<td><input type="text" name="eng" /></td>
			</tr>
			<tr>
				<th>수학</th>
				<td><input type="text" name="mat" /></td>
			</tr>
			<tr>
				<th>과학</th>
				<td><input type="text" name="sci" /></td>
			</tr>
			<tr>
				<th>역사</th>
				<td><input type="text" name="his" /></td>
			</tr>
			<tr>
				<td colspan="2"><button type="button" onClick="chuga()">확인</button></td>
			</tr>
		</table>
	</form>
	<script>
		function chuga() {
			if (confirm('저장하시겠습니까?')) {
				document.chugaForm.action = 'chugaProc.jsp';
				document.chugaForm.method = 'post';
				document.chugaForm.submit();
			}//end if
		}//end chuga
	</script>
</body>
</html>
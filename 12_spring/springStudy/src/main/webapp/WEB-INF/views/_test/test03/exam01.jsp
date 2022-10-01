<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "../../_include/inc_header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@ include file = "../../_include/inc_menu.jsp" %>
	
		<h2>${requestScope.title }</h2>
	
	<form name="DirForm">
		<table border="1">
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>주민번호</td>
				<td><input type="text" name="jumin" /></td>
			</tr>
			<tr>
				<td>성별</td>
				<td><input type="text" name="gender" /></td>
			</tr>
			<tr>
				<td>나이</td>
				<td><input type="text" name="age" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="button" onclick="proc()">확인</button>
				</td>
			</tr>
		</table>
	</form>
	
	<script>
		function proc() {
			if (confirm('OK?')) {
				document.DirForm.action = '${path }/test03Proc';
				document.DirForm.method = 'post';
				document.DirForm.submit();
			}//if
		}//proc
	</script>
	
</body>
</html>
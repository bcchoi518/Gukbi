<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@ include file = "../../_include/inc_menu.jsp" %>
	
	<h2>02</h2>
<!-- 이름, 출생연도 입력받고 이름, 출생연도, 나이 출력 -->
	<form name="DirForm">
		<table border="1">
			<tr>
				<td>이름 : </td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>출생연도 : </td>
				<td><input type="text" name="birthYear" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="button" onclick="save()">확인</button>
				</td>
			</tr>
		</table>
	</form>
	
	<script>
		function save() {
			if (confirm('실행할까요?')) {
				document.DirForm.action = '/jspStudyModel2/exam_servlet/02Proc.do';
				document.DirForm.method = 'post';
				document.DirForm.submit();
			}//if
		}//save
	</script>
	
</body>
</html>

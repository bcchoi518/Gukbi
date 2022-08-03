<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>exam09.jsp</title>
</head>
<body>

	<h2>exam09.jsp</h2>
	
	<form name="exam09Form">
		<table border="1">
			<tr>
				<th>이름1</th>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<th>이름2</th>
				<td><input type="text" name="name" /></td>
			</tr>
				<tr>
				<th>이름3</th>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<th>회원등급</th>
				<td>
					<input type="radio" name="grade" value="최우수회원"/>최우수회원 &nbsp;
					<input type="radio" name="grade" value="우수회원"/>우수회원 &nbsp;
					<input type="radio" name="grade" value="일반회원" checked/>일반회원 &nbsp;
				</td>
			</tr>
			<tr>
				<td colspan="2"><button type="button" onClick="formSubmit();">확인</button></td>
			</tr>
		</table>
	</form>
	<script>
		function formSubmit() {
			document.exam09Form.action = "exam09Proc.jsp"
			document.exam09Form.method = "post"
			document.exam09Form.submit();
		}//end formSubmit
	</script>
</body>
</html>
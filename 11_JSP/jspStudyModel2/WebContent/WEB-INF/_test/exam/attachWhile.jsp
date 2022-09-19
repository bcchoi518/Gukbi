<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>

	<%@ include file = "../../_include/inc_menu.jsp" %>
	
	<h2>attachWhile</h2>
	
	<form name="DirForm">
		<table border="1">
			<tr>
				<td>첨부메모 : </td>
				<td><input type="text" name="memo" /></td>
			</tr>
			<tr>
				<td>첨부파일 : </td>
				<td>
					<input type="file" name="0" /><br>
					<input type="file" name="1" /><br>
					<input type="file" name="2" /><br>
					<input type="file" name="3" /><br>
					<input type="file" name="4" /><br>
					<input type="text" name="attachCounter" value="5"/>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="button" onclick="save()">등록하기</button>
				</td>
			</tr>
		</table>
	</form>
	
	<script>
		function save() {
			const f = document.DirForm;
			if (confirm('OK?')) {
				f.enctype = 'multipart/form-data';
				f.action = '${path }/exam_servlet/attachWhileProc.do';
				f.method = 'post';
				f.submit();
			}//if
		}//save
	</script>
</body>
</html>

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
	
	<h2>학사관리_시험정보등록</h2>
	
	<form name="DirForm">
		<table border="1" width="80%">
			<tr>
				<td>시험명</td>
				<td><input type="text" name="sihumName" /></td>
			</tr>
			<tr>
				<td>시험일</td>
				<td><input type="date" name="sihumDate" /></td>
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
			if (confirm('등록하시겠습니까?')) {
				document.DirForm.action = '${path }/haksaSihum_servlet/chugaProc.do';
				document.DirForm.method = 'post';
				document.DirForm.submit();
			}//if
		}//save
	</script>
	
</body>
</html>
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
	
	<h2>부서정보삭제</h2>
	
	<form name="DirForm">
		<input type="hidden" name="buseoNo" value="${requestScope.dto.buseoNo }" />
		<table border="1" width="80%">
			<tr>
				<td>부서번호</td>
				<td>${requestScope.dto.buseoNo }</td>
			</tr>
			<tr>
				<td>부서이름</td>
				<td>${requestScope.dto.buseoName }</td>
			</tr>
			<tr>
				<td>등록일</td>
				<td>${requestScope.dto.regiDate }</td>
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
				document.DirForm.action = '${path }/buseo_servlet/sakjeProc.do';
				document.DirForm.method = 'post';
				document.DirForm.submit();
			}//if
		}//save
	</script>
</body>
</html>
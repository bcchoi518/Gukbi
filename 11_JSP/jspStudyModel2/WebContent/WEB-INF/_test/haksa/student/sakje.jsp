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
	
	<h2>학사관리_학생정보삭제</h2>
	
	<form name="DirForm">
		<input type="hidden" name="hakbun" value="${requestScope.dto.hakbun }" />
		<table border="1" width="80%">
			<tr>
				<td>이름</td>
				<td>${requestScope.dto.name }</td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td>${requestScope.dto.phone }</td>
			</tr>
			<tr>
				<td>부모님전화번호</td>
				<td>${requestScope.dto.parentPhone }</td>
			</tr>
			<tr>
				<td>주소</td>
				<td>${requestScope.dto.addr1 } ${requestScope.dto.addr2 } ${requestScope.dto.addr3 } ${requestScope.dto.addr4 }</td>
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
				document.DirForm.action = '${path }/haksaStudent_servlet/sakjeProc.do';
				document.DirForm.method = 'post';
				document.DirForm.submit();
			}//if
		}//save
	</script>
</body>
</html>
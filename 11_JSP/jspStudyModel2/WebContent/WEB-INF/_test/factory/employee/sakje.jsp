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
	
	<h2>사원정보삭제</h2>
	
	<form name="DirForm">
		<input type="hidden" name="sabun" value="${requestScope.dto.sabun }" />
		<table border="1" width="80%">
			<tr>
				<td>사원번호</td>
				<td>${requestScope.dto.sabun }</td>
			</tr>
			<tr>
				<td>사원이름</td>
				<td>${requestScope.dto.name }</td>
			</tr>
			<tr>
				<td>연락처</td>
				<td>${requestScope.dto.phone }</td>
			</tr>
			<tr>
				<td>입사일</td>
				<td>${requestScope.dto.hireDate }</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td>${requestScope.dto.email }</td>
			</tr>
			<tr>
				<td>급여</td>
				<td>${requestScope.dto.salary }</td>
			</tr>
			<tr>
				<td>부서</td>
				<td>${requestScope.dto.buseoName }</td>
			</tr>
			<tr>
				<td>부서</td>
				<td>${requestScope.dto.positionName }</td>
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
				document.DirForm.action = '${path }/employee_servlet/sakjeProc.do';
				document.DirForm.method = 'post';
				document.DirForm.submit();
			}//if
		}//save
	</script>
</body>
</html>
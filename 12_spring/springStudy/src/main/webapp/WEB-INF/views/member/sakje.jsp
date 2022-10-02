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
		<input type="hidden" name="no" value="${requestScope.dto.no }" />
		<table border="1" width="80%">
			<tr>
				<td>아이디</td>
				<td>${requestScope.dto.id }</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="passwd" id="passwd" value="" /></td>
			</tr>
			<tr>
				<td>이름</td>
				<td>${requestScope.dto.name }</td>
			</tr>
			<tr>
				<td>연락처</td>
				<td>${requestScope.dto.phone }</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td>${requestScope.dto.email }</td>
			</tr>
			<tr>
				<td>주민번호</td>
				<td>${fn:substring(dto.jumin, 0, 7) }-${fn:substring(dto.jumin, 7, 8) }******</td>
			</tr>
			<tr>
				<td>주소</td>
				<td>
					(${requestScope.dto.juso1 })
					${requestScope.dto.juso2 }
					${requestScope.dto.juso3 }
					<c:if test="${requestScope.dto.juso4 != '-' }">
						${requestScope.dto.juso4 }
					</c:if>
				</td>
			</tr>
			<tr>
				<td>등급</td>
				<td>${requestScope.dto.grade }</td>
			</tr>
			<tr>
				<td>등록일</td>
				<td>${requestScope.dto.regiDate }</td>
			</tr>
			<tr>
				<td colspan="2" align="center" style="height:50px">
					<button type="button" onclick="save()">삭제</button>
				</td>
			</tr>
		</table>
	</form>
	
	<script>
	function save() {
		if (confirm('삭제하시겠습니까?')) {
			document.DirForm.action = '${path }/member/sakjeProc';
			document.DirForm.method = 'post';
			document.DirForm.submit();
		}//if
	}//save
	</script>
	
</body>
</html>
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
	
	<h2>사원정보수정</h2>
	
	<form name="DirForm">
		<input type="hidden" name="sabun" value="${requestScope.dto.sabun }" />
		<table border="1" width="80%">
			<tr>
				<td>사원이름</td>
				<td><input type="text" name="name" value="${requestScope.dto.name }"/></td>
			</tr>
			<tr>
				<td>연락처</td>
				<td><input type="text" name="phone" value="${requestScope.dto.phone }"/></td>
			</tr>
			<tr>
				<td>입사일</td>
				<td><input type="date" name="hireDate" value="${requestScope.dto.hireDate }"/></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="email" value="${requestScope.dto.email }"/></td>
			</tr>
			<tr>
				<td>급여</td>
				<td><input type="text" name="salary" value="${requestScope.dto.salary }"/></td>
			</tr>
			<tr>
				<td>부서</td>
				<td>
					<select name="buseoNo">
						<c:forEach var="buseoDto" items="${requestScope.buseoList }">
							<option value="${buseoDto.buseoNo }" <c:if test="${buseoDto.buseoNo == requestScope.dto.buseoNo }">selected</c:if>>${buseoDto.buseoName }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>직위</td>
				<td>
					<select name="positionNo">
						<c:forEach var="positionDto" items="${requestScope.positionList }">
							<option value="${positionDto.positionNo }" <c:if test="${positionDto.positionNo == requestScope.dto.positionNo }">selected</c:if>>${positionDto.positionName }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="button" onclick="save()">수정하기</button>
				</td>
			</tr>
		</table>
	</form>
	
	<script>
		function save() {
			if (confirm('수정하시겠습니까?')) {
				document.DirForm.action = '${path }/employee_servlet/sujungProc.do';
				document.DirForm.method = 'post';
				document.DirForm.submit();
			}//if
		}//save
	</script>
	
</body>
</html>
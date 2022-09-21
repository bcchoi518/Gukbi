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
	
	<h2>사원정보등록</h2>
	<form name="DirForm">
		<table border="1" width="80%">
			<tr>
				<td>사원이름</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>연락처</td>
				<td><input type="text" name="phone" /></td>
			</tr>
			<tr>
				<td>입사일</td>
				<td><input type="date" name="hireDate" /></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td>급여</td>
				<td><input type="text" name="salary" /></td>
			</tr>
			<tr>
				<td>부서</td>
				<td>
					<select name="buseoNo">
						<option value="0" selected>-- 선택 --</option>
						<c:forEach var="buseoDto" items="${requestScope.buseoList }">
							<option value="${buseoDto.buseoNo }">${buseoDto.buseoName }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>직위</td>
				<td>
					<select name="positionNo">
						<option value="0" selected>-- 선택 --</option>
						<c:forEach var="positionDto" items="${requestScope.positionList }">
							<option value="${positionDto.positionNo }">${positionDto.positionName }</option>
						</c:forEach>
					</select>
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
			if (confirm('등록하시겠습니까?')) {
				document.DirForm.action = '${path }/employee_servlet/chugaProc.do';
				document.DirForm.method = 'post';
				document.DirForm.submit();
			}//if
		}//save
	</script>
	
</body>
</html>
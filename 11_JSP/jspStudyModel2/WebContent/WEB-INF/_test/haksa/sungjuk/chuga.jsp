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
	
	<h2>학사관리_성적등록</h2>
	
	<form name="DirForm">
		<table border="1" width="80%">
			<tr>
				<td>이름</td>
				<td>
					<select name="hakbun">
						<option value="0">-- 선택 --</option>
						<c:forEach var="dto" items="${requestScope.studentList }">
							<option value="${dto.hakbun }">${dto.name }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>시험명</td>
				<td>
					<select name="sihumNo">
						<option value="0">-- 선택 --</option>
						<c:forEach var="dto" items="${requestScope.sihumList }">
							<option value="${dto.sihumNo }">${dto.sihumName }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>국어</td>
				<td><input type="text" name="kor" /></td>
			</tr>
			<tr>
				<td>영어</td>
				<td><input type="text" name="eng" /></td>
			</tr>
			<tr>
				<td>수학</td>
				<td><input type="text" name="mat" /></td>
			</tr>
			<tr>
				<td>과학</td>
				<td><input type="text" name="sci" /></td>
			</tr>
			<tr>
				<td>역사</td>
				<td><input type="text" name="his" /></td>
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
				document.DirForm.action = '${path }/haksaSungjuk_servlet/chugaProc.do';
				document.DirForm.method = 'post';
				document.DirForm.submit();
			}//if
		}//save
	</script>
	
</body>
</html>
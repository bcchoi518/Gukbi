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
	
	<h2>학사관리_성적수정</h2>
	
	<form name="DirForm">
		<input type="hidden" name="sungjukNo" value="${requestScope.dto.sungjukNo }"/>
		<table border="1" width="80%">
			<tr>
				<td>이름</td>
				<td>
					<select name="hakbun">
						<option value="0">-- 선택 --</option>
						<c:forEach var="studentDto" items="${requestScope.studentList }">
							<option value="${studentDto.hakbun }" <c:if test="${studentDto.hakbun == requestScope.dto.hakbun }">selected</c:if>>${studentDto.name }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>시험명</td>
				<td>
					<select name="sihumNo">
						<option value="0">-- 선택 --</option>
						<c:forEach var="sihumDto" items="${requestScope.sihumList }">
							<option value="${sihumDto.sihumNo }" <c:if test="${sihumDto.sihumNo == requestScope.dto.sihumNo }">selected</c:if>>${sihumDto.sihumName }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>국어</td>
				<td><input type="text" name="kor" value="${requestScope.dto.kor }"/></td>
			</tr>
			<tr>
				<td>영어</td>
				<td><input type="text" name="eng" value="${requestScope.dto.eng }"/></td>
			</tr>
			<tr>
				<td>수학</td>
				<td><input type="text" name="mat" value="${requestScope.dto.mat }"/></td>
			</tr>
			<tr>
				<td>과학</td>
				<td><input type="text" name="sci" value="${requestScope.dto.sci }"/></td>
			</tr>
			<tr>
				<td>역사</td>
				<td><input type="text" name="his" value="${requestScope.dto.his }"/></td>
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
				document.DirForm.action = '${path }/haksaSungjuk_servlet/sujungProc.do';
				document.DirForm.method = 'post';
				document.DirForm.submit();
			}//if
		}//save
	</script>
	
</body>
</html>
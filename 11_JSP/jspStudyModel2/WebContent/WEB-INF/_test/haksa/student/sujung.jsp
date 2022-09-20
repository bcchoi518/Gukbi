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
	
	<h2>학사관리_학생정보수정</h2>
	
	<form name="DirForm">
		<input type="hidden" name="hakbun" value="${requestScope.dto.hakbun }" />
		<table border="1" width="80%">
			<tr>
				<td>이름</td>
				<td>${requestScope.dto.name }</td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="phone" value="${requestScope.dto.phone }"/></td>
			</tr>
			<tr>
				<td>부모님전화번호</td>
				<td><input type="text" name="parentPhone" value="${requestScope.dto.parentPhone }"/></td>
			</tr>
			<tr>
				<td>주소</td>
				<td>
					<input type="text" name="addr1" id="sample6_postcode" value="${requestScope.dto.addr1 }" placeholder="우편번호" readonly>
					<button type="button" onclick="sample6_execDaumPostcode()">우편번호 찾기</button><br>
					<input type="text" name="addr2" id="sample6_address" value="${requestScope.dto.addr2 }" placeholder="주소" readonly><br>
					<input type="text" name="addr3" id="sample6_detailAddress" value="${requestScope.dto.addr3 }" placeholder="상세주소">
					<input type="text" name="addr4" id="sample6_extraAddress" value="${requestScope.dto.addr4 }" placeholder="참고항목" readonly>
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
				document.DirForm.action = '${path }/haksaStudent_servlet/sujungProc.do';
				document.DirForm.method = 'post';
				document.DirForm.submit();
			}//if
		}//save
	</script>
	
	<jsp:include page="_inc_daumApi.jsp" flush="true"></jsp:include>
</body>
</html>
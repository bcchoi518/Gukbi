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
	
	<h2>학사관리_학생정보등록</h2>
	
	<form name="DirForm">
		<table border="1" width="80%">
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="phone" /></td>
			</tr>
			<tr>
				<td>부모님전화번호</td>
				<td><input type="text" name="parentPhone" /></td>
			</tr>
			<tr>
				<td>주소</td>
				<td>
					<input type="text" name="addr1" id="sample6_postcode" placeholder="우편번호" readonly>
					<button type="button" onclick="sample6_execDaumPostcode()">우편번호 찾기</button><br>
					<input type="text" name="addr2" id="sample6_address" placeholder="주소" readonly><br>
					<input type="text" name="addr3" id="sample6_detailAddress" placeholder="상세주소">
					<input type="text" name="addr4" id="sample6_extraAddress" placeholder="참고항목" readonly>
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
				document.DirForm.action = '${path }/haksaStudent_servlet/chugaProc.do';
				document.DirForm.method = 'post';
				document.DirForm.submit();
			}//if
		}//save
	</script>
	
	<jsp:include page="_inc_daumApi.jsp" flush="true"></jsp:include>
</body>
</html>
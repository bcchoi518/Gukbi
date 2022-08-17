<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h2>학생등록</h2>

<form name="DirForm">
	<table border="1" width="80%">
		<tr>
			<th>이름</th>
			<td><input type="text" name="name" /></td>	
		</tr>
		<tr>
			<th>연락처</th>
			<td><input type="text" name="phone" /></td>	
		</tr>
		<tr>
			<th>부모님연락처</th>
			<td><input type="text" name="parentPhone" /></td>	
		</tr>
		<tr>
		<th rowspan="3">주소</th>
			<td>
				<input type="text" name="addr1" id="sample6_postcode" placeholder="우편번호" readonly>
				<button type="button" onclick="sample6_execDaumPostcode()">우편번호 찾기</button>
		<tr>
			<td>
				<input type="text" name="addr2" id="sample6_address" placeholder="주소" readonly>
			</td>
		</tr>
		<tr>
			<td>
				<input type="text" name="addr3" id="sample6_detailAddress" placeholder="상세주소">
				<input type="text" name="addr4" id="sample6_extraAddress" placeholder="참고항목" readonly>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<button type="button" onClick="submitForm()">등록하기</button>
				<button type="button" onClick="location.href='list.jsp';">목록으로</button>
			</td>
		</tr>
	</table>
</form>
<script>
	function submitForm() {
		document.DirForm.action = "chugaProc.jsp";
		document.DirForm.method = "post";
		document.DirForm.submit();
	}//submitForm
</script>
<jsp:include page="_inc_daumApi.jsp"></jsp:include>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h2>도서등록</h2>

<form name="DirForm">
	<table border="1">
		<tr>
			<th>제목</th>
			<td><input type="text" name="subject" id="subject"/></td>
		</tr>
		<tr>
			<th>저자</th>
			<td><input type="text" name="author" id="author"/></td>
		</tr>
		<tr>
			<th>발행일</th>
			<td><input type="date" name="created" id="created"/></td>
		</tr>
		<tr>
			<th>분류</th>
			<td><input type="text" name="profile" id="profile"/></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button type="button" onClick="formSubmit()">저장하기</button>&nbsp;
				<button type="button" onClick="location.href='list.jsp';">목록으로</button>
			</td>
		</tr>
	</table>
</form>
<script>
 function formSubmit() {
	 if (confirm('저장할까요?')) {
		 document.DirForm.action = 'chugaProc.jsp';
		 document.DirForm.method = 'post';
		 document.DirForm.submit();
	 }//if
 }//formSubmit
</script>
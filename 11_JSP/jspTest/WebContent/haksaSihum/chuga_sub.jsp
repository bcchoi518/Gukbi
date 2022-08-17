<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h2>시험등록</h2>

<form name="DirForm">
	<table border="1" width="80%">
		<tr>
			<th>시험이름</th>
			<td><input type="text" name="sihumName" /></td>	
		</tr>
		<tr>
			<th>시험날짜</th>
			<td><input type="date" name="sihumDate" /></td>	
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
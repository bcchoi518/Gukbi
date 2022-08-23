<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h2>메모등록</h2>
<form name="frm">
	<table border="0" width="80%" align="center">
		<tr>
			<td class="entryName">작성자 : </td>
			<td><input type="text" name="writer" /></td>
		</tr>
		<tr>
			<td class="entryName">메모내용 : </td>
			<td><textarea name="content" rows="15" cols="100"></textarea></td>
		</tr>
		<tr>
			<td colspan="2">
				<button type="button" onClick="frmSubmit()">등록하기</button> &nbsp;
				<button type="button" onClick="location.href='main.jsp?menuGubun=memo_list'">목록으로</button>
			</td>
		</tr>
	</table>
</form>
<script>
	function frmSubmit() {
		if (confirm('등록할까요?')) {
			document.frm.action = "mainProc.jsp?menuGubun=memo_chugaProc";
			document.frm.method = "post"
			document.frm.submit();
		}//if
	}//frmSubmit
</script>
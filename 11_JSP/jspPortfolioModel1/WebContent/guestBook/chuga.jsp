<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "../_include/inc_sessionChk.jsp" %>

<h2>방명록등록</h2>
<form name="frm">
	<table border="0" align="center"> 
		<tr>
			<td class="entryName">이름 : </td>
			<td><input type="text" name="name" value="<%=sessionName %>"/></td>
		</tr>
		<tr>
			<td class="entryName">이메일 : </td>
			<td><input type="text" name="email" /></td>
		</tr>
		<tr>
			<td class="entryName">비밀번호 : </td>
			<td><input type="password" name="passwd" /></td>
		</tr>
		<tr>
			<td class="entryName">방명록 내용 : </td>
			<td><textarea name="content" rows="15" cols="100"></textarea></td>
		</tr>
		<tr align="center" height="50px">
			<td colspan="2">
				<button type="button" onClick="formSubmit()">등록하기</button>
				<button type="button" onClick="location.href='../main/main.jsp?menuGubun=guestBook_list';">목록으로</button>
			</td>
		</tr>
	</table>
</form>
<script>
	function formSubmit() {
		if (confirm('등록할까요?')) {
			document.frm.action = "mainProc.jsp?menuGubun=guestBook_chugaProc";
			document.frm.method = "post";
			document.frm.submit();
		}//if
	}//formSubmit
</script>
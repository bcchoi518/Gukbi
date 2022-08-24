<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="memo.model.dao.MemoDAO"%>
<%@ page import="memo.model.dto.MemoDTO"%>

<%
	String no_ = request.getParameter("no");
	int no = Integer.parseInt(no_);
	MemoDTO arguMemoDto = new MemoDTO();
	arguMemoDto.setNo(no);

	MemoDAO memoDao = new MemoDAO();
	MemoDTO resultMemoDto = memoDao.getSelectOne(arguMemoDto);
%>

<h2>메모수정</h2>
<form name="frm">
	<input type="hidden" name="no" value="<%=resultMemoDto.getNo() %>" />
	<table border="1" width="80%" align="center">
		<tr>
			<td class="entryName">작성자 : </td>
			<td><input type="text" name="writer" value="<%=resultMemoDto.getWriter() %>"/></td>
		</tr>
		<tr>
			<td class="entryName">메모내용 : </td>
			<td><textarea name="content" rows="15" cols="100"><%=resultMemoDto.getContent() %></textarea></td>
		</tr>
		<tr>
			<td colspan="2">
				<button type="button" onClick="frmSubmit()">수정하기</button> &nbsp;
				<button type="button" onClick="location.href='main.jsp?menuGubun=memo_list'">목록으로</button>
			</td>
		</tr>
	</table>
</form>
<script>
	function frmSubmit() {
		if (confirm('수정할까요?')) {
			document.frm.action = "mainProc.jsp?menuGubun=memo_sujungProc";
			document.frm.method = "post"
			document.frm.submit();
		}//if
	}//frmSubmit
</script>
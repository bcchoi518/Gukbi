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

<h2>메모삭제</h2>
<form name="frm">
	<input type="hidden" name="no" value="<%=resultMemoDto.getNo() %>" />
	<table border="1" width="80%" align="center">
		<tr>
			<td>작성자 : </td>
			<td><%=resultMemoDto.getWriter() %></td>
		</tr>
		<tr>
			<td>메모내용 : </td>
			<td><%=resultMemoDto.getContent().replace("\n", "<br>") %></td>
		</tr>
		<tr>
			<td colspan="2">
				<button type="button" onClick="frmSubmit()">삭제하기</button> &nbsp;
				<button type="button" onClick="location.href='main.jsp?menuGubun=memo_list'">목록으로</button>
			</td>
		</tr>
	</table>
</form>
<script>
	function frmSubmit() {
		if (confirm('삭제할까요?')) {
			document.frm.action = "mainProc.jsp?menuGubun=memo_sakjeProc";
			document.frm.method = "post"
			document.frm.submit();
		}//if
	}//frmSubmit
</script>
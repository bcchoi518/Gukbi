<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="config.Util"%>

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

<h2>메모상세보기</h2>
<table border="0" align="center">
	<tr>
		<td>No : </td>
		<td><%=resultMemoDto.getNo() %></td>
	</tr>
	<tr>
		<td>작성자 : </td>
		<td><%=resultMemoDto.getWriter() %></td>
	</tr>
	<tr>
		<td>메모내용 : </td>
		<td><%=resultMemoDto.getContent().replace("\n", "<br>") %></td>
	</tr>
	<tr>
		<td>등록일 : </td>
		<td><%=resultMemoDto.getRegiDate() %></td>
	</tr>
</table>
<div style="border: 0px solid red; padding-top:20px; width:80%; text-align:right;">
|
<a href="#" onClick="move('memo_list')">목록</a>
|
<a href="#" onClick="move('memo_chuga')">등록</a>
|
<a href="#" onClick="move('memo_sujung','<%=no %>')">수정</a>
|
<a href="#" onClick="move('memo_sakje','<%=no %>')">삭제</a>
|
</div>
<script>
	function move(value1, value2) {
		if (value2 != undefined) {
			location.href = 'main.jsp?menuGubun=' + value1 + "&no=" + value2;
		} else {
			location.href = 'main.jsp?menuGubun=' + value1;
		}//if
	}//move
</script>
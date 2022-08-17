<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="java.util.ArrayList"%>

<%@page import="haksaSihum.model.dto.HaksaSihumDTO"%>
<%@page import="haksaSihum.model.dao.HaksaSihumDAO"%>

<%
	String arg1_ = request.getParameter("arg1");
	int arg1 = Integer.parseInt(arg1_);

	HaksaSihumDTO sihumArguDto = new HaksaSihumDTO();
	sihumArguDto.setSihumNo(arg1);
	
	HaksaSihumDAO sihumDao = new HaksaSihumDAO();
	HaksaSihumDTO sihumResultDto = sihumDao.getSelectOne(sihumArguDto);
%>

<h2>시험삭제</h2>

<form name="DirForm">
	<input type="hidden" name="arg1" value="<%=sihumResultDto.getSihumNo() %>" />
	<table border="1" width="80%">
		<tr>
			<th>시험번호</th>
			<td><%=sihumResultDto.getSihumNo() %></td>	
		</tr>
		<tr>
			<th>시험이름</th>
			<td><%=sihumResultDto.getSihumName() %></td>	
		</tr>
		<tr>
			<th>시험날짜</th>
			<td><%=sihumResultDto.getSihumDate() %></td>	
		</tr>
		<tr>
			<th>등록일</th>
			<td><%=sihumResultDto.getRegiDate() %></td>	
		</tr>
		<tr>
			<td colspan="2">
				<button type="button" onClick="submitForm()">삭제하기</button>
				<button type="button" onClick="location.href='list.jsp';">목록으로</button>
			</td>
		</tr>
	</table>
</form>
<script>
	function submitForm() {
		document.DirForm.action = "sakjeProc.jsp";
		document.DirForm.method = "post";
		document.DirForm.submit();
	}//submitForm
</script>
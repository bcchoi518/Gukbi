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

<h2>시험수정</h2>

<form name="DirForm">
	<input type="hidden" name="arg1" value="<%=sihumResultDto.getSihumNo() %>" />
	<table border="1" width="80%">
		<tr>
			<th>시험이름</th>
			<td><input type="text" name="sihumName" value="<%=sihumResultDto.getSihumName() %>"/></td>	
		</tr>
		<tr>
			<th>시험날짜</th>
			<td><input type="date" name="sihumDate" value="<%=sihumResultDto.getSihumDate() %>"/></td>	
		</tr>
		<tr>
			<td colspan="2">
				<button type="button" onClick="submitForm()">수정하기</button>
				<button type="button" onClick="location.href='list.jsp';">목록으로</button>
			</td>
		</tr>
	</table>
</form>
<script>
	function submitForm() {
		document.DirForm.action = "sujungProc.jsp";
		document.DirForm.method = "post";
		document.DirForm.submit();
	}//submitForm
</script>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="java.util.ArrayList"%>

<%@page import="haksaMember.model.dao.HaksaMemberDAO"%>
<%@page import="haksaMember.model.dto.HaksaMemberDTO"%>

<%
	String arg1_ = request.getParameter("arg1");
	int arg1 = Integer.parseInt(arg1_);
	
	HaksaMemberDTO memberArguDto = new HaksaMemberDTO();
	memberArguDto.setHakbun(arg1);
	
	HaksaMemberDAO memberDao = new HaksaMemberDAO();
	HaksaMemberDTO memberResultDto = memberDao.getSelectOne(memberArguDto);
%>

<h2>학생수정</h2>

<form name="DirForm">
	<input type="hidden" name="arg1" value="<%=memberResultDto.getHakbun() %>" />
	<table border="1" width="80%">
		<tr>
			<th>학번</th>
			<td><%=memberResultDto.getHakbun() %></td>	
		</tr>
		<tr>
			<th>이름</th>
			<td><%=memberResultDto.getName() %></td>	
		</tr>
		<tr>
			<th>연락처</th>
			<td><%=memberResultDto.getPhone() %></td>	
		</tr>
		<tr>
			<th>부모님연락처</th>
			<td><%=memberResultDto.getParentPhone() %></td>	
		</tr>
		<tr>
		<th>주소</th>
			<td>
				(<%=memberResultDto.getAddr1() %>) <%=memberResultDto.getAddr2() %> <%=memberResultDto.getAddr3() %> <%=memberResultDto.getAddr4() %>
			</td>
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
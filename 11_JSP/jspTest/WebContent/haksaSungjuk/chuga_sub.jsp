<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="java.util.ArrayList"%>

<%@page import="haksaMember.model.dto.HaksaMemberDTO"%>
<%@page import="haksaMember.model.dao.HaksaMemberDAO"%>

<%@page import="haksaSihum.model.dto.HaksaSihumDTO"%>
<%@page import="haksaSihum.model.dao.HaksaSihumDAO"%>

<%
	HaksaMemberDAO memberDao = new HaksaMemberDAO();
	ArrayList<HaksaMemberDTO> memberList = memberDao.getSelectAll();
	
	HaksaSihumDAO sihumDao = new HaksaSihumDAO();
	ArrayList<HaksaSihumDTO> sihumList = sihumDao.getSelectAll();
%>

<h2>성적등록</h2>

<form name="DirForm">
	<table border="1" width="80%">
		<tr>
			<th>학생이름</th>
			<td>
				<select name="hakbun">
					<option value="0">-- 선택하세요 --</option>
				<% for (HaksaMemberDTO memberResultDto : memberList) { %>
					<option value="<%=memberResultDto.getHakbun() %>"><%=memberResultDto.getName() %></option>
				<% }//for %>
				</select>
			</td>	
		</tr>
		<tr>
			<th>시험구분</th>
			<td>
				<select name="sihumNo">
					<option value="0">-- 선택하세요 --</option>
				<% for (HaksaSihumDTO sihumResultDto : sihumList) { %>
					<option value="<%=sihumResultDto.getSihumNo() %>"><%=sihumResultDto.getSihumName() %></option>
				<% }//for %>
				</select>
			</td>	
		</tr>
		<tr>
			<th>국어점수</th>
			<td><input type="text" name="kor" /></td>	
		</tr>
		<tr>
			<th>영어점수</th>
			<td><input type="text" name="eng" /></td>	
		</tr>
		<tr>
			<th>수학점수</th>
			<td><input type="text" name="mat" /></td>	
		</tr>
		<tr>
			<th>과학점수</th>
			<td><input type="text" name="sci" /></td>	
		</tr>
		<tr>
			<th>역사점수</th>
			<td><input type="text" name="his" /></td>	
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
		if (confirm('저장하시겠습니까?')) {
			document.DirForm.action = "chugaProc.jsp";
			document.DirForm.method = "post";
			document.DirForm.submit();
		}//if
	}//submitForm
</script>
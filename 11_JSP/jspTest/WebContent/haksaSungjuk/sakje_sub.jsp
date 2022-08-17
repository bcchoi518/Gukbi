<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="java.util.ArrayList"%>

<%@page import="haksaMember.model.dto.HaksaMemberDTO"%>
<%@page import="haksaMember.model.dao.HaksaMemberDAO"%>

<%@page import="haksaSihum.model.dto.HaksaSihumDTO"%>
<%@page import="haksaSihum.model.dao.HaksaSihumDAO"%>

<%@page import="haksaSungjuk.model.dao.HaksaSungjukDAO"%>
<%@page import="haksaSungjuk.model.dto.HaksaSungjukDTO"%>

<%
	HaksaMemberDAO memberDao = new HaksaMemberDAO();
	ArrayList<HaksaMemberDTO> memberList = memberDao.getSelectAll();
	
	HaksaSihumDAO sihumDao = new HaksaSihumDAO();
	ArrayList<HaksaSihumDTO> sihumList = sihumDao.getSelectAll();
	
	String arg1_ = request.getParameter("arg1");
	int arg1 = Integer.parseInt(arg1_);
	
	HaksaSungjukDTO sungjukArguDto = new HaksaSungjukDTO();
	sungjukArguDto.setSungjukNo(arg1);
	
	HaksaSungjukDAO sungjukDao = new HaksaSungjukDAO();
	HaksaSungjukDTO sungjukResultDto = sungjukDao.getSelectOne(sungjukArguDto);
%>

<h2>성적삭제</h2>

<form name="DirForm">
	<input type="hidden" name="arg1" value="<%=sungjukResultDto.getSungjukNo() %>" />
	<table border="1" width="80%">
		<tr>
			<th>학생이름</th>
			<td><%=sungjukResultDto.getName() %></td>	
		</tr>
		<tr>
			<th>시험구분</th>
			<td><%=sungjukResultDto.getSihumName() %></td>	
		</tr>
		<tr>
			<th>국어점수</th>
			<td><%=sungjukResultDto.getKor() %></td>	
		</tr>
		<tr>
			<th>영어점수</th>
			<td><%=sungjukResultDto.getEng() %></td>	
		</tr>
		<tr>
			<th>수학점수</th>
			<td><%=sungjukResultDto.getMat() %></td>	
		</tr>
		<tr>
			<th>과학점수</th>
			<td><%=sungjukResultDto.getSci() %></td>	
		</tr>
		<tr>
			<th>역사점수</th>
			<td><%=sungjukResultDto.getHis() %></td>	
		</tr>
		<tr>
			<th>총점</th>
			<td><%=sungjukResultDto.getTot() %></td>	
		</tr>
		<tr>
			<th>평균</th>
			<td><%=sungjukResultDto.getAvg() %></td>	
		</tr>
		<tr>
			<th>등급</th>
			<td><%=sungjukResultDto.getGrade() %></td>	
		</tr>
		<tr>
			<th>등록일</th>
			<td><%=sungjukResultDto.getRegiDate() %></td>	
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
		if (confirm('삭제하시겠습니까?')) {
			document.DirForm.action = "sakjeProc.jsp";
			document.DirForm.method = "post";
			document.DirForm.submit();
		}//if
	}//submitForm
</script>
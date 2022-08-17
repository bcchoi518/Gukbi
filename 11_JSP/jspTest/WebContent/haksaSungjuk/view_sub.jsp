<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="haksaSungjuk.model.dao.HaksaSungjukDAO"%>
<%@page import="haksaSungjuk.model.dto.HaksaSungjukDTO"%>

<%
	String arg1_ = request.getParameter("arg1");
	int arg1 = Integer.parseInt(arg1_);
	
	HaksaSungjukDTO sungjukArguDto = new HaksaSungjukDTO();
	sungjukArguDto.setSungjukNo(arg1);
	
	HaksaSungjukDAO sungjukDao = new HaksaSungjukDAO();
	HaksaSungjukDTO sungjukResultDto = sungjukDao.getSelectOne(sungjukArguDto);
%>

<h2>성적상세보기</h2>

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
</table>
<div style="width:80%; margin-top:10px; text-align:right;">
|
<a href="#" onClick="move('list.jsp')">목록</a>
|
<a href="#" onClick="move('chuga.jsp')">등록</a>
|
<a href="#" onClick="move('sujung.jsp','<%=arg1 %>')">수정</a>
|
<a href="#" onClick="move('sakje.jsp','<%=arg1 %>')">삭제</a>
|
</div>
<script>
	function move(value1, value2) {
		if (value2 != undefined) {
			location.href = value1 + '?arg1=' + value2;
		} else {
			location.href = value1;
		}//if
	}//move
</script>
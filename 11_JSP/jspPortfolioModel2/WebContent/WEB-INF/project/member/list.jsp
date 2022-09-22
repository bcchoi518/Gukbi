<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "../include/inc_header.jsp" %>

<h2>회원관리</h2>

<table border="1" width="80%" align="center">
	<tr>
		<th>순번</th>
		<th>아이디</th>
		<th>비밀번호</th>
		<th>이름</th>
		<th>생년월일</th>
		<th>전화번호</th>
		<th>가입일</th>
	</tr>
	
	<c:if test="${fn:length(list) == 0 }">
		<tr>
			<td colspan="7" height="200px" style="text-align:center;">등록된 회원이 없습니다.</td>
		</tr>
	</c:if>
	
	<c:forEach var="memberDto" items="${requestScope.list }">
		<tr>
			<td>${memberDto.no }</td>
			<td><a href="#" onclick="move('member_view.do','${memberDto.no }')">${memberDto.id }</a></td>
			<td>${memberDto.passwd }</td>
			<td>${memberDto.name }</td>
			<td>${memberDto.jumin1 }-${memberDto.jumin2 }******</td>
			<td>${memberDto.phone1 }-${memberDto.phone2 }-${memberDto.phone3 }</td>
			<td>${memberDto.regiDate }</td>
		</tr>
	</c:forEach>
</table>

<div style="border: 0px solid red; width: 80%; margin-top:10px;" align="right">
|
<a href="#" onclick="move('member_list.do')">목록</a>
|
<a href="#" onclick="move('member_chuga.do')">등록</a>
|
</div>

<script>
	function move(value1, value2) {
		let linkAddr = '${path }/member_servlet/' + value1;
		if (value2 != undefined) {
			linkAddr += '?no=' + value2;
		}//if
		location.href = linkAddr;
	}//move
</script>
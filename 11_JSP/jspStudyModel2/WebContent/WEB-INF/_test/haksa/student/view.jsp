<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "../../../_include/inc_header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@ include file = "../../../_include/inc_menu.jsp" %>

	<h2>학사관리_학생상세정보</h2>

	<table border="1" width="80%">
		<tr>
			<td>학번</td>
			<td>${requestScope.dto.hakbun }</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>${requestScope.dto.name }</td>
		</tr>
		<tr>
			<td>연락처</td>
			<td>${requestScope.dto.phone }</td>
		</tr>
		<tr>
			<td>부모님연락처</td>
			<td>${requestScope.dto.parentPhone }</td>
		</tr>
		<tr>
			<td>주소</td>
			<td>${requestScope.dto.addr1 } ${requestScope.dto.addr2 } ${requestScope.dto.addr3 } ${requestScope.dto.addr4 }</td>
		</tr>
		<tr>
			<td>등록일</td>
			<td>${requestScope.dto.regiDate }</td>
		</tr>
	</table>
	
	<div style="border: 0px solid red; width: 80%; margin-top:10px;" align="right">
	|
	<a href="#" onclick="move('list.do')">목록</a>
	|
	<a href="#" onclick="move('chuga.do')">등록</a>
	|
	<a href="#" onclick="move('sujung.do','${requestScope.dto.hakbun }')">수정</a>
	|
	<a href="#" onclick="move('sakje.do','${requestScope.dto.hakbun }')">삭제</a>
	|
	</div>
	
	<script>
		function move(value1, value2) {
			let linkAddr = '${path }/haksaStudent_servlet/' + value1;
			if (value2 != undefined) {
				linkAddr += '?hakbun=' + value2;
			}//if
			location.href = linkAddr;
		}//move
	</script>
</body>
</html>
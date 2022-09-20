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

	<h2>학사관리_성적상세정보</h2>

		<table border="1" width="80%">
			<tr>
				<td>성적번호</td>
				<td>${requestScope.dto.sungjukNo }</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>${requestScope.dto.name }</td>
			</tr>
			<tr>
				<td>시험명</td>
				<td>${requestScope.dto.sihumName }</td>
			</tr>
			<tr>
				<td>국어</td>
				<td>${requestScope.dto.kor }</td>
			</tr>
			<tr>
				<td>영어</td>
				<td>${requestScope.dto.eng }</td>
			</tr>
			<tr>
				<td>수학</td>
				<td>${requestScope.dto.mat }</td>
			</tr>
			<tr>
				<td>과학</td>
				<td>${requestScope.dto.sci }</td>
			</tr>
			<tr>
				<td>역사</td>
				<td>${requestScope.dto.his }</td>
			</tr>
			<tr>
				<td>총점</td>
				<td>${requestScope.dto.tot }</td>
			</tr>
			<tr>
				<td>평균</td>
				<td>${requestScope.dto.avg }</td>
			</tr>
			<tr>
				<td>등급</td>
				<td>${requestScope.dto.grade }</td>
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
	<a href="#" onclick="move('sujung.do','${requestScope.dto.sungjukNo }')">수정</a>
	|
	<a href="#" onclick="move('sakje.do','${requestScope.dto.sungjukNo }')">삭제</a>
	|
	</div>
	
	<script>
		function move(value1, value2) {
			let linkAddr = '${path }/haksaSungjuk_servlet/' + value1;
			if (value2 != undefined) {
				linkAddr += '?sungjukNo=' + value2;
			}//if
			location.href = linkAddr;
		}//move
	</script>
</body>
</html>
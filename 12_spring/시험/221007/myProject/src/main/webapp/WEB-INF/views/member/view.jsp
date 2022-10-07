<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "../_include/inc_top.jsp" %>

<h2>나의 정보 상세보기</h2>

<table border="1" width="80%">
	<tr>
		<td>아이디</td>
		<td>${requestScope.dto.id }</td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td>${requestScope.dto.passwd }</td>
	</tr>
	<tr>
		<td>이름</td>
		<td>${requestScope.dto.name }</td>
	</tr>
	<tr>
		<td>전화번호</td>
		<td>${requestScope.dto.phone1 }-${requestScope.dto.phone2 }-${requestScope.dto.phone3 }</td>
	</tr>
	<tr>
		<td>email</td>
		<td>${requestScope.dto.email1 }@${requestScope.dto.email2 }</td>
	</tr>
	<tr>
		<td>postcode</td>
		<td>${requestScope.dto.postcode }</td>
	</tr>
	<tr>
		<td>address</td>
		<td>${requestScope.dto.address }</td>
	</tr>
	<tr>
		<td>detailAddress</td>
		<td>${requestScope.dto.detailAddress }</td>
	</tr>
	<tr>
		<td>extraAddress</td>
		<td>${requestScope.dto.extraAddress }</td>
	</tr>
	<tr>
		<td>가입일</td>
		<td>${requestScope.dto.regiDate }</td>
	</tr>
	<tr>
		<td colspan="2" align="center" style="height:50px">
			<button type="button" onclick="move('sujung','${requestScope.dto.no }')">회원정보 수정</button>
		</td>
	</tr>
</table>

<script>
	function move(value1, value2) {
		let linkAddr = '${path }/member/'+ value1;
		if (value2 != undefined) {
			linkAddr += '?no=' + value2;
		}//if
		location.href = linkAddr;
	}//move
</script>
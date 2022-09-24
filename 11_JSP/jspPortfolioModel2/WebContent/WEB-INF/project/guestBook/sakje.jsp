<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "../include/inc_header.jsp" %>

<h2>방명록삭제</h2>

<form name="DirForm">
	<input type="hidden" name="searchGubun" id="searchGubun" value="${requestScope.searchGubun }" />
	<input type="hidden" name="searchData" id="searchData" value="${requestScope.searchData }" />
	<input type="hidden" name="no" id="no" value="${requestScope.dto.no }" />
	<table border="1" align="center" width="80%">
		<tr>
			<td style="width:10%;">이름</td>
			<td>${requestScope.dto.name }</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="passwd" id="passwd" value="" /></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td>${requestScope.dto.email }</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>${fn:replace(requestScope.dto.content, requestScope.newLine, '<br>') }</td>
		</tr>
		<tr>
			<td>등록일</td>
			<td>${requestScope.dto.regiDate }</td>
		</tr>
		<tr>
			<td colspan="2" align="center" style="height:50px">
				<button type="button" onclick="save()">삭제하기</button>
				<button type="button" onclick="move('guestBook_list.do')">목록으로</button>
			</td>
		</tr>
	</table>
</form>

<script>
	function save() {
		if (confirm('OK?')) {
			document.DirForm.action = '${requestScope.path }/guestBook_servlet/guestBook_sakjeProc.do';
			document.DirForm.method = 'post';
			document.DirForm.submit();
		}//if
	}//save
	
	function move(value1, value2) {
		let linkAddr = '${requestScope.path }/guestBook_servlet/' + value1 + '?${requestScope.searchQuery }';
		if (value2 != undefined) {
			linkAddr += '&no=' + value2;
		}//if
		location.href = linkAddr;
	}//move
</script>
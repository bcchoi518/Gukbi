<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "../_include/inc_header.jsp" %>

<h2>게시글삭제</h2>

<form name="DirForm">
	<input type="hidden" name="no" value="${requestScope.dto.no }"/>
	<table border="1" align="center" width="80%">
		<tr>
			<td style="width:10%;">작성자</td>
			<td>${requestScope.dto.writer }</td>
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
			<td>공지글 여부</td>
			<td>
				<c:if test="${requestScope.dto.noticeNo > 0 }">O</c:if>
				<c:if test="${requestScope.dto.noticeNo <= 0 }">X</c:if>
			</td>
		</tr>
		<tr>
			<td>비밀글 여부</td>
			<td>
				<c:if test="${requestScope.dto.secretGubun == 'T' }">O</c:if>
				<c:if test="${requestScope.dto.secretGubun == 'F' }">X</c:if>
			</td>
		</tr>
		<tr>
			<td>제목</td>
			<td>${requestScope.dto.subject }</td>
		</tr>
		<tr>
			<td>내용</td>
			<td style="height:200px; vertical-align:text-top;">${fn:replace(requestScope.dto.content, requestScope.newLine, '<br>') }</td>
		</tr>
		<tr>
			<td>조회수</td>
			<td>${requestScope.dto.hit }</td>
		</tr>
		<tr>
			<td>등록일</td>
			<td>${requestScope.dto.regiDate }</td>
		</tr>
		<tr>
			<td colspan="2" align="center" style="height:50px">
				<button type="button" onclick="save()">삭제하기</button>
				<button type="button" onclick="move('list')">목록으로</button>
			</td>
		</tr>
	</table>
</form>

<script>
	function save() {
		if (confirm('OK?')) {
			document.DirForm.action = '${path }/board/sakjeProc';
			document.DirForm.method = 'post';
			document.DirForm.submit();
		}//if
	}//save
	
	function move(value1, value2) {
		let linkAddr = '${path }/board/' + value1 + '?${requestScope.searchQuery }';
		if (value2 != undefined) {
			linkAddr += '&no=' + value2;
		}//if
		location.href = linkAddr;
	}//move
</script>
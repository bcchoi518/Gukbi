<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "../include/inc_top.jsp" %>

<h2>${requestScope.title }</h2>

<form name="DirForm">
	<input type="hidden" name="code" value="${requestScope.dto.code }"/>
	<table border="1">
		<tr>
			<td>도서명</td>
			<td><input type="text" name="title" value="${requestScope.dto.title }"/></td>
		</tr>
		<tr>
			<td>분류</td>
			<td><input type="text" name="category" value="${requestScope.dto.category }" /></td>
		</tr>
		<tr>
			<td>저자</td>
			<td><input type="text" name="author" value="${requestScope.dto.author }" /></td>
		</tr>
		<tr>
			<td>출판사</td>
			<td><input type="text" name="publisher" value="${requestScope.dto.publisher }" /></td>
		</tr>
		<tr>
			<td>발행일</td>
			<td><input type="date" name="publicationDate" value="${requestScope.dto.publicationDate }" /></td>
		</tr>
		<tr>
			<td colspan="2" style="text-align:center">
				<button type="button" onclick="save()">수정하기</button>
				<button type="button" onclick="move('list')">목록으로</button>
			</td>
		</tr>
	</table>
</form>

<script>
	function save() {
		if (confirm('수정하시겠습니까?')) {
			document.DirForm.action = '${path }/book/sujungProc';
			document.DirForm.method = 'post';
			document.DirForm.submit();
		}//if
	}//save
	
	
	function move(value1) {
		location.href = '${path }/book/'+ value1;
	}//save
</script>
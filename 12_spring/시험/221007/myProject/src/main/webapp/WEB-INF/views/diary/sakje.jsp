<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "../_include/inc_top.jsp" %>

<h2>다이어리 삭제</h2>

<form name="DirForm">
	<input type="hidden" name="searchGubun" id="searchGubun" value="${requestScope.searchGubun }" />
	<input type="hidden" name="searchData" id="searchData" value="${requestScope.searchData }" />
	<input type="hidden" name="pageNumber" id="pageNumber" value="${requestScope.pageNumber }" />
	<input type="hidden" name="tbl" id="tbl" value="${requestScope.tbl }" />
	<input type="hidden" name="no" id="no" value="${requestScope.dto.no }" />
	<table border="1" align="center" width="80%">
		<tr>
			<td>title</td>
			<td>${requestScope.dto.title }</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>${fn:replace(requestScope.dto.content, newLineChar, '<br>') }</td>
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
			document.DirForm.action = '${path }/diary/sakjeProc';
			document.DirForm.method = 'post';
			document.DirForm.submit();
		}//if
	}//save
	
	function move(value1, value2) {
		let linkAddr = '${path }/diary/'+ value1 +'?tbl=${requestScope.tbl }&pageNumber=${requestScope.pageNumber }';
		if (value2 != undefined) {
			linkAddr += '&no=' + value2;
		}//if
		linkAddr += '&searchGubun=${requestScope.searchGubun }&searchData=${requestScope.searchData }';
		location.href = linkAddr;
	}//move
</script>
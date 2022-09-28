<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "../include/inc_header.jsp" %>
<%@ include file = "_inc_top.jsp" %>

<h2>메모등록 (Mybatis)</h2>

<form name="DirForm">
	<input type="hidden" name="searchGubun" value="${requestScope.searchGubun }" />
	<input type="hidden" name="searchData" value="${requestScope.searchData }" />
	<input type="hidden" name="no" />
	<table border="1" style="width:80%;">
		<tr>
			<td style="width:10%; text-align:center;">작성자</td>
			<td style="width:99%;"><input type="text" name="writer"/></td>
		</tr>
		<tr>
			<td style="text-align:center;">내용</td>
			<td><textarea name="content" style="height:40px; width:99%;" ></textarea></td>
		</tr>
		<tr>
			<td colspan="2">
				<button type="button" id="btnSave" onclick="save()">등록</button>
				<button type="button" id="btnReset" onclick="move('memoMybatis_list.do')">목록으로</button>
			</td>
		</tr>
	</table>
</form>
<script>
	function save() {
		if (confirm('OK?')) {
			document.DirForm.action = '${requestScope.path }/memoMybatis_servlet/memoMybatis_chugaProc.do';
			document.DirForm.method = 'post';
			document.DirForm.submit();
		}//if
	}//save
	
	function move(value1) {
		location.href = '${requestScope.path }/memoMybatis_servlet/'+ value1 + '?${requestScope.searchQuery }';
	}//move
</script>
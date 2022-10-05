<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "../_include/inc_header.jsp" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
</head>
<body>

<form name="DirForm">
	<table border="1" align="center" width="80%">
		<tr>
			<td colspan="2"><h2>아이디 찾기</h2></td>
		</tr>
		<tr>
			<td>
				<input type="text" name="id" id="id" value="${requestScope.id }" style="width:100px;" />
				<span id="spanMsg">${requestScope.msg }</span>
				<input type="hidden" name="result" id="result" value="${requestScope.imsiId }" style="width:100px;" />
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center" style="height:50px;">
				<button type="button" onclick="search();">검색</button>
				<c:if test="${fn:length(requestScope.imsiId) > 0 }">
					<button type="button" onclick="apply();">적용</button>
				</c:if>
			</td>
		</tr>
	</table>
</form>

<script>
	function search() {
		if (document.DirForm.id.value == '') {
			alert('아이디를 입력하세요.');
			document.DirForm.id.focus();
			return;
		}//if
		if (confirm('OK?')) {
			document.DirForm.action = '${path }/member/idCheckWinProc';
			document.DirForm.method = 'post';
			document.DirForm.submit();
		}//if
	}//search
	
	function apply() {
		const id = document.querySelector('#result').value;
		opener.document.querySelector('#id').value = id;
		opener.document.querySelector('#tempId').value = id;
		opener.document.querySelector('#id').readOnly = true;
		window.close();
	}//apply
</script>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "../include/inc_header.jsp" %>    

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
				<br>
				<input type="text" name="result" id="result" value="${requestScope.imsiId }" style="width:100px;" />
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center" style="height:50px;">
				<button bype="button" onclick="search();">검색</button>
				<span id="spanView" style="display:none;">
					<button bype="button" onclick="save();">적용</button>
				</span>
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
			document.DirForm.action = '${requestScope.path }/member_servlet/member_idCheckWinProc.do';
			document.DirForm.method = 'post';
			document.DirForm.submit();
		}//if
	}//search
</script>

</body>
</html>
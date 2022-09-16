<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "../../_include/inc_header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@ include file = "../../_include/inc_menu.jsp" %>
	
	<h2>06Result1</h2>
	
	<table border="1">
		<tr>
			<td>아이디 : </td>
			<td>${requestScope.id }</td>
		</tr>
		<tr>
			<td>로그인 결과 : </td>
			<td>${requestScope.result }</td>
		</tr>
	</table>
<%--	
	<br>
	<a href="/jspStudyModel2/exam_servlet/06Proc2.do?id=${requestScope.id }&result=${requestScope.result }">다음페이지로..</a>
--%>
<%--	
	<form name="DirForm">
		<input type="text" name="id" value="${requestScope.id }"/>
		<input type="text" name="result" value="${requestScope.result }"/>
	</form>
	<script>
		function autoMove() {
			document.DirForm.action = '/jspStudyModel2/exam_servlet/06Proc2.do';
			document.DirForm.method = 'post';
			document.DirForm.submit();
		}//autoMove
		autoMove();
	</script>
--%>

<%-- content="0; <-- 일정 시간 후에 이동하도록 설정하는 값 --%>
<meta http-equiv="refresh" content="0; url=/jspStudyModel2/exam_servlet/06Proc2.do?id=${requestScope.id }&result=${requestScope.result }" />

</body>
</html>
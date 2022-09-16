<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@ include file = "../../_include/inc_menu.jsp" %>
<%--	
	<h2>07Result</h2>
	
	<table border="1">
		<tr>
			<td>이름 : </td>
			<td>${requestScope.name }</td>
		</tr>
		<tr>
			<td>주소 : </td>
			<td>${requestScope.address }</td>
		</tr>
		<tr>
			<td>나이 : </td>
			<td>${requestScope.age }</td>
		</tr>
	</table>
--%>

<form name="DirForm">
	<input type="text" name="name" value="${requestScope.name }"/>
	<input type="text" name="address" value="${requestScope.address }"/>
	<input type="text" name="age" value="${requestScope.age }"/>
</form>

<script>
	function autoMove() {
// 		location.href='/jspStudyModel2/exam_servlet/07.do?name=${requestScope.name }&address=${requestScope.address }&age=${requestScope.age }';
		document.DirForm.action = '/jspStudyModel2/exam_servlet/07.do';
		document.DirForm.method = 'get';
		document.DirForm.submit();
	}//autoMove
	autoMove();
</script>

</body>
</html>
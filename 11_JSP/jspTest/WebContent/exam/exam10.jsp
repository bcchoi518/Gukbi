<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int dan = 0;
	request.setCharacterEncoding("UTF-8");
	String dan_ = request.getParameter("dan");
	if (dan_ == null) {
		dan_ = "";
	} else if (!dan_.equals("")) {
		dan = Integer.parseInt(dan_);
	}//end if
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exam10.jsp</title>
</head>
<body>

	<h2>exam10.jsp</h2>
	<form name="inputDanForm">
		<table>
			<tr>
				<td>입력</td>
				<td><input type="text" name="dan" placeholder="시작할 단수.." value="<%=dan_%>"/></td>
				<td><button type="button" onClick="formSubmit();">확인</button></td>
			</tr>
		</table>
	</form>
	<hr>
	<script>
		function formSubmit() {
			document.inputDanForm.action="exam10.jsp"
			document.inputDanForm.method="post"
			document.inputDanForm.submit();
		}//end formSubmit
	</script>

<%
	if(dan > 0) {
		for (int i = dan; i < 10; i++) {
%>
			<table border="0">
<%
			for (int j = 1; j < 10; j++) {
%>
				<tr>
					<td><%=i %></td>
					<td>*</td>
					<td><%=j %></td>
					<td>=</td>
					<td><%=(i * j) %></td>
				</tr>
<%
			}//end for
%>
			</table>
			<% if (i < 9) { %>
				<hr>
			<% } %>
<%
		}//end for
	}//end if
%>
</body>
</html>
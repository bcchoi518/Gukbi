<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "../_include/inc_header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>spring portfolio</title>
<script src = "http://code.jquery.com/jquery-3.3.1.min.js" ></script>
</head>
<body>

	<table border="1" align="center" width="90%">
		<tr>
			<td style="padding:20px;" align="center">
				<%@ include file = "../_include/inc_menu.jsp" %>
			</td>
		</tr>
		<tr>
			<td style="padding:20px;" align="center">
				<jsp:include page="../${requestScope.folderName }/${requestScope.fileName }.jsp"></jsp:include>
			</td>
		</tr>
		<tr>
			<td style="padding:20px;" align="center">
				<jsp:include page="../_include/inc_footer.jsp"></jsp:include>
			</td>
		</tr>
	</table>
	
</body>
</html>
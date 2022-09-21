<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "../../../_include/inc_header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@ include file = "../../../_include/inc_menu.jsp" %>
	
	<h2>직위정보수정</h2>
	
	<form name="DirForm">
		<input type="hidden" name="positionNo" value="${requestScope.dto.positionNo }" />
		<table border="1" width="80%">
			<tr>
				<td>직위이름</td>
				<td><input type="text" name="positionName" value="${requestScope.dto.positionName }"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="button" onclick="save()">수정하기</button>
				</td>
			</tr>
		</table>
	</form>
	
	<script>
		function save() {
			if (confirm('수정하시겠습니까?')) {
				document.DirForm.action = '${path }/position_servlet/sujungProc.do';
				document.DirForm.method = 'post';
				document.DirForm.submit();
			}//if
		}//save
	</script>
	
</body>
</html>
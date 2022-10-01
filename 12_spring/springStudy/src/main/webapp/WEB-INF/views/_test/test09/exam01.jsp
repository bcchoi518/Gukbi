<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "../../_include/inc_header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src = "http://code.jquery.com/jquery-3.4.1.min.js" ></script>
</head>
<body>

	<%@ include file = "../../_include/inc_menu.jsp" %>
	
	<h2>${requestScope.title }</h2>
	
	<table border="1">
		<tr>
			<td>아이디</td>
			<td><input type="text" id="id"/></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" id="name"/></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type="text" id="email"/></td>
		</tr>
		<tr>
			<td colspan="2">
				<button type="button" id="btnSave" >확인</button>
			</td>
		</tr>
	</table>
	<div id="result"></div>
	<script>
		$(document).ready(function() {
			$('#btnSave').click(function() {
				const param = {
					'id': $('#id').val(),
					'name': $('#name').val(),
					'email': $('#email').val()
				}
				const url = '${path }/test09Proc';
				$.ajax({
					type: 'post',
					data: param,
					url: url,
					success: function(result) {
						console.log(result);
						$('#result').html('id: '+ result.id +', name: '+ result.name +', email: '+ result.email);
// 						$('#id').val('');
// 						$('#name').val('');
// 						$('#email').val('');
					}
				});
			});
		});
	</script>
	
</body>
</html>
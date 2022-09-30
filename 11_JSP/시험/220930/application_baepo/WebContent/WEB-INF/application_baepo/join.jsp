<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "_inc_top.jsp" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="joinForm">
		<table border="1" width="80%">
			<tr>
				<td colspan="5" height="80px"><h2>회원가입</h2></td>
			</tr>
			<tr>
				<td>아이디</td>
				<td>
					<input type="text" name="id" />
					<button type="button">아이디찾기</button>
					<button type="button">아이디찾기(새창)</button>
				</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="passwd" /></td>
			</tr>
			<tr>
				<td>비밀번호확인</td>
				<td><input type="password" name="passwdChk" /></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>성별</td>
				<td>
					<input type="radio" name="gender" value="M" checked/>남자
					<input type="radio" name="gender" value="F" />여자
				</td>
			</tr>
			<tr>
				<td>태어난년도</td>
				<td><input type="text" name="birthYear" /></td>
			</tr>
			<tr>
				<td rowspan="3">주소</td>
				<td>
					<input type="text" name="addr1" id="sample6_postcode" placeholder="우편번호" readonly>
					<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기">
				</td>
			</tr>
			<tr>
				<td>
					<input type="text" name="addr2" id="sample6_address" placeholder="주소" readonly>
				</td>
			</tr>
			<tr>
				<td>
					<input type="text" name="addr3" id="sample6_detailAddress" placeholder="상세주소">
					<input type="text" name="addr4" id="sample6_extraAddress" placeholder="참고항목" readonly>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center" style="height:50px">
					<button type="button" onclick="join()">JOIN</button>
					<button type="button" onclick="location.href='${requestScope.path }/list';">LIST</button>
				</td>
			</tr>
		</table>
	</form>
	
	<script>
		function join() {
			if (confirm('회원가입 하시겠습니까?')) {
				document.joinForm.action = '${requestScope.path }/joinProc';
				document.joinForm.method = 'post';
				document.joinForm.submit();
			}//if
		}//join
	</script>
	
	<jsp:include page="_inc_daumApi.jsp" flush="true"></jsp:include>
</body>
</html>
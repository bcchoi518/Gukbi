<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" width="80%" align="center">
		<tr>
			<td height="100px" align="center">
				상단메뉴
			</td>
		</tr>
		<tr>
			<td height="300px" align="center">
				본문내용
			</td>
		<tr>
			<td height="100px" align="center">
				CopyRight
			</td>
		</tr>
	</table>
</body>
</html>

<th>아이디</th>
			<td><input type="text" name="id" /></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="text" name="id" /></td>
		</tr>
		<tr>
			<th>비밀번호확인</th>
			<td><input type="text" name="id" /></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><input type="text" name="id" /></td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td><input type="text" name="id" /></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><input type="text" name="id" /></td>
		</tr>
		<tr>
			<th>주소</th>
			<td>
				<input type="text" name="post_1" id="sample6_postcode" placeholder="우편번호">
				<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
				<input type="text" name="post_2" id="sample6_address" placeholder="주소"><br>
				<input type="text" name="post_3" id="sample6_detailAddress" placeholder="상세주소">
				<input type="text" name="post_4" id="sample6_extraAddress" placeholder="참고항목">
			</td>
		</tr>
		<tr>
			<td colspan="2"><button type="button">회원가입</button></td>
		</tr>
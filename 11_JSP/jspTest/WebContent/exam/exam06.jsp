<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>exam06.jsp</title>
</head>
<body>

	<h2>회원가입(2)</h2>

	<form name="signUpForm" method="post" action="exam06Proc.jsp">
		<table>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="id" /></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pw" /></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<th>닉네임</th>
				<td><input type="text" name="nickname" /></td>
			</tr>
			<tr>
				<th>휴대폰</th>
				<td><input type="text" name="phone" /></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="email" name="email" /></td>
			</tr>
			<tr>
				<th>주민번호</th>
				<td><input type="text" name="jumin" /></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input type="text" name="address" /></td>
			</tr>
		</table>
		
		<hr>
		
		<table>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="id2" /></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pw2" /></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="name2" /></td>
			</tr>
			<tr>
				<th>닉네임</th>
				<td><input type="text" name="nickname2" /></td>
			</tr>
			<tr>
				<th>휴대폰</th>
				<td><input type="text" name="phone2" /></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="email" name="email2" /></td>
			</tr>
			<tr>
				<th>주민번호</th>
				<td><input type="text" name="jumin2" /></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input type="text" name="address2" /></td>
			</tr>
			<tr>
				<td colspan="2"><button type="submit">회원가입</button></td>
			</tr>
		</table>
	</form>
</body>
</html>
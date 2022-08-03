<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>exam07.jsp</title>
</head>
<body>

	<h2>exam07.jsp</h2>
	
	<form name="exam07Form">
		<table border="1">
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
				<th>회원등급</th>
				<td>
					<input type="radio" name="grade" value="최우수회원"/>최우수회원 &nbsp;
					<input type="radio" name="grade" value="우수회원"/>우수회원 &nbsp;
					<input type="radio" name="grade" value="일반회원" checked/>일반회원 &nbsp;
				</td>
			</tr>
			<tr>
				<th>주소</th>
				<td>
					<select name="address">
						<option value="" selected>- 선택 -</option>
						<option value="서울">서울</option>
						<option value="대전">대전</option>
						<option value="대구">대구</option>
						<option value="부산">부산</option>
						<option value="광주">광주</option>
						<option value="제주">제주</option>
						<option value="강원">강원</option>
						<option value="기타">기타</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>관심분야</th>
				<td>
					<input type="checkbox" name="hobby" value="영화"/>영화 &nbsp;
					<input type="checkbox" name="hobby" value="독서"/>독서 &nbsp;
					<input type="checkbox" name="hobby" value="음악"/>음악 &nbsp;
					<br>
					<input type="checkbox" name="hobby" value="캠핑"/>캠핑 &nbsp;
					<input type="checkbox" name="hobby" value="골프"/>골프 &nbsp;
					<input type="checkbox" name="hobby" value="등산"/>등산 &nbsp;
					<br>
					<input type="checkbox" name="hobby" value="스쿠버"/>스쿠버 &nbsp;
					<input type="checkbox" name="hobby" value="모터사이클"/>모터사이클 &nbsp;
					<input type="checkbox" name="hobby" value="자동차"/>자동차 &nbsp;
				</td>
			</tr>
			<tr>
				<td colspan="2"><button type="button" onClick="formSubmit();">확인</button></td>
			</tr>
		</table>
	</form>
	<script>
		function formSubmit() {
			document.exam07Form.action = "exam07Proc.jsp"
			document.exam07Form.method = "post"
			document.exam07Form.submit();
		}//end formSubmit
	</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
	<h2>회원등록</h2>
	<form name="chugaForm">
		<table border="1">
			<tr>
				<th>아이디</th>
				<td><input type="text" name="id" /></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="passwd" /></td>
			</tr>
			<tr>
				<th>비밀번호확인</th>
				<td><input type="password" name="passwdChk" /></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<th>연락처</th>
				<td><input type="text" name="phone" /></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<th>주민번호</th>
				<td>
					<input type="text" name="jumin1" style="width:60px"/> 
					-
					<input type="text" name="jumin2" style="width:60px"/>
				</td>
			</tr>
			<tr>
				<th rowspan="3">주소</th>
				<td>
					<input type="text" name="juso1" id="sample6_postcode" placeholder="우편번호" readonly>
					<button type="button" onclick="sample6_execDaumPostcode()">우편번호 찾기</button>
			<tr>
				<td>
					<input type="text" name="juso2" id="sample6_address" placeholder="주소" readonly>
				</td>
			</tr>
			<tr>
				<td>
					<input type="text" name="juso3" id="sample6_detailAddress" placeholder="상세주소">
					<input type="text" name="juso4" id="sample6_extraAddress" placeholder="참고항목" readonly>
				</td>
			</tr>
			<tr>
				<td colspan="2"><button type="button" onClick="chuga()">가입하기</button></td>
			</tr>
		</table>
	</form>
	<script>
		function chuga() {
			if (confirm('가입하시겠습니까?')) {
				document.chugaForm.action = 'chugaProc.jsp';
				document.chugaForm.method = 'post';
				document.chugaForm.submit();
			}//if
		}//chuga
	</script>
	<jsp:include page="_inc_daumApi.jsp"></jsp:include>
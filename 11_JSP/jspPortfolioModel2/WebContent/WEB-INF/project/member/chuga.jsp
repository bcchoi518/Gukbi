<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "../include/inc_header.jsp" %>

<h2>회원등록</h2>

<form name="DirForm">
	<input type="hidden" name="searchGubun" id="searchGubun" value="${requestScope.searchGubun }" />
	<input type="hidden" name="searchData" id="searchData" value="${requestScope.searchData }" />
	<table border="1" align="center" width="80%">
		<tr>
			<td width="150px">아이디</td>
			<td>
				<input type="text" name="id" id="id" value="" />
				<button type="button" onclick="idCheck()">아이디찾기</button>
				<button type="button" onclick="idCheckWin()">아이디찾기(새창)</button>
				<br>
				<label id="label_id"></label>
			</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="passwd" id="passwd" value="" /></td>
		</tr>
		<tr>
			<td>비밀번호확인</td>
			<td><input type="password" name="passwdChk" id="passwdChk" value="" /></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="name" id="name" value="" /></td>
		</tr>
		<tr>
			<td>생년월일</td>
			<td>
				<input type="text" name="jumin1" maxlength="6" style="width:50px" /> -
				<input type="text" name="jumin2" maxlength="1" style="width:10px"/>******
			</td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td>
				<select name="phone1">
					<option value="010" selected>010</option>
					<option value="011" >011</option>
					<option value="016" >016</option>
				</select>
				-
				<input type="text" name="phone2" maxlength="4" style="width:50px" />
				-
				<input type="text" name="phone3" maxlength="4" style="width:50px" />
			</td>
		</tr>
		<tr>
			<td>이메일</td>
			<td>
				<input type="text" name="email1" style="width:100px" />
				@
				<select name="email2">
					<option value="google.com" >google.com</option>
					<option value="naver.com" >naver.com</option>
					<option value="daum.net" >daum.net</option>
				</select>
			</td>
		</tr>
		<tr>
			<td rowspan="3">주소</td>
			<td>
				<input type="text" name="postcode" id="sample6_postcode" placeholder="우편번호" readonly>
				<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기">
			</td>
		</tr>
		<tr>
			<td>
				<input type="text" name="address" id="sample6_address" placeholder="주소" readonly>
			</td>
		</tr>
		<tr>
			<td>
				<input type="text" name="detailAddress" id="sample6_detailAddress" placeholder="상세주소">
				<input type="text" name="extraAddress" id="sample6_extraAddress" placeholder="참고항목" readonly>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center" style="height:50px">
				<button type="button" onclick="save()">등록하기</button>
				<button type="button" onclick="move('member_list.do')">목록으로</button>
			</td>
		</tr>
	</table>
</form>

<script>
	function save() {
		if (confirm('OK?')) {
			document.DirForm.action = '${requestScope.path }/member_servlet/member_chugaProc.do';
			document.DirForm.method = 'post';
			document.DirForm.submit();
		}//if
	}//save
	
	function move(value1, value2) {
		let linkAddr = '${requestScope.path }/member_servlet/' + value1 + '?${requestScope.searchQuery }';
		if (value2 != undefined) {
			linkAddr += '&no=' + value2;
		}//if
		location.href = linkAddr;
	}//move
	
	function idCheck() {
		alert('idCheck');
	}//idCheck
	
	function idCheckWin() {
		window.open('${requestScope.path }/member_servlet/member_idCheckWin.do','idCheckWin','width=600, height=210, toolbar=no, menubar=no, scrollbars=no, resizable=no');
	}//idCheck
</script>

<jsp:include page="_inc_daumApi.jsp" flush="true"></jsp:include>
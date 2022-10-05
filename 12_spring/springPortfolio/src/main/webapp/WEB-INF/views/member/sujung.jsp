<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "../_include/inc_header.jsp" %>

<h2>회원수정</h2>

<form name="DirForm">
	<input type="hidden" name="no" id="no" value="${requestScope.dto.no }" />
	<input type="hidden" name="searchGubun" id="searchGubun" value="${requestScope.searchGubun }" />
	<input type="hidden" name="searchData" id="searchData" value="${requestScope.searchData }" />
	<table border="1" align="center" width="80%">
		<tr>
			<td width="150px">아이디</td>
			<td>${requestScope.dto.id }</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="passwd" id="passwd" value="" /></td>
		</tr>
		<tr>
			<td>이름</td>
			<td>${requestScope.dto.name }</td>
		</tr>
		<tr>
			<td>생년월일</td>
			<td>${requestScope.dto.jumin1 }-${requestScope.dto.jumin2 }******</td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td>
				<select name="phone1">
					<c:choose>
						<c:when test="${requestScope.dto.phone1 == '010' }">
							<option value="010" selected>010</option>
							<option value="011" >011</option>
							<option value="016" >016</option>
						</c:when>
						<c:when test="${requestScope.dto.phone1 == '011' }">
							<option value="010" >010</option>
							<option value="011" selected>011</option>
							<option value="016" >016</option>
						</c:when>
						<c:otherwise>
							<option value="010" >010</option>
							<option value="011" >011</option>
							<option value="016" selected>016</option>
						</c:otherwise>
					</c:choose>
				</select>
				-
				<input type="text" name="phone2" maxlength="4" style="width:50px" value="${requestScope.dto.phone2 }"/>
				-
				<input type="text" name="phone3" maxlength="4" style="width:50px" value="${requestScope.dto.phone3 }"/>
			</td>
		</tr>
		<tr>
			<td>이메일</td>
			<td>
				<input type="text" name="email1" style="width:100px" value="${requestScope.dto.email1 }"/>
				@
				<input type="text" name="email2" id="email2" style="width:100px" value="${requestScope.dto.email2 }" readOnly/>
				<select name="emailSelector" id="emailSelector" onchange="changeEmail2()">
					<c:choose>
						<c:when test="${requestScope.dto.email2 == 'google.com' }">
							<option value="" >-- 직접입력 --</option>
							<option value="google.com" selected>google.com</option>
							<option value="naver.com" >naver.com</option>
							<option value="daum.net" >daum.net</option>
						</c:when>
						<c:when test="${requestScope.dto.email2 == 'naver.com' }">
							<option value="" >-- 직접입력 --</option>
							<option value="google.com" >google.com</option>
							<option value="naver.com" selected>naver.com</option>
							<option value="daum.net" >daum.net</option>
						</c:when>
						<c:otherwise>
							<option value="" >-- 직접입력 --</option>
							<option value="google.com" >google.com</option>
							<option value="naver.com" >naver.com</option>
							<option value="daum.net" selected>daum.net</option>
						</c:otherwise>
					</c:choose>
				</select>
			</td>
		</tr>
		<tr>
			<td rowspan="3">주소</td>
			<td>
				<input type="text" name="postcode" id="sample6_postcode" placeholder="우편번호" value="${requestScope.dto.postcode }" readonly>
				<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기">
			</td>
		</tr>
		<tr>
			<td>
				<input type="text" name="address" id="sample6_address" placeholder="주소" value="${requestScope.dto.address }" readonly>
			</td>
		</tr>
		<tr>
			<td>
				<input type="text" name="detailAddress" id="sample6_detailAddress" value="${requestScope.dto.detailAddress }" placeholder="상세주소">
				<input type="text" name="extraAddress" id="sample6_extraAddress" value="${requestScope.dto.extraAddress }" placeholder="참고항목" readonly>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center" style="height:50px">
				<button type="button" onclick="save()">수정하기</button>
				<button type="button" onclick="move('list')">목록으로</button>
			</td>
		</tr>
	</table>
</form>

<script>
	function changeEmail2() {
		const emailSelector = document.querySelector('#emailSelector');
		const email2 = document.querySelector('#email2');
		const selectedValue = emailSelector.options[emailSelector.selectedIndex].value;
		
		email2.value = selectedValue;
		
		if (selectedValue == '') {
			email2.readOnly = false;
		} else {
			email2.readOnly = true;
		}//if
	}//changeEmail2

	function save() {
		if (confirm('OK?')) {
			document.DirForm.action = '${path }/member/sujungProc';
			document.DirForm.method = 'post';
			document.DirForm.submit();
		}//if
	}//save
	
	function move(value1, value2) {
		let linkAddr = '${path }/member/'+ value1 +'?pageNumber=${requestScope.pageNumber }';
		if (value2 != undefined) {
			linkAddr += '&no='+ value2;
		}//if
		linkAddr += '&searchGubun=${requestScope.searchGubun }&searchData=${requestScope.searchData }';
		location.href = linkAddr;
	}//move
</script>

<jsp:include page="_inc_daumApi.jsp" flush="true"></jsp:include>
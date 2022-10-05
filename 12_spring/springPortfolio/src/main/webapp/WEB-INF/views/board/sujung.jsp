<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "../_include/inc_header.jsp" %>

<h2>게시글수정</h2>

<form name="DirForm">
	<input type="hidden" name="no" value="${requestScope.dto.no }"/>
	<table border="1" align="center" width="80%">
		<tr>
			<td style="width:10%;">작성자</td>
			<td><input type="text" name="writer" id="writer" value="${requestScope.dto.writer }" /></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="passwd" id="passwd" value="" /></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td>
				<c:set var="emailArray" value="${fn:split(requestScope.dto.email, '@') }" />
				<input type="text" name="email1" style="width:100px" value="${emailArray[0] }"/>
				@
				<input type="text" name="email2" id="email2" style="width:100px" value="${emailArray[1] }" readOnly/>
				<select name="emailSelector" id="emailSelector" onchange="changeEmail2()">
					<option value="" selected>-- 직접입력 --</option>
					<option value="google.com" <c:if test="${emailArray[1] == 'google.com' }">selected</c:if>>google.com</option>
					<option value="naver.com" <c:if test="${emailArray[1] == 'naver.com' }">selected</c:if>>naver.com</option>
					<option value="daum.net" <c:if test="${emailArray[1] == 'daum.net' }">selected</c:if>>daum.net</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>공지글</td>
			<td>
				<input type="radio" name="noticeGubun" id="noticeGubun" value="F" <c:if test="${requestScope.dto.noticeNo == 0 }">checked</c:if>/>일반
				<input type="radio" name="noticeGubun" id="noticeGubun" value="T" <c:if test="${requestScope.dto.noticeNo > 0 }">checked</c:if>/>공지
			</td>
		</tr>
		<tr>
			<td>비밀글</td>
			<td>
				<input type="radio" name="secretGubun" id="secretGubun" value="F" <c:if test="${requestScope.dto.secretGubun == 'F' }">checked</c:if>/>공개
				<input type="radio" name="secretGubun" id="secretGubun" value="T" <c:if test="${requestScope.dto.secretGubun == 'T' }">checked</c:if> <c:if test="${requestScope.dto.noticeNo > 0 }">disabled</c:if> />비밀
			</td>
		</tr>
		<tr>
			<td>제목</td>
			<td><input type="text" name="subject" id="subject" value="${requestScope.dto.subject }" style="width:99%;"/></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea name="content" style="width:99%; height:200px;">${requestScope.dto.content }</textarea></td>
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
	const frm = document.DirForm;
	frm.noticeGubun[0].addEventListener('change', function() {
		frm.secretGubun[1].disabled = false;
	});
	frm.noticeGubun[1].addEventListener('change', function() {
		frm.secretGubun[1].disabled = true;
	});
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
			document.DirForm.action = '${path }/board/sujungProc';
			document.DirForm.method = 'post';
			document.DirForm.submit();
		}//if
	}//save
	
	function move(value1, value2) {
		let linkAddr = '${path }/board/' + value1 + '?${requestScope.searchQuery }';
		if (value2 != undefined) {
			linkAddr += '&no=' + value2;
		}//if
		location.href = linkAddr;
	}//move
</script>
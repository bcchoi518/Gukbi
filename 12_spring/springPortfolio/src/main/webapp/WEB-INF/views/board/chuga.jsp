<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "../_include/inc_header.jsp" %>

<c:set var="subject" value=""/>
<c:set var="content" value=""/>
<c:set var="no" value="0"/>
<c:choose>
	<c:when test="${requestScope.dto.no > 0 }">
		<h2>답변글등록</h2>
		<c:set var="subject" value="${requestScope.dto.subject }"/>
		<c:set var="content" value="${requestScope.dto.content }"/>
		<c:set var="no" value="${requestScope.dto.no }"/>
	</c:when>
	<c:otherwise>
		<h2>게시글등록</h2>
	</c:otherwise>
</c:choose>

<form name="DirForm">
	<input type="hidden" name="no" value="${no }"/>
	<table border="1" align="center" width="80%">
		<tr>
			<td style="width:10%;">작성자</td>
			<td><input type="text" name="writer" id="writer" value="" /></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="passwd" id="passwd" value="" /></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td>
				<input type="text" name="email1" style="width:100px" />
				@
				<input type="text" name="email2" id="email2" style="width:100px" />
				<select name="emailSelector" id="emailSelector" onchange="changeEmail2()">
					<option value="" selected>-- 직접입력 --</option>
					<option value="google.com" >google.com</option>
					<option value="naver.com" >naver.com</option>
					<option value="daum.net" >daum.net</option>
				</select>
				
				
			</td>
		</tr>
		<tr>
			<td>공지글</td>
			<td>
				<input type="radio" name="noticeGubun" id="noticeGubun" value="F" checked/>일반
				<input type="radio" name="noticeGubun" id="noticeGubun" value="T" />공지
			</td>
		</tr>
		<tr>
			<td>비밀글</td>
			<td>
				<input type="radio" name="secretGubun" id="secretGubun" value="F" checked/>공개
				<input type="radio" name="secretGubun" id="secretGubun" value="T" />비밀
			</td>
		</tr>
		<tr>
			<td>제목</td>
			<td><input type="text" name="subject" id="subject" value="${subject }" style="width:99%;"/></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea name="content" style="width:99%; height:200px;">${content }</textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="center" style="height:50px">
				<button type="button" onclick="save()">등록하기</button>
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
			frm.action = '${path }/board/chugaProc';
			frm.method = 'post';
			frm.submit();
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
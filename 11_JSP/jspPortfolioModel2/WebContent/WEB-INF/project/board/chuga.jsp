<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "../include/inc_header.jsp" %>

<h2>게시글등록</h2>

<form name="DirForm">
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
			<td>공지글 여부</td>
			<td>
				<input type="radio" name="noticeGubun" id="noticeGubun" value="F" checked/>일반
				<input type="radio" name="noticeGubun" id="noticeGubun" value="T" />공지
			</td>
		</tr>
		<tr>
			<td>비밀글 여부</td>
			<td>
				<input type="radio" name="secretGubun" id="secretGubun" value="F" checked/>공개
				<input type="radio" name="secretGubun" id="secretGubun" value="T" />비밀
			</td>
		</tr>
		<tr>
			<td>제목</td>
			<td><input type="text" name="subject" id="subject" value="" style="width:99%;"/></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea name="content" style="width:99%; height:200px;"></textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="center" style="height:50px">
				<button type="button" onclick="save()">등록하기</button>
				<button type="button" onclick="move('board_list.do')">목록으로</button>
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
			document.DirForm.action = '${requestScope.path }/board_servlet/board_chugaProc.do';
			document.DirForm.method = 'post';
			document.DirForm.submit();
		}//if
	}//save
	
	function move(value1, value2) {
		let linkAddr = '${requestScope.path }/board_servlet/' + value1 + '?${requestScope.searchQuery }';
		if (value2 != undefined) {
			linkAddr += '&no=' + value2;
		}//if
		location.href = linkAddr;
	}//move
</script>
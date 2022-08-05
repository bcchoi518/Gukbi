<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<h2>회원등록</h2>
	<form name="chugaForm">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><input type="text"	name="id"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password"	name="passwd"></td>
			</tr>
			<tr>
				<td>비밀번호확인</td>
				<td><input type="password"	name="passwdChk"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text"	name="name"></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text"	name="phone"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="email"	name="email"></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text"	name="address"></td>
			</tr>
			<tr>
				<td colspan="2">
				<button type="button" onClick="join();">가입하기</button>
				</td>
			</tr>
		</table>
	</form>
	<script>
		function join() {
// 			if (document.chugaForm.id.value.trim() == '') {
// 				alert('아이디를 입력하세요.');
// 				document.chugaForm.id.focus();
// 				return;
// 			}//end if
// 			if (document.chugaForm.passwd.value.trim() == '') {
// 				alert('비밀번호를 입력하세요.');
// 				document.chugaForm.passwd.focus();
// 				return;
// 			}//end if
// 			if (document.chugaForm.passwdChk.value.trim() == '') {
// 				alert('비밀번호확인란을 입력하세요.');
// 				document.chugaForm.passwdChk.focus();
// 				return;
// 			}//end if
// 			if (document.chugaForm.passwd.value.trim() != document.chugaForm.passwdChk.value.trim()) {
// 				alert('입력한 비밀번호가 다릅니다.');
// 				document.chugaForm.passwdChk.focus();
// 				return;
// 			}//end if
// 			if (document.chugaForm.name.value.trim() == '') {
// 				alert('이름을 입력하세요.');
// 				document.chugaForm.name.focus();
// 				return;
// 			}//end if
// 			if (document.chugaForm.phone.value.trim() == '') {
// 				alert('전화번호를 입력하세요.');
// 				document.chugaForm.phone.focus();
// 				return;
// 			}//end if
// 			if (document.chugaForm.email.value.trim() == '') {
// 				alert('이메일을 입력하세요.');
// 				document.chugaForm.email.focus();
// 				return;
// 			}//end if
// 			if (document.chugaForm.address.value.trim() == '') {
// 				alert('주소를 입력하세요.');
// 				document.chugaForm.address.focus();
// 				return;
// 			}//end if
			document.chugaForm.action = "mainProc.jsp?menuGubun=member2_chugaProc";
			document.chugaForm.method = "post";
			document.chugaForm.submit();
		}//end join
	</script>
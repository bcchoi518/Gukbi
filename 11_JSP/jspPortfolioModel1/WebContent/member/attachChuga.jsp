<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "_inc_top.jsp" %>

<h2>회원등록(attach)</h2>
<form name="chugaForm">
	<table border="0" align="center"> 
		<tr>
			<td class="entryName">아이디 : </td>
			<td><input type="text" name="id" /></td>
		</tr>
		<tr>
			<td class="entryName">비밀번호 : </td>
			<td><input type="password" name="passwd" /></td>
		</tr>
		<tr>
			<td class="entryName">비밀번호확인 : </td>
			<td><input type="password" name="passwdChk" /></td>
		</tr>
		<tr>
			<td class="entryName">이름 : </td>
			<td><input type="text" name="name" /></td>
		</tr>
		<tr>
			<td class="entryName">연락처 : </td>
			<td><input type="text" name="phone" /></td>
		</tr>
		<tr>
			<td class="entryName">이메일 : </td>
			<td><input type="text" name="email" /></td>
		</tr>
		<tr>
			<td class="entryName">주민번호 : </td>
			<td>
				<input type="text" name="jumin1" style="width:60px"/>
				-
				<input type="text" name="jumin2" style="width:60px"/>
			</td>
		</tr>
		<tr>
			<td class="entryName">주소 : </td>
				<td>
					<input type="text" name="juso1" id="sample6_postcode" placeholder="우편번호" readonly>
					<button type="button" onclick="sample6_execDaumPostcode()">우편번호 찾기</button><br>
					<input type="text" name="juso2" id="sample6_address" placeholder="주소" readonly><br>
					<input type="text" name="juso3" id="sample6_detailAddress" placeholder="상세주소">
					<input type="text" name="juso4" id="sample6_extraAddress" placeholder="참고항목" readonly>
				</td>
		</tr>
		<tr>
			<td class="entryName">회원등급 : </td>
			<td>
				<input type="radio" name="grade" value="최우수회원" /> 최우수회원 &nbsp;
				<input type="radio" name="grade" value="우수회원" /> 우수회원 &nbsp;
				<input type="radio" name="grade" value="일반회원" checked /> 일반회원 &nbsp;
			</td>
		</tr>
		<tr>
			<td class="entryName">사진첨부 : </td>
			<td>
				<input type="file" name="file1"><br>
				<input type="file" name="file2"><br>
				<input type="file" name="file3">
			</td>
		</tr>
		<tr align="center" height="50px">
			<td colspan="2">
				<button type="button" onClick="join()">가입하기</button>
				<button type="button" onClick="location.href='../main/main.jsp?menuGubun=member_list';">목록으로</button>
			</td>
		</tr>
	</table>
</form>
<script>
	function join() {
		if (confirm('등록할까요?')) {
			//파일을 첨부하여 submit 하면 반드시 enctype을 작성해야함
			document.chugaForm.enctype = 'multipart/form-data';
			document.chugaForm.action = "mainProc.jsp?menuGubun=member_attachChugaProc";
			document.chugaForm.method = "post";
			document.chugaForm.submit();
		}//if
	}//join
</script>
<jsp:include page="_inc_daumApi.jsp" flush="true"></jsp:include>
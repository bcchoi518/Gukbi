<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "../_include/inc_header.jsp" %>

<h2>회원삭제</h2>

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
			<td>${requestScope.dto.phone1 }-${requestScope.dto.phone2 }-${requestScope.dto.phone3 }</td>
		</tr>
		<tr>
			<td>이메일</td>
			<td>${requestScope.dto.email1 }@${requestScope.dto.email2 }</td>
		</tr>
		<tr>
			<td>postcode</td>
			<td>${requestScope.dto.postcode }</td>
		</tr>
		<tr>
			<td>address</td>
			<td>${requestScope.dto.address }</td>
		</tr>
		<tr>
			<td>detailAddress</td>
			<td>${requestScope.dto.detailAddress }</td>
		</tr>
		<tr>
			<td>extraAddress</td>
			<td>${requestScope.dto.extraAddress }</td>
		</tr>
		<tr>
			<td>가입일</td>
			<td>${requestScope.dto.regiDate }</td>
		</tr>
		<tr>
			<td colspan="2" align="center" style="height:50px">
				<button type="button" onclick="save()">삭제하기</button>
				<button type="button" onclick="move('list')">목록으로</button>
			</td>
		</tr>
	</table>
</form>

<script>
	function save() {
		if (confirm('OK?')) {
			document.DirForm.action = '${path }/member/sakjeProc';
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
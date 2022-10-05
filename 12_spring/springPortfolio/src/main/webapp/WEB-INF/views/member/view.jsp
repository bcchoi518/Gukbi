<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "../_include/inc_header.jsp" %>

<h2>회원상세보기</h2>

<table border="1" width="80%">
	<tr>
		<td>아이디</td>
		<td>${requestScope.dto.id }</td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td>${requestScope.dto.passwd }</td>
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
		<td>email</td>
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
</table>

<div style="border: 0px solid red; padding-top:10px; width:80%;" align="center">
	<table border="0" width="100%">
		<tr>
			<td width="100px" >이전회원</td>
			<td>
				<c:if test="${requestScope.dto.preNo > 0 }">
					<a href="#" onClick="move('view','${requestScope.dto.preNo }')">${requestScope.dto.preName }</a>
				</c:if>
				<c:if test="${requestScope.dto.preNo <= 0 }">
					등록된 회원이 없습니다.
				</c:if>
			</td>
		</tr>
		<tr>
			<td class="entryName">다음회원</td>
			<td>
				<c:if test="${requestScope.dto.nxtNo > 0 }">
					<a href="#" onClick="move('view','${requestScope.dto.nxtNo }')">${requestScope.dto.nxtName }</a>
				</c:if>
				<c:if test="${requestScope.dto.nxtNo <= 0 }">
					등록된 회원이 없습니다.
				</c:if>
			</td>
		</tr>
	</table>
</div>

<div style="border: 0px solid red; width: 80%; margin-top:10px;" align="right">
|
<a href="${path }/member/list" >전체목록</a>
|
<a href="#" onclick="move('list')">목록</a>
|
<a href="#" onclick="move('chuga')">등록</a>
|
<a href="#" onclick="move('sujung','${requestScope.dto.no }')">수정</a>
|
<a href="#" onclick="move('sakje','${requestScope.dto.no }')">삭제</a>
|
</div>

<script>
	function move(value1, value2) {
		let linkAddr = '${path }/member/'+ value1 +'?pageNumber=${requestScope.pageNumber }';
		if (value2 != undefined) {
			linkAddr += '&no=' + value2;
		}//if
		linkAddr += '&searchGubun=${requestScope.searchGubun }&searchData=${requestScope.searchData }';
		location.href = linkAddr;
	}//move
</script>
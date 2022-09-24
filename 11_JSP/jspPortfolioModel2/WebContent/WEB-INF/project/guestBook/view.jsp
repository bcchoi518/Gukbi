<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "../include/inc_header.jsp" %>

<h2>방명록상세보기</h2>

<table border="1" width="80%">
	<tr>
		<td>이름</td>
		<td>${requestScope.dto.name }</td>
	</tr>
	<tr>
		<td>이메일</td>
		<td>${requestScope.dto.email }</td>
	</tr>
	<tr>
		<td>내용</td>
		<td>${fn:replace(requestScope.dto.content, requestScope.newLine, '<br>') }</td>
	</tr>
	<tr>
		<td>등록일</td>
		<td>${requestScope.dto.regiDate }</td>
	</tr>
</table>

<%-- pre/next Start --%>
<div style="border: 0px solid red; padding-top:10px; width:80%;" align="center">
	<table border="0" width="100%">
		<tr>
			<td width="100px" >이전글</td>
			<td>
				<c:if test="${requestScope.dto.preNo > 0 }">
					<a href="#" onClick="move('guestBook_view.do','${requestScope.dto.preNo }')">${requestScope.dto.preContent }...</a>
				</c:if>
				<c:if test="${requestScope.dto.preNo <= 0 }">
					이전 글이 없습니다.
				</c:if>
			</td>
		</tr>
		<tr>
			<td class="entryName">다음글</td>
			<td>
				<c:if test="${requestScope.dto.nxtNo > 0 }">
					<a href="#" onClick="move('guestBook_view.do','${requestScope.dto.nxtNo }')">${requestScope.dto.nxtContent }...</a>
				</c:if>
				<c:if test="${requestScope.dto.nxtNo <= 0 }">
					다음 글이 없습니다.
				</c:if>
			</td>
		</tr>
	</table>
</div>
<%-- pre/next End --%>

<div style="border: 0px solid red; width: 80%; margin-top:10px;" align="right">
|
<a href="${requestScope.path }/guestBook_servlet/guestBook_list.do" >전체목록</a>
|
<a href="#" onclick="move('guestBook_list.do')">목록</a>
|
<a href="#" onclick="move('guestBook_chuga.do')">등록</a>
|
<a href="#" onclick="move('guestBook_sujung.do','${requestScope.dto.no }')">수정</a>
|
<a href="#" onclick="move('guestBook_sakje.do','${requestScope.dto.no }')">삭제</a>
|
</div>

<script>
	function move(value1, value2) {
		let linkAddr = '${requestScope.path }/guestBook_servlet/' + value1 + '?${requestScope.searchQuery }';
		if (value2 != undefined) {
			linkAddr += '&no=' + value2;
		}//if
		location.href = linkAddr;
	}//move
</script>
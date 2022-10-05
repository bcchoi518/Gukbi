<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "../_include/inc_header.jsp" %>

<c:choose>
	<c:when test="${requestScope.dto.secretGubun == 'T' && requestScope.viewPasswd != requestScope.dto.passwd }">
		<form name="viewPasswdForm">
			<input type="hidden" name="no" value="${requestScope.dto.no }" />
			<input type="hidden" name="searchGubun" value="${requestScope.searchGubun }" />
			<input type="hidden" name="searchData" value="${requestScope.searchData }" />
			<table border="0" align="center" style="margin:183px;">
				<tr>
					<td colspan="2" align="center">
						<h2>글상세보기 (비밀글입니다.)</h2>
					</td>
				</tr>
				<tr>
					<td align="center">
						비밀번호 :&nbsp;
						<input type="password" name="viewPasswd" />
						<button type="button" onclick="viewPasswdSubmit()">확인</button>
					</td>
				</tr>
			</table>
		</form>
		<script>
			function viewPasswdSubmit() {
				document.viewPasswdForm.action = '${path }/board/view';
				document.viewPasswdForm.method = 'post';
				document.viewPasswdForm.submit();
			}//viewPasswdSubmit
		</script>
	</c:when>
	<c:otherwise>
		<h2>게시글상세보기</h2>
		
		<table border="1" width="80%">
			<tr>
				<td style="width:10%;">작성자</td>
				<td>${requestScope.dto.writer }</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td>${requestScope.dto.email }</td>
			</tr>
			<tr>
				<td>공지글 여부</td>
				<td>
					<c:if test="${requestScope.dto.noticeNo > 0 }">O</c:if>
					<c:if test="${requestScope.dto.noticeNo <= 0 }">X</c:if>
				</td>
			</tr>
			<tr>
				<td>비밀글 여부</td>
				<td>
					<c:if test="${requestScope.dto.secretGubun == 'T' }">O</c:if>
					<c:if test="${requestScope.dto.secretGubun == 'F' }">X</c:if>
				</td>
			</tr>
			<tr>
				<td>제목</td>
				<td>${requestScope.dto.subject }</td>
			</tr>
			<tr>
				<td>내용</td>
				<td style="height:200px; vertical-align:text-top;">${fn:replace(requestScope.dto.content, requestScope.newLine, '<br>') }</td>
			</tr>
			<tr>
				<td>조회수</td>
				<td>${requestScope.dto.hit }</td>
			</tr>
			<tr>
				<td>등록일</td>
				<td>${requestScope.dto.regiDate }</td>
			</tr>
		</table>
	</c:otherwise>
</c:choose>
<%-- pre/next Start --%>
<div style="border: 0px solid red; padding-top:10px; width:80%;" align="center">
	<table border="0" width="100%">
		<tr>
			<td width="100px" >이전글</td>
			<td>
				<c:if test="${requestScope.dto.preNo > 0 }">
					<a href="#" onClick="move('view','${requestScope.dto.preNo }')">${requestScope.dto.preSubject }...</a>
				</c:if>
				<c:if test="${requestScope.dto.preNo <= 0 }">
					이전 글이 없습니다.
				</c:if>
			</td>
		</tr>
		<tr>
			<td>다음글</td>
			<td>
				<c:if test="${requestScope.dto.nxtNo > 0 }">
					<a href="#" onClick="move('view','${requestScope.dto.nxtNo }')">${requestScope.dto.nxtSubject }...</a>
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
<a href="${path }/board/list" >전체목록</a>
|
<a href="#" onclick="move('list')">목록</a>
|
<a href="#" onclick="move('chuga')">등록</a>
|
<a href="#" onclick="move('chuga','${requestScope.dto.no }')">답변</a>
|
<a href="#" onclick="move('sujung','${requestScope.dto.no }')">수정</a>
|
<a href="#" onclick="move('sakje','${requestScope.dto.no }')">삭제</a>
|
</div>

<%-- board Comment Start --%>
	<a name="comment"></a>
	<div id="commentResult" style="border: 0px solid red; margin: 10px 0px; width: 80%" align="center"></div>
<%-- board Comment End --%>

<script>
	$(document).ready(function () {
		commentList();
	});
	
	function commentList() {
		const param = {
				no : ${requestScope.dto.no }
		}
		const url = '${path }/board/commentList';
		$.ajax({
			type: 'post',
			data: param,
			url: url,
			success: function(data) {
				$('#commentResult').html(data);
			}
		});
	}//commentList
	
	function move(value1, value2) {
		let linkAddr = '${path }/board/' + value1 + '?${requestScope.searchQuery }';
		if (value2 != undefined) {
			linkAddr += '&no=' + value2;
		}//if
		location.href = linkAddr;
	}//move
</script>
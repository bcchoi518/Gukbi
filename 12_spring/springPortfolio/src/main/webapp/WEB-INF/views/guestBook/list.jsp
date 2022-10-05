<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "../_include/inc_header.jsp" %>
<%@ include file = "_inc_top.jsp" %>

<h2>방명록 목록</h2>

<div style="border: 0px solid red; width: 80%; margin-top:10px;" align="left">
	<c:choose>
		<c:when test="${fn:length(requestScope.searchGubun) > 0 }">
			* 검색어 "<span style="color:red; font-weight:bold;">${requestScope.searchData }</span>"으/로 검색된 목록 : ${requestScope.totalRecord }건
		</c:when>
		<c:otherwise>
			* 전체목록: ${requestScope.totalRecord }건
		</c:otherwise>
	</c:choose>
	<c:set var="totalPage" value="${requestScope.pagerMap.totalPage }" />
	<c:if test="${totalPage <= 0 }">
		<c:set var="totalPage" value="1" />
	</c:if>
	(${requestScope.pageNumber }/${totalPage })
</div>

<table border="0" width="80%" align="center">
	<c:if test="${requestScope.totalRecord <= 0 }">
		<c:choose>
			<c:when test="${fn:length(requestScope.searchGubun) > 0 }">
				<tr>
					<td>
						<table border="1" width="100%" align="center">
							<tr>
								<td height="200px" style="text-align:center;">검색된 방명록이 없습니다.</td>
							</tr>
						</table>
					</td>
				</tr>
			</c:when>
			<c:otherwise>
				<tr>
					<td>
						<table border="1" width="100%" align="center">
							<tr>
								<td height="200px" style="text-align:center;">등록된 방명록이 없습니다.</td>
							</tr>
						</table>
					</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</c:if>
	<c:forEach var="guestBookDto" items="${requestScope.list }">
		<tr>
			<td>
				<table border="1" width="100%" align="center">
					<tr>
						<td width="100px">이름</td>
						<td>${guestBookDto.name }</td>
						<td width="100px">날짜</td>
						<td>${guestBookDto.regiDate }</td>
					</tr>
					<tr>
						<td>이메일</td>
						<td colspan="3">${guestBookDto.email }</td>
					</tr>
					<tr>
						<td colspan="4" style="height: 200px; padding:15px; vertical-align: top; position: relative;">
							${fn:replace(guestBookDto.content, newLineChar, '<br>') }
							<div style="float:right; bottom:15px; right:15px; position: absolute;" >
								<a href="#" onclick="move('guestBook_sujung','${guestBookDto.no }')">수정</a>
								/
								<a href="#" onclick="move('guestBook_sakje','${guestBookDto.no }')">삭제</a>
							</div>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</c:forEach>
</table>

<div style="border: 0px solid red; width: 80%; margin-top:10px;" align="right">
|
<a href="${path }/guestBook/list" >전체목록</a>
|
<a href="#" onclick="move('list')">목록</a>
|
<a href="#" onclick="move('chuga')">등록</a>
|
</div>

<%-- searchStart --%>
<div style="border: 0px solid red; width: 80%; margin-top:10px;" align="center">
	<form name="searchForm">
		<select name="searchGubun" id="searchGubun">
			<option value="" selected>-- 선택 --</option>
			<option value="name" <c:if test="${requestScope.searchGubun == 'name' }">selected</c:if>>이름</option>
			<option value="content" <c:if test="${requestScope.searchGubun == 'content' }">selected</c:if>>내용</option>
			<option value="name_content" <c:if test="${requestScope.searchGubun == 'name_content' }">selected</c:if>>이름+내용</option>
		</select>
		&nbsp;
		<input type="text" name="searchData" id="searchData" value="${requestScope.searchData }" style="width:150px;"/>
		&nbsp;
		<button type="button" onclick="search()">검색</button>
	</form>
</div>
<%-- searchEnd --%>

<%-- pagerStart --%>
<c:if test="${requestScope.totalRecord > 0 }">
	<div style="border: 0px solid red; width: 80%; margin-top:30px;" align="center">
		<a href="#" onclick="goPage('1')">[첫페이지]</a>
		&nbsp;
		<c:if test="${requestScope.pagerMap.startPage > requestScope.pagerMap.blockSize }">
			<a href="#" onclick="goPage(${requestScope.pagerMap.startPage - requestScope.pagerMap.blockSize })">[이전10개]</a>
		</c:if>
		<c:if test="${requestScope.pagerMap.startPage <= requestScope.pagerMap.blockSize }">
			[이전10개]
		</c:if>
		&nbsp;
		
		<c:forEach var="i" begin="${requestScope.pagerMap.startPage }" end="${requestScope.pagerMap.lastPage }" step="1" >
			<c:if test="${i == requestScope.pageNumber }" >
				[${i }]
			</c:if>
			<c:if test="${i != requestScope.pageNumber }" >
				<a href="#" onclick="goPage(${i })">[${i }]</a>
			</c:if>
			&nbsp;
		</c:forEach>
		
		<c:if test="${requestScope.pagerMap.lastPage < requestScope.pagerMap.totalPage }">
			<a href="#" onclick="goPage(${requestScope.pagerMap.startpage + requestScope.pagerMap.blockSize})">[다음10개]</a>
		</c:if>
		<c:if test="${requestScope.pagerMap.lastPage >= requestScope.pagerMap.totalPage }">
			[다음10개]
		</c:if>
		&nbsp;
		<a href="#" onclick="goPage('${requestScope.pagerMap.totalPage }')">[끝페이지]</a>
	</div>
</c:if>
<%-- pagerEnd --%>

<script>
	function move(value1, value2) {
		let linkAddr = '${path }/guestBook/' + value1 + '?${requestScope.searchQuery }';
		if (value2 != undefined) {
			linkAddr += '&no=' + value2;
		}//if
		location.href = linkAddr;
	}//move
	
	function search() {
		if (confirm('searchOK?')) {
			document.searchForm.action = '${path }/guestBook/search';
			document.searchForm.method = 'post';
			document.searchForm.submit();
		}//if
	}//search
	
	function goPage(value1) {
		location.href = '${path }/guestBook/list?pageNumber='+ value1 +'&searchGubun=${requestScope.searchGubun }&searchData=${requestScope.searchData }';
	}//goPage
</script>
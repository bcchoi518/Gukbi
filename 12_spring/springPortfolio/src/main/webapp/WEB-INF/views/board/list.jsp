<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "../_include/inc_header.jsp" %>

<h2>게시글목록</h2>

<div style="border: 0px solid red; width: 80%; margin-top:10px;" align="left">
	<c:choose>
		<c:when test="${requestScope.searchGubun != '' }">
			* 검색어 "<span style="color:red; font-weight:bold;">${requestScope.searchData }</span>"으/로 검색된 목록 : ${requestScope.totalRecord }건
		</c:when>
		<c:otherwise>
			* 전체목록: ${requestScope.totalRecord }건
		</c:otherwise>
	</c:choose>
	(${requestScope.pageNumber }/${requestScope.pagerMap.totalPage })
</div>

<table border="1" width="80%" align="center">
	<tr>
		<th>순번</th>
		<th>작성자</th>
		<th>제목</th>
		<th>조회수</th>
		<th>등록일</th>
	</tr>
	<c:if test="${fn:length(requestScope.list) <= 0 }">
		<tr>
			<td colspan="5" height="200px" style="text-align:center;">등록된 글이 없습니다.</td>
		</tr>
	</c:if>
	<c:set var="cntDisplay" value="${requestScope.pagerMap.cntDisplay }" />
	<c:forEach var="boardDto" items="${requestScope.list }">
		<tr>
			<td>
				<c:choose>
					<c:when test="${boardDto.noticeNo > 0 }">
						[공지]
					</c:when>
					<c:otherwise>
						${cntDisplay }
					</c:otherwise>
				</c:choose>
			</td>
			<td>${boardDto.writer }</td>
			<td>
				<c:forEach var="i" begin="2" end="${boardDto.stepNo }" step="1">
					&nbsp;&nbsp;
				</c:forEach>
				<a href="#" onclick="move('view','${boardDto.no }')">
				<c:if test="${boardDto.stepNo > 1 }" >[Re]:</c:if>
				<c:if test="${boardDto.secretGubun == 'T' }" >&#128274;</c:if>
				${boardDto.subject }
				</a>
			</td>
			<td>${boardDto.hit }</td>
			<td>${boardDto.regiDate }</td>
		</tr>
		<c:set var="cntDisplay" value="${cntDisplay - 1 }" />
	</c:forEach>
</table>

<div style="border: 0px solid red; width: 80%; margin-top:10px;" align="right">
|
<a href="${path }/board/list" >전체목록</a>
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
			<option value="writer" <c:if test="${requestScope.searchGubun == 'writer' }">selected</c:if>>작성자</option>
			<option value="subject" <c:if test="${requestScope.searchGubun == 'subject' }">selected</c:if>>제목</option>
			<option value="writer_subject" <c:if test="${requestScope.searchGubun == 'writer_subject' }">selected</c:if>>작성자+제목</option>
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
		let linkAddr = '${path }/board/' + value1 + '?${requestScope.searchQuery }';
		if (value2 != undefined) {
			linkAddr += '&no=' + value2;
		}//if
		location.href = linkAddr;
	}//move
	
	function search() {
		if (confirm('searchOK?')) {
			document.searchForm.action = '${path }/board/search';
			document.searchForm.method = 'post';
			document.searchForm.submit();
		}//if
	}//search
	
	function goPage(value1) {
		location.href = '${path }/board/list?pageNumber='+ value1 +'&searchGubun=${requestScope.searchGubun }&searchData=${requestScope.searchData }';
	}//goPage
</script>
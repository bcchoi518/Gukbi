<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "../include/inc_header.jsp" %>

<h2>방명록목록</h2>

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
		<th>이름</th>
		<th>이메일</th>
		<th style="width:60%;">내용</th>
		<th>등록일</th>
	</tr>
	
	<c:if test="${requestScope.totalRecord == 0 }">
		<c:choose>
			<c:when test="${requestScope.searchGubun != '' }">
				<tr>
					<td colspan="5" height="200px" style="text-align:center;">검색된 결과가 없습니다.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="5" height="200px" style="text-align:center;">등록된 회원이 없습니다.</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</c:if>
	
	<c:set var="cntDisplay" value="${requestScope.pagerMap.cntDisplay }" />
	<c:forEach var="guestBookDto" items="${requestScope.list }">
		<tr>
			<td>${cntDisplay }</td>
			<td><a href="#" onclick="move('guestBook_view.do','${guestBookDto.no }')">${guestBookDto.name }</a></td>
			<td>${guestBookDto.email }</td>
			<td>${fn:substring(guestBookDto.content, 0, 51) } <c:if test="${fn:length(guestBookDto.content) >= 50 }">...</c:if></td>
			<td>${guestBookDto.regiDate }</td>
		</tr>
		<c:set var="cntDisplay" value="${cntDisplay - 1 }" />
	</c:forEach>
</table>

<div style="border: 0px solid red; width: 80%; margin-top:10px;" align="right">
|
<a href="${requestScope.path }/guestBook_servlet/guestBook_list.do" >전체목록</a>
|
<a href="#" onclick="move('guestBook_list.do')">목록</a>
|
<a href="#" onclick="move('guestBook_chuga.do')">등록</a>
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
		let linkAddr = '${requestScope.path }/guestBook_servlet/' + value1 + '?${requestScope.searchQuery }';
		if (value2 != undefined) {
			linkAddr += '&no=' + value2;
		}//if
		location.href = linkAddr;
	}//move
	
	function search() {
		if (confirm('searchOK?')) {
			document.searchForm.action = '${requestScope.path }/guestBook_servlet/guestBook_search.do';
			document.searchForm.method = 'post';
			document.searchForm.submit();
		}//if
	}//search
	
	function goPage(value1) {
		location.href = '${requestScope.path }/guestBook_servlet/guestBook_list.do?pageNumber='+ value1 +'&searchGubun=${requestScope.searchGubun }&searchData=${requestScope.searchData }';
	}//goPage
</script>
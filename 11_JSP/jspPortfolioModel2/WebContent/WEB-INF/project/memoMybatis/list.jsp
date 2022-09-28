<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "../include/inc_header.jsp" %>
<%@ include file = "_inc_top.jsp" %>

<h2>메모목록 (Mybatis)</h2>
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
<%-- 메모 목록 Start --%>
<table border="1" style="width:80%;">
	<tr>
		<th>순번</th>
		<th>작성자</th>
		<th width="70%">내용</th>
		<th>등록일</th>
	</tr>
	<c:if test="${fn:length(requestScope.list) == 0 }">
		<c:if test="${requestScope.searchGubun == '' }">
			<tr>
				<td colspan="5" style="height:200px; text-align:center;">등록된 내용이 없습니다.</td>
			</tr>
		</c:if>
		<c:if test="${requestScope.searchGubun != '' }">
			<tr>
				<td colspan="5" style="height:200px; text-align:center;">검색된 내용이 없습니다.</td>
			</tr>
		</c:if>
	</c:if>
	<c:set var="cntDisplay" value="${requestScope.pagerMap.cntDisplay }" />
	<c:forEach var="dto" items="${requestScope.list }">
		<tr>
			<td>${cntDisplay }</td>
			<td>${dto.writer }</td>
			<td>
				<a href="#" onclick="move('memoMybatis_view.do','${dto.no }')">${fn:replace(dto.content, requestScope.newLine, '<br>') }</a>
			</td>
			<td>${dto.regiDate }</td>
		</tr>
		<c:set var="cntDisplay" value="${cntDisplay - 1 }" />
	</c:forEach>
</table>
<%-- 메모 목록 End --%>
<div style="border: 0px solid red; width: 80%; margin-top:10px;" align="right">
|
<a href="${requestScope.path }/memoMybatis_servlet/memoMybatis_list.do" >전체목록</a>
|
<a href="#" onclick="move('memoMybatis_list.do')">목록</a>
|
<a href="#" onclick="move('memoMybatis_chuga.do')">등록</a>
|
</div>
<%-- search Start --%>
<div style="width:80%; text-align:center; margin-top:20px;">
	<form name="searchForm">
		<select name="searchGubun">
			<option value="" selected>-- 선택 --</option>
			<option value="writer" <c:if test="${requestScope.searchGubun == 'writer' }">selected</c:if>>작성자</option>
			<option value="content" <c:if test="${requestScope.searchGubun == 'content' }">selected</c:if>>내용</option>
			<option value="writer_content" <c:if test="${requestScope.searchGubun == 'writer_content' }">selected</c:if>>작성자+내용</option>
		</select>
		&nbsp;
		<input type="text" name="searchData" value="${requestScope.searchData }"/>
		&nbsp;
		<button type="button" onclick="search()">검색</button>
	</form>
</div>
<%-- search End --%>

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
		let linkAddr = '${requestScope.path }/memoMybatis_servlet/' + value1 + '?${requestScope.searchQuery }';
		if (value2 != undefined) {
			linkAddr += '&no=' + value2;
		}//if
		location.href = linkAddr;
	}//move

	function search() {
		if (confirm('searchOK?')) {
			document.searchForm.action = '${requestScope.path }/memoMybatis_servlet/memoMybatis_search.do';
			document.searchForm.method = 'post';
			document.searchForm.submit();
		}//if
	}//search
	
	function goPage(value1) {
		location.href = '${requestScope.path }/memoMybatis_servlet/memoMybatis_list.do?pageNumber='+ value1 +'&searchGubun=${requestScope.searchGubun }&searchData=${requestScope.searchData }';
	}//goPage
</script>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "../_include/inc_header.jsp" %>

<%-- 메모 입력 Start --%>
<form name="DirForm">
	<input type="hidden" name="searchGubun" value="${requestScope.searchGubun }" />
	<input type="hidden" name="searchData" value="${requestScope.searchData }" />
	<input type="hidden" name="procGubun" value="chuga" />
	<input type="hidden" name="no" />
	<table border="0" style="width:80%;">
		<tr>
			<td style="width:10%; text-align:center;">작성자</td>
			<td style="width:10%;"><input type="text" name="writer"/></td>
			<td>
				<button type="button" id="btnSave" onclick="save()">등록</button>
				<button type="button" id="btnReset" onclick="resetForm()">초기화</button>
			</td>
		</tr>
		<tr>
			<td style="text-align:center;">내용</td>
			<td colspan="3"><textarea name="content" style="height:40px; width:99%;" ></textarea></td>
		</tr>
	</table>
</form>
<%-- 메모 입력 End --%>
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
<%-- 메모 목록 Start --%>
<table border="1" style="width:80%;">
	<tr>
		<th>순번</th>
		<th>작성자</th>
		<th width="70%">내용</th>
		<th>등록일</th>
		<th>비고</th>
	</tr>
	<c:if test="${fn:length(requestScope.list) == 0 }">
		<c:choose>
			<c:when test="${fn:length(requestScope.searchGubun) > 0 }">
				<tr>
					<td colspan="7" height="200px" style="text-align:center;">검색된 결과가 없습니다.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="7" height="200px" style="text-align:center;">등록된 내용이 없습니다.</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</c:if>
	<c:set var="cntDisplay" value="${requestScope.pagerMap.cntDisplay }" />
	<c:forEach var="dto" items="${requestScope.list }">
		<tr>
			<td>${cntDisplay }</td>
			<td>
				${dto.writer }
				<input type="hidden" id="writer_${dto.no }" value="${dto.writer }" />
			</td>
			<td>
				${fn:replace(dto.content, requestScope.newLine, '<br>') }
				<input type="hidden" id="content_${dto.no }" value="${dto.content }" />
			</td>
			<td>${dto.regiDate }</td>
			<td>
			<a href="#" onclick="suntaek('sujung', '${dto.no }')">수정</a>
			/
			<a href="#" onclick="suntaek('sakje', '${dto.no }')">삭제</a>
			</td>
		</tr>
		<c:set var="cntDisplay" value="${cntDisplay - 1 }" />
	</c:forEach>
</table>
<%-- 메모 목록 End --%>

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
		<button type="button" onclick="location.href='${path }/memo/list'">초기화</button>
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
	const frm = document.DirForm;
	function save() {
		if (confirm('OK?')) {
			frm.action = '${path }/memo/proc';
			frm.method = 'post';
	 		frm.submit();
		}//if
	}//save
	
	function suntaek(value1, value2) {
		frm.procGubun.value = value1;
		frm.no.value = value2;
		
		if (value1 == 'sujung') {
			frm.writer.value = document.querySelector('#writer_' + value2).value
			frm.content.value = document.querySelector('#content_' + value2).value
			document.querySelector('#btnSave').innerText = '수정';
		} else if (value1 == 'sakje') {
			if (confirm('deleteOK?')) {
				save();
				document.querySelector('#btnSave').innerText = '삭제';
			}//if
		}//if
	}//suntaek
	
	function resetForm() {
		frm.writer.value = '';
		frm.content.value = '';
		frm.procGubun.value = 'chuga';
		document.querySelector('#btnSave').innerText = '등록';
	}//formReset
	
	function search() {
		if (confirm('searchOK?')) {
			document.searchForm.action = '${path }/memo/list';
			document.searchForm.method = 'post';
			document.searchForm.submit();
		}//if
	}//search
	
	function goPage(value1) {
		location.href = '${path }/memo/list?pageNumber='+ value1 +'&searchGubun=${requestScope.searchGubun }&searchData=${requestScope.searchData }';
	}//goPage
</script>
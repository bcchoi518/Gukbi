<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="nav--wrapper">
	<h1>메뉴</h1>
	<ul>
		<li><a href="${path }">HOME</a></li>
	</ul>
	<c:if test="${sessionScope.sessionNo != null }">
	<h1>나의 정보 관리</h1>
	<ul>
		<li><a href="${path }/member/view">나의 정보 조회</a></li>
		<li><a href="${path }/member/sakje">회원 탈퇴</a></li>
	</ul>
	</c:if>
	<h1>다이어리</h1>
	<ul>
		<li><a href="${path }/diary/index?tbl=todayNote">오늘의 기록</a></li>
		<li><a href="${path }/diary/index?tbl=notepad">연습장</a></li>
	</ul>
</div>
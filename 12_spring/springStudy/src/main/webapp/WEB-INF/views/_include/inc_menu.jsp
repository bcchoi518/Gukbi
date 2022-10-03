<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div style="text-align:right;">
	<c:choose>
		<c:when test="${sessionScope.sessionNo == null }">
			<a href="${path }/member/login">로그인</a>
		</c:when>
		<c:otherwise>
			<a href="${path }/member/logout">로그아웃</a>
		</c:otherwise>
	</c:choose>
</div>


|
<a href="${path }">Home</a>
|
<a href="${path }/test01">test01</a>
|
<a href="${path }/test02">test02</a>
|
<a href="${path }/test03">test03</a>
|
<a href="${path }/test04">test04</a>
|
<a href="${path }/test05">test05</a>
|
<a href="${path }/test06">test06</a>
|
<a href="${path }/test07">test07</a>
|
<a href="${path }/test08">test08(ajax)</a>
|
<a href="${path }/test09">test09(ajax)</a>
|
<a href="${path }/test10">test10</a>
|
<br>
|
<a href="${path }/member/list">회원관리</a>
|
<a href="${path }/memo/list">메모장</a>
|
<a href="${path }/guestBook/list">방명록</a>
|
<hr>
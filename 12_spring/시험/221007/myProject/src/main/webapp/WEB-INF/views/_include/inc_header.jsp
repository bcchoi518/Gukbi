<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h1>- My Project - Last Test -</h1>

<div style="text-align:right;">
	<c:choose>
		<c:when test="${sessionScope.sessionNo == null }">
			<a href="${path }/signIn">로그인</a>
			<c:set var="imsiMemberNo" value="0" />
		</c:when>
		<c:otherwise>
			<a href="${path }/signOut">로그아웃</a>
			<c:set var="imsiMemberNo" value="${sessionScope.sessionNo }" />
		</c:otherwise>
	</c:choose>
</div>
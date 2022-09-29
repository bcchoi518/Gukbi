<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "../include/inc_header.jsp" %>

<table border="0" align="center" width="90%">
	<tr>
		<td colspan="5" style="padding: 0px 0px 10px 10px;">
<%-- 			Location : project > ${requestScope.folderName } > ${requestScope.fileName } --%>
			접속IP : ${requestScope.ip }
		</td>
		<td colspan="10" style="padding: 0px 0px 10px 10px;" align="right">
			<c:choose>
				<c:when test="${sessionScope.sessionNo > 0 }">
					${sessionScope.sessionName }님...
					<a href="${requestScope.path }/member_servlet/member_sujung.do">회원정보수정</a>
					<a href="${requestScope.path }/member_servlet/member_sakje.do">회원탈퇴</a>
					<a href="${requestScope.path }/noLogin_servlet/noLogin_logout.do">로그아웃</a>
				</c:when>
				<c:otherwise>
					<a href="${requestScope.path }/noLogin_servlet/noLogin_login.do">로그인</a>
				</c:otherwise>
			</c:choose>
		</td>
	</tr>
	<tr align="center">
		<td style="padding:0px 10px;" id="home">
			<a href="${requestScope.path }">HOME</a><br>&nbsp;
		</td>
		<td style="padding:0px 10px;" id="member">
			<a href="${requestScope.path }/member_servlet/member_list.do">회원관리</a><br>&nbsp;
		</td>
		<td style="padding:0px 10px;" id="memo">
			<a href="${requestScope.path }/memo_servlet/memo_list.do">메모장</a><br>&nbsp;
		</td>
		<td style="padding:0px 10px;" id="memoMybatis">
			<a href="${requestScope.path }/memoMybatis_servlet/memoMybatis_list.do">메모장<br>(Mybatis)</a>
		</td>
		<td style="padding:0px 10px;" id="guestBook">
			<a href="${requestScope.path }/guestBook_servlet/guestBook_list.do">방명록</a><br>&nbsp;
		</td>
		<td style="padding:0px 10px;" id="guestBookMybatis">
			<a href="${requestScope.path }/guestBookMybatis_servlet/guestBookMybatis_list.do">방명록<br>(Mybatis)</a>
		</td>
		<td style="padding:0px 10px;" id="boardChk">
			<a href="${requestScope.path }/boardChk_servlet/boardChk_list.do">게시판<br>(관리)</a>
		</td>
		<td style="padding:0px 10px;" id="board">
			<a href="${requestScope.path }/board_servlet/board_list.do">게시판<br>(자유게시판)</a>
		</td>
		<td style="padding:0px 10px;" id="board">
			<a href="${requestScope.path }/board_servlet/board_list.do">게시판<br>(Q&A게시판)</a>
		</td>
		<td style="padding:0px 10px;" id="shopProduct">
			<a href="${requestScope.path }/shopProduct_servlet/shopProduct_list.do">Mall<br>(상품관리)</a>
		</td>
		<td style="padding:0px 10px;" id="shopVendor">
			<a href="${requestScope.path }/shopVendor_servlet/shopVendor_list.do">Mall<br>(제조사)</a>
		</td>
		<td style="padding:0px 10px;" id="shopMall">
			<a href="${requestScope.path }/shopMall_servlet/shopMall_list.do">Mall<br>(쇼핑몰)</a>
		</td>
		<td style="padding:0px 10px;" id="chart">
			<a href="${requestScope.path }/chart_servlet/chart_list.do">chart</a><br>&nbsp;
		</td>
	</tr>
</table>
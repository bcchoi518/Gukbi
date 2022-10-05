<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<table border="0" align="center">
	<tr>
		<td colspan="100px" align="right" style="padding:5px 20px 10px;">
			로그인 / 로그아웃
		</td>
	</tr>
	<tr align="center">
		<td style="padding: 0px 10px;" id="index">
			<a href="${path }">HOME</a>
		</td>
		<td style="padding: 0px 10px;" id="member">
			<a href="${path }/member/list">회원관리</a>
		</td>
		<td style="padding: 0px 10px;" id="memo">
			<a href="${path }/memo/list">메모장</a>
		</td>
		<td style="padding: 0px 10px;" id="guestBook">
			<a href="${path }/guestBook/list">방명록</a>
		</td>
		<td style="padding: 0px 10px;" id="board">
			<a href="${path }/board/list">게시판</a>
		</td>
		<td style="padding: 0px 10px;" id="boardChk">
			<a href="${path }/boardChk/list">게시판관리</a>
		</td>
		<td style="padding: 0px 10px;" id="shopProduct">
			<a href="${path }/shopProduct/list">상품관리</a>
		</td>
		<td style="padding: 0px 10px;" id="shopVendor">
			<a href="${path }/shopVendor/list">제조사관리</a>
		</td>
		<td style="padding: 0px 10px;" id="shopMall">
			<a href="${path }/shopMall/list">쇼핑몰</a>
		</td>
		<td style="padding: 0px 10px;" id="chart">
			<a href="${path }/chart/list">챠트</a>
		</td>
	</tr>
</table>
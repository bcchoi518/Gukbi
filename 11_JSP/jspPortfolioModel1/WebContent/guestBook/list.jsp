<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="java.util.ArrayList"%>

<%@page import="config.Util"%>
<%@page import="guestBook.model.dto.GuestBookDTO"%>
<%@page import="guestBook.model.dao.GuestBookDAO"%>

<%
	request.setCharacterEncoding("UTF-8");
	String searchGubun = request.getParameter("searchGubun");
	String searchData = request.getParameter("searchData");
	
	Util util = new Util();
	searchGubun = util.getNullBlankCheck(searchGubun, "");
	searchData = util.getNullBlankCheck(searchData, "");
	searchData = util.getCheckString(searchData);
	
	if (searchGubun.equals("") || searchData.equals("")) {
		searchGubun = "";
		searchData = "";
	}//if
	
	GuestBookDAO guestBookDao = new GuestBookDAO();
	ArrayList<GuestBookDTO> guestBookList = guestBookDao.getSelectAll(searchGubun, searchData);
%>

<h2>방명록목록</h2>
<div style="border: 0px solid red; padding:0px; width:80%; text-align:left;">
<% if (searchGubun.equals("") || searchData.equals("")) { %>
* 전체목록 (<%=guestBookList.size() %>건)
<% } else { %>
* 검색어 "<%=searchData %>"으/로 검색된 목록 (<%=guestBookList.size() %>건)
<% }//if %>
</div>
<table border="1" width="80%" style="text-align: center;">
	<tr>
		<th>순번</th>
		<th>이름</th>
		<th>이메일</th>
		<th>방명록내용</th>
		<th>등록일</th>
		<th>실작성자</th>
	</tr>
	<%
		for (GuestBookDTO guestBookResultDto : guestBookList) {
	%>
		<tr>
			<td><%=guestBookResultDto.getNo() %></td>
			<td><a href="#" onClick="move('guestBook_view','<%=guestBookResultDto.getNo() %>')"><%=guestBookResultDto.getName() %></a></td>
			<td><%=guestBookResultDto.getEmail() %></td>
			<td style="text-align:left;"><div id="list_content"><%=guestBookResultDto.getContent() %></div></td>
			<td><%=guestBookResultDto.getRegiDate() %></td>
			<td><%=guestBookResultDto.getMemberNo() %></td>
		</tr>
	<% }//for %>
	
	<tr>
		<td colspan="5" align="center" style="padding:20px 0px">
			<form name="searchForm">
				<select name="searchGubun">
					<option value="" <% if (searchGubun.equals("")) { out.println("selected"); } %>>-- 선택 --</option>
					<option value="name" <% if (searchGubun.equals("name")) { out.println("selected"); } %>>이름</option>
					<option value="content" <% if (searchGubun.equals("content")) { out.println("selected"); } %>>내용</option>
					<option value="name_content" <% if (searchGubun.equals("name_content")) { out.println("selected"); } %>>이름+내용</option>
				</select>
				&nbsp;
				<input type="text" name="searchData" value="<%=searchData %>"/>
				&nbsp;
				<button type="button" onClick="search()">검색하기</button>
			</form>
			
			<script>
				function search() {
					document.searchForm.action = 'mainProc.jsp?menuGubun=guestBook_listSearch';
					document.searchForm.method = 'post';
					document.searchForm.submit();
				}//search
			</script>
		</td>
	</tr>
</table>
<div style="border: 0px solid red; padding-top:20px; width:80%; text-align:right;">
|
<a href="#" onClick="move('guestBook_list')">목록</a>
|
<a href="#" onClick="move('guestBook_chuga')">등록</a>
|
</div>
<form name="dataTransferForm">
	<input type="hidden" name="menuGubun" />
	<input type="hidden" name="no" />
</form>
<script>
	function move(value1, value2) {
		if (value2 != undefined) {
			document.dataTransferForm.no.value = value2;
		}//if
		document.dataTransferForm.menuGubun.value = value1;
		
		document.dataTransferForm.action = 'main.jsp';
		document.dataTransferForm.method = 'post';
		document.dataTransferForm.submit();
	}//move
</script>
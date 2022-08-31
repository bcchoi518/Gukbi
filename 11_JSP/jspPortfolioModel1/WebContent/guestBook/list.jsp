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
	
	int totalRecord = guestBookList.size();
%>

<h2>방명록목록</h2>
<div style="border: 0px solid red; padding:0px; width:80%; text-align:left;">
<% if (searchGubun.equals("") || searchData.equals("")) { %>
* 전체목록 (<%=totalRecord %>건)
<% } else { %>
* 검색어 "<%=searchData %>"으/로 검색된 목록 (<%=totalRecord %>건)
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
		if (totalRecord == 0) {
			out.println("<tr>");
			out.println("<td colspan=\"6\" height=\"100px\" style=\"text-align:center;\">저장된 정보가 없습니다.</td>");
			out.println("</tr>");
		}//if
	%>
	<%
		for (GuestBookDTO resultGuestBookDto : guestBookList) {
	%>
		<tr>
			<td><%=resultGuestBookDto.getNo() %></td>
			<td><a href="#" onClick="move('guestBook_view','<%=resultGuestBookDto.getNo() %>')"><%=resultGuestBookDto.getName() %></a></td>
			<td><%=resultGuestBookDto.getEmail() %></td>
			<td style="text-align:left;"><div id="list_content"><%=resultGuestBookDto.getContent() %></div></td>
			<td><%=resultGuestBookDto.getRegiDate() %></td>
			<td><%=resultGuestBookDto.getMemberNo() %></td>
		</tr>
	<% }//for %>
</table>

<div style="border: 0px solid red; padding-top:20px; width:80%; text-align:right;">
|
<a href="#" onClick="move('guestBook_list')">목록</a>
|
<a href="#" onClick="move('guestBook_chuga')">등록</a>
|
</div>

<!-- search start -->
<div style="border: 0px solid red; width:80%;">
	<form name="searchForm" style="padding:0px;">
		<div style="margin:0px; padding:0px; display:flex; justify-content: center;">
			<select name="searchGubun" style="border:0px; padding:0px 10px; height:30px; border-radius:10px 0px 0px 10px;">
				<option value="">-- 선택 --</option>
				<option value="name" <% if (searchGubun.equals("name")) { out.println("selected"); } %>>이름</option>
				<option value="content" <% if (searchGubun.equals("content")) { out.println("selected"); } %>>내용</option>
				<option value="name_content" <% if (searchGubun.equals("name_content")) { out.println("selected"); } %>>이름+내용</option>
			</select>
			<input type="text" name="searchData" value="<%=searchData %>" style="border:0px; margin:0px; padding:0px; height:30px; width:200px;"/>
			<button type="button" onclick="search()" style="border:0px; border-radius:0px 10px 10px 0px; margin:0px; padding:0px 10px; height:30px; font-size:1rem;">검색</button>
		</div>
	</form>
</div>
<!-- search end -->

<form name="dataTransferForm">
	<input type="hidden" name="menuGubun" />
	<input type="hidden" name="no" />
</form>
<script>
	function search() {
		document.searchForm.action = 'mainProc.jsp?menuGubun=guestBook_listSearch';
		document.searchForm.method = 'post';
		document.searchForm.submit();
	}//search
	
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
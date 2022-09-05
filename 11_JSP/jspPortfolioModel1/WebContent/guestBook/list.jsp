<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.ArrayList"%>

<%@ page import="config.Util"%>
<%@ page import="guestBook.model.dto.GuestBookDTO"%>
<%@ page import="guestBook.model.dao.GuestBookDAO"%>

<%@ include file = "_inc_top.jsp" %>
<%@ include file = "_inc_script.jsp" %>

<%
//search start
	String searchValue = "O";
	String searchGubun = request.getParameter("searchGubun");
	String searchData = request.getParameter("searchData");
	
	Util util = new Util();
	searchGubun = util.getNullBlankCheck(searchGubun, "");
	searchData = util.getNullBlankCheck(searchData, "");
	searchData = util.getCheckString(searchData);
	
	if (searchGubun.equals("") || searchData.equals("")) {
		searchValue = "X";
		searchGubun = "";
		searchData = "";
	}//if
//search end
	GuestBookDAO guestBookDao = new GuestBookDAO();
//pager start
	String pageNumber_ = request.getParameter("pageNumber"); 
	pageNumber_ = util.getNullBlankCheck(pageNumber_, "1");
	
	int pageNumber = Integer.parseInt(pageNumber_);
	
	int totalRecord = guestBookDao.getTotalRecord(searchGubun, searchData);
	int pageSize = 5; // 한페이지에 나타낼 레코드 갯수
	int blockSize = 10;

	int block = (pageNumber - 1) / blockSize;
	int jj = totalRecord - pageSize * (pageNumber - 1); //단순히 화면에 보여주는 일련번호
	double totalPageDou = Math.ceil(totalRecord / (double)pageSize);
	int totalPage = (int)totalPageDou;
	
	int startRecord = pageSize * (pageNumber - 1) + 1;
	int lastRecord = pageSize * pageNumber;
//pager end	
	ArrayList<GuestBookDTO> guestBookList = guestBookDao.getSelectAll(searchGubun, searchData, startRecord, lastRecord);
%>

<h2>방명록 목록</h2>
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

<!-- pager start -->
<div style="border: 0px solid red; padding:10px 0px; width:80%;" align="center">
<%
	int totalBlock = totalPage / blockSize;
	double value1 = (double)totalBlock;
	double value2 = totalPage / blockSize;
	if (value1 - value2 == 0) {
		totalBlock = totalBlock - 1;
	}//if
%>
	<button class="pageBtn" onclick="goPage('<%=menuGubun %>','1','<%=searchGubun %>','<%=searchData %>')">&lt;&lt;</button>
<%
	if (block > 0) {
		int imsiPage = (block - 1) * blockSize + 1;
%>
		<button class="pageBtn" onclick="goPage('<%=menuGubun %>','<%=imsiPage %>','<%=searchGubun %>','<%=searchData %>')">&lt;</button>
<% 
	} else {
%>
	<button class="pageBtn" >&lt;</button>
<%
	}//if
%>
<%
	for (int goPage=1; goPage <= blockSize; goPage++) {
		int imsiValue = block * blockSize + goPage;
		if (totalPage - imsiValue >= 0) {
			if (imsiValue == pageNumber) {
%>
				<button class="pageBtn <% if (pageNumber == imsiValue) { out.println("selected"); } %>" ><%=imsiValue %></button>
<%
			} else {
%>
				<button class="pageBtn" onclick="goPage('<%=menuGubun %>','<%=imsiValue %>','<%=searchGubun %>','<%=searchData %>')"><%=imsiValue %></button>
<%
			}//if
		}//if
	}//for
%>
<%
	if (block - totalBlock <= 0) {
		int yyy = (block + 1) * blockSize + 1;
		//int zzz = block + 1;
%>
		<button class="pageBtn" onclick="goPage('<%=menuGubun %>','<%=yyy %>','<%=searchGubun %>','<%=searchData %>')" >&gt;</button>
<%
	} else {
%>
		<button class="pageBtn" >&gt;</button>
<%		
	}//if
%>
<button class="pageBtn" onclick="goPage('<%=menuGubun %>','<%=totalPage %>','<%=searchGubun %>','<%=searchData %>')" >&gt;&gt;</button>
</div>
<!-- pager end -->
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
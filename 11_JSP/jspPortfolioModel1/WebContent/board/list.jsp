<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "_inc_top.jsp" %>
<%@ include file = "_inc_script.jsp" %>

<%
	String pageNumber_ = request.getParameter("pageNumber"); 
	String searchValue = "O";
	String searchGubun = request.getParameter("searchGubun");
	String searchData = request.getParameter("searchData");
	
	Util util = new Util();
	pageNumber_ = util.getNullBlankCheck(pageNumber_, "1");
	searchGubun = util.getNullBlankCheck(searchGubun, "");
	searchData = util.getNullBlankCheck(searchData, "");
	searchData = util.getCheckString(searchData);
	
	int pageNumber = Integer.parseInt(pageNumber_);
	
	if (searchGubun.equals("") || searchData.equals("")) {
		searchValue = "X";
		searchGubun = "";
		searchData = "";
	}//if
	
	int totalRecord = boardDao.getTotalRecord(searchGubun, searchData);
	int pageSize = 10; // 한페이지에 나타낼 레코드 갯수
	int blockSize = 10;
	
	int block = (pageNumber - 1) / pageSize;
	int jj = totalRecord - pageSize * (pageNumber - 1); //단순히 화면에 보여주는 일련번호
	
	double totalPageDou = Math.ceil(totalRecord / (double)pageSize);
	int totalPage = (int)totalPageDou;
	
	int startRecord = pageSize * (pageNumber - 1) + 1;
	int lastRecord = pageSize * pageNumber;

	ArrayList<BoardDTO> boardList = boardDao.getSelectAll(searchGubun, searchData, startRecord, lastRecord);
%>

<h2>게시글 목록</h2>
<div style="border:0px solid red; width:80%; padding:5px 0px; text-align:left;">
<% if (searchValue.equals("O")) { %>
	검색어 "<%=searchData %>" (으)로 검색된 목록 : <%=totalRecord %>건
<% } else { %>
	전체 목록 : <%=totalRecord %>건
<% }//if %>
</div>
<table border="1" width="80%">
	<tr>
		<th>순번</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일</th>
		<th>조회수</th>
		<th>refNo</th>
		<th>stepNo</th>
		<th>levelNo</th>
		<th>parentNo</th>
		<th>noticeNo</th>
		<th>memberNo</th>
		<th>ip</th>
		<th>공지글</th>
		<th>비밀글</th>
	</tr>
	
	<% 
		for (int i = 0; i < boardList.size(); i++) {
			resultBoardDto = boardList.get(i);
	%>
			<tr>
				<td>
					<% 
						if (resultBoardDto.getNoticeNo() > 0) {
							out.println("[공지]"); 
						} else {
							out.println(jj--); 
							out.println(resultBoardDto.getNo()); 
						}//if
					%>
				</td>
				<td>
					<%
						String blankValue = "";
						for (int j = 2; j <= resultBoardDto.getStepNo(); j++) {
							blankValue += "&nbsp;&nbsp;";
						}//for
						
						String imsiSubject = "";
						if (resultBoardDto.getStepNo() >= 2) {
							imsiSubject += "[Re]:";
						}//if
						
						if (resultBoardDto.getSecretGubun().equals("T")) {
							imsiSubject += "&#128274;";
						}//if
						
						imsiSubject += resultBoardDto.getSubject();
						
						if (imsiSubject.length() > 15) {
							imsiSubject = imsiSubject.substring(0, 15) + "...";
						}//if

					%>
					<%=blankValue %><a href="#" onclick="move('board_view','<%=resultBoardDto.getNo() %>','<%=searchGubun %>','<%=searchData %>')"><%=imsiSubject %></a>
				</td>
				<td><%=resultBoardDto.getWriter() %></td>
				<td><%=resultBoardDto.getRegiDate() %></td>
				<td><%=resultBoardDto.getHit() %></td>
				<td><%=resultBoardDto.getRefNo() %></td>
				<td><%=resultBoardDto.getStepNo() %></td>
				<td><%=resultBoardDto.getLevelNo() %></td>
				<td><%=resultBoardDto.getParentNo() %></td>
				<td><%=resultBoardDto.getNoticeNo() %></td>
				<td><%=resultBoardDto.getMemberNo() %></td>
				<td><%=resultBoardDto.getIp() %></td>
				<td><%=resultBoardDto.getNoticeNo() %></td>
				<td><%=resultBoardDto.getSecretGubun() %></td>
			</tr>
	<% }//if %>
</table>
	
<div style="border: 0px solid red; padding-top:20px; width:80%; text-align:right;">
|
<a href="#" onClick="move('board_list','','<%=searchGubun %>','<%=searchData %>')">목록</a>
|
<a href="#" onClick="move('board_chuga','','<%=searchGubun %>','<%=searchData %>')">등록</a>
|
</div>

<div>
	<button class="pageBtn">&lt;&lt;</button>
	<button class="pageBtn">&lt;</button>

		<button class="pageBtn selected" onclick="pageSelect()">1</button>
	<%	
		for (int i = 2; i <= totalPage; i++) {
	%>
			<button class="pageBtn" onclick="pageSelect()"><%=i %></button>
	<% }//for %>
	<button class="pageBtn">&gt;</button>
	<button class="pageBtn">&gt;&gt;</button>
</div>

<div style="border: 0px solid red; padding-top:20px; width:80%;">
	<form name="searchForm" style="padding:0px;">
		<div style="margin:0px; padding:0px; display:flex; justify-content: center;">
			<select name="searchGubun" style="border:0px; padding:0px 10px; height:30px; border-radius:10px 0px 0px 10px;">
				<option value="">-- 선택 --</option>
				<option value="writer" <% if (searchGubun.equals("writer")) { out.println("selected"); } %>>작성자</option>
				<option value="subject" <% if (searchGubun.equals("subject")) { out.println("selected"); } %>>제목</option>
				<option value="content" <% if (searchGubun.equals("content")) { out.println("selected"); } %>>내용</option>
				<option value="writer_subject_content" <% if (searchGubun.equals("writer_subject_content")) { out.println("selected"); } %>>작성자+제목+내용</option>
			</select>
			<input type="text" name="searchData" value="<%=searchData %>" style="border:0px; margin:0px; padding:0px; height:30px; width:200px;"/>
			<button type="button" onclick="search()" style="border:0px; border-radius:0px 10px 10px 0px; margin:0px; padding:0px 10px; height:30px; font-size:1rem;">검색</button>
		</div>
	</form>
</div>

<script>
	$('.pageBtn').click(function () {
		
	});
	
	function search() {
		document.searchForm.action = 'main.jsp?menuGubun=board_listSearch';
		document.searchForm.method = 'post';
		document.searchForm.submit();
	}//search
	
	function pageSelect() {
		
	}//pageSelect
</script>
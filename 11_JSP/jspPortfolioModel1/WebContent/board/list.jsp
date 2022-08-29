<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "_inc_top.jsp" %>

<%
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
	
	ArrayList<BoardDTO> boardList = boardDao.getSelectAll(searchGubun, searchData);
%>

<h2>게시글 목록</h2>
<div style="border: 0px solid red; width:80%; text-align:left;">
<% if (searchGubun.equals("")) { %>
* 전체 조회 결과 (<%=boardList.size() %>건)
<% } else { %>
* 검색어 "<%=searchData %>" 으/로 검색한 결과 (<%=boardList.size() %>건)
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
				<td><%=resultBoardDto.getNo() %></td>
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
						
						if (resultBoardDto.getNoticeNo() > 0) {
							imsiSubject += "[공지]";
						}//if
						
						imsiSubject += resultBoardDto.getSubject();
						
						if (imsiSubject.length() > 15) {
							imsiSubject = imsiSubject.substring(0, 15) + "...";
						}//if

					%>
					<%=blankValue %><a href="#" onclick="move('board_view','<%=resultBoardDto.getNo() %>')"><%=imsiSubject %></a>
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
<a href="#" onClick="move('board_list')">목록</a>
|
<a href="#" onClick="move('board_chuga')">등록</a>
|
</div>

<div style="border: 0px solid red; padding-top:20px; width:80%;">
<form name="searchForm" style="padding:0px;">
	<div style="margin:0px; padding:0px; display:flex; justify-content: center;">
		<select name="searchGubun" style="border:0px; padding:0px 10px; height:30px; border-radius:10px 0px 0px 10px;">
			<option value="">-- 선택 --</option>
			<option value="writer">작성자</option>
			<option value="subject">제목</option>
			<option value="content">내용</option>
			<option value="subject_content">제목+내용</option>
		</select>
		<input type="text" name="searchData" style="border:0px; margin:0px; padding:0px; height:30px; width:200px;"/>
		<button type="button" onclick="search()" style="border:0px; border-radius:0px 10px 10px 0px; margin:0px; padding:0px 10px; height:30px; font-size:1rem;">검색</button>
	</div>
</form>
</div>

<script>
	function move(value1, value2) {
		let linkAddr = 'main.jsp?menuGubun='+ value1;
		if (value2 != undefined) {
			linkAddr += '&no=' + value2;
		}//if
		location.href = linkAddr;
	}//move
	
	function search() {
		document.searchForm.action = 'main.jsp?menuGubun=board_list';
		document.searchForm.method = 'post';
		document.searchForm.submit();
	}//search
</script>
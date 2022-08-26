<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "_inc_top.jsp" %>

<%@page import="java.util.ArrayList"%>

<%@page import="config.Util"%>
<%@page import="boardBasic.model.dto.BoardBasicDTO"%>
<%@page import="boardBasic.model.dao.BoardBasicDAO"%>

<%
	request.setCharacterEncoding("UTF-8");
// 	String searchGubun = request.getParameter("searchGubun");
// 	String searchData = request.getParameter("searchData");
	
// 	Util util = new Util();
// 	searchGubun = util.getNullBlankCheck(searchGubun, "");
// 	searchData = util.getNullBlankCheck(searchData, "");
// 	searchData = util.getCheckString(searchData);
	
// 	if (searchGubun.equals("") || searchData.equals("")) {
// 		searchGubun = "";
// 		searchData = "";
// 	}//if

	BoardBasicDAO boardBasicDao = new BoardBasicDAO();
	ArrayList<BoardBasicDTO> boardBasicList = boardBasicDao.getSelectAll();
	
	int totalRecord = boardBasicList.size();
%>

<h2>게시글목록</h2>
<div style="border: 0px solid red; padding:0px; width:80%; text-align:left;">
<%-- <% if (searchGubun.equals("") || searchData.equals("")) { %> --%>
* 전체목록 (<%=totalRecord %>건)
<%-- <% } else { %> --%>
<%-- * 검색어 "<%=searchData %>"으/로 검색된 목록 (<%=totalRecord %>건) --%>
<%-- <% }//if %> --%>
</div>
<table border="1" width="80%" style="text-align: center;">
	<tr>
		<th>순번</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일</th>
		<th>조회수</th>
		<th>실작성자</th>
		<th>IP</th>
		<th>부모No</th>
	</tr>
	<%
		if (totalRecord == 0) {
			out.println("<tr>");
			out.println("<td colspan=\"5\" height=\"100px\" style=\"text-align:center;\">저장된 정보가 없습니다.</td>");
			out.println("</tr>");
		}//if
	%>
	<%
		for (BoardBasicDTO resultBoardBasicDto : boardBasicList) {
	%>
		<tr>
			<td><%=resultBoardBasicDto.getNo() %></td>
			<% 
				String reply = "";
				String subject = resultBoardBasicDto.getSubject();
				if (subject.length() > 5) {
						subject = subject.substring(0, 6) + "...";
				}//if
				
				for (int i = 1; i < resultBoardBasicDto.getStepNo(); i++) {
					reply += "&nbsp;&nbsp;&nbsp;";
					if (i == resultBoardBasicDto.getStepNo() - 1) {
						reply += "[RE]:";
					}//if
				}//for
			%>
			<td style="text-align:left">
				<% if (sessionChk.equals("O")) { %>
					<a href="#" onClick="move('boardBasic_view','<%=resultBoardBasicDto.getNo() %>')"><%=reply %><%=subject %></a>
				<% } else { %>
					<%=reply %><%=subject %>
				<% }//if %>
			</td>
			<td><%=resultBoardBasicDto.getWriter() %></td>
			<td><%=resultBoardBasicDto.getRegiDate() %></td>
			<td><%=resultBoardBasicDto.getHit() %></td>
			<td>
			<%=resultBoardBasicDto.getMemberNo() %>
			<% 
				if (resultBoardBasicDto.getMemberNo() > 0) {
					out.println("(회원)");
				} else {
					out.println("(비회원)");
				}//if
			%>
			</td>
			<td><%=resultBoardBasicDto.getIp() %></td>
			<td><%=resultBoardBasicDto.getParentNo() %></td>
		</tr>
	<% }//for %>
<%-- 	
	<tr>
		<td colspan="6" align="center" style="padding:20px 0px">
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
					document.searchForm.action = 'mainProc.jsp?menuGubun=boardBasic_listSearch';
					document.searchForm.method = 'post';
					document.searchForm.submit();
				}//search
			</script>
		</td>
	</tr>
--%>
</table>
<div style="border: 0px solid red; padding-top:20px; width:80%; text-align:right;">
|
<a href="#" onClick="move('boardBasic_list')">목록</a>
|
<% if (sessionChk.equals("O")) { %>
<a href="#" onClick="move('boardBasic_chuga')">등록</a>
|
<% }//if %>
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
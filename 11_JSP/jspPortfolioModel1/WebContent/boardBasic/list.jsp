<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "_inc_top.jsp" %>

<%@page import="java.util.ArrayList"%>

<%@page import="config.Util"%>
<%@page import="boardBasic.model.dto.BoardBasicDTO"%>
<%@page import="boardBasic.model.dao.BoardBasicDAO"%>

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

	BoardBasicDAO boardBasicDao = new BoardBasicDAO();
	ArrayList<BoardBasicDTO> boardBasicList = boardBasicDao.getSelectAll();
	
	int totalRecord = boardBasicList.size();
%>

<h2>게시글목록</h2>
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
			out.println("<td colspan=\"8\" height=\"100px\" style=\"text-align:center;\">저장된 정보가 없습니다.</td>");
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

<!-- search start -->
<div style="border: 0px solid red; width:80%;">
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
<!-- search end -->

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
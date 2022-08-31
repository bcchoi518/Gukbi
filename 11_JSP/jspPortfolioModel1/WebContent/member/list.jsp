<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "_inc_top.jsp" %>
 
<%@ page import="java.util.ArrayList"%>

<%@ page import="config.Util"%>
<%@ page import="member.model.dto.MemberDTO"%>
<%@ page import="member.model.dao.MemberDAO"%>

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

	MemberDAO memberDao = new MemberDAO();
	ArrayList<MemberDTO> memberList = memberDao.getSelectAll(searchGubun, searchData);
	
	int totalRecord = memberList.size();
%>

<h2>회원목록</h2>
<div style="border: 0px solid red; padding:0px; width:80%; text-align:left;">
<% if (searchGubun.equals("") || searchData.equals("")) { %>
* 전체목록 (<%=totalRecord %>건)
<% } else { %>
* 검색어 <%=searchData %>으/로 검색된 결과 (<%=totalRecord %>건)
<% }//if %>
</div>
<table border="1" width="80%" style="text-align: center;">
	<tr>
		<th>순번</th>
		<th>사진</th>
		<th>아이디</th>
		<th>이름</th>
		<th>연락처</th>
		<th>주민번호</th>
		<th>등급</th>
		<th>등록일</th>
	</tr>
	<%
		if (totalRecord == 0) {
			out.println("<tr>");
			out.println("<td colspan=\"8\" height=\"100px\" style=\"text-align:center;\">저장된 정보가 없습니다.</td>");
			out.println("</tr>");
		}//if
	%>
	<%
		for (MemberDTO memberResultDto : memberList) {
	%>
		<tr>
			<td><%=memberResultDto.getNo() %></td>
			<td>
				<%
					if (memberResultDto.getAttachInfo() == null || memberResultDto.getAttachInfo().equals("-")) {
						out.println("&nbsp;");
					} else {
						String[] imsiArray = memberResultDto.getAttachInfo().split(",");
						for (int j = 0; j < imsiArray.length; j++) {
							String[] imsiArray2 = imsiArray[j].split("[|]");
							
							String imsiImgPath = "";
							imsiImgPath += request.getContextPath();
							imsiImgPath += "/attach";
							imsiImgPath += request.getContextPath();
							imsiImgPath += "/member/";
							imsiImgPath += imsiArray2[1];
							
							out.println("<img src=\""+ imsiImgPath + "\" width=\"50\" height=\"50\"><br>"+ imsiArray2[0] + "("+ imsiArray2[3] +") <br>");
						}//for
					}//if
				%>
			</td>
			<td><a href="#" onClick="move('member_view','<%=memberResultDto.getNo() %>')"><%=memberResultDto.getId() %></a></td>
			<td><%=memberResultDto.getName() %></td>
			<td><%=memberResultDto.getPhone() %></td>
			<td><%=memberResultDto.getJumin().substring(0, 8) %>******</td>
			<td><%=memberResultDto.getGrade() %></td>
			<td><%=memberResultDto.getRegiDate() %></td>
		</tr>
	<% }//for %>
</table>

<div style="border: 0px solid red; padding-top:20px; width:80%; text-align:right;">
|
<a href="#" onClick="move('member_list')">목록</a>
|
<a href="#" onClick="move('member_chuga')">등록</a>
|
<a href="#" onClick="move('member_attachChuga')">등록(attach)</a>
|
</div>

<!-- search start -->
<div style="border: 0px solid red; width:80%;">
	<form name="searchForm" style="padding:0px;">
		<div style="margin:0px; padding:0px; display:flex; justify-content: center;">
			<select name="searchGubun" style="border:0px; padding:0px 10px; height:30px; border-radius:10px 0px 0px 10px;">
				<option value="">-- 선택 --</option>
				<option value="id" <% if (searchGubun.equals("id")) { out.println("selected"); } %>>아이디</option>
				<option value="name" <% if (searchGubun.equals("name")) { out.println("selected"); } %>>이름</option>
				<option value="phone" <% if (searchGubun.equals("phone")) { out.println("selected"); } %>>연락처</option>
				<option value="jumin" <% if (searchGubun.equals("jumin")) { out.println("selected"); } %>>주민번호</option>
				<option value="id_name_phone_jumin" <% if (searchGubun.equals("id_name_phone_jumin")) { out.println("selected"); } %>>아이디+이름+연락처+주민번호</option>
			</select>
			<input type="text" name="searchData" value="<%=searchData %>" style="border:0px; margin:0px; padding:0px; height:30px; width:200px;"/>
			<button type="button" onclick="search()" style="border:0px; border-radius:0px 10px 10px 0px; margin:0px; padding:0px 10px; height:30px; font-size:1rem;">검색</button>
		</div>
	</form>
</div>
<!-- search end -->
<script>
	function search() {
		document.searchForm.action = 'mainProc.jsp?menuGubun=member_listSearch';
		document.searchForm.method = 'post';
		document.searchForm.submit();
	}//search
	
	function move(value1, value2) {
		if (value2 != undefined) {
			location.href = 'main.jsp?menuGubun=' + value1 + "&no=" + value2;
		} else {
			location.href = 'main.jsp?menuGubun=' + value1;
		}//if
	}//move
</script>
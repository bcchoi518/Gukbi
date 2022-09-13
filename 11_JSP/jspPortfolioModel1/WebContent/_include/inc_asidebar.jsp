<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "../_include/inc_header.jsp" %>
<%@ include file = "../_include/inc_sessionChk.jsp" %>

<aside class="asidebar">
  <ul class="aside_portfolio_menu">
    <li id="dashBoard"><a href="<%=path %>">Summary</a></li>
    <li id="member"><a href="<%=path %>/main/main.jsp?menuGubun=member_list">회원관리</a></li>
    <li id="memo"><a href="<%=path %>/main/main.jsp?menuGubun=memo_list">메모장</a></li>
    <li id="guestBook"><a href="<%=path %>/main/main.jsp?menuGubun=guestBook_list">방명록</a></li>
    <li id="boardBasic"><a href="<%=path %>/main/main.jsp?menuGubun=boardBasic_list">게시판(B)</a></li>
    <li id="shopProduct"><a href="<%=path %>/main/main.jsp?menuGubun=shopProduct_list">몰(product)</a></li>
    <li id="shopVendor"><a href="<%=path %>/main/main.jsp?menuGubun=shopVendor_list">몰(vendor)</a></li>
    <li id="shopMall"><a href="<%=path %>/main/main.jsp?menuGubun=shopMall_list">몰(Mall)</a></li>
    <li id="shopCart"><a href="<%=path %>/main/main.jsp?menuGubun=shopCart_list">몰(Cart)</a></li>
    <li id="chart"><a href="<%=path %>/main/main.jsp?menuGubun=chart_list">챠트</a></li>
    <li id="freeboard"><a href="<%=path %>/main/main.jsp?menuGubun=board_list&tbl=freeboard">자유게시판</a></li>
    <li id="onebyone"><a href="<%=path %>/main/main.jsp?menuGubun=board_list&tbl=onebyone">1:1게시판</a></li>
    <li id="qna"><a href="<%=path %>/main/main.jsp?menuGubun=board_list&tbl=qna">Q&A게시판</a></li>
    <li id="boardChk"><a href="<%=path %>/main/main.jsp?menuGubun=boardChk_list">게시판(M)</a></li>
  </ul>
</aside>
<script>
	function menuSelecter() {
	<%
		String imsiFolderName = folderName;
		if (folderName.equals("board")) {
			String tbl = request.getParameter("tbl");
			imsiFolderName = tbl;
		}//if
	%>
		$('#<%=imsiFolderName %>').css({'text-decoration':'underline','text-underline-offset':'7px', 'text-decoration-color':'#005b88', 'text-decoration-thickness':'3px'});
	}//applyBgColor
	menuSelecter();
</script>
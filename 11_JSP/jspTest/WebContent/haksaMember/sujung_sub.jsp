<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="java.util.ArrayList"%>

<%@page import="haksaMember.model.dao.HaksaMemberDAO"%>
<%@page import="haksaMember.model.dto.HaksaMemberDTO"%>

<%
	String arg1_ = request.getParameter("arg1");
	int arg1 = Integer.parseInt(arg1_);
	
	HaksaMemberDTO memberArguDto = new HaksaMemberDTO();
	memberArguDto.setHakbun(arg1);
	
	HaksaMemberDAO memberDao = new HaksaMemberDAO();
	HaksaMemberDTO memberResultDto = memberDao.getSelectOne(memberArguDto);
%>

<h2>학생수정</h2>

<form name="DirForm">
	<input type="hidden" name="arg1" value="<%=memberResultDto.getHakbun() %>" />
	<table border="1" width="80%">
		<tr>
			<th>이름</th>
			<td><%=memberResultDto.getName() %></td>
		</tr>
		<tr>
			<th>연락처</th>
			<td><input type="text" name="phone" value="<%=memberResultDto.getPhone() %>"/></td>	
		</tr>
		<tr>
			<th>부모님연락처</th>
			<td><input type="text" name="parentPhone" value="<%=memberResultDto.getParentPhone() %>"/></td>	
		</tr>
		<tr>
		<th rowspan="3">주소</th>
			<td>
				<input type="text" name="addr1" id="sample6_postcode" value="<%=memberResultDto.getAddr1() %>" placeholder="우편번호" readonly>
				<button type="button" onclick="sample6_execDaumPostcode()">우편번호 찾기</button>
		<tr>
			<td>
				<input type="text" name="addr2" id="sample6_address" value="<%=memberResultDto.getAddr2() %>" placeholder="주소" readonly>
			</td>
		</tr>
		<tr>
			<td>
				<input type="text" name="addr3" id="sample6_detailAddress" value="<%=memberResultDto.getAddr3() %>" placeholder="상세주소">
				<input type="text" name="addr4" id="sample6_extraAddress" value="<%=memberResultDto.getAddr4() %>" placeholder="참고항목" readonly>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<button type="button" onClick="submitForm()">수정하기</button>
				<button type="button" onClick="location.href='list.jsp';">목록으로</button>
			</td>
		</tr>
	</table>
</form>
<script>
	function submitForm() {
		document.DirForm.action = "sujungProc.jsp";
		document.DirForm.method = "post";
		document.DirForm.submit();
	}//submitForm
</script>
<jsp:include page="_inc_daumApi.jsp"></jsp:include>
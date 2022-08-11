<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="memberBasic.MemberBasicDAO"%>
<%@ page import="memberBasic.MemberBasicDTO"%>

<%
	request.setCharacterEncoding("UTF-8");
	String no_ = request.getParameter("no");

	int failCounter = 0;
	if (no_ == null || no_.trim().equals("")) {
		failCounter++;
	}//if
	
	int no = 0;
	try {
		no = Integer.parseInt(no_);
	} catch (Exception e) {
// 		e.printStackTrace();
		no = 0;
		failCounter++;
	}//try-catch
	
	if (failCounter > 0) {
		out.println("<script>");
		out.println("alert('정상적인 접속이 아닙니다.');");
		out.println("location.href='list.jsp';");
		out.println("</script>");
		return;
	}//if
	
	MemberBasicDAO dao = new MemberBasicDAO();
	MemberBasicDTO arguDto = new MemberBasicDTO();
	arguDto.setNo(no);
	MemberBasicDTO resultDto = dao.getSelectOne(arguDto);
%>

	<h2>회원수정</h2>
	<form name="sujungForm">
		<input type="hidden" name="no" value="<%=no %>"/>
		<table border="1" width="70%">
			<tr>
				<th>아이디</th>
				<td><%=resultDto.getId() %></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="passwd" /></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><%=resultDto.getName() %></td>
			</tr>
			<tr>
				<th>연락처</th>
				<td><input type="text" name="phone" value="<%=resultDto.getPhone() %>"/></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="text" name="email" value="<%=resultDto.getEmail() %>"/></td>
			</tr>
			<tr>
				<th>주민번호</th>
				<td><%=resultDto.getJumin().substring(0, 7)%>******</td>
			</tr>
			<tr>
				<th>현재주소</th>
				<td>(<%=resultDto.getJuso1() %>) <%=resultDto.getJuso2() %> <%=resultDto.getJuso3() %> <%=resultDto.getJuso4() %></td>
			</tr>
			<tr>
				<th rowspan="3">주소</th>
				<td>
					<input type="text" name="juso1" id="sample6_postcode" placeholder="우편번호" readonly>
					<button type="button" onclick="sample6_execDaumPostcode()">우편번호 찾기</button>
			<tr>
				<td>
					<input type="text" name="juso2" id="sample6_address" placeholder="주소" readonly>
				</td>
			</tr>
			<tr>
				<td>
					<input type="text" name="juso3" id="sample6_detailAddress" placeholder="상세주소">
					<input type="text" name="juso4" id="sample6_extraAddress" placeholder="참고항목" readonly>
				</td>
			</tr>
			<tr>
				<td colspan="2"><button type="button" onClick="sujung()">수정하기</button></td>
			</tr>
		</table>
		<input type="hidden" name="post1" value="<%=resultDto.getJuso1() %>" />
		<input type="hidden" name="post2" value="<%=resultDto.getJuso2() %>" />
		<input type="hidden" name="post3" value="<%=resultDto.getJuso3() %>" />
		<input type="hidden" name="post4" value="<%=resultDto.getJuso4() %>" />
	</form>
		<script>
		function sujung() {
			if (document.sujungForm.juso1.value != '' && document.sujungForm.juso3.value != '') {
				document.sujungForm.post1.value = document.sujungForm.juso1.value;
				document.sujungForm.post2.value = document.sujungForm.juso2.value;
				document.sujungForm.post3.value = document.sujungForm.juso3.value;
				document.sujungForm.post4.value = document.sujungForm.juso4.value;
			}//if
			
			if (confirm('수정하시겠습니까?')) {
				document.sujungForm.action = 'sujungProc.jsp';
				document.sujungForm.method = 'post';
				document.sujungForm.submit();
			}//if
		}//sujung
	</script>
	<jsp:include page="_inc_daumApi.jsp"></jsp:include>
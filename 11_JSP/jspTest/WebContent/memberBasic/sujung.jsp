<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="memberBasic.MemberBasicDAO"%>
<%@ page import="memberBasic.MemberBasicDTO"%>

<%
	request.setCharacterEncoding("UTF-8");
	String arg1 = request.getParameter("arg1");
	
	MemberBasicDAO dao = new MemberBasicDAO();
	MemberBasicDTO dto = new MemberBasicDTO();
	dto.setId(arg1);
	dto = dao.getSelectOne(dto);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" width="80%" align="center">
		<tr>
			<td height="100px" align="center">
				<jsp:include page="../include/inc_menu.jsp"></jsp:include>
			</td>
		</tr>
		<tr>
			<td height="300px" align="center">
<!-- 본문 내용 시작 -->
				<h2>회원수정</h2>
				<form name="sujungForm">
					<input type="hidden" name="arg1" value="<%=arg1 %>"/>
					<table border="1">
						<tr>
							<th>아이디</th>
							<td><%=dto.getId() %></td>
						</tr>
						<tr>
							<th>비밀번호</th>
							<td><input type="password" name="passwd" /></td>
						</tr>
						<tr>
							<th>이름</th>
							<td><%=dto.getName() %></td>
						</tr>
						<tr>
							<th>연락처</th>
							<td><input type="text" name="phone" value="<%=dto.getPhone() %>"/></td>
						</tr>
						<tr>
							<th>이메일</th>
							<td><input type="text" name="email" value="<%=dto.getEmail() %>"/></td>
						</tr>
						<tr>
							<th>주민번호</th>
							<td>
								<input type="text" name="jumin1" value="<%=dto.getJumin().substring(0, 6)%>" style="width:60px"/> 
								-
								<input type="text" name="jumin2" value="<%=dto.getJumin().substring(6)%>" style="width:60px"/>
							</td>
						</tr>
						<tr>
							<th rowspan="3">주소</th>
							<td>
								<input type="text" name="juso1" id="sample6_postcode" value="<%=dto.getJuso1() %>" placeholder="우편번호">
								<button type="button" onclick="sample6_execDaumPostcode()">우편번호 찾기</button>
						<tr>
							<td>
								<input type="text" name="juso2" id="sample6_address" value="<%=dto.getJuso2() %>" placeholder="주소">
							</td>
						</tr>
						<tr>
							<td>
								<input type="text" name="juso3" id="sample6_detailAddress" value="<%=dto.getJuso3() %>" placeholder="상세주소">
								<input type="text" name="juso4" id="sample6_extraAddress" value="<%=dto.getJuso4() %>" placeholder="참고항목">
							</td>
						</tr>
						<tr>
							<td colspan="2"><button type="button" onClick="sujung()">수정하기</button></td>
						</tr>
					</table>
				</form>
<!-- 본문 내용 끝 -->
			</td>
		<tr>
			<td height="100px" align="center">
				<jsp:include page="../include/inc_bottom.jsp"></jsp:include>
			</td>
		</tr>
	</table>
	<script>
		function sujung() {
			if (confirm('저장하시겠습니까?')) {
				document.sujungForm.action = 'sujungProc.jsp';
				document.sujungForm.method = 'post';
				document.sujungForm.submit();
			}//if
		}//sujung
	</script>
	
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script>
	    function sample6_execDaumPostcode() {
	        new daum.Postcode({
	            oncomplete: function(data) {
	                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
	
	                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
	                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
	                var addr = ''; // 주소 변수
	                var extraAddr = ''; // 참고항목 변수
	
	                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
	                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
	                    addr = data.roadAddress;
	                } else { // 사용자가 지번 주소를 선택했을 경우(J)
	                    addr = data.jibunAddress;
	                }
	
	                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
	                if(data.userSelectedType === 'R'){
	                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
	                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
	                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
	                        extraAddr += data.bname;
	                    }
	                    // 건물명이 있고, 공동주택일 경우 추가한다.
	                    if(data.buildingName !== '' && data.apartment === 'Y'){
	                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	                    }
	                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
	                    if(extraAddr !== ''){
	                        extraAddr = ' (' + extraAddr + ')';
	                    }
	                    // 조합된 참고항목을 해당 필드에 넣는다.
	                    document.getElementById("sample6_extraAddress").value = extraAddr;
	                
	                } else {
	                    document.getElementById("sample6_extraAddress").value = '';
	                }
	
	                // 우편번호와 주소 정보를 해당 필드에 넣는다.
	                document.getElementById('sample6_postcode').value = data.zonecode;
	                document.getElementById("sample6_address").value = addr;
	                // 커서를 상세주소 필드로 이동한다.
	                document.getElementById("sample6_detailAddress").focus();
	            }
	        }).open();
	    }
	</script>
</body>
</html>
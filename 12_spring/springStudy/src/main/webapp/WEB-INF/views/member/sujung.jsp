<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "../_include/inc_header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@ include file = "../_include/inc_menu.jsp" %>
	
	<h2>${requestScope.title }</h2>
	
	<form name="DirForm">
		<input type="hidden" name="no" value="${requestScope.dto.no }" />
		<table border="1" width="80%">
			<tr>
				<td width="150px">아이디</td>
				<td>${requestScope.dto.id }</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="passwd" id="passwd" value="" /></td>
			</tr>
			<tr>
				<td>이름</td>
				<td>${requestScope.dto.name }</td>
			</tr>
			<tr>
				<td>연락처</td>
				<td><input type="text" name="phone" value="${requestScope.dto.phone }"/></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="email" value="${requestScope.dto.email }"/></td>
			</tr>
			<tr>
				<td>주민번호</td>
				<td>${fn:substring(dto.jumin, 0, 7) }-${fn:substring(dto.jumin, 7, 8) }******</td>
			</tr>
			<tr>
				<td rowspan="3">주소</td>
				<td>
					<input type="text" name="juso1" id="sample6_postcode" placeholder="우편번호" value="${requestScope.dto.juso1 }" readonly>
					<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기">
				</td>
			</tr>
			<tr>
				<td>
					<input type="text" name="juso2" id="sample6_address" placeholder="주소" value="${requestScope.dto.juso2 }" readonly>
				</td>
			</tr>
			<tr>
				<td>
					<input type="text" name="juso3" id="sample6_detailAddress" value="${requestScope.dto.juso3 }" placeholder="상세주소">
					<input type="text" name="juso4" id="sample6_extraAddress" value="${requestScope.dto.juso4 }" placeholder="참고항목" readonly>
				</td>
			</tr>
			<tr>
				<td>등급</td>
				<td>
					<input type="radio" name="grade" value="최우수회원" <c:if test="${requestScope.dto.grade == '최우수회원' }">checked</c:if>/> 최우수회원 &nbsp;
					<input type="radio" name="grade" value="우수회원" <c:if test="${requestScope.dto.grade == '우수회원' }">checked</c:if>/> 우수회원 &nbsp;
					<input type="radio" name="grade" value="일반회원" <c:if test="${requestScope.dto.grade == '일반회원' }">checked</c:if>/> 일반회원 &nbsp;
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center" style="height:50px">
					<button type="button" onclick="save()">수정</button>
				</td>
			</tr>
		</table>
	</form>
	
	<script>
		function save() {
			if (confirm('수정하시겠습니까?')) {
				document.DirForm.action = '${path }/member/sujungProc';
				document.DirForm.method = 'post';
				document.DirForm.submit();
			}//if
		}//save
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
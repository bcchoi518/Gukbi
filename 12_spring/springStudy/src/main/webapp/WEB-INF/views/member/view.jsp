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
	
	<table border="1" width="80%">
		<tr>
			<td>아이디</td>
			<td>${requestScope.dto.id }</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>${requestScope.dto.name }</td>
		</tr>
		<tr>
			<td>연락처</td>
			<td>${requestScope.dto.phone }</td>
		</tr>
		<tr>
			<td>이메일</td>
			<td>${requestScope.dto.email }</td>
		</tr>
		<tr>
			<td>주민번호</td>
			<td>${fn:substring(dto.jumin, 0, 7) }-${fn:substring(dto.jumin, 7, 8) }******</td>
		</tr>
		<tr>
			<td>주소</td>
			<td>
				(${requestScope.dto.juso1 })
				${requestScope.dto.juso2 }
				${requestScope.dto.juso3 }
				<c:if test="${requestScope.dto.juso4 != '-' }">
					${requestScope.dto.juso4 }
				</c:if>
			</td>
		</tr>
		<tr>
			<td>등급</td>
			<td>${requestScope.dto.grade }</td>
		</tr>
		<tr>
			<td>등록일</td>
			<td>${requestScope.dto.regiDate }</td>
		</tr>
		<tr>
			<td>첨부파일</td>
			<td>
				<c:set var="fileInfoArray" value="${fn:split(requestScope.dto.attachInfo, '|') }" />
				<c:forEach var="i" begin="0" end="${fn:length(fileInfoArray) - 1 }" step="1">
					<c:choose>
						<c:when test="${dto.attachInfo == '-' }">
							&nbsp;
						</c:when>
						<c:otherwise>
							<c:set var="fileInfo" value="${fn:split(fileInfoArray[i], ',') }" />
							<c:set var="fileOriginName" value="${fileInfo[0] }" />
							<c:set var="fileName" value="${fileInfo[1] }" />
							<a href="#" onclick="attachDownLoad('${requestScope.dto.no }','${i }')">
								<img alt="${fileOriginName }" title="${fileOriginName }" src="${path }/attach${path }/member/${fileName }" />
							</a>
						</c:otherwise>
					</c:choose>
					<hr>
				</c:forEach>
			</td>
		</tr>
	</table>
	
	<div style="border: 0px solid red; width: 80%; margin-top:10px;" align="right">
	|
	<a href="${path }/member/list" >전체목록</a>
	|
	<a href="#" onclick="move('list')">목록</a>
	|
	<a href="#" onclick="move('chuga')">등록</a>
	|
	<a href="#" onclick="move('sujung','${requestScope.dto.no }')">수정</a>
	|
	<a href="#" onclick="move('sakje','${requestScope.dto.no }')">삭제</a>
	|
	</div>
	
	<script>
		function move(value1, value2) {
			let linkAddr = '${path }/member/' + value1;
			if (value2 != undefined) {
				linkAddr += '?no='+ value2;
			}//if
			location.href = linkAddr;
		}//move
		
		function attachDownLoad(value1, value2) {
			location.href = '${path }/member/download?no='+ value1 + "&num="+ value2;
		}//download
	</script>
	
</body>
</html>
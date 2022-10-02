<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "../../_include/inc_header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src = "http://code.jquery.com/jquery-3.4.1.min.js" ></script>
</head>
<body>

	<%@ include file = "../../_include/inc_menu.jsp" %>
	
	<h2>${requestScope.title }</h2>
	
	<form name="imsiForm">
		<input type="hidden" name="fileInfo" />
	</form>
	
	<c:set var="k" value="${k = 0 }" />
	<c:forEach var="item" items="${requestScope.list }">
		<c:set var="gubun" value="${fn:split(item, '^')[0] }"></c:set>
		<c:set var="fileName" value="${fn:split(item, '^')[1] }"></c:set>
		<input type="hidden" name="box_${k }" id="box_${k }" value="${fileName }" /><br>
		<a href="#" onclick="sakje('box_${k }')">[삭제]</a> &nbsp; : &nbsp; (${gubun }) ${fileName }<hr>
		<c:set var="k" value="${k = k + 1 }" />
	</c:forEach>
	<c:if test="${empty list }" >
		파일이 있었는데요 없었습니다.
	</c:if>
	
	<script>
		function sakje(value1) {
			//DOM
			const formTag = document.imsiForm;
			if (confirm('delete OK?')) {
				const info = document.getElementById(value1).value;
				formTag.fileInfo.value = info;
				
				formTag.action = '${path }/test10Proc';
				formTag.method = 'post';
				formTag.submit();
			}//if
		}//sakje
	</script>
	
</body>
</html>
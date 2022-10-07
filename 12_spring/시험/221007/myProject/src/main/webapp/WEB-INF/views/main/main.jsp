<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "../_include/inc_top.jsp" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src = "http://code.jquery.com/jquery-3.3.1.min.js" /></script>
<style type="text/css">
	* {
		margin: 0px;
		padding: 0px;
	}
	html, body {
		magin: 0 auto;
		padding: 20px;
		width: 90%;
	}
	header {
		margin: 30px;
		text-align: center;
	}
	section {
		display: flex;
	}
	footer {
		margin-top: 30px;
	}	
	nav {
		flex: 2;
	}
	article {
		flex: 8;
	}
	h1, h2 {
		text-align: center;
		margin: 20px;
	}
	table {
		margin: 0 auto;
		width: 80%;
		border-collapse: collapse;
	}
	td {
		min-width: 50px;
	}
	input[type="text"] {
		width: 100%;
		height:100%;
		border: none;
	}
	button {
		margin: 0px 1px;
		padding: 2px;
	}
	li {
		list-style: none;
		text-align: center;
		margin: 5px;
	}
	#searchData {
		border: 1px solid gray;
	}
	#sample6_postcode {
		width: 100px;
	}
	#sample6_detailAddress {
		width: 200px;
	}
	#sample6_extraAddress {
		width: 100px;
	}
</style>
</head>
<body>

	<header>
		<%@ include file = "../_include/inc_header.jsp" %>
	</header>
	
	<section>
		<nav>
			<%@ include file = "../_include/inc_nav.jsp" %>
		</nav>
		
		<article>
			<jsp:include page="../${requestScope.folderName }/${requestScope.fileName }.jsp"></jsp:include>
		</article>
	</section>
	
	<footer>
		<jsp:include page="../_include/inc_footer.jsp"></jsp:include>
	</footer>
</body>
</html>
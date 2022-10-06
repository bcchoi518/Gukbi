<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CBC 도서관</title>
<style>
	* {
		margin: 0px;
		padding: 0px;
	}
	header {
		margin: 30px;
		text-align: center;
	}
	h1, h2 {
		text-align: center;
		margin: 20px;
	}
	table {
		margin: 0 auto;
		width: 70%;
		border-collapse: collapse;
		border: none;
	}
	td {
		height: 30px;
	}
	input {
		border: none;
	}
	input[type="text"] {
		width: 100%;
		height: 100%;
	}
	button {
		margin: 0px 1px;
		padding: 2px;
	}
</style>
</head>
<body>
	<header><h1>도서 관리 프로그램</h1></header>
	<jsp:include page="../${requestScope.folderName }/${requestScope.fileName }.jsp"></jsp:include>
</body>
</html>
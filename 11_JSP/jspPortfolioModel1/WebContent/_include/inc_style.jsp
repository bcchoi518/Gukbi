<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<style>
	body {
		background-color: #c7f9cc;
	}
	table {
		border-collapse: collapse;
		background-color: #80ed99;
		width: 80%;
	}
	a {
		text-decoration: none;
	}
	td {
		padding: 10px;
		min-width: 30px;
		max-width: 400px;
	}
	#list_content {
		overflow: hidden;
		white-space: nowrap;
		text-overflow: ellipsis; 
	}
	.entryName {
		text-align: right;
	}
	:focus {
		outline: none;
	}
	.pageBtn {
	 	width:30px;
	 	height:30px;
	 	border: 1px solid #57cc99;
	 	border-radius: 50%;
	 	background-color:#80ed99;
	}
	.pageBtn:hover {
		border: 1px solid red;
	}
	.selected {
		background-color: #57cc99;
	}
	select {
		background-color: white;
	}
</style>
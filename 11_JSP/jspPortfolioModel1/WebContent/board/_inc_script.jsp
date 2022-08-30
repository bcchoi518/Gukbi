<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script>
	function move(value1, value2, value3, value4) {
		let linkAddr = 'main.jsp?menuGubun='+ value1;
		if (value2 != undefined) {
			linkAddr += '&no=' + value2;
		}//if
		if (value3 != undefined) {
			linkAddr += '&searchGubun=' + value3;
		}//if
		if (value4 != undefined) {
			linkAddr += '&searchData=' + value4;
		}//if
		location.href = linkAddr;
	}//move
</script>
function check() {
	
}//end check

function move(value1, value2) {
	let url = '../main/main.jsp?menuGubun=' + value1
	if (value2 != null) {
		url += '&arg1=' + value2;		
	}//end if
	location.href = url;		
}//end move
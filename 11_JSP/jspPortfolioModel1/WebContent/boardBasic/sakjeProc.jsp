<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "_inc_top.jsp" %>    

<%@ page import="boardBasic.model.dao.BoardBasicDAO"%>
<%@ page import="boardBasic.model.dto.BoardBasicDTO"%>

<%
	request.setCharacterEncoding("UTF-8");

	String no_ = request.getParameter("no");
	String passwd = request.getParameter("passwd");
	
	int no = Integer.parseInt(no_);
	
	BoardBasicDTO arguBoardBasicDto = new BoardBasicDTO();
	arguBoardBasicDto.setNo(no);
	arguBoardBasicDto.setPasswd(passwd);
	
	BoardBasicDAO boardBasicDao = new BoardBasicDAO();
	
	BoardBasicDTO returnBoardBasicDto = boardBasicDao.getSelectOne(arguBoardBasicDto);
	if (!passwd.equals(returnBoardBasicDto.getPasswd())) {
		out.println("<script>");
		out.println("alert('입력한 비밀번호가 다릅니다.');");
		out.println("location.href='main.jsp?menuGubun=boardBasic_sakje&no="+ no +"';");
		out.println("</script>");
		return;
	}//if
	
	
	
	int result = boardBasicDao.setDelete(arguBoardBasicDto);
	
	String imsiMsg = "삭제 중 오류가 발생했습니다.";
	String imsiUrl = "main.jsp?menuGubun=boardBasic_sakje&no=" + no;
	if (result > 0) {
		imsiMsg = "삭제 성공..";
		imsiUrl = "main.jsp?menuGubun=boardBasic_list";
	}//if
	
	out.println("<script>");
	if (result <= 0) {
		out.println("alert('"+ imsiMsg +"');");
	}//if
	out.println("location.href='"+ imsiUrl +"';");
	out.println("</script>");
%>
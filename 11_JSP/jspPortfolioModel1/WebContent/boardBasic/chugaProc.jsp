<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "_inc_top.jsp" %>
    
<%@ page import="config.Util"%>
<%@ page import="boardBasic.model.dao.BoardBasicDAO"%>
<%@ page import="boardBasic.model.dto.BoardBasicDTO"%>

<%
	request.setCharacterEncoding("UTF-8");
	
	String no_ = request.getParameter("no");
	String writer = request.getParameter("writer");
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");
	String email = request.getParameter("email");
	String passwd = request.getParameter("passwd");
	
	Util util = new Util();
	no_ = util.getNullBlankCheck(no_, "0");
	int no = Integer.parseInt(no_);
	int num = 0;
	int hit = 0;
	int memberNo = sessionNo;
	
	writer = util.getNullBlankCheck(writer, "-");
	writer = util.getCheckString(writer);
	subject = util.getNullBlankCheck(subject, "-");
	subject = util.getCheckString(subject);
	email = util.getNullBlankCheck(email, "-");
	email = util.getCheckString(email);
	content = util.getNullBlankCheck(content, "-");
	content = util.getCheckString(content);
	passwd = util.getNullBlankCheck(passwd, "-");
	passwd = util.getCheckString(passwd);

	BoardBasicDAO boardBasicDao = new BoardBasicDAO();
	//새글일때
	//refNo: refNo의 최대값 + 1
	//stepNo: 1
	//levelNo: 1
	int refNo = boardBasicDao.getMaxRefNo() + 1;
	int stepNo = 1;
	int levelNo = 1;
	int parentNo = 0;
	
	BoardBasicDTO arguBoardBasicDto = new BoardBasicDTO();
	arguBoardBasicDto.setNo(no);
	
	if (no > 0) {//답글일때
		BoardBasicDTO returnDto = boardBasicDao.getSelectOne(arguBoardBasicDto);
		//refNo: 부모글의 refNo
		refNo = returnDto.getRefNo();
		//stepNo: 부모글의 stepNo + 1
		stepNo = returnDto.getStepNo() + 1;
		//levelNo: refNo가 같은 부모글 중에서 levelNo보다 큰 값들은 1씩 증가시키고 levelNo + 1
		boardBasicDao.setUpdateReLevel(returnDto);
		levelNo = returnDto.getLevelNo() + 1;
		parentNo = no;
	}//if
	
	num = boardBasicDao.getMaxNum() + 1;
	
	arguBoardBasicDto.setNum(num);
	arguBoardBasicDto.setWriter(writer);
	arguBoardBasicDto.setSubject(subject);
	arguBoardBasicDto.setContent(content);
	arguBoardBasicDto.setEmail(email);
	arguBoardBasicDto.setPasswd(passwd);
	arguBoardBasicDto.setRefNo(refNo);
	arguBoardBasicDto.setStepNo(stepNo);
	arguBoardBasicDto.setLevelNo(levelNo);
	arguBoardBasicDto.setHit(hit);
	arguBoardBasicDto.setMemberNo(memberNo);
	arguBoardBasicDto.setIp(ip);
	arguBoardBasicDto.setParentNo(parentNo);
	
	int result = boardBasicDao.setInsert(arguBoardBasicDto);
	
	if (result > 0) {
		out.println("<script>");
		out.println("location.href='main.jsp?menuGubun=boardBasic_list';");
		out.println("</script>");
	} else {
		out.println("<script>");
		out.println("alert('등록 중 오류가 발생했습니다.');");
		out.println("location.href='main.jsp?menuGubun=boardBasic_chuga';");
		out.println("</script>");
	}//if
%>
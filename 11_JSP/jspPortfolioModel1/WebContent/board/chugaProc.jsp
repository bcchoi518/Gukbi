<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "_inc_top.jsp" %>

<%
	request.setCharacterEncoding("UTF-8");

	String writer = request.getParameter("writer");
	String email = request.getParameter("email");
	String passwd = request.getParameter("passwd");
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");
	String noticeGubun = request.getParameter("noticeGubun");
	String secretGubun = request.getParameter("secretGubun");
	
	int failCounter = 0;
	writer = util.getNullBlankCheck(writer, "");
	writer = util.getCheckString(writer);
	if (writer.length() <= 0) { failCounter++; }//if
	
	email = util.getNullBlankCheck(email, "");
	email = util.getCheckString(email);
	if (email.length() <= 0) { failCounter++; }//if
	
	passwd = util.getNullBlankCheck(passwd, "");
	passwd = util.getCheckString(passwd);
	if (passwd.length() <= 0) { failCounter++; }//if
	
	subject = util.getNullBlankCheck(subject, "");
	subject = util.getCheckString(subject);
	if (subject.length() <= 0) { failCounter++; }//if

	content = util.getNullBlankCheck(content, "");
	content = util.getCheckString(content);
	if (content.length() <= 0) { failCounter++; }//if
	
	noticeGubun = util.getNullBlankCheck(noticeGubun, "");
	if (!(noticeGubun.equals("T") || noticeGubun.equals("F"))) { failCounter++; }

	secretGubun = util.getNullBlankCheck(secretGubun, "");
	if (!(secretGubun.equals("T") || secretGubun.equals("F"))) { failCounter++; }

	//공지글은 비밀글로 작성불가
	if (noticeGubun.equals("T") && secretGubun.equals("T")) { failCounter++; }
	
	if (failCounter > 0) {
		out.println("<script>");
		out.println("alert('입력한 값이 정확하지않습니다.');");
		out.println("location.href='main.jsp?menuGubun=board_chuga';");
		out.println("</script>");
		return;
	}//if
	
	int num = boardDao.getMaxValue("num") + 1;
	String tbl = "-";
	
	//새글..
	int refNo = boardDao.getMaxValue("refNo") + 1;
	int stepNo = 1;
	int levelNo = 1;
	int parentNo = 0;
	
	if (resultBoardDto.getNo() > 0) {//답변..
		refNo = resultBoardDto.getRefNo();
		stepNo = resultBoardDto.getStepNo() + 1;
		boardDao.setUpdateReLevel(resultBoardDto);
		levelNo = resultBoardDto.getLevelNo() + 1;
		parentNo = resultBoardDto.getNo();
	}//if
	
	int hit = 0;
	//String ip = "";
	int memberNo = sessionNo;
	
	int noticeNo = 0;
	if (noticeGubun.trim().equals("T")) {//공지글이면..
		noticeNo = boardDao.getMaxValue("noticeNo") + 1;
	}//if

	String attachInfo = "-";

	arguBoardDto.setNum(num);
	arguBoardDto.setTbl(tbl);
	arguBoardDto.setWriter(writer);
	arguBoardDto.setSubject(subject);
	arguBoardDto.setContent(content);
	arguBoardDto.setEmail(email);
	arguBoardDto.setPasswd(passwd);
	arguBoardDto.setRefNo(refNo);
	arguBoardDto.setStepNo(stepNo);
	arguBoardDto.setLevelNo(levelNo);
	arguBoardDto.setParentNo(parentNo);
	arguBoardDto.setHit(hit);
	arguBoardDto.setIp(ip);
	arguBoardDto.setMemberNo(memberNo);
	arguBoardDto.setNoticeNo(noticeNo);
	arguBoardDto.setSecretGubun(secretGubun);
	arguBoardDto.setAttachInfo(attachInfo);

	int result = boardDao.setInsert(arguBoardDto);
	
	String ment = "";
	String addr = "";
	if (result > 0) {
		ment = "";
		addr = "main.jsp?menuGubun=board_list";
	} else {
		ment = "등록 중 오류가 발생했습니다.";
		addr = "main.jsp?menuGubun=board_chuga";
	}//if
	
	out.println("<script>");
	if (result > 0) {
		
	} else {
		out.println("alert('"+ ment +"');");
	}//if
	out.println("location.href='"+ addr +"';");
	out.println("</script>");
%>
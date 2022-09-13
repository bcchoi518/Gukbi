<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "_inc_top.jsp" %>

<%
	String email = request.getParameter("email");
	String passwd = request.getParameter("passwd");
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");
	String noticeNo_ = request.getParameter("noticeNo");
	String noticeGubun = request.getParameter("noticeGubun");
	String secretGubun = request.getParameter("secretGubun");
	
	int failCounter = 0;
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

	noticeNo_ = util.getNullBlankCheck(noticeNo_, "");
	if (noticeNo_.length() <= 0) { failCounter++; }//if
	int boxNoticeNo = Integer.parseInt(noticeNo_);

	noticeGubun = util.getNullBlankCheck(noticeGubun, "");
	if (!(noticeGubun.equals("T") || noticeGubun.equals("F"))) { failCounter++; }

	secretGubun = util.getNullBlankCheck(secretGubun, "");
	if (!(secretGubun.equals("T") || secretGubun.equals("F"))) { failCounter++; }

	//공지글은 비밀글로 작성불가
	if (noticeGubun.equals("T") && secretGubun.equals("T")) { failCounter++; }
	
	if (!resultBoardDto.getPasswd().equals(passwd)) { failCounter++; }
	
	if (failCounter > 0) {
		out.println("<script>");
		out.println("alert('입력한 값이 정확하지않습니다.');");
		out.println("location.href='main.jsp?menuGubun=board_list&tbl="+ tbl +"&searchGubun=" + searchGubun + "&searchData=" + searchData + "';");
		out.println("</script>");
		return;
	}//if
	
	int memberNo = sessionNo;
	
	int noticeNo = 0;
	if (noticeGubun.equals("T")) {
		if (boxNoticeNo > 0) {//기존 글이 공지글..
			noticeNo = resultBoardDto.getNoticeNo();
		} else {
			noticeNo = boardDao.getMaxValue("noticeNo") + 1;
		}//if
	}//if
	
	String attachInfo = resultBoardDto.getAttachInfo();
	
	arguBoardDto.setNo(resultBoardDto.getNo());
	arguBoardDto.setTbl(tbl);
	arguBoardDto.setSubject(subject);
	arguBoardDto.setContent(content);
	arguBoardDto.setEmail(email);
	arguBoardDto.setPasswd(passwd);
	arguBoardDto.setMemberNo(memberNo);
	arguBoardDto.setNoticeNo(noticeNo);
	arguBoardDto.setSecretGubun(secretGubun);
	arguBoardDto.setAttachInfo(attachInfo);
	
	int result = boardDao.setUpdate(arguBoardDto);
	
	imsiQueryString += "&no="+ resultBoardDto.getNo() + "&pageNumber="+ pageNumber;
	String resultPage = "board_view";
	out.println("<script>");
	if (result <= 0) {
		out.println("alert('수정 처리 중 오류가 발생했습니다.');");
		resultPage = "board_sujung";
	}//if
	out.println("location.href = 'main.jsp?menuGubun=" + resultPage + "&"+ imsiQueryString +"';");
	out.println("</script>");
%>
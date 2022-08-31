<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "_inc_top.jsp" %>
   
<%@ page import="member.model.dao.MemberDAO"%>
<%@ page import="member.model.dto.MemberDTO"%>

<%
	request.setCharacterEncoding("UTF-8");

	String no_ = request.getParameter("no");
	String passwd = request.getParameter("passwd");
// 	String attachInfo = request.getParameter("attachInfo");
	
	int no = Integer.parseInt(no_);
	
	MemberDTO memberArguDto = new MemberDTO();
	memberArguDto.setNo(no);
	memberArguDto.setPasswd(passwd);
	
	MemberDTO imsiDto = new MemberDTO();
	imsiDto.setNo(no);
	
	MemberDAO memberDao = new MemberDAO();
	MemberDTO resultDto = memberDao.getSelectOne(imsiDto);
	String attachInfo = resultDto.getAttachInfo();
	
	int result = memberDao.setDelete(memberArguDto);
	
	String imsiMsg = "삭제 중 오류가 발생했습니다.";
	String imsiUrl = "main.jsp?menuGubun=member_sakje&no=" + no;
	if (result > 0) {
		imsiMsg = "삭제 성공..";
		imsiUrl = "main.jsp?menuGubun=member_list";
		
		if (!attachInfo.equals("-")) {
			//파일 삭제 처리..
			String attachPath = "C:/cbc/attach";
			String uploadPath = attachPath + request.getContextPath() + "/member";
			
			String[] imsiArray01 = attachInfo.split(",");
			for (int i = 0; i < imsiArray01.length; i++) {
				String[] imsiArray02 = imsiArray01[i].split("[|]");
				String uploadFile = uploadPath + "/" + imsiArray02[1];
				java.io.File f = new java.io.File(uploadFile);
				if (f.delete()) {
					//파일 삭제 성공..
				} else {
					//파일 삭제 실패..
				}//if
			}//for
		}//if
	}//if
	
	out.println("<script>");
	if (result <= 0) {
		out.println("alert('"+ imsiMsg +"');");
	}//if
	out.println("location.href='"+ imsiUrl +"';");
	out.println("</script>");
%>
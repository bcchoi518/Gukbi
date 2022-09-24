package project.member.controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.common.Util;
import project.member.model.dao.MemberDAO;
import project.member.model.dto.MemberDTO;

@WebServlet("/member_servlet/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProc(request, response);
	}//doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProc(request, response);
	}//doPost
	
	protected void doProc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		Util util = new Util();
		
//serverInfo Start
		String[] serverInfo = util.getServerInfo(request);
		String referer = serverInfo[0];
		String path = serverInfo[1];
		String url = serverInfo[2];
		String uri = serverInfo[3];
		String ip = serverInfo[4];
		String ip6 = serverInfo[5];
		String folderName = serverInfo[6];
		String fileName = serverInfo[7];
		
		request.setAttribute("referer", referer);
		request.setAttribute("path", path);
		request.setAttribute("ip", ip);
		request.setAttribute("folderName", folderName);
		request.setAttribute("fileName", fileName);
//serverInfo Start		
//pagerStart
		String pageNumber_ = request.getParameter("pageNumber");
		int pageNumber = util.getNumberCheck(pageNumber_, 1);
		request.setAttribute("pageNumber", pageNumber);
//pagerEnd
//searchStart
		String searchGubun = request.getParameter("searchGubun");
		String searchData = request.getParameter("searchData");
		String imsiSearchYN = "O";
		
		searchGubun = util.getNullBlankCheck(searchGubun);
		searchData = util.getNullBlankCheck(searchData);
		
		if (searchGubun.equals("") || searchData.equals("")) {
			imsiSearchYN = "X";
			searchGubun = "";
			searchData = "";
		}//if
		
		//임의로 주소줄에 적어서 넘어온 값은 인코딩되어 있으므로 디코딩해야 함
		searchGubun = URLDecoder.decode(searchGubun, "UTF-8"); //import java.net.URLDecoder
		searchData = URLDecoder.decode(searchData, "UTF-8"); //import java.net.URLDecoder
		
		String searchQuery = "pageNumber="+ pageNumber +"&searchGubun=&searchData=";
		if (imsiSearchYN.equals("O")) {
			String imsiSearchGubun = URLEncoder.encode(searchGubun, "UTF-8");
			String imsiSearchData = URLEncoder.encode(searchData, "UTF-8");
			searchQuery = "pageNumber="+ pageNumber +"&searchGubun="+ imsiSearchGubun +"&searchData="+ imsiSearchData;
		}//if
		
		request.setAttribute("searchGubun", searchGubun);
		request.setAttribute("searchData", searchData);
		request.setAttribute("searchQuery", searchQuery);
//searchEnd
		
		String forwardPage = "/WEB-INF/project/main/main.jsp";
		
		if (fileName.equals("list")) {
			searchGubun = util.getCheckString(searchGubun);
			searchData = util.getCheckString(searchData);
			
			MemberDTO arguMemberDto = new MemberDTO();
			arguMemberDto.setSearchGubun(searchGubun);
			arguMemberDto.setSearchData(searchData);
			
			MemberDAO memberDao = new MemberDAO();
			
//pagerStart
			int pageSize = 3;
			int blockSize = 10;
			int totalRecord = memberDao.getTotalRecord(arguMemberDto);
			request.setAttribute("totalRecord", totalRecord);
			
			Map<String, Integer> pagerMap = util.getPagerMap(pageNumber, pageSize, blockSize, totalRecord);
			pagerMap.put("blockSize", blockSize);
			
			arguMemberDto.setStartRecord(pagerMap.get("startRecord"));
			arguMemberDto.setLastRecord(pagerMap.get("lastRecord"));
//pagerEnd
			
			ArrayList<MemberDTO> memberList = memberDao.getSelectAll(arguMemberDto);
			
			request.setAttribute("pagerMap", pagerMap);
			request.setAttribute("list", memberList);
			
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (fileName.equals("view")) {
			String no_ = request.getParameter("no");
			int no = util.getNumberCheck(no_, 0);
			
			if (no == 0) {
				System.out.println("no: " + no);
				return;
			}//if
			
			MemberDTO arguMemberDto = new MemberDTO();
			arguMemberDto.setNo(no);
			arguMemberDto.setSearchGubun(searchGubun);
			arguMemberDto.setSearchData(searchData);
			
			MemberDAO memberDao = new MemberDAO();
			MemberDTO returnMemberDto = memberDao.getSelectOne(arguMemberDto);
			
			if (returnMemberDto.getNo() == 0) {
				System.out.println("no: " + returnMemberDto.getNo());
				return;
			}//if
			
			request.setAttribute("dto", returnMemberDto);
			
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (fileName.equals("chuga")) {
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (fileName.equals("sujung")) {
			String no_ = request.getParameter("no");
			int no = util.getNumberCheck(no_, 0);
			
			if (no <= 0) {
				System.out.println("no: " + no);
				return;
			}//if
			
			MemberDTO arguMemberDto = new MemberDTO();
			arguMemberDto.setNo(no);
			arguMemberDto.setSearchGubun(searchGubun);
			arguMemberDto.setSearchData(searchData);
			
			MemberDAO memberDao = new MemberDAO();
			MemberDTO returnMemberDto = memberDao.getSelectOne(arguMemberDto);
			
			if (returnMemberDto.getNo() <= 0) {
				System.out.println("no: " + returnMemberDto.getNo());
				return;
			}//if
			
			request.setAttribute("dto", returnMemberDto);
			
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (fileName.equals("sakje")) {
			String no_ = request.getParameter("no");
			int no = util.getNumberCheck(no_, 0);
			
			if (no == 0) {
				System.out.println("no: " + no);
				return;
			}//if
			
			MemberDTO arguMemberDto = new MemberDTO();
			arguMemberDto.setNo(no);
			arguMemberDto.setSearchGubun(searchGubun);
			arguMemberDto.setSearchData(searchData);
			
			MemberDAO memberDao = new MemberDAO();
			MemberDTO returnMemberDto = memberDao.getSelectOne(arguMemberDto);
			
			if (returnMemberDto.getNo() <= 0) {
				System.out.println("no: " + returnMemberDto.getNo());
				return;
			}//if
			
			request.setAttribute("dto", returnMemberDto);
			
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
		
			
		} else if (fileName.equals("search")) {
			String moveUrl = "";
			moveUrl += path + "/member_servlet/member_list.do?" + searchQuery;
			
			response.sendRedirect(moveUrl);

		} else if (fileName.equals("chugaProc")) {
			System.out.println("referer: " + referer);
			String id = request.getParameter("id");
			String passwd = request.getParameter("passwd");
			String passwdChk = request.getParameter("passwdChk");
			String name = request.getParameter("name");
			String jumin1 = request.getParameter("jumin1");
			String jumin2 = request.getParameter("jumin2");
			String phone1 = request.getParameter("phone1");
			String phone2 = request.getParameter("phone2");
			String phone3 = request.getParameter("phone3");
			String email1 = request.getParameter("email1");
			String email2 = request.getParameter("email2");
			String postcode = request.getParameter("postcode");
			String address = request.getParameter("address");
			String detailAddress = request.getParameter("detailAddress");
			String extraAddress = request.getParameter("extraAddress");
			
			id = util.getNullBlankCheck(id);
			passwd = util.getNullBlankCheck(passwd);
			passwdChk = util.getNullBlankCheck(passwdChk);
			name = util.getNullBlankCheck(name);
			jumin1 = util.getNullBlankCheck(jumin1);
			jumin2 = util.getNullBlankCheck(jumin2);
			phone1 = util.getNullBlankCheck(phone1);
			phone2 = util.getNullBlankCheck(phone2);
			phone3 = util.getNullBlankCheck(phone3);
			email1 = util.getNullBlankCheck(email1);
			email2 = util.getNullBlankCheck(email2);
			postcode = util.getNullBlankCheck(postcode);
			address = util.getNullBlankCheck(address);
			detailAddress = util.getNullBlankCheck(detailAddress);
			extraAddress = util.getNullBlankCheck(extraAddress);
			
			int failCounter = 0;
			if (id.equals("") || id.trim().length() > 10) {
				failCounter++;
			} else if (passwd.equals("") || !passwd.equals(passwdChk)) {
				failCounter++;
			} else if (name.equals("") || name.trim().length() > 15) {
				failCounter++;
			} else if (jumin1.equals("") || jumin1.trim().length() != 6 || util.getNumberCheck(jumin1, 0) <= 0) {
				failCounter++;
			} else if (jumin2.equals("") || jumin2.trim().length() != 1 || util.getNumberCheck(jumin2, 0) <= 0) {
				failCounter++;
			} else if (phone1.equals("") || !(phone1.equals("010") || phone2.equals("011") || phone3.equals("016"))) {
				failCounter++;
			} else if (phone2.equals("") || phone2.length() != 4 || util.getNumberCheck(phone2, 0) <= 0) {
				failCounter++;
			} else if (phone3.equals("") || phone3.length() != 4 || util.getNumberCheck(phone3, 0) <= 0) {
				failCounter++;
			} else if (email1.equals("")) {
				failCounter++;
			} else if (email2.equals("")) {
				failCounter++;
			} else if (postcode.equals("")) {
				failCounter++;
			} else if (address.equals("")) {
				failCounter++;
			} else if (detailAddress.equals("")) {
				extraAddress = "-";
			} else if (extraAddress.equals("")) {
				extraAddress = "-";
			}//if
			
			if (failCounter > 0) {
				System.out.println("failCounter: " + failCounter);
				return;
			}//if
			
			id = util.getCheckString(id);
			passwd = util.getCheckString(passwd);
			name = util.getCheckString(name);
			jumin1 = util.getCheckString(jumin1);
			jumin2 = util.getCheckString(jumin2);
			phone1 = util.getCheckString(phone1);
			phone2 = util.getCheckString(phone2);
			phone3 = util.getCheckString(phone3);
			email1 = util.getCheckString(email1);
			email2 = util.getCheckString(email2);
			postcode = util.getCheckString(postcode);
			address = util.getCheckString(address);
			detailAddress = util.getCheckString(detailAddress);
			extraAddress = util.getCheckString(extraAddress);

			MemberDTO arguMemberDto = new MemberDTO();
			arguMemberDto.setId(id);
			arguMemberDto.setPasswd(passwd);
			arguMemberDto.setName(name);
			arguMemberDto.setJumin1(jumin1);
			arguMemberDto.setJumin2(jumin2);
			arguMemberDto.setPhone1(phone1);
			arguMemberDto.setPhone2(phone2);
			arguMemberDto.setPhone3(phone3);
			arguMemberDto.setEmail1(email1);
			arguMemberDto.setEmail2(email2);
			arguMemberDto.setPostcode(postcode);
			arguMemberDto.setAddress(address);
			arguMemberDto.setDetailAddress(detailAddress);
			arguMemberDto.setExtraAddress(extraAddress);
			
			MemberDAO memberDao = new MemberDAO();
			int result = memberDao.setInsert(arguMemberDto);
			
			if (result > 0) {
				response.sendRedirect(path + "/member_servlet/member_list.do");
			} else {
				response.sendRedirect(path + "/member_servlet/member_chuga.do?" + searchQuery);
			}//if
			
		} else if (fileName.equals("sujungProc")) {
			String no_ = request.getParameter("no");
			int no = util.getNumberCheck(no_, 0);
			
			if (no == 0) {
				System.out.println("no: " + no);
				return;
			}//if
			
			MemberDTO arguMemberDto = new MemberDTO();
			arguMemberDto.setNo(no);
			arguMemberDto.setSearchGubun(searchGubun);
			arguMemberDto.setSearchData(searchData);
			
			MemberDAO memberDao = new MemberDAO();
			MemberDTO returnMemberDto = memberDao.getSelectOne(arguMemberDto);
			
			if (returnMemberDto.getNo() <= 0) {
				System.out.println("no: " + returnMemberDto.getNo());
				return;
			}//if
			
			String passwd = request.getParameter("passwd");
			String phone1 = request.getParameter("phone1");
			String phone2 = request.getParameter("phone2");
			String phone3 = request.getParameter("phone3");
			String email1 = request.getParameter("email1");
			String email2 = request.getParameter("email2");
			String postcode = request.getParameter("postcode");
			String address = request.getParameter("address");
			String detailAddress = request.getParameter("detailAddress");
			String extraAddress = request.getParameter("extraAddress");
			
			passwd = util.getNullBlankCheck(passwd);
			phone1 = util.getNullBlankCheck(phone1);
			phone2 = util.getNullBlankCheck(phone2);
			phone3 = util.getNullBlankCheck(phone3);
			email1 = util.getNullBlankCheck(email1);
			email2 = util.getNullBlankCheck(email2);
			postcode = util.getNullBlankCheck(postcode);
			address = util.getNullBlankCheck(address);
			detailAddress = util.getNullBlankCheck(detailAddress);
			extraAddress = util.getNullBlankCheck(extraAddress);
			
			int failCounter = 0;
			if (phone1.equals("") || !(phone1.equals("010") || phone2.equals("011") || phone3.equals("016"))) {
				failCounter++;
			} else if (phone2.equals("") || phone2.length() != 4 || util.getNumberCheck(phone2, 0) <= 0) {
				failCounter++;
			} else if (phone3.equals("") || phone3.length() != 4 || util.getNumberCheck(phone3, 0) <= 0) {
				failCounter++;
			} else if (email1.equals("")) {
				failCounter++;
			} else if (email2.equals("")) {
				failCounter++;
			} else if (postcode.equals("")) {
				failCounter++;
			} else if (address.equals("")) {
				failCounter++;
			} else if (detailAddress.equals("")) {
				extraAddress = "-";
			} else if (extraAddress.equals("")) {
				extraAddress = "-";
			}//if
			
			passwd = util.getCheckString(passwd);
			phone1 = util.getCheckString(phone1);
			phone2 = util.getCheckString(phone2);
			phone3 = util.getCheckString(phone3);
			email1 = util.getCheckString(email1);
			email2 = util.getCheckString(email2);
			postcode = util.getCheckString(postcode);
			address = util.getCheckString(address);
			detailAddress = util.getCheckString(detailAddress);
			extraAddress = util.getCheckString(extraAddress);

			if (!passwd.equals(returnMemberDto.getPasswd())) {
				failCounter++;
			}//if
			
			if (failCounter > 0) {
				System.out.println("failCounter: " + failCounter);
				return;
			}//if
			
			arguMemberDto.setPasswd(passwd);
			arguMemberDto.setPhone1(phone1);
			arguMemberDto.setPhone2(phone2);
			arguMemberDto.setPhone3(phone3);
			arguMemberDto.setEmail1(email1);
			arguMemberDto.setEmail2(email2);
			arguMemberDto.setPostcode(postcode);
			arguMemberDto.setAddress(address);
			arguMemberDto.setDetailAddress(detailAddress);
			arguMemberDto.setExtraAddress(extraAddress);
			
			int result = memberDao.setUpdate(arguMemberDto);
			
			if (result > 0) {
				response.sendRedirect(path + "/member_servlet/member_view.do?no=" + no + "&" + searchQuery);
			} else {
				response.sendRedirect(path + "/member_servlet/member_sujung.do?no=" + no + "&" + searchQuery);
			}//if
			
		} else if (fileName.equals("sakjeProc")) {
			String no_ = request.getParameter("no");
			int no = util.getNumberCheck(no_, 0);
			
			if (no == 0) {
				System.out.println("no: " + no);
				return;
			}//if
			
			MemberDTO arguMemberDto = new MemberDTO();
			arguMemberDto.setNo(no);
			arguMemberDto.setSearchGubun(searchGubun);
			arguMemberDto.setSearchData(searchData);
			
			MemberDAO memberDao = new MemberDAO();
			MemberDTO returnMemberDto = memberDao.getSelectOne(arguMemberDto);
			
			if (returnMemberDto.getNo() == 0) {
				System.out.println("no: " + returnMemberDto.getNo());
				return;
			}//if
			
			String passwd = request.getParameter("passwd");
			passwd = util.getNullBlankCheck(passwd);
			passwd = util.getCheckString(passwd);
			
			int failCounter = 0;
			if (passwd.equals("") || !passwd.equals(returnMemberDto.getPasswd())) {
				failCounter++;
			}//if
			
			if (failCounter > 0) {
				System.out.println("failCounter: " + failCounter);
				return;
			}//if
			
			arguMemberDto.setPasswd(passwd);
			
			int result = memberDao.setDelete(arguMemberDto);
			
			if (result > 0) {
				response.sendRedirect(path + "/member_servlet/member_list.do?" + searchQuery);
			} else {
				response.sendRedirect(path + "/member_servlet/member_sakje.do?no=" + no + "&" + searchQuery);
			}//if
			
		} else if (fileName.equals("idCheckWin")) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/project/member/idCheckWin.jsp");
			rd.forward(request, response);
			
		} else if (fileName.equals("idCheckWinProc")) {
			String id = request.getParameter("id");
			id = util.getNullBlankCheck(id);
			
			MemberDTO arguMemberDto = new MemberDTO();
			arguMemberDto.setId(id);
			
			MemberDAO memberDao = new MemberDAO();
			int result = memberDao.getIdCheckWin(arguMemberDto);
			
			String imsiId = id;
			String msg = "사용 가능한 아이디입니다.";
			if(result > 0) {
				imsiId = "";
				msg = "사용 불가능한 아이디입니다.";	
			}//if
			
			request.setAttribute("id", id);
			request.setAttribute("imsiId", imsiId);
			request.setAttribute("msg", msg);
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/project/member/idCheckWin.jsp");
			rd.forward(request, response);
		}//if
	}//doProc
}//MemberController
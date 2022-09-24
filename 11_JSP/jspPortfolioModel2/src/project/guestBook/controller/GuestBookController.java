package project.guestBook.controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.common.Util;
import project.guestBook.model.dao.GuestBookDAO;
import project.guestBook.model.dto.GuestBookDTO;

@WebServlet("/guestBook_servlet/*")
public class GuestBookController extends HttpServlet {
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
//serverInfo End
//pager Start
		String pageNumber_ = request.getParameter("pageNumber");
		int pageNumber = util.getNumberCheck(pageNumber_, 1);
		request.setAttribute("pageNumber", pageNumber);
//pager End
//search Start
		String searchGubun = request.getParameter("searchGubun");
		String searchData = request.getParameter("searchData");
		String imsiSearchYN = "O";
		
		searchGubun = util.getNullBlankCheck(searchGubun);
		searchData = util.getNullBlankCheck(searchData);
		
		if (searchGubun.equals("")) {
			searchGubun = "";
			searchData = "";
			imsiSearchYN = "X";
		}//if
		
		searchGubun = URLDecoder.decode(searchGubun, "UTF-8");
		searchData = URLDecoder.decode(searchData, "UTF-8");
		
		String searchQuery = "pageNumber="+ pageNumber;
		if (imsiSearchYN.equals("O")) {
			String imsiSearchGubun =  URLEncoder.encode(searchGubun, "UTF-8");
			String imsiSearchData =  URLEncoder.encode(searchData, "UTF-8");
			searchQuery = "pageNumber="+ pageNumber +"&searchGubun="+ imsiSearchGubun +"&searchData="+ imsiSearchData;
		}//if
		
		request.setAttribute("searchGubun", searchGubun);
		request.setAttribute("searchData", searchData);
		request.setAttribute("searchQuery", searchQuery);
//search End
		String forwardPage = "/WEB-INF/project/main/main.jsp";
		if (fileName.equals("list")) {
			GuestBookDTO arguGuestBookDto = new GuestBookDTO();
			arguGuestBookDto.setSearchGubun(searchGubun);
			arguGuestBookDto.setSearchData(searchData);
			
			GuestBookDAO guestBookDao = new GuestBookDAO();
//pager Start
			int pageSize = 5;
			int blockSize = 10;
			int totalRecord = guestBookDao.getTotalRecord(arguGuestBookDto);
			request.setAttribute("totalRecord", totalRecord);
			
			Map<String, Integer> pagerMap = util.getPagerMap(pageNumber, pageSize, blockSize, totalRecord);
			pagerMap.put("blockSize", blockSize);
			request.setAttribute("pagerMap", pagerMap);
			
			arguGuestBookDto.setStartRecord(pagerMap.get("startRecord"));
			arguGuestBookDto.setLastRecord(pagerMap.get("lastRecord"));
//pager End
			ArrayList<GuestBookDTO> guestBookList = guestBookDao.getSelectAll(arguGuestBookDto);
			request.setAttribute("list", guestBookList);
			
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (fileName.equals("view")) {
			String no_ = request.getParameter("no");
			int no = util.getNumberCheck(no_, 0);
			
			if (no <= 0) {
				return;
			}//if
			
			GuestBookDTO arguGuestBookDto = new GuestBookDTO();
			arguGuestBookDto.setNo(no);
			arguGuestBookDto.setSearchGubun(searchGubun);
			arguGuestBookDto.setSearchData(searchData);
			
			GuestBookDAO guestBookDao = new GuestBookDAO();
			GuestBookDTO returnGuestBookDto = guestBookDao.getSelectOne(arguGuestBookDto);
			
			if (returnGuestBookDto.getNo() <= 0) {
				return;
			}//if
			
			request.setAttribute("dto", returnGuestBookDto);
			request.setAttribute("newLine", "\n");
			
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (fileName.equals("chuga")) {
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (fileName.equals("sujung")) {
			String no_ = request.getParameter("no");
			int no = util.getNumberCheck(no_, 0);
			
			if (no <= 0) {
				return;
			}//if
			
			GuestBookDTO arguGuestBookDto = new GuestBookDTO();
			arguGuestBookDto.setNo(no);
			arguGuestBookDto.setSearchGubun(searchGubun);
			arguGuestBookDto.setSearchData(searchData);
			
			GuestBookDAO guestBookDao = new GuestBookDAO();
			GuestBookDTO returnGuestBookDto = guestBookDao.getSelectOne(arguGuestBookDto);
			
			if (returnGuestBookDto.getNo() <= 0) {
				return;
			}//if
			
			request.setAttribute("dto", returnGuestBookDto);
			
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (fileName.equals("sakje")) {
			String no_ = request.getParameter("no");
			int no = util.getNumberCheck(no_, 0);
			
			if (no <= 0) {
				return;
			}//if
			
			GuestBookDTO arguGuestBookDto = new GuestBookDTO();
			arguGuestBookDto.setNo(no);
			arguGuestBookDto.setSearchGubun(searchGubun);
			arguGuestBookDto.setSearchData(searchData);
			
			GuestBookDAO guestBookDao = new GuestBookDAO();
			GuestBookDTO returnGuestBookDto = guestBookDao.getSelectOne(arguGuestBookDto);
			
			if (returnGuestBookDto.getNo() <= 0) {
				return;
			}//if
			
			request.setAttribute("dto", returnGuestBookDto);
			request.setAttribute("newLine", "\n");
			
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (fileName.equals("chugaProc")) {
			String name = request.getParameter("name");
			String passwd = request.getParameter("passwd");
			String email1 = request.getParameter("email1");
			String email2 = request.getParameter("email2");
			String content = request.getParameter("content");
			
			name = util.getNullBlankCheck(name);
			passwd = util.getNullBlankCheck(passwd);
			email1 = util.getNullBlankCheck(email1);
			email2 = util.getNullBlankCheck(email2);
			content = util.getNullBlankCheck(content);
			
			int failCounter = 0;
			if (name.equals("")) {
				failCounter++;
			} else if (passwd.equals("")) {
				failCounter++;
			} else if (email1.equals("")) {
				failCounter++;
			} else if (email2.equals("")) {
				failCounter++;
			} else if (content.equals("")) {
				failCounter++;
			}//if
			
			if (failCounter > 0) {
				System.out.println("failCounter: "+ failCounter);
				return;
			}//if
			
			name = util.getCheckString(name);
			passwd = util.getCheckString(passwd);
			email1 = util.getCheckString(email1);
			email2 = util.getCheckString(email2);
			content = util.getCheckString(content);
			String email = email1 +"@"+ email2;
			
			GuestBookDTO arguGuestBookDto = new GuestBookDTO();
			arguGuestBookDto.setName(name);
			arguGuestBookDto.setPasswd(passwd);
			arguGuestBookDto.setEmail(email);
			arguGuestBookDto.setContent(content);
			
			GuestBookDAO guestBookDao = new GuestBookDAO();
			int result = guestBookDao.setInsert(arguGuestBookDto);
			
			if (result > 0) {
				response.sendRedirect(path + "/guestBook_servlet/guestBook_list.do");
			} else {
				response.sendRedirect(path + "/guestBook_servlet/guestBook_chuga.do?"+ searchQuery);
			}//if
			
		} else if (fileName.equals("sujungProc")) {
			String no_ = request.getParameter("no");
			String name = request.getParameter("name");
			String passwd = request.getParameter("passwd");
			String email1 = request.getParameter("email1");
			String email2 = request.getParameter("email2");
			String content = request.getParameter("content");
			
			int no = util.getNumberCheck(no_, 0);
			name = util.getNullBlankCheck(name);
			passwd = util.getNullBlankCheck(passwd);
			email1 = util.getNullBlankCheck(email1);
			email2 = util.getNullBlankCheck(email2);
			content = util.getNullBlankCheck(content);
			
			int failCounter = 0;
			if (no <= 0) {
				failCounter++;
			} else if (name.equals("")) {
				failCounter++;
			} else if (passwd.equals("")) {
				failCounter++;
			} else if (email1.equals("")) {
				failCounter++;
			} else if (email2.equals("")) {
				failCounter++;
			} else if (content.equals("")) {
				failCounter++;
			}//if
			
			name = util.getCheckString(name);
			passwd = util.getCheckString(passwd);
			email1 = util.getCheckString(email1);
			email2 = util.getCheckString(email2);
			content = util.getCheckString(content);
			String email = email1 +"@"+ email2;
			
			GuestBookDTO arguGuestBookDto = new GuestBookDTO();
			arguGuestBookDto.setNo(no);
			arguGuestBookDto.setName(name);
			arguGuestBookDto.setPasswd(passwd);
			arguGuestBookDto.setEmail(email);
			arguGuestBookDto.setContent(content);
			arguGuestBookDto.setSearchGubun(searchGubun);
			arguGuestBookDto.setSearchData(searchData);
			
			GuestBookDAO guestBookDao = new GuestBookDAO();
			GuestBookDTO returnGuestBookDto = guestBookDao.getSelectOne(arguGuestBookDto);
			
			if (returnGuestBookDto.getNo() <= 0) {
				failCounter++;
			} else if (!passwd.equals(returnGuestBookDto.getPasswd())) {
				failCounter++;
			}//if
			
			if (failCounter > 0) {
				System.out.println("failCounter: "+ failCounter);
				return;
			}//if
			
			int result = guestBookDao.setUpdate(arguGuestBookDto);
			
			if (result > 0) {
				response.sendRedirect(path + "/guestBook_servlet/guestBook_view.do?no="+ no +"&"+ searchQuery);
			} else {
				response.sendRedirect(path + "/guestBook_servlet/guestBook_sujung.do?no="+ no +"&"+ searchQuery);
			}//if
			
		} else if (fileName.equals("sakjeProc")) {
			String no_ = request.getParameter("no");
			String passwd = request.getParameter("passwd");
			
			int no = util.getNumberCheck(no_, 0);
			passwd = util.getNullBlankCheck(passwd);
			
			int failCounter = 0;
			if (no <= 0) {
				failCounter++;
			} else if (passwd.equals("")) {
				failCounter++;
			}//if
			
			passwd = util.getCheckString(passwd);
			
			GuestBookDTO arguGuestBookDto = new GuestBookDTO();
			arguGuestBookDto.setNo(no);
			arguGuestBookDto.setPasswd(passwd);
			arguGuestBookDto.setSearchGubun(searchGubun);
			arguGuestBookDto.setSearchData(searchData);
			
			GuestBookDAO guestBookDao = new GuestBookDAO();
			GuestBookDTO returnGuestBookDto = guestBookDao.getSelectOne(arguGuestBookDto);
			
			if (returnGuestBookDto.getNo() <= 0) {
				failCounter++;
			} else if (!passwd.equals(returnGuestBookDto.getPasswd())) {
				failCounter++;
			}//if
			
			if (failCounter > 0) {
				System.out.println("failCounter: "+ failCounter);
				return;
			}//if
			
			int result = guestBookDao.setDelete(arguGuestBookDto);
			
			if (result > 0) {
				response.sendRedirect(path + "/guestBook_servlet/guestBook_list.do?"+ searchQuery);
			} else {
				response.sendRedirect(path + "/guestBook_servlet/guestBook_sakje.do?no="+ no);
			}//if
			
		} else if (fileName.equals("search")) {
			String moveUrl = "";
			moveUrl += path + "/guestBook_servlet/guestBook_list.do?" + searchQuery;
			
			response.sendRedirect(moveUrl);
		}//if
	}//doProc
}//GuestBookController

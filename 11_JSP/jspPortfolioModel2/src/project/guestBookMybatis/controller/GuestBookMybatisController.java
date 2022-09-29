package project.guestBookMybatis.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.common.Util;
import project.guestBookMybatis.model.dao.GuestBookMybatisDAO;
import project.guestBookMybatis.model.dto.GuestBookMybatisDTO;

@WebServlet("/guestBookMybatis_servlet/*")
public class GuestBookMybatisController extends HttpServlet {
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
		
		String[] sessionArray = util.getSessionCheck(request);
		int sessionNo = Integer.parseInt(sessionArray[0]);
		String sessionId = sessionArray[1];
		String sessionName = sessionArray[2];
		
		if (sessionNo <= 0) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인 후 이용하세요.');");
			out.println("location.href='"+ path +"';");
			out.println("</script>");
			out.flush();
			out.close();
			return;
		}//if
		
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
			String imsiSearchGubun = URLEncoder.encode(searchGubun, "UTF-8");
			String imsiSearchData = URLEncoder.encode(searchData, "UTF-8");
			searchQuery += "&searchGubun="+ imsiSearchGubun +"&searchData="+ imsiSearchData;
		}//if
		
		request.setAttribute("searchGubun", searchGubun);
		request.setAttribute("searchData", searchData);
		request.setAttribute("searchQuery", searchQuery);
//search End
		
		String forwardPage = "/WEB-INF/project/main/main.jsp";
		if (fileName.equals("list")) {
			GuestBookMybatisDTO arguGuestBookMybatisDto = new GuestBookMybatisDTO();
			arguGuestBookMybatisDto.setSearchGubun(searchGubun);
			arguGuestBookMybatisDto.setSearchData(searchData);
			
			GuestBookMybatisDAO guestBookMybatisDao = new GuestBookMybatisDAO();
			
			int pageSize = 1;
			int blockSize = 10;
			int totalRecord = guestBookMybatisDao.getTotalRecord(arguGuestBookMybatisDto);
			request.setAttribute("totalRecord", totalRecord);
			
			Map<String, Integer> pagerMap = util.getPagerMap(pageNumber, pageSize, blockSize, totalRecord);
			pagerMap.put("blockSize", blockSize);
			request.setAttribute("pagerMap", pagerMap);
			
			arguGuestBookMybatisDto.setStartRecord(pagerMap.get("startRecord"));
			arguGuestBookMybatisDto.setLastRecord(pagerMap.get("lastRecord"));
			
			List<GuestBookMybatisDTO> guestBookMybatisList = guestBookMybatisDao.getSelectAll(arguGuestBookMybatisDto);
			
			request.setAttribute("list", guestBookMybatisList);
			
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (fileName.equals("chuga")) {
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (fileName.equals("chugaProc")) {
			String name = request.getParameter("name");
			String passwd = request.getParameter("passwd");
			String email1 = request.getParameter("email1");
			String email2 = request.getParameter("email2");
			String content = request.getParameter("content");
			String email = "-";
			int memberNo = sessionNo;
			
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
				email2 = "";
			} else if (content.equals("")) {
				content = "-";
			}//if
			
			if (failCounter > 0) {
				return;
			}//if
			
			name = util.getCheckString(name);
			passwd = util.getCheckString(passwd);
			email1 = util.getCheckString(email1);
			email2 = util.getCheckString(email2);
			content = util.getCheckString(content);
			
			if (!email1.equals("")) {
				email = email1 +"@"+ email2;
			}//if
			
			GuestBookMybatisDTO arguGuestBookMybatisDto = new GuestBookMybatisDTO();
			arguGuestBookMybatisDto.setName(name);
			arguGuestBookMybatisDto.setPasswd(passwd);
			arguGuestBookMybatisDto.setEmail(email);
			arguGuestBookMybatisDto.setContent(content);
			arguGuestBookMybatisDto.setMemberNo(memberNo);
			
			GuestBookMybatisDAO guestBookMybatisDao = new GuestBookMybatisDAO();
			int result = guestBookMybatisDao.setInsert(arguGuestBookMybatisDto);
			
			if (result > 0) {
				response.sendRedirect(path + "/guestBookMybatis_servlet/guestBookMybatis_list.do");
			} else {
				response.sendRedirect(path + "/guestBookMybatis_servlet/guestBookMybatis_chuga.do?"+ searchQuery);
			}//if
			
		} else if (fileName.equals("sujung")) {
			String no_ = request.getParameter("no");
			int no = util.getNumberCheck(no_, 0);
			
			if (no <= 0) {
				System.out.println("no: "+ no);
				return;
			}//if
			
			GuestBookMybatisDTO arguGuestBookMybatisDto = new GuestBookMybatisDTO();
			arguGuestBookMybatisDto.setNo(no);
			
			GuestBookMybatisDAO guestBookMybatisDao = new GuestBookMybatisDAO();
			GuestBookMybatisDTO resultGuestBookMybatisDto = guestBookMybatisDao.getSelectOne(arguGuestBookMybatisDto);
			
			if (resultGuestBookMybatisDto.getNo() != no) {
				return;
			}//if
			
			request.setAttribute("dto", resultGuestBookMybatisDto);
			
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (fileName.equals("sujungProc")) {
			String no_ = request.getParameter("no");
			int no = util.getNumberCheck(no_, 0);
			
			if (no <= 0) {
				System.out.println("no: "+ no);
				return;
			}//if
			
			String name = request.getParameter("name");
			String passwd = request.getParameter("passwd");
			String email1 = request.getParameter("email1");
			String email2 = request.getParameter("email2");
			String content = request.getParameter("content");
			String email = "-";
			int memberNo = sessionNo;
			
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
				email2 = "";
			} else if (content.equals("")) {
				content = "-";
			}//if
			
			if (failCounter > 0) {
				return;
			}//if
			
			name = util.getCheckString(name);
			passwd = util.getCheckString(passwd);
			email1 = util.getCheckString(email1);
			email2 = util.getCheckString(email2);
			content = util.getCheckString(content);
			
			if (!email1.equals("")) {
				email = email1 +"@"+ email2;
			}//if
			
			GuestBookMybatisDTO arguGuestBookMybatisDto = new GuestBookMybatisDTO();
			arguGuestBookMybatisDto.setNo(no);
			arguGuestBookMybatisDto.setName(name);
			arguGuestBookMybatisDto.setPasswd(passwd);
			arguGuestBookMybatisDto.setEmail(email);
			arguGuestBookMybatisDto.setContent(content);
			arguGuestBookMybatisDto.setMemberNo(memberNo);
			
			GuestBookMybatisDAO guestBookMybatisDao = new GuestBookMybatisDAO();
			int result = guestBookMybatisDao.setUpdate(arguGuestBookMybatisDto);
			
			if (result > 0) {
				response.sendRedirect(path + "/guestBookMybatis_servlet/guestBookMybatis_list.do?"+ searchQuery);
			} else {
				response.sendRedirect(path + "/guestBookMybatis_servlet/guestBookMybatis_sujung.do?no="+ no +"&"+ searchQuery);
			}//if
			
		} else if (fileName.equals("sakje")) {
			String no_ = request.getParameter("no");
			int no = util.getNumberCheck(no_, 0);
			
			if (no <= 0) {
				return;
			}//if
			
			GuestBookMybatisDTO arguGuestBookMybatisDto = new GuestBookMybatisDTO();
			arguGuestBookMybatisDto.setNo(no);
			
			GuestBookMybatisDAO guestBookMybatisDao = new GuestBookMybatisDAO();
			GuestBookMybatisDTO resultGuestBookMybatisDto = guestBookMybatisDao.getSelectOne(arguGuestBookMybatisDto);
			
			if (resultGuestBookMybatisDto.getNo() != no) {
				return;
			}//if
			
			request.setAttribute("dto", resultGuestBookMybatisDto);
			
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (fileName.equals("sakjeProc")) {
			String no_ = request.getParameter("no");
			int no = util.getNumberCheck(no_, 0);
			
			if (no <= 0) {
				System.out.println("no: "+ no);
				return;
			}//if
			
			String passwd = request.getParameter("passwd");
			int memberNo = sessionNo;
			
			passwd = util.getNullBlankCheck(passwd);
			
			int failCounter = 0;
			if (passwd.equals("")) {
				failCounter++;
			}//if
			
			if (failCounter > 0) {
				return;
			}//if
			
			passwd = util.getCheckString(passwd);
			
			GuestBookMybatisDTO arguGuestBookMybatisDto = new GuestBookMybatisDTO();
			arguGuestBookMybatisDto.setNo(no);
			arguGuestBookMybatisDto.setPasswd(passwd);
			arguGuestBookMybatisDto.setMemberNo(memberNo);
			
			GuestBookMybatisDAO guestBookMybatisDao = new GuestBookMybatisDAO();
			int result = guestBookMybatisDao.setDelete(arguGuestBookMybatisDto);
			
			if (result > 0) {
				response.sendRedirect(path + "/guestBookMybatis_servlet/guestBookMybatis_list.do");
			} else {
				response.sendRedirect(path + "/guestBookMybatis_servlet/guestBookMybatis_sakje.do?no="+ no +"&"+ searchQuery);
			}//if
			
		} else if (fileName.equals("search")) {
			response.sendRedirect(path + "/guestBookMybatis_servlet/guestBookMybatis_list.do?"+ searchQuery);
		}//if
	}//doProc
}//GuestBookMybatisController

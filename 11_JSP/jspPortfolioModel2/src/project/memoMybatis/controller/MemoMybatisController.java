package project.memoMybatis.controller;

import java.io.IOException;
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
import project.memoMybatis.model.dao.MemoMybatisDAO;
import project.memoMybatis.model.dto.MemoMybatisDTO;


@WebServlet("/memoMybatis_servlet/*")
public class MemoMybatisController extends HttpServlet {
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
		
		if (sessionNo <= 0) {//로그인 안한 상태..
			response.sendRedirect(path +"/noLogin_servlet/noLogin_login.do");
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
//search End
		
		String forwardPage = "/WEB-INF/project/main/main.jsp";
		if (fileName.equals("list")) {
			MemoMybatisDTO arguMemoMybatisDto = new MemoMybatisDTO();
			arguMemoMybatisDto.setSearchGubun(searchGubun);
			arguMemoMybatisDto.setSearchData(searchData);
			MemoMybatisDAO memoMybatisDao = new MemoMybatisDAO();
			
			int pageSize = 5;
			int blockSize = 10;
			int totalRecord = memoMybatisDao.getTotalRecord(arguMemoMybatisDto);
			request.setAttribute("totalRecord", totalRecord);
			
			Map<String, Integer> pagerMap = util.getPagerMap(pageNumber, pageSize, blockSize, totalRecord);
			pagerMap.put("blockSize", blockSize);
			request.setAttribute("pagerMap", pagerMap);
			
			arguMemoMybatisDto.setStartRecord(pagerMap.get("startRecord"));
			arguMemoMybatisDto.setLastRecord(pagerMap.get("lastRecord"));
			
			List<MemoMybatisDTO> memoMybatislist = memoMybatisDao.getSelectAll(arguMemoMybatisDto);
			request.setAttribute("list", memoMybatislist);
			
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (fileName.equals("view")) {
			String no_ = request.getParameter("no");
			int no = util.getNumberCheck(no_, 0);
			
			if (no <= 0) {
				System.out.println("no: " + no);
				return;
			}//if
			
			MemoMybatisDTO arguMemoMybatisDto = new MemoMybatisDTO();
			arguMemoMybatisDto.setNo(no);
//			arguMemoMybatisDto.setSearchGubun(searchGubun);
//			arguMemoMybatisDto.setSearchData(searchData);
			
			MemoMybatisDAO memoMybatisDao = new MemoMybatisDAO();
			MemoMybatisDTO returnMemoMybatisDto = memoMybatisDao.getSelectOne(arguMemoMybatisDto);
			
			if (returnMemoMybatisDto.getNo() != no) {
				System.out.println("wrong no");
				return;
			}//if
			
			arguMemoMybatisDto.setSearchGubun(searchGubun);
			arguMemoMybatisDto.setSearchData(searchData);
			
			MemoMybatisDTO resultMemoMybatisDto = memoMybatisDao.getSelectOne(arguMemoMybatisDto);
			
			request.setAttribute("dto", resultMemoMybatisDto);
			
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (fileName.equals("chuga")) {
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (fileName.equals("chugaProc")) {
			String[] refererArray = referer.split("/");
			String[] urlArray = referer.split("/");
			
			for (int i = 0; i < refererArray.length - 1; i++) {
				System.out.println("ra: "+refererArray[i]);
				System.out.println("ua: "+urlArray[i]);
				if (!refererArray[i].equals(urlArray[i])) {
					return;
				}//if
			}//for
			
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");
			
			writer = util.getNullBlankCheck(writer);
			content = util.getNullBlankCheck(content);
			
			int failCounter = 0;
			if (writer.equals("")) {
				failCounter++;
			} else if (content.equals("")) {
				failCounter++;
			}//if
			
			if (failCounter > 0) {
				System.out.println("failCounter: " + failCounter);
				return;
			}//if
			
			writer = util.getCheckString(writer);
			content = util.getCheckString(content);
			
			MemoMybatisDTO arguMemoMybatisDto = new MemoMybatisDTO();
			arguMemoMybatisDto.setWriter(writer);
			arguMemoMybatisDto.setContent(content);
			
			MemoMybatisDAO memoMybatisDao = new MemoMybatisDAO();
			int result = memoMybatisDao.setInsert(arguMemoMybatisDto);
			
			if (result > 0) {
				response.sendRedirect(path + "/memoMybatis_servlet/memoMybatis_list.do");
			} else {
				response.sendRedirect(path + "/memoMybatis_servlet/memoMybatis_chuga.do?"+ searchQuery);
			}//if
			
		} else if (fileName.equals("sujung")) {
			String no_ = request.getParameter("no");
			int no = util.getNumberCheck(no_, 0);
			
			if (no <= 0) {
				System.out.println("no: " + no);
				return;
			}//if
			
			MemoMybatisDTO arguMemoMybatisDto = new MemoMybatisDTO();
			arguMemoMybatisDto.setNo(no);
//			arguMemoMybatisDto.setSearchGubun(searchGubun);
//			arguMemoMybatisDto.setSearchData(searchData);
			
			MemoMybatisDAO memoMybatisDao = new MemoMybatisDAO();
			MemoMybatisDTO returnMemoMybatisDto = memoMybatisDao.getSelectOne(arguMemoMybatisDto);
			
			if (returnMemoMybatisDto.getNo() != no) {
				System.out.println("wrong no");
				return;
			}//if
			
			request.setAttribute("dto", returnMemoMybatisDto);
			
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (fileName.equals("sujungProc")) {
			System.out.println(referer);
			String no_ = request.getParameter("no");
			int no = util.getNumberCheck(no_, 0);
			
			if (no <= 0) {
				System.out.println("no: " + no);
				return;
			}//if
			
			MemoMybatisDTO arguMemoMybatisDto = new MemoMybatisDTO();
			arguMemoMybatisDto.setNo(no);
//			arguMemoMybatisDto.setSearchGubun(searchGubun);
//			arguMemoMybatisDto.setSearchData(searchData);
			
			MemoMybatisDAO memoMybatisDao = new MemoMybatisDAO();
			MemoMybatisDTO returnMemoMybatisDto = memoMybatisDao.getSelectOne(arguMemoMybatisDto);
			
			if (returnMemoMybatisDto.getNo() != no) {
				System.out.println("wrong no");
				return;
			}//if
			
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");
			
			writer = util.getNullBlankCheck(writer);
			content = util.getNullBlankCheck(content);
			
			int failCounter = 0;
			if (writer.equals("")) {
				failCounter++;
			} else if (content.equals("")) {
				failCounter++;
			}//if
			
			if (failCounter > 0) {
				System.out.println("failCounter: " + failCounter);
				return;
			}//if
			
			writer = util.getCheckString(writer);
			content = util.getCheckString(content);
			
			arguMemoMybatisDto.setWriter(writer);
			arguMemoMybatisDto.setContent(content);
			
			int result = memoMybatisDao.setUpdate(arguMemoMybatisDto);
			
			if (result > 0) {
				response.sendRedirect(path + "/memoMybatis_servlet/memoMybatis_view.do?no="+ no +"&"+ searchQuery);
			} else {
				response.sendRedirect(path + "/memoMybatis_servlet/memoMybatis_sujung.do?no"+ no +"&"+ searchQuery);
			}//if
			
		} else if (fileName.equals("sakje")) {
			String no_ = request.getParameter("no");
			int no = util.getNumberCheck(no_, 0);
			
			if (no <= 0) {
				System.out.println("no: " + no);
				return;
			}//if
			
			MemoMybatisDTO arguMemoMybatisDto = new MemoMybatisDTO();
			arguMemoMybatisDto.setNo(no);
//			arguMemoMybatisDto.setSearchGubun(searchGubun);
//			arguMemoMybatisDto.setSearchData(searchData);
			
			MemoMybatisDAO memoMybatisDao = new MemoMybatisDAO();
			MemoMybatisDTO returnMemoMybatisDto = memoMybatisDao.getSelectOne(arguMemoMybatisDto);
			
			if (returnMemoMybatisDto.getNo() != no) {
				System.out.println("wrong no");
				return;
			}//if
			
			request.setAttribute("dto", returnMemoMybatisDto);
			
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (fileName.equals("sakjeProc")) {
			System.out.println(referer);
			String no_ = request.getParameter("no");
			int no = util.getNumberCheck(no_, 0);
			
			if (no <= 0) {
				System.out.println("no: " + no);
				return;
			}//if
			
			MemoMybatisDTO arguMemoMybatisDto = new MemoMybatisDTO();
			arguMemoMybatisDto.setNo(no);
			
			MemoMybatisDAO memoMybatisDao = new MemoMybatisDAO();
			MemoMybatisDTO returnMemoMybatisDto = memoMybatisDao.getSelectOne(arguMemoMybatisDto);
			
			if (returnMemoMybatisDto.getNo() != no) {
				System.out.println("wrong no");
				return;
			}//if
			
			int result = memoMybatisDao.setDelete(arguMemoMybatisDto);
			
			if (result > 0) {
				response.sendRedirect(path + "/memoMybatis_servlet/memoMybatis_list.do?"+ searchQuery);
			} else {
				response.sendRedirect(path + "/memoMybatis_servlet/memoMybatis_sakje.do?no"+ no +"&"+ searchQuery);
			}//if
			
		} else if (fileName.equals("search")) {
			response.sendRedirect(path + "/memoMybatis_servlet/memoMybatis_list.do?"+ searchQuery);
		}//if
	}//doPost
}//MemoMybatisController

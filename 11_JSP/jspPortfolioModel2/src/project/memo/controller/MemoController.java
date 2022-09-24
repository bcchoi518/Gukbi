package project.memo.controller;

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
import project.memo.model.dao.MemoDAO;
import project.memo.model.dto.MemoDTO;

@WebServlet("/memo_servlet/*")
public class MemoController extends HttpServlet {
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
//search Start
		String searchGubun = request.getParameter("searchGubun");
		String searchData = request.getParameter("searchData");
		
		searchGubun = util.getNullBlankCheck(searchGubun);
		searchData = util.getNullBlankCheck(searchData);
		
		if (searchGubun.equals("")) {
			searchGubun = "";
			searchData = "";
		}//if
		
		searchGubun = URLDecoder.decode(searchGubun, "UTF-8");
		searchData = URLDecoder.decode(searchData, "UTF-8");
		
		request.setAttribute("searchGubun", searchGubun);
		request.setAttribute("searchData", searchData);
//search End
//pager Start
		String pageNumber_ = request.getParameter("pageNumber");
		int pageNumber = util.getNumberCheck(pageNumber_, 1);
		request.setAttribute("pageNumber", pageNumber);
//pager End
		String forwardPage = "/WEB-INF/project/main/main.jsp";
		if (fileName.equals("list")) {
			
			MemoDTO arguMemoDto = new MemoDTO();
			arguMemoDto.setSearchGubun(searchGubun);
			arguMemoDto.setSearchData(searchData);
			
			MemoDAO memoDao = new MemoDAO();
			
			int pageSize = 5;
			int blockSize = 10;
			int totalRecord = memoDao.getTotalRecord(arguMemoDto);
			request.setAttribute("totalRecord", totalRecord);
			
			Map<String, Integer> pagerMap = util.getPagerMap(pageNumber, pageSize, blockSize, totalRecord);
			pagerMap.put("blockSize", blockSize);
			request.setAttribute("pagerMap", pagerMap);
			
			arguMemoDto.setStartRecord(pagerMap.get("startRecord"));
			arguMemoDto.setLastRecord(pagerMap.get("lastRecord"));
			
			ArrayList<MemoDTO> memoList = memoDao.getSelectAll(arguMemoDto);
			request.setAttribute("list", memoList);
			request.setAttribute("newLine", "\n");
			
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (fileName.equals("proc")) {
			String procGubun = request.getParameter("procGubun");
			
			procGubun = util.getNullBlankCheck(procGubun);
			
			if (procGubun.equals("chuga")) {
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
				
				MemoDTO arguMemoDto = new MemoDTO();
				arguMemoDto.setWriter(writer);
				arguMemoDto.setContent(content);
				
				MemoDAO memoDao = new MemoDAO();
				int result = memoDao.setInsert(arguMemoDto);
				
				searchGubun = "";
				searchData = "";
				
			} else if (procGubun.equals("sujung")) {
				String no_ = request.getParameter("no");
				String writer = request.getParameter("writer");
				String content = request.getParameter("content");
				int no = util.getNumberCheck(no_, 0);
				
				if (no <= 0) {
					return;
				}//if
				
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
				
				MemoDTO arguMemoDto = new MemoDTO();
				arguMemoDto.setNo(no);
				arguMemoDto.setWriter(writer);
				arguMemoDto.setContent(content);
				
				MemoDAO memoDao = new MemoDAO();
				MemoDTO returnMemoDto = memoDao.getSelectOne(arguMemoDto);
				
				if (returnMemoDto.getNo() <= 0) {
					return;
				}//if
				
				int result = memoDao.setUpdate(arguMemoDto);
				
			} else if (procGubun.equals("sakje")) {
				String no_ = request.getParameter("no");
				int no = util.getNumberCheck(no_, 0);
				
				if (no <= 0) {
					return;
				}//if
				
				MemoDTO arguMemoDto = new MemoDTO();
				arguMemoDto.setNo(no);
				
				MemoDAO memoDao = new MemoDAO();
				MemoDTO returnMemoDto = memoDao.getSelectOne(arguMemoDto);
				
				if (returnMemoDto.getNo() <= 0) {
					return;
				}//if
				
				int result = memoDao.setDelete(returnMemoDto);
			}//if
			
			String imsiSearchGubun = URLEncoder.encode(searchGubun, "UTF-8");
			String imsiSearchData = URLEncoder.encode(searchData, "UTF-8");
			
			response.sendRedirect(path + "/memo_servlet/memo_list.do?searchGubun=" + imsiSearchGubun + "&searchData=" + imsiSearchData);
		}//if
	}//doProc
}//MemoController

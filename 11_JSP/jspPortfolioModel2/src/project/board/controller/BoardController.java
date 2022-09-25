package project.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.board.model.dao.BoardDAO;
import project.board.model.dto.BoardDTO;
import project.common.Util;

@WebServlet("/board_servlet/*")
public class BoardController extends HttpServlet {
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
		
		String forwardPage = "/WEB-INF/project/main/main.jsp";
		if (fileName.equals("list")) {
			BoardDTO arguBoardDto = new BoardDTO();
			
			BoardDAO boardDao = new BoardDAO();
			
			ArrayList<BoardDTO> boardList =boardDao.getSelectAll(); 
			
			request.setAttribute("list", boardList);
			
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (fileName.equals("view")) {
			String no_ = request.getParameter("no");
			int no = util.getNumberCheck(no_, 0);
			
			if (no <= 0) {
				return;
			}//if
			
			BoardDTO arguBoardDto = new BoardDTO();
			arguBoardDto.setNo(no);
			
			BoardDAO boardDao = new BoardDAO();
			BoardDTO returnBoardDto = boardDao.getSelectOne(arguBoardDto);
			
			if (returnBoardDto.getNo() <= 0) {
				return;
			}//if
			
			request.setAttribute("dto", returnBoardDto);
			request.setAttribute("newLine", "\n");
			
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (fileName.equals("chuga")) {
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (fileName.equals("sujung")) {
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (fileName.equals("sakje")) {
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (fileName.equals("chugaProc")) {
			String no_ = request.getParameter("no");
			int no = util.getNumberCheck(no_, 0);
			
			String writer = request.getParameter("writer");
			String passwd = request.getParameter("passwd");
			String email1 = request.getParameter("email1");
			String email2 = request.getParameter("email2");
			String secretGubun = request.getParameter("secretGubun");
			String noticeGubun = request.getParameter("noticeGubun");
			String subject = request.getParameter("subject");
			String content = request.getParameter("content");
			
			writer = util.getNullBlankCheck(writer);
			passwd = util.getNullBlankCheck(passwd);
			email1 = util.getNullBlankCheck(email1);
			email2 = util.getNullBlankCheck(email2);
			secretGubun = util.getNullBlankCheck(secretGubun);
			noticeGubun = util.getNullBlankCheck(noticeGubun);
			subject = util.getNullBlankCheck(subject);
			content = util.getNullBlankCheck(content);
			
			int failCounter = 0;
			if (writer.equals("")) {
				System.out.println("writer error");
				failCounter++;
			} else if (passwd.equals("")) {
				System.out.println("passwd error");
				failCounter++;
			} else if (email1.equals("")) {
				System.out.println("email1 error");
				failCounter++;
			} else if (email2.equals("")) {
				System.out.println("email2 error");
				failCounter++;
			} else if (secretGubun.equals("") || !(secretGubun.equals("T") || secretGubun.equals("F"))) {
				System.out.println("secretGubun error");
				failCounter++;
			} else if (noticeGubun.equals("") || !(secretGubun.equals("T") || secretGubun.equals("F"))) {
				System.out.println("noticeGubun error");
				failCounter++;
			} else if (noticeGubun.equals("T") && secretGubun.equals("T")) {
				System.out.println("T && T error");
				failCounter++;
			} else if (subject.equals("")) {
				System.out.println("subject error");
				failCounter++;
			} else if (content.equals("")) {
				System.out.println("content error");
				failCounter++;
			}//if
			
			writer = util.getCheckString(writer);
			passwd = util.getCheckString(passwd);
			email1 = util.getCheckString(email1);
			email2 = util.getCheckString(email2);
			secretGubun = util.getCheckString(secretGubun);
			noticeGubun = util.getCheckString(noticeGubun);
			subject = util.getCheckString(subject);
			content = util.getCheckString(content);
			
			BoardDTO arguBoardDto = new BoardDTO();
			arguBoardDto.setNo(no);
			
			BoardDAO boardDao = new BoardDAO();
			BoardDTO returnDto = boardDao.getSelectOne(arguBoardDto);
			
			int num = boardDao.getMaxValue("num") + 1;
			String tbl = "-";
			String email = email1 +"@"+ email2;
			int refNo = 0;
			int stepNo = 0;
			int levelNo = 0;
			int parentNo = 0;
			int hit = 0;
//			String ip;
			int memberNo = 0;//나중에 sessionNo 값을 넣을 예정
			int noticeNo = 0;
			String attachInfo = "-"; 
			
			if (no == 0) {//새글일때..
				refNo = boardDao.getMaxValue("refNo") + 1;
				stepNo = 1;
				levelNo = 1;
			} else if (returnDto.getNo() > 0) {//답글일때..
				refNo = returnDto.getRefNo();
				stepNo = returnDto.getStepNo() + 1;
				boardDao.setUpdateReLevel(returnDto);
				levelNo = returnDto.getLevelNo() + 1;
				parentNo = returnDto.getNo();
			} else {
				System.out.println("새글 답글 error");
				failCounter++;
			}//if

			if (noticeGubun.equals("T")) {//공지글일때..
				noticeNo = boardDao.getMaxValue("noticeNo") + 1;
			}//if
			
			if (failCounter > 0) {
				return;
			}//if
			
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
			
			if (result > 0) {
				response.sendRedirect(path + "/board_servlet/board_list.do");
			} else {
				response.sendRedirect(path + "/board_servlet/board_chuga.do");
			}//if
			
		} else if (fileName.equals("sujungProc")) {
			
		} else if (fileName.equals("sakjeProc")) {
			
		}//if
	}//doProc
}//BoardController

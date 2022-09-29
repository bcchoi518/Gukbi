package project.board.controller;

import java.io.IOException;
import java.io.PrintWriter;
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

import project.board.model.dao.BoardCommentDAO;
import project.board.model.dao.BoardDAO;
import project.board.model.dto.BoardCommentDTO;
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
			BoardDTO arguBoardDto = new BoardDTO();
			arguBoardDto.setSearchGubun(searchGubun);
			arguBoardDto.setSearchData(searchData);
			
			BoardDAO boardDao = new BoardDAO();
//pager Start
			int pageSize = 5;
			int blockSize = 10;
			int totalRecord = boardDao.getTotalRecord(arguBoardDto);
			request.setAttribute("totalRecord", totalRecord);
			
			Map<String, Integer> pagerMap = util.getPagerMap(pageNumber, pageSize, blockSize, totalRecord);
			pagerMap.put("blockSize", blockSize);
			
			arguBoardDto.setStartRecord(pagerMap.get("startRecord"));
			arguBoardDto.setLastRecord(pagerMap.get("lastRecord"));
			
			request.setAttribute("pagerMap", pagerMap);
//pager End
			ArrayList<BoardDTO> boardList =boardDao.getSelectAll(arguBoardDto); 
			
			request.setAttribute("list", boardList);
			
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (fileName.equals("view")) {
			String no_ = request.getParameter("no");
			int no = util.getNumberCheck(no_, 0);
			
			if (no <= 0) {
				return;
			}//if
			
			String viewPasswd = request.getParameter("viewPasswd");
			viewPasswd = util.getNullBlankCheck(viewPasswd);
			viewPasswd = util.getCheckString(viewPasswd);
			request.setAttribute("viewPasswd", viewPasswd);
			
			BoardDTO arguBoardDto = new BoardDTO();
			arguBoardDto.setNo(no);
			arguBoardDto.setSearchGubun(searchGubun);
			arguBoardDto.setSearchData(searchData);
			
			BoardDAO boardDao = new BoardDAO();
			boardDao.setUpdateHit(arguBoardDto);
			BoardDTO returnBoardDto = boardDao.getSelectOne(arguBoardDto);
			
			if (returnBoardDto.getNo() <= 0) {
				return;
			}//if
			
			request.setAttribute("dto", returnBoardDto);
			request.setAttribute("newLine", "\n");
			
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (fileName.equals("chuga")) {
			String no_ = request.getParameter("no");
			int no = util.getNumberCheck(no_, 0);
			
			if (no > 0) {
				BoardDTO arguBoardDto = new BoardDTO();
				arguBoardDto.setNo(no);
				arguBoardDto.setSearchGubun(searchGubun);
				arguBoardDto.setSearchData(searchData);
				
				BoardDAO boardDao = new BoardDAO();
				BoardDTO returnBoardDto = boardDao.getSelectOne(arguBoardDto);
				
				if (returnBoardDto.getNo() <= 0) {
					System.out.println("wrong no");
					return;
				}//if
				
				request.setAttribute("newLine", "\n");
				request.setAttribute("dto", returnBoardDto);
			}//if
			
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (fileName.equals("sujung")) {
			String no_ = request.getParameter("no");
			int no = util.getNumberCheck(no_, 0);
			
			if (no <= 0) {
				System.out.println("wrong no");
				return;
			}//if
			
			BoardDTO arguBoardDto = new BoardDTO();
			arguBoardDto.setNo(no);
			arguBoardDto.setSearchGubun(searchGubun);
			arguBoardDto.setSearchData(searchData);
			
			BoardDAO boardDao = new BoardDAO();
			BoardDTO returnBoardDto = boardDao.getSelectOne(arguBoardDto);
			
			if (returnBoardDto.getNo() <= 0) {
				System.out.println("wrong no");
				return;
			}//if
			
			request.setAttribute("dto", returnBoardDto);
			
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (fileName.equals("sakje")) {
			String no_ = request.getParameter("no");
			int no = util.getNumberCheck(no_, 0);
			
			if (no <= 0) {
				System.out.println("wrong no");
				return;
			}//if
			
			BoardDTO arguBoardDto = new BoardDTO();
			arguBoardDto.setNo(no);
			arguBoardDto.setSearchGubun(searchGubun);
			arguBoardDto.setSearchData(searchData);
			
			BoardDAO boardDao = new BoardDAO();
			BoardDTO returnBoardDto = boardDao.getSelectOne(arguBoardDto);
			
			if (returnBoardDto.getNo() <= 0) {
				System.out.println("wrong no");
				return;
			}//if
			
			request.setAttribute("dto", returnBoardDto);
			
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (fileName.equals("search")) {
			String moveUrl = "";
			moveUrl += path + "/board_servlet/board_list.do?" + searchQuery;
			
			response.sendRedirect(moveUrl);
			
		} else if (fileName.equals("commentList")) {
			String no_ = request.getParameter("no");
			int no = util.getNumberCheck(no_, 0);
			
			if (no <= 0) {
				System.out.println("no: "+ no);
				return;
			}//if
			
			BoardCommentDTO arguBoardCommentDto = new BoardCommentDTO();
			arguBoardCommentDto.setBoardNo(no);
			
			BoardCommentDAO commentBoardDao = new BoardCommentDAO();
			ArrayList<BoardCommentDTO> commentList = commentBoardDao.getSelectAll(arguBoardCommentDto);
			
			request.setAttribute("no", no);
			request.setAttribute("list", commentList);
			
			forwardPage = "/WEB-INF/project/board/commentList.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (fileName.equals("commentProc")) {
			String procGubun = request.getParameter("procGubun");
			String no_ = request.getParameter("no");
			int no = util.getNumberCheck(no_, 0);
			procGubun = util.getNullBlankCheck(procGubun);
			
			int result = 0;
			if (procGubun.equals("chuga")) {
				String commentWriter = request.getParameter("commentWriter");
				String commentPasswd = request.getParameter("commentPasswd");
				String commentContent = request.getParameter("commentContent");
				
				commentWriter = util.getNullBlankCheck(commentWriter);
				commentPasswd = util.getNullBlankCheck(commentPasswd);
				commentContent = util.getNullBlankCheck(commentContent);
				
				int failCounter = 0;
				if (commentWriter.equals("")) {
					System.out.println("commentWriter error");
					failCounter++;
				} else if (commentPasswd.equals("")) {
					System.out.println("commentPasswd error");
					failCounter++;
				} else if (commentContent.equals("")) {
					System.out.println("commentContent error");
					failCounter++;
				}//if
				
				if (failCounter > 0) {
					return;
				}//if
				
				commentWriter = util.getCheckString(commentWriter);
				commentPasswd = util.getCheckString(commentPasswd);
				commentContent = util.getCheckString(commentContent);
				
				BoardCommentDTO arguBoardCommentDto = new BoardCommentDTO();
				arguBoardCommentDto.setBoardNo(no);
				arguBoardCommentDto.setWriter(commentWriter);
				arguBoardCommentDto.setContent(commentContent);
				arguBoardCommentDto.setPasswd(commentPasswd);
				arguBoardCommentDto.setMemberNo(sessionNo);
				arguBoardCommentDto.setIp(ip);
				
				BoardCommentDAO commentBoardDao = new BoardCommentDAO();
				result = commentBoardDao.setInsert(arguBoardCommentDto);
				
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println(result);
				out.flush();
				out.close();
				
			} else if (procGubun.equals("sujung")) {
				String commentNo_ = request.getParameter("commentNo");
				String commentWriter = request.getParameter("commentWriter");
				String commentPasswd = request.getParameter("commentPasswd");
				String commentContent = request.getParameter("commentContent");
				int commentNo = util.getNumberCheck(commentNo_, 0);
				
				commentWriter = util.getNullBlankCheck(commentWriter);
				commentPasswd = util.getNullBlankCheck(commentPasswd);
				commentContent = util.getNullBlankCheck(commentContent);
				
				int failCounter = 0;
				if (commentWriter.equals("")) {
					System.out.println("commentWriter error");
					failCounter++;
				} else if (commentPasswd.equals("")) {
					System.out.println("commentPasswd error");
					failCounter++;
				} else if (commentContent.equals("")) {
					System.out.println("commentContent error");
					failCounter++;
				}//if
				
				if (failCounter > 0) {
					return;
				}//if
				
				commentWriter = util.getCheckString(commentWriter);
				commentPasswd = util.getCheckString(commentPasswd);
				commentContent = util.getCheckString(commentContent);
				
				BoardCommentDTO arguBoardCommentDto = new BoardCommentDTO();
				arguBoardCommentDto.setCommentNo(commentNo);
				arguBoardCommentDto.setWriter(commentWriter);
				arguBoardCommentDto.setContent(commentContent);
				arguBoardCommentDto.setPasswd(commentPasswd);
				
				BoardCommentDAO commentBoardDao = new BoardCommentDAO();
				result = commentBoardDao.setUpdate(arguBoardCommentDto);
				
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println(result);
				out.flush();
				out.close();
				
			} else if (procGubun.equals("sakje")) {
				String commentNo_ = request.getParameter("commentNo");
				String commentPasswd = request.getParameter("commentPasswd");
				int commentNo = util.getNumberCheck(commentNo_, 0);
				
				commentPasswd = util.getNullBlankCheck(commentPasswd);
				
				int failCounter = 0;
				if (commentPasswd.equals("")) {
					System.out.println("commentPasswd error");
					failCounter++;
				}//if
				
				if (failCounter > 0) {
					return;
				}//if
				
				commentPasswd = util.getCheckString(commentPasswd);
				
				BoardCommentDTO arguBoardCommentDto = new BoardCommentDTO();
				arguBoardCommentDto.setCommentNo(commentNo);
				arguBoardCommentDto.setPasswd(commentPasswd);
				
				BoardCommentDAO commentBoardDao = new BoardCommentDAO();
				result = commentBoardDao.setDelete(arguBoardCommentDto);
				
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println(result);
				out.flush();
				out.close();
			}//if
			
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
			arguBoardDto.setSearchGubun(searchGubun);
			arguBoardDto.setSearchData(searchData);
			
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
			arguBoardDto.setSearchGubun(searchGubun);
			arguBoardDto.setSearchData(searchData);
			
			BoardDAO boardDao = new BoardDAO();
			BoardDTO returnDto = boardDao.getSelectOne(arguBoardDto);
			
			if (returnDto.getNo() <= 0) {
				System.out.println("wrong no");
				failCounter++;
			} else if (!passwd.equals(returnDto.getPasswd())) {
				System.out.println("passwd mismatch");
				failCounter++;
			}//if
			
			if (failCounter > 0) {
				return;
			}//if
			
			String email = email1 +"@"+ email2;
			String attachInfo = "-";
			
			int noticeNo = returnDto.getNoticeNo();
			if (noticeNo == 0 && noticeGubun.equals("T")) {
				noticeNo = boardDao.getMaxValue("noticeNo") + 1;
			} else if (noticeNo > 0 && noticeGubun.equals("F")) {
				noticeNo = 0;
			}//if
			
			arguBoardDto.setWriter(writer);
			arguBoardDto.setSubject(subject);
			arguBoardDto.setContent(content);
			arguBoardDto.setEmail(email);
			arguBoardDto.setPasswd(passwd);
			arguBoardDto.setNoticeNo(noticeNo);
			arguBoardDto.setSecretGubun(secretGubun);
			arguBoardDto.setAttachInfo(attachInfo);
			
			int result = boardDao.setUpdate(arguBoardDto);
			
			if (result > 0) {
				response.sendRedirect(path + "/board_servlet/board_view.do?no="+ no);
			} else {
				response.sendRedirect(path + "/board_servlet/board_sujung.do?no="+ no);
			}//if
			
		} else if (fileName.equals("sakjeProc")) {
			String no_ = request.getParameter("no");
			int no = util.getNumberCheck(no_, 0);
			
			String passwd = request.getParameter("passwd");
			
			passwd = util.getNullBlankCheck(passwd);
			
			int failCounter = 0;
			if (passwd.equals("")) {
				System.out.println("passwd error");
				failCounter++;
			}//if
			
			passwd = util.getCheckString(passwd);
			
			BoardDTO arguBoardDto = new BoardDTO();
			arguBoardDto.setNo(no);
			arguBoardDto.setSearchGubun(searchGubun);
			arguBoardDto.setSearchData(searchData);
			
			BoardDAO boardDao = new BoardDAO();
			BoardDTO returnDto = boardDao.getSelectOne(arguBoardDto);
			
			if (returnDto.getNo() <= 0) {
				System.out.println("wrong no");
				failCounter++;
			} else if (!passwd.equals(returnDto.getPasswd())) {
				System.out.println("passwd mismatch");
				failCounter++;
			}//if
			
			if (failCounter > 0) {
				return;
			}//if
			
			arguBoardDto.setPasswd(passwd);
			
			int result = boardDao.setDelete(arguBoardDto);
			
			if (result > 0) {
				response.sendRedirect(path + "/board_servlet/board_list.do?");
			} else {
				response.sendRedirect(path + "/board_servlet/board_sakje.do?no="+ no);
			}//if
		}//if
	}//doProc
}//BoardController

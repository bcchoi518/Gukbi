package _test.haksa.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import _common.Util;
import _test.haksa.model.dao.SihumDAO;
import _test.haksa.model.dto.SihumDTO;

@WebServlet("/haksaSihum_servlet/*")
public class SihumController extends HttpServlet {
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
		
		String path = request.getContextPath();
		String uri = request.getRequestURI().toString();
		
		request.setAttribute("path", path);
		
		String[] imsiUriArray = uri.split("/");
		String imsiUriFileName = imsiUriArray[imsiUriArray.length - 1];
		
		String forwardPage = "/WEB-INF/_test/haksa/sihum";
		
		if (imsiUriFileName.equals("list.do")) {
			SihumDAO sihumDao = new SihumDAO();
			ArrayList<SihumDTO> sihumList = sihumDao.getSelectAll();
			
			request.setAttribute("list", sihumList);
			
			forwardPage += "/list.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (imsiUriFileName.equals("view.do")) {
			String sihumNo_ = request.getParameter("sihumNo");
			int sihumNo = util.getNumberCheck(sihumNo_, 0);
			
			SihumDTO arguSihumDto = new SihumDTO();
			arguSihumDto.setSihumNo(sihumNo);
			
			SihumDAO sihumDao = new SihumDAO();
			SihumDTO resultSihumDto = sihumDao.getSelectOne(arguSihumDto);
			
			request.setAttribute("dto", resultSihumDto);
			
			forwardPage += "/view.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (imsiUriFileName.equals("chuga.do")) {
			forwardPage += "/chuga.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (imsiUriFileName.equals("sujung.do")) {
			String sihumNo_ = request.getParameter("sihumNo");
			int sihumNo = util.getNumberCheck(sihumNo_, 0);
			
			SihumDTO arguSihumDto = new SihumDTO();
			arguSihumDto.setSihumNo(sihumNo);
			
			SihumDAO sihumDao = new SihumDAO();
			SihumDTO resultSihumDto = sihumDao.getSelectOne(arguSihumDto);
			
			request.setAttribute("dto", resultSihumDto);
			
			forwardPage += "/sujung.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (imsiUriFileName.equals("sakje.do")) {
			String sihumNo_ = request.getParameter("sihumNo");
			int sihumNo = util.getNumberCheck(sihumNo_, 0);
			
			SihumDTO arguSihumDto = new SihumDTO();
			arguSihumDto.setSihumNo(sihumNo);
			
			SihumDAO sihumDao = new SihumDAO();
			SihumDTO resultSihumDto = sihumDao.getSelectOne(arguSihumDto);
			
			request.setAttribute("dto", resultSihumDto);
			
			forwardPage += "/sakje.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (imsiUriFileName.equals("chugaProc.do")) {
			String sihumName = request.getParameter("sihumName");
			String sihumDate_ = request.getParameter("sihumDate");
			Date sihumDate = Date.valueOf(sihumDate_);
			
			SihumDTO arguSihumDto = new SihumDTO();
			arguSihumDto.setSihumName(sihumName);
			arguSihumDto.setSihumDate(sihumDate);
			
			SihumDAO sihumDao = new SihumDAO();
			int result = sihumDao.setInsert(arguSihumDto);
			
			if (result > 0) {
				response.sendRedirect(path + "/haksaSihum_servlet/list.do");
			} else {
				response.sendRedirect(path + "/haksaSihum_servlet/chuga.do");
			}//if
			
		} else if (imsiUriFileName.equals("sujungProc.do")) {
			String sihumNo_ = request.getParameter("sihumNo");
			int sihumNo = util.getNumberCheck(sihumNo_, 0);
			String sihumName = request.getParameter("sihumName");
			String sihumDate_ = request.getParameter("sihumDate");
			Date sihumDate = Date.valueOf(sihumDate_);
			
			SihumDTO arguSihumDto = new SihumDTO();
			arguSihumDto.setSihumNo(sihumNo);
			arguSihumDto.setSihumName(sihumName);
			arguSihumDto.setSihumDate(sihumDate);
			
			SihumDAO sihumDao = new SihumDAO();
			int result = sihumDao.setUpdate(arguSihumDto);
			
			if (result > 0) {
				response.sendRedirect(path + "/haksaSihum_servlet/view.do?sihumNo=" + sihumNo);
			} else {
				response.sendRedirect(path + "/haksaSihum_servlet/sujung.do?sihumNo=" + sihumNo);
			}//if
			
		} else if (imsiUriFileName.equals("sakjeProc.do")) {
			String sihumNo_ = request.getParameter("sihumNo");
			int sihumNo = util.getNumberCheck(sihumNo_, 0);
			
			SihumDTO arguSihumDto = new SihumDTO();
			arguSihumDto.setSihumNo(sihumNo);
			
			SihumDAO sihumDao = new SihumDAO();
			int result = sihumDao.setDelete(arguSihumDto);
			
			if (result > 0) {
				response.sendRedirect(path + "/haksaSihum_servlet/list.do");
			} else {
				response.sendRedirect(path + "/haksaSihum_servlet/sakje.do?sihumNo=" + sihumNo);
			}//if
			
		} else {
			System.out.println("없네..");
		}//if
	}//doProc
}//SihumController

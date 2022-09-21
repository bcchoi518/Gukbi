package _test.factory.controller;

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
import _test.factory.model.dao.PositionDAO;
import _test.factory.model.dto.PositionDTO;

@WebServlet("/position_servlet/*")
public class PositionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProc(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProc(request, response);
	}

	protected void doProc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		Util util = new Util();
		
		String path = request.getContextPath();
		String uri = request.getRequestURI().toString();
		
		request.setAttribute("path", path);
		
		String[] imsiUriArray = uri.split("/");
		String imsiUriFileName = imsiUriArray[imsiUriArray.length - 1];
		
		String forwardPage = "/WEB-INF/_test/factory/position";
		
		if (imsiUriFileName.equals("list.do")) {
			PositionDAO positionDao = new PositionDAO();
			ArrayList<PositionDTO> positionList = positionDao.getSelectAll();
			
			request.setAttribute("list", positionList);
			
			forwardPage += "/list.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (imsiUriFileName.equals("view.do")) {
			String positionNo_ = request.getParameter("positionNo");
			int positionNo = util.getNumberCheck(positionNo_, 0);
			
			PositionDTO arguPositionDto = new PositionDTO();
			arguPositionDto.setPositionNo(positionNo);
			
			PositionDAO positionDao = new PositionDAO();
			PositionDTO resultPositionDto = positionDao.getSelectOne(arguPositionDto);
			
			request.setAttribute("dto", resultPositionDto);
			
			forwardPage += "/view.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (imsiUriFileName.equals("chuga.do")) {
			forwardPage += "/chuga.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (imsiUriFileName.equals("sujung.do")) {
			String positionNo_ = request.getParameter("positionNo");
			int positionNo = util.getNumberCheck(positionNo_, 0);
			
			PositionDTO arguPositionDto = new PositionDTO();
			arguPositionDto.setPositionNo(positionNo);
			
			PositionDAO positionDao = new PositionDAO();
			PositionDTO resultPositionDto = positionDao.getSelectOne(arguPositionDto);
			
			request.setAttribute("dto", resultPositionDto);
			
			forwardPage += "/sujung.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (imsiUriFileName.equals("sakje.do")) {
			String positionNo_ = request.getParameter("positionNo");
			int positionNo = util.getNumberCheck(positionNo_, 0);
			
			PositionDTO arguPositionDto = new PositionDTO();
			arguPositionDto.setPositionNo(positionNo);
			
			PositionDAO positionDao = new PositionDAO();
			PositionDTO resultPositionDto = positionDao.getSelectOne(arguPositionDto);
			
			request.setAttribute("dto", resultPositionDto);
			
			forwardPage += "/sakje.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (imsiUriFileName.equals("chugaProc.do")) {
			String positionName = request.getParameter("positionName");
			
			PositionDTO arguPositionDto = new PositionDTO();
			arguPositionDto.setPositionName(positionName);
			
			PositionDAO positionDao = new PositionDAO();
			int result = positionDao.setInsert(arguPositionDto);
			
			if (result > 0) {
				response.sendRedirect(path + "/position_servlet/list.do");
			} else {
				response.sendRedirect(path + "/position_servlet/chuga.do");
			}//if
			
		} else if (imsiUriFileName.equals("sujungProc.do")) {
			String positionNo_ = request.getParameter("positionNo");
			String positionName = request.getParameter("positionName");
			int positionNo = util.getNumberCheck(positionNo_, 0);
			
			PositionDTO arguPositionDto = new PositionDTO();
			arguPositionDto.setPositionNo(positionNo);
			arguPositionDto.setPositionName(positionName);
			
			PositionDAO positionDao = new PositionDAO();
			int result = positionDao.setUpdate(arguPositionDto);
			
			if (result > 0) {
				response.sendRedirect(path + "/position_servlet/view.do?positionNo=" + positionNo);
			} else {
				response.sendRedirect(path + "/position_servlet/sujung.do?positionNo=" + positionNo);
			}//if
			
		} else if (imsiUriFileName.equals("sakjeProc.do")) {
			String positionNo_ = request.getParameter("positionNo");
			int positionNo = util.getNumberCheck(positionNo_, 0);
			
			PositionDTO arguPositionDto = new PositionDTO();
			arguPositionDto.setPositionNo(positionNo);
			
			PositionDAO positionDao = new PositionDAO();
			int result = positionDao.setDelete(arguPositionDto);
			
			if (result > 0) {
				response.sendRedirect(path + "/position_servlet/list.do");
			} else {
				response.sendRedirect(path + "/position_servlet/sakje.do?positionNo=" + positionNo);
			}//if
			
		} else {
			System.out.println("없네..");
		}//if
	}//doProc
}//

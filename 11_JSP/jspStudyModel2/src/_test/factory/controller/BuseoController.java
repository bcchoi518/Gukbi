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
import _test.factory.model.dao.BuseoDAO;
import _test.factory.model.dto.BuseoDTO;

@WebServlet("/buseo_servlet/*")
public class BuseoController extends HttpServlet {
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
		
		String forwardPage = "/WEB-INF/_test/factory/buseo";
		
		if (imsiUriFileName.equals("list.do")) {
			BuseoDAO buseoDao = new BuseoDAO();
			ArrayList<BuseoDTO> buseoList = buseoDao.getSelectAll();
			
			request.setAttribute("list", buseoList);
			
			forwardPage += "/list.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (imsiUriFileName.equals("view.do")) {
			String buseoNo_ = request.getParameter("buseoNo");
			int buseoNo = util.getNumberCheck(buseoNo_, 0);
			
			BuseoDTO arguBuseoDto = new BuseoDTO();
			arguBuseoDto.setBuseoNo(buseoNo);
			
			BuseoDAO buseoDao = new BuseoDAO();
			BuseoDTO resultBuseoDto = buseoDao.getSelectOne(arguBuseoDto);
			
			request.setAttribute("dto", resultBuseoDto);
			
			forwardPage += "/view.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (imsiUriFileName.equals("chuga.do")) {
			forwardPage += "/chuga.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (imsiUriFileName.equals("sujung.do")) {
			String buseoNo_ = request.getParameter("buseoNo");
			int buseoNo = util.getNumberCheck(buseoNo_, 0);
			
			BuseoDTO arguBuseoDto = new BuseoDTO();
			arguBuseoDto.setBuseoNo(buseoNo);
			
			BuseoDAO buseoDao = new BuseoDAO();
			BuseoDTO resultBuseoDto = buseoDao.getSelectOne(arguBuseoDto);
			
			request.setAttribute("dto", resultBuseoDto);
			
			forwardPage += "/sujung.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (imsiUriFileName.equals("sakje.do")) {
			String buseoNo_ = request.getParameter("buseoNo");
			int buseoNo = util.getNumberCheck(buseoNo_, 0);
			
			BuseoDTO arguBuseoDto = new BuseoDTO();
			arguBuseoDto.setBuseoNo(buseoNo);
			
			BuseoDAO buseoDao = new BuseoDAO();
			BuseoDTO resultBuseoDto = buseoDao.getSelectOne(arguBuseoDto);
			
			request.setAttribute("dto", resultBuseoDto);
			
			forwardPage += "/sakje.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (imsiUriFileName.equals("chugaProc.do")) {
			String buseoName = request.getParameter("buseoName");
			
			BuseoDTO arguBuseoDto = new BuseoDTO();
			arguBuseoDto.setBuseoName(buseoName);
			
			BuseoDAO buseoDao = new BuseoDAO();
			int result = buseoDao.setInsert(arguBuseoDto);
			
			if (result > 0) {
				response.sendRedirect(path + "/buseo_servlet/list.do");
			} else {
				response.sendRedirect(path + "/buseo_servlet/chuga.do");
			}//if
			
		} else if (imsiUriFileName.equals("sujungProc.do")) {
			String buseoNo_ = request.getParameter("buseoNo");
			String buseoName = request.getParameter("buseoName");
			int buseoNo = util.getNumberCheck(buseoNo_, 0);
			
			BuseoDTO arguBuseoDto = new BuseoDTO();
			arguBuseoDto.setBuseoNo(buseoNo);
			arguBuseoDto.setBuseoName(buseoName);
			
			BuseoDAO buseoDao = new BuseoDAO();
			int result = buseoDao.setUpdate(arguBuseoDto);
			
			if (result > 0) {
				response.sendRedirect(path + "/buseo_servlet/view.do?buseoNo=" + buseoNo);
			} else {
				response.sendRedirect(path + "/buseo_servlet/sujung.do?buseoNo=" + buseoNo);
			}//if
			
		} else if (imsiUriFileName.equals("sakjeProc.do")) {
			String buseoNo_ = request.getParameter("buseoNo");
			int buseoNo = util.getNumberCheck(buseoNo_, 0);
			
			BuseoDTO arguBuseoDto = new BuseoDTO();
			arguBuseoDto.setBuseoNo(buseoNo);
			
			BuseoDAO buseoDao = new BuseoDAO();
			int result = buseoDao.setDelete(arguBuseoDto);
			
			if (result > 0) {
				response.sendRedirect(path + "/buseo_servlet/list.do");
			} else {
				response.sendRedirect(path + "/buseo_servlet/sakje.do?buseoNo=" + buseoNo);
			}//if
			
		} else {
			System.out.println("없네..");
		}//if
	}//doProc
}//

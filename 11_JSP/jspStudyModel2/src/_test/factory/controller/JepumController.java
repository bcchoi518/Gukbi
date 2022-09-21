package _test.factory.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import _common.Util;
import _test.factory.model.dao.JepumDAO;
import _test.factory.model.dto.JepumDTO;

@WebServlet("/jepum_servlet/*")
public class JepumController extends HttpServlet {
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
		
		String forwardPage = "/WEB-INF/_test/factory/jepum";
		
		if (imsiUriFileName.equals("list.do")) {
			JepumDAO jepumDao = new JepumDAO();
			ArrayList<JepumDTO> jepumList = jepumDao.getSelectAll();
			
			request.setAttribute("list", jepumList);
			
			forwardPage += "/list.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (imsiUriFileName.equals("view.do")) {
			String code = request.getParameter("code");
			
			JepumDTO arguJepumDto = new JepumDTO();
			arguJepumDto.setCode(code);
			
			JepumDAO jepumDao = new JepumDAO();
			JepumDTO resultJepumDto = jepumDao.getSelectOne(arguJepumDto);
			
			request.setAttribute("dto", resultJepumDto);
			
			forwardPage += "/view.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (imsiUriFileName.equals("chuga.do")) {
			forwardPage += "/chuga.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (imsiUriFileName.equals("sujung.do")) {
			String code = request.getParameter("code");
			
			JepumDTO arguJepumDto = new JepumDTO();
			arguJepumDto.setCode(code);
			
			JepumDAO jepumDao = new JepumDAO();
			JepumDTO resultJepumDto = jepumDao.getSelectOne(arguJepumDto);
			
			request.setAttribute("dto", resultJepumDto);
			
			forwardPage += "/sujung.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (imsiUriFileName.equals("sakje.do")) {
			String code = request.getParameter("code");
			
			JepumDTO arguJepumDto = new JepumDTO();
			arguJepumDto.setCode(code);
			
			JepumDAO jepumDao = new JepumDAO();
			JepumDTO resultJepumDto = jepumDao.getSelectOne(arguJepumDto);
			
			request.setAttribute("dto", resultJepumDto);
			
			forwardPage += "/sakje.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (imsiUriFileName.equals("chugaProc.do")) {
			String code = request.getParameter("code");
			String name = request.getParameter("name");
			String standard = request.getParameter("standard");
			String unit = request.getParameter("unit");
			String barcode = request.getParameter("barcode");
			
			JepumDTO arguJepumDto = new JepumDTO();
			arguJepumDto.setCode(code);
			arguJepumDto.setName(name);
			arguJepumDto.setStandard(standard);
			arguJepumDto.setUnit(unit);
			arguJepumDto.setBarcode(barcode);
			
			JepumDAO jepumDao = new JepumDAO();
			int result = jepumDao.setInsert(arguJepumDto);
			
			if (result > 0) {
				response.sendRedirect(path + "/jepum_servlet/list.do");
			} else {
				response.sendRedirect(path + "/jepum_servlet/chuga.do");
			}//if
			
		} else if (imsiUriFileName.equals("sujungProc.do")) {
			String code = request.getParameter("code");
			String name = request.getParameter("name");
			String standard = request.getParameter("standard");
			String unit = request.getParameter("unit");
			String barcode = request.getParameter("barcode");
			
			JepumDTO arguJepumDto = new JepumDTO();
			arguJepumDto.setCode(code);
			arguJepumDto.setName(name);
			arguJepumDto.setStandard(standard);
			arguJepumDto.setUnit(unit);
			arguJepumDto.setBarcode(barcode);
			
			JepumDAO jepumDao = new JepumDAO();
			int result = jepumDao.setUpdate(arguJepumDto);
			
			if (result > 0) {
				response.sendRedirect(path + "/jepum_servlet/view.do?code=" + code);
			} else {
				response.sendRedirect(path + "/jepum_servlet/sujung.do?code=" + code);
			}//if
			
		} else if (imsiUriFileName.equals("sakjeProc.do")) {
			String code = request.getParameter("code");
			
			JepumDTO arguJepumDto = new JepumDTO();
			arguJepumDto.setCode(code);
			
			JepumDAO jepumDao = new JepumDAO();
			int result = jepumDao.setDelete(arguJepumDto);
			
			if (result > 0) {
				response.sendRedirect(path + "/jepum_servlet/list.do");
			} else {
				response.sendRedirect(path + "/jepum_servlet/sakje.do?code=" + code);
			}//if
			
		} else {
			System.out.println("없네..");
		}//if
	}//doProc
}//

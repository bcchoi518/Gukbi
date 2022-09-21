package _test.haksa.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import _common.Util;
import _test.haksa.model.dao.SihumDAO;
import _test.haksa.model.dao.StudentDAO;
import _test.haksa.model.dao.SungjukDAO;
import _test.haksa.model.dto.SihumDTO;
import _test.haksa.model.dto.StudentDTO;
import _test.haksa.model.dto.SungjukDTO;

@WebServlet("/haksaSungjuk_servlet/*")
public class SungjukController extends HttpServlet {
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
		
		String forwardPage = "/WEB-INF/_test/haksa/sungjuk";
		
		if (imsiUriFileName.equals("list.do")) {
			SungjukDAO sungjukDao = new SungjukDAO();
			ArrayList<SungjukDTO> sungjukList = sungjukDao.getSelectAll();
			
			request.setAttribute("list", sungjukList);
			
			forwardPage += "/list.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (imsiUriFileName.equals("view.do")) {
			String sungjukNo_ = request.getParameter("sungjukNo");
			int sungjukNo = util.getNumberCheck(sungjukNo_, 0);
			
			SungjukDTO arguSungjukDto = new SungjukDTO();
			arguSungjukDto.setSungjukNo(sungjukNo);
			
			SungjukDAO sungjukDao = new SungjukDAO();
			SungjukDTO resultSungjukDto = sungjukDao.getSelectOne(arguSungjukDto);
			
			request.setAttribute("dto", resultSungjukDto);
			
			forwardPage += "/view.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (imsiUriFileName.equals("chuga.do")) {
			StudentDAO studentDao = new StudentDAO();
			ArrayList<StudentDTO> studentList = studentDao.getSelectAll();
			
			SihumDAO sihumDao = new SihumDAO();
			ArrayList<SihumDTO> sihumList = sihumDao.getSelectAll();
			
			request.setAttribute("studentList", studentList);
			request.setAttribute("sihumList", sihumList);
			
			forwardPage += "/chuga.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (imsiUriFileName.equals("sujung.do")) {
			String sungjukNo_ = request.getParameter("sungjukNo");
			int sungjukNo = util.getNumberCheck(sungjukNo_, 0);
			
			SungjukDTO arguSungjukDto = new SungjukDTO();
			arguSungjukDto.setSungjukNo(sungjukNo);
			
			SungjukDAO sungjukDao = new SungjukDAO();
			SungjukDTO resultSungjukDto = sungjukDao.getSelectOne(arguSungjukDto);
			
			StudentDAO studentDao = new StudentDAO();
			ArrayList<StudentDTO> studentList = studentDao.getSelectAll();
			
			SihumDAO sihumDao = new SihumDAO();
			ArrayList<SihumDTO> sihumList = sihumDao.getSelectAll();
			
			request.setAttribute("studentList", studentList);
			request.setAttribute("sihumList", sihumList);
			request.setAttribute("dto", resultSungjukDto);
			
			forwardPage += "/sujung.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (imsiUriFileName.equals("sakje.do")) {
			String sungjukNo_ = request.getParameter("sungjukNo");
			int sungjukNo = util.getNumberCheck(sungjukNo_, 0);
			
			SungjukDTO arguSungjukDto = new SungjukDTO();
			arguSungjukDto.setSungjukNo(sungjukNo);
			
			SungjukDAO sungjukDao = new SungjukDAO();
			SungjukDTO resultSungjukDto = sungjukDao.getSelectOne(arguSungjukDto);
			
			request.setAttribute("dto", resultSungjukDto);
			
			forwardPage += "/sakje.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (imsiUriFileName.equals("chugaProc.do")) {
			String hakbun_ = request.getParameter("hakbun");
			String sihumNo_ = request.getParameter("sihumNo");
			String kor_ = request.getParameter("kor");
			String eng_ = request.getParameter("eng");
			String mat_ = request.getParameter("mat");
			String sci_ = request.getParameter("sci");
			String his_ = request.getParameter("his");
			
			int hakbun = util.getNumberCheck(hakbun_, 0);
			int sihumNo = util.getNumberCheck(sihumNo_, 0);
			int kor = util.getNumberCheck(kor_, 0);
			int eng = util.getNumberCheck(eng_, 0);
			int mat = util.getNumberCheck(mat_, 0);
			int sci = util.getNumberCheck(sci_, 0);
			int his = util.getNumberCheck(his_, 0);
			
			SungjukDTO arguSungjukDto = new SungjukDTO();
			arguSungjukDto.setHakbun(hakbun);
			arguSungjukDto.setSihumNo(sihumNo);
			arguSungjukDto.setKor(kor);
			arguSungjukDto.setEng(eng);
			arguSungjukDto.setMat(mat);
			arguSungjukDto.setSci(sci);
			arguSungjukDto.setHis(his);
			arguSungjukDto.setTot();
			arguSungjukDto.setAvg();
			arguSungjukDto.setGrade();
			
			SungjukDAO sungjukDao = new SungjukDAO();
			int result = sungjukDao.setInsert(arguSungjukDto);
			
			if (result > 0) {
				response.sendRedirect(path + "/haksaSungjuk_servlet/list.do");
			} else {
				response.sendRedirect(path + "/haksaSungjuk_servlet/chuga.do");
			}//if
			
		} else if (imsiUriFileName.equals("sujungProc.do")) {
			String sungjukNo_ = request.getParameter("sungjukNo");
			String hakbun_ = request.getParameter("hakbun");
			String sihumNo_ = request.getParameter("sihumNo");
			String kor_ = request.getParameter("kor");
			String eng_ = request.getParameter("eng");
			String mat_ = request.getParameter("mat");
			String sci_ = request.getParameter("sci");
			String his_ = request.getParameter("his");
			
			int sungjukNo = util.getNumberCheck(sungjukNo_, 0);
			int hakbun = util.getNumberCheck(hakbun_, 0);
			int sihumNo = util.getNumberCheck(sihumNo_, 0);
			int kor = util.getNumberCheck(kor_, 0);
			int eng = util.getNumberCheck(eng_, 0);
			int mat = util.getNumberCheck(mat_, 0);
			int sci = util.getNumberCheck(sci_, 0);
			int his = util.getNumberCheck(his_, 0);
			
			SungjukDTO arguSungjukDto = new SungjukDTO();
			arguSungjukDto.setSungjukNo(sungjukNo);
			arguSungjukDto.setHakbun(hakbun);
			arguSungjukDto.setSihumNo(sihumNo);
			arguSungjukDto.setKor(kor);
			arguSungjukDto.setEng(eng);
			arguSungjukDto.setMat(mat);
			arguSungjukDto.setSci(sci);
			arguSungjukDto.setHis(his);
			arguSungjukDto.setTot();
			arguSungjukDto.setAvg();
			arguSungjukDto.setGrade();
			
			SungjukDAO sungjukDao = new SungjukDAO();
			int result = sungjukDao.setUpdate(arguSungjukDto);
			
			if (result > 0) {
				response.sendRedirect(path + "/haksaSungjuk_servlet/view.do?sungjukNo=" + sungjukNo);
			} else {
				response.sendRedirect(path + "/haksaSungjuk_servlet/sujung.do?sungjukNo=" + sungjukNo);
			}//if
			
		} else if (imsiUriFileName.equals("sakjeProc.do")) {
			String sungjukNo_ = request.getParameter("sungjukNo");
			int sungjukNo = util.getNumberCheck(sungjukNo_, 0);
			
			SungjukDTO arguSungjukDto = new SungjukDTO();
			arguSungjukDto.setSungjukNo(sungjukNo);
			
			SungjukDAO sungjukDao = new SungjukDAO();
			int result = sungjukDao.setDelete(arguSungjukDto);
			
			if (result > 0) {
				response.sendRedirect(path + "/haksaSungjuk_servlet/list.do");
			} else {
				response.sendRedirect(path + "/haksaSungjuk_servlet/sakje.do?sungjukNo=" + sungjukNo);
			}//if
			
		} else {
			System.out.println("없네..");
		}//if
	}//doProc
}//SungjukController

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
import _test.haksa.model.dao.StudentDAO;
import _test.haksa.model.dto.StudentDTO;


@WebServlet("/haksaStudent_servlet/*")
public class StudentController extends HttpServlet {
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
		
		String forwardPage = "/WEB-INF/_test/haksa/student";
		
		if (imsiUriFileName.equals("list.do")) {
			StudentDAO studentDao = new StudentDAO();
			ArrayList<StudentDTO> studentList = studentDao.getSelectAll();
			
			request.setAttribute("list", studentList);
			
			forwardPage += "/list.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (imsiUriFileName.equals("view.do")) {
			String hakbun_ = request.getParameter("hakbun");
			int hakbun = util.getNumberCheck(hakbun_, 0);
			
			StudentDTO arguStudentDto = new StudentDTO();
			arguStudentDto.setHakbun(hakbun);
			
			StudentDAO studentDao = new StudentDAO();
			StudentDTO resultStudentDto = studentDao.getSelectOne(arguStudentDto);
			
			request.setAttribute("dto", resultStudentDto);
			
			forwardPage += "/view.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (imsiUriFileName.equals("chuga.do")) {
			forwardPage += "/chuga.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (imsiUriFileName.equals("sujung.do")) {
			String hakbun_ = request.getParameter("hakbun");
			int hakbun = util.getNumberCheck(hakbun_, 0);
			
			StudentDTO arguStudentDto = new StudentDTO();
			arguStudentDto.setHakbun(hakbun);
			
			StudentDAO studentDao = new StudentDAO();
			StudentDTO resultStudentDto = studentDao.getSelectOne(arguStudentDto);
			
			request.setAttribute("dto", resultStudentDto);
			
			forwardPage += "/sujung.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (imsiUriFileName.equals("sakje.do")) {
			String hakbun_ = request.getParameter("hakbun");
			int hakbun = util.getNumberCheck(hakbun_, 0);
			
			StudentDTO arguStudentDto = new StudentDTO();
			arguStudentDto.setHakbun(hakbun);
			
			StudentDAO studentDao = new StudentDAO();
			StudentDTO resultStudentDto = studentDao.getSelectOne(arguStudentDto);
			
			request.setAttribute("dto", resultStudentDto);
			
			forwardPage += "/sakje.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (imsiUriFileName.equals("chugaProc.do")) {
			String name = request.getParameter("name");
			String phone = request.getParameter("phone");
			String parentPhone = request.getParameter("parentPhone");
			String addr1 = request.getParameter("addr1");
			String addr2 = request.getParameter("addr2");
			String addr3 = request.getParameter("addr3");
			String addr4 = request.getParameter("addr4");
			
			if (addr4.equals("")) {
				addr4 = "-";
			}//if
			
			StudentDTO arguStudentDto = new StudentDTO();
			arguStudentDto.setName(name);
			arguStudentDto.setPhone(phone);
			arguStudentDto.setParentPhone(parentPhone);
			arguStudentDto.setAddr1(addr1);
			arguStudentDto.setAddr2(addr2);
			arguStudentDto.setAddr3(addr3);
			arguStudentDto.setAddr4(addr4);
			
			StudentDAO studentDao = new StudentDAO();
			int result = studentDao.setInsert(arguStudentDto);
			
			if (result > 0) {
				response.sendRedirect(path + "/haksaStudent_servlet/list.do");
			} else {
				response.sendRedirect(path + "/haksaStudent_servlet/chuga.do");
			}//if
			
		} else if (imsiUriFileName.equals("sujungProc.do")) {
			String hakbun_ = request.getParameter("hakbun");
			int hakbun = util.getNumberCheck(hakbun_, 0);
			String phone = request.getParameter("phone");
			String parentPhone = request.getParameter("parentPhone");
			String addr1 = request.getParameter("addr1");
			String addr2 = request.getParameter("addr2");
			String addr3 = request.getParameter("addr3");
			String addr4 = request.getParameter("addr4");
			
			if (addr4.equals("")) {
				addr4 = "-";
			}//if
			
			StudentDTO arguStudentDto = new StudentDTO();
			arguStudentDto.setHakbun(hakbun);
			arguStudentDto.setPhone(phone);
			arguStudentDto.setParentPhone(parentPhone);
			arguStudentDto.setAddr1(addr1);
			arguStudentDto.setAddr2(addr2);
			arguStudentDto.setAddr3(addr3);
			arguStudentDto.setAddr4(addr4);
			
			StudentDAO studentDao = new StudentDAO();
			int result = studentDao.setUpdate(arguStudentDto);
			
			if (result > 0) {
				response.sendRedirect(path + "/haksaStudent_servlet/view.do?hakbun=" + hakbun);
			} else {
				response.sendRedirect(path + "/haksaStudent_servlet/sujung.do?hakbun=" + hakbun);
			}//if
			
		} else if (imsiUriFileName.equals("sakjeProc.do")) {
			String hakbun_ = request.getParameter("hakbun");
			int hakbun = util.getNumberCheck(hakbun_, 0);
			
			StudentDTO arguStudentDto = new StudentDTO();
			arguStudentDto.setHakbun(hakbun);
			
			StudentDAO studentDao = new StudentDAO();
			int result = studentDao.setDelete(arguStudentDto);
			
			if (result > 0) {
				response.sendRedirect(path + "/haksaStudent_servlet/list.do");
			} else {
				response.sendRedirect(path + "/haksaStudent_servlet/sakje.do?hakbun=" + hakbun);
			}//if
			
		} else {
			System.out.println("없네..");
		}//if
	}//doProc
}//StudentController

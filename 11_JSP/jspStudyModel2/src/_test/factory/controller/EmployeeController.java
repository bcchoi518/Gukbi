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
import _test.factory.model.dao.EmployeeDAO;
import _test.factory.model.dao.PositionDAO;
import _test.factory.model.dto.BuseoDTO;
import _test.factory.model.dto.EmployeeDTO;
import _test.factory.model.dto.PositionDTO;

@WebServlet("/employee_servlet/*")
public class EmployeeController extends HttpServlet {
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
		
		String forwardPage = "/WEB-INF/_test/factory/employee";
		
		if (imsiUriFileName.equals("list.do")) {
			EmployeeDAO employeeDao = new EmployeeDAO();
			ArrayList<EmployeeDTO> employeeList = employeeDao.getSelectAll();
			
			request.setAttribute("list", employeeList);
			
			forwardPage += "/list.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (imsiUriFileName.equals("view.do")) {
			String sabun_ = request.getParameter("sabun");
			int sabun = util.getNumberCheck(sabun_, 0);
			
			EmployeeDTO arguEmployeeDto = new EmployeeDTO();
			arguEmployeeDto.setSabun(sabun);
			
			EmployeeDAO employeeDao = new EmployeeDAO();
			EmployeeDTO resultEmployeeDto = employeeDao.getSelectOne(arguEmployeeDto);
			
			request.setAttribute("dto", resultEmployeeDto);
			
			forwardPage += "/view.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (imsiUriFileName.equals("chuga.do")) {
			BuseoDAO buseoDao = new BuseoDAO();
			ArrayList<BuseoDTO> buseoList = buseoDao.getSelectAll();
			
			PositionDAO positionDao = new PositionDAO();
			ArrayList<PositionDTO> positionList = positionDao.getSelectAll();
			
			request.setAttribute("buseoList", buseoList);
			request.setAttribute("positionList", positionList);
			
			forwardPage += "/chuga.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (imsiUriFileName.equals("sujung.do")) {
			String sabun_ = request.getParameter("sabun");
			int sabun = util.getNumberCheck(sabun_, 0);
			
			EmployeeDTO arguEmployeeDto = new EmployeeDTO();
			arguEmployeeDto.setSabun(sabun);
			
			EmployeeDAO employeeDao = new EmployeeDAO();
			EmployeeDTO resultEmployeeDto = employeeDao.getSelectOne(arguEmployeeDto);
			
			BuseoDAO buseoDao = new BuseoDAO();
			ArrayList<BuseoDTO> buseoList = buseoDao.getSelectAll();
			
			PositionDAO positionDao = new PositionDAO();
			ArrayList<PositionDTO> positionList = positionDao.getSelectAll();
			
			request.setAttribute("buseoList", buseoList);
			request.setAttribute("positionList", positionList);
			request.setAttribute("dto", resultEmployeeDto);
			
			forwardPage += "/sujung.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (imsiUriFileName.equals("sakje.do")) {
			String sabun_ = request.getParameter("sabun");
			int sabun = util.getNumberCheck(sabun_, 0);
			
			EmployeeDTO arguEmployeeDto = new EmployeeDTO();
			arguEmployeeDto.setSabun(sabun);
			
			EmployeeDAO employeeDao = new EmployeeDAO();
			EmployeeDTO resultEmployeeDto = employeeDao.getSelectOne(arguEmployeeDto);
			
			request.setAttribute("dto", resultEmployeeDto);
			
			forwardPage += "/sakje.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (imsiUriFileName.equals("chugaProc.do")) {
			String name = request.getParameter("name");
			String phone = request.getParameter("phone");
			String hireDate_ = request.getParameter("hireDate");
			String email = request.getParameter("email");
			String salary_ = request.getParameter("salary");
			String buseoNo_ = request.getParameter("buseoNo");
			String positionNo_ = request.getParameter("positionNo");
			Date hireDate = Date.valueOf(hireDate_);
			int salary = util.getNumberCheck(salary_, 0);
			int buseoNo = util.getNumberCheck(buseoNo_, 0);
			int positionNo = util.getNumberCheck(positionNo_, 0);
			
			EmployeeDTO arguEmployeeDto = new EmployeeDTO();
			arguEmployeeDto.setName(name);
			arguEmployeeDto.setPhone(phone);
			arguEmployeeDto.setHireDate(hireDate);
			arguEmployeeDto.setEmail(email);
			arguEmployeeDto.setSalary(salary);
			arguEmployeeDto.setBuseoNo(buseoNo);
			arguEmployeeDto.setPositionNo(positionNo);
			
			EmployeeDAO employeeDao = new EmployeeDAO();
			int result = employeeDao.setInsert(arguEmployeeDto);
			
			if (result > 0) {
				response.sendRedirect(path + "/employee_servlet/list.do");
			} else {
				response.sendRedirect(path + "/employee_servlet/chuga.do");
			}//if
			
		} else if (imsiUriFileName.equals("sujungProc.do")) {
			String sabun_ = request.getParameter("sabun");
			int sabun = util.getNumberCheck(sabun_, 0);
			String name = request.getParameter("name");
			String phone = request.getParameter("phone");
			String hireDate_ = request.getParameter("hireDate");
			String email = request.getParameter("email");
			String salary_ = request.getParameter("salary");
			String buseoNo_ = request.getParameter("buseoNo");
			String positionNo_ = request.getParameter("positionNo");
			Date hireDate = Date.valueOf(hireDate_);
			int salary = util.getNumberCheck(salary_, 0);
			int buseoNo = util.getNumberCheck(buseoNo_, 0);
			int positionNo = util.getNumberCheck(positionNo_, 0);
			
			EmployeeDTO arguEmployeeDto = new EmployeeDTO();
			arguEmployeeDto.setSabun(sabun);
			arguEmployeeDto.setName(name);
			arguEmployeeDto.setPhone(phone);
			arguEmployeeDto.setHireDate(hireDate);
			arguEmployeeDto.setEmail(email);
			arguEmployeeDto.setSalary(salary);
			arguEmployeeDto.setBuseoNo(buseoNo);
			arguEmployeeDto.setPositionNo(positionNo);
			
			EmployeeDAO employeeDao = new EmployeeDAO();
			int result = employeeDao.setUpdate(arguEmployeeDto);
			
			if (result > 0) {
				response.sendRedirect(path + "/employee_servlet/view.do?sabun=" + sabun);
			} else {
				response.sendRedirect(path + "/employee_servlet/sujung.do?sabun=" + sabun);
			}//if
			
		} else if (imsiUriFileName.equals("sakjeProc.do")) {
			String sabun_ = request.getParameter("sabun");
			int sabun = util.getNumberCheck(sabun_, 0);
			
			EmployeeDTO arguEmployeeDto = new EmployeeDTO();
			arguEmployeeDto.setSabun(sabun);
			
			EmployeeDAO employeeDao = new EmployeeDAO();
			int result = employeeDao.setDelete(arguEmployeeDto);
			
			if (result > 0) {
				response.sendRedirect(path + "/employee_servlet/list.do");
			} else {
				response.sendRedirect(path + "/employee_servlet/sakje.do?sabun=" + sabun);
			}//if
			
		} else {
			System.out.println("없네..");
		}//if
	}//doProc
}//

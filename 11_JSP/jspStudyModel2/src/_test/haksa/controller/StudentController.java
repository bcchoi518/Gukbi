package _test.haksa.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import _common.Util;


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
			forwardPage += "/list.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (imsiUriFileName.equals("view.do")) {
			forwardPage += "/view.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (imsiUriFileName.equals("chuga.do")) {
			forwardPage += "/chuga.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (imsiUriFileName.equals("sujung.do")) {
			forwardPage += "/sujung.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (imsiUriFileName.equals("sakje.do")) {
			forwardPage += "/sakje.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (imsiUriFileName.equals("chugaProc.do")) {
			
		} else if (imsiUriFileName.equals("sujungProc.do")) {
			
		} else if (imsiUriFileName.equals("sakjeProc.do")) {
			
		} else {
			System.out.println("없네..");
		}//if
	}//doProc

}//StudentController

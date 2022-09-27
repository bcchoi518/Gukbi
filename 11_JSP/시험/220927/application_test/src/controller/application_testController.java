package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.Application_testDAO;
import model.dto.Application_testDTO;

@WebServlet("/")
public class application_testController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProc(request, response);
	}//doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProc(request, response);
	}//doPost
	
	protected void doProc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String path = request.getContextPath();
		request.setAttribute("path", path);
		
		String uri = request.getRequestURI().toString();
		String[] tmp = uri.split("/");
		String fileName = tmp[tmp.length - 1];
		
		String forwardPage = "/WEB-INF/application_test";
		if (fileName.equals(path.substring(1))) {
			response.sendRedirect(path + "/main");
			
		} else if (fileName.equals("login")) {
			forwardPage += "/login.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (fileName.equals("loginProc")) {
			String id = request.getParameter("id");
			String passwd = request.getParameter("passwd");
			
			int failCounter = 0;
			if (id == null || id.trim().equals("")) {
				failCounter++;
			} else if (passwd == null || passwd.trim().equals("")) {
				failCounter++;
			}//if
			
			if (failCounter > 0) {
				return;
			}//if
			
			Application_testDTO arguDto = new Application_testDTO();
			arguDto.setId(id);
			arguDto.setPasswd(passwd);
			
			Application_testDAO dao = new Application_testDAO();
			Application_testDTO returnDto = dao.getLogin(arguDto);
			
			String msg = "입력된 정보가 일치하지 않습니다.\\n확인 후 다시 이용해주세요.";
			if (returnDto.getLoginResult() > 0) {
				msg = "정상적으로 로그인되었습니다.";
				HttpSession session = request.getSession();
				session.setMaxInactiveInterval(1*60);
				
				session.setAttribute("sessionId", returnDto.getId());
			}//if
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('"+ msg +"');");
			out.println("location.href = '"+ path +"';");
			out.println("</script>");
			out.flush();
			out.close();
			return;
			
		} else if (fileName.equals("logout")) {
			HttpSession session = request.getSession();
			session.invalidate();
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그아웃 되었습니다. 다음에 또 이용해주세요.');");
			out.println("location.href = '"+ path +"';");
			out.println("</script>");
			out.flush();
			out.close();
			return;
			
		} else if (fileName.equals("main")) {
			HttpSession session = request.getSession();
			String id = (String) session.getAttribute("sessionId");
			System.out.println("sessionId: " + id);
			
			if (id == null) {
				System.out.println("sessionId가 null이므로 로그인 페이지로 이동");
				response.sendRedirect(path + "/login");
				return;
			}//if
			
			Application_testDTO arguDto = new Application_testDTO();
			arguDto.setId(id);
			
			Application_testDAO dao = new Application_testDAO();
			int result = dao.getCheckChangeDate(arguDto);
			
			if (result >= 6) {
				System.out.println("changeDate가 6개월 이상이므로 비밀번호 변경 페이지로 이동");
				response.sendRedirect(path + "/change");
				return;
			}//if
			
			forwardPage += "/main.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (fileName.equals("change")) {
			HttpSession session = request.getSession();
			String id = (String) session.getAttribute("sessionId");
			System.out.println("sessionId: " + id);
			
			if (id == null) {
				System.out.println("sessionId가 null이므로 로그인 페이지로 이동");
				response.sendRedirect(path + "/login");
				return;
			}//if
			
			forwardPage += "/change.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (fileName.equals("changeProc")) {
			HttpSession session = request.getSession();
			String id = (String) session.getAttribute("sessionId");
			System.out.println("sessionId: " + id);
			
			if (id == null) {
				System.out.println("sessionId가 null이므로 로그인 페이지로 이동");
				response.sendRedirect(path + "/login");
				return;
			}//if
			
			id = request.getParameter("id");
			String passwd = request.getParameter("passwd");
			String passwdChk = request.getParameter("passwdChk");
			
			int failCounter = 0;
			if (id == null || id.trim().equals("")) {
				failCounter++;
			} else if (passwd == null || passwd.trim().equals("")) {
				failCounter++;
			} else if (passwdChk == null || passwdChk.trim().equals("")) {
				failCounter++;
			} else if (!passwd.equals(passwdChk)) {
				failCounter++;
			}//if
			
			if (failCounter > 0) {
				return;
			}//if
			
			Application_testDTO arguDto = new Application_testDTO();
			arguDto.setId(id);
			arguDto.setPasswd(passwd);
			
			Application_testDAO dao = new Application_testDAO();
			int result = dao.setUpdatePasswd(arguDto);
			
			if (result > 0) {
				response.sendRedirect(path + "/main");
			} else {
				response.sendRedirect(path + "/change");
			}//if
		}//if
	}//doProc
}//application_testController

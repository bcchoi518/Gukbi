package application_baepo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import application_baepo.model.dao.Application_baepoDAO;
import application_baepo.model.dto.Application_baepoDTO;

@WebServlet("/")
public class Application_baepoController extends HttpServlet {
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
		String[] uriArray = uri.split("/");
		String fileName = uriArray[uriArray.length - 1];
		
		String forwardPage = "/WEB-INF/application_baepo";
		if (fileName.equals(path.substring(1))) {
			response.sendRedirect(path + "/list");
			
		} else if (fileName.equals("list")) {
			Application_baepoDAO application_baepoDao = new Application_baepoDAO();
			List<Application_baepoDTO> application_baepoList = application_baepoDao.getSelectAll();
			
			request.setAttribute("list", application_baepoList);
			
			forwardPage += "/list.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (fileName.equals("join")) {
			forwardPage += "/join.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (fileName.equals("joinProc")) {
			String id = request.getParameter("id");
			String passwd = request.getParameter("passwd");
			String passwdChk = request.getParameter("passwdChk");
			String name = request.getParameter("name");
			String gender = request.getParameter("gender");
			String birthYear = request.getParameter("birthYear");
			String addr1 = request.getParameter("addr1");
			String addr2 = request.getParameter("addr2");
			String addr3 = request.getParameter("addr3");
			String addr4 = request.getParameter("addr4");
			
			int failCounter = 0;
			if (id == null || id.trim().equals("")) {
				failCounter++;
			} else if (passwd == null || passwd.trim().equals("")) {
				failCounter++;
			} else if (passwdChk == null || passwdChk.trim().equals("")) {
				failCounter++;
			} else if (!passwd.equals(passwdChk)) {
				failCounter++;
			} else if (name == null || name.trim().equals("")) {
				failCounter++;
			} else if (gender == null || gender.trim().equals("")) {
				failCounter++;
			} else if (!(gender.equals("M") || gender.equals("F"))) {
				failCounter++;
			} else if (birthYear == null || birthYear.trim().equals("")) {
				failCounter++;
			} else if (addr1 == null || addr1.trim().equals("")) {
				failCounter++;
			} else if (addr2 == null || addr2.trim().equals("")) {
				failCounter++;
			} else if (addr3 == null || addr3.trim().equals("")) {
				failCounter++;
			} else if (addr4 == null || addr4.trim().equals("")) {
				addr4 = "-";
			}//if
			
			if (failCounter > 0) {
				System.out.println("-- 입력값 오류 --");
				return;
			}//if
			
			Application_baepoDTO arguApplication_baepoDto = new Application_baepoDTO();
			arguApplication_baepoDto.setId(id);
			arguApplication_baepoDto.setPasswd(passwd);
			arguApplication_baepoDto.setName(name);
			arguApplication_baepoDto.setGender(gender);
			arguApplication_baepoDto.setBirthYear(birthYear);
			arguApplication_baepoDto.setAddr1(addr1);
			arguApplication_baepoDto.setAddr2(addr2);
			arguApplication_baepoDto.setAddr3(addr3);
			arguApplication_baepoDto.setAddr4(addr4);
			
			Application_baepoDAO application_baepoDao = new Application_baepoDAO();
			int result = application_baepoDao.setInsert(arguApplication_baepoDto);
			
			if (result > 0) {
				response.sendRedirect(path + "/list");
			} else {
				response.sendRedirect(path + "/join");
			}//if
			
		} else if (fileName.equals("view")) {
			String no_ = request.getParameter("no");
			int no = 0;
			try {
				no = Integer.parseInt(no_);
			} catch (Exception e) {
				no = 0;
			}//try-catch
			
			if (no <= 0) {
				System.out.println("-- wrong no --");
				return;
			}//if
			
			Application_baepoDTO arguApplication_baepoDto = new Application_baepoDTO();
			arguApplication_baepoDto.setNo(no);
			
			Application_baepoDAO application_baepoDao = new Application_baepoDAO();
			Application_baepoDTO returnApplication_baepoDto = application_baepoDao.getSelectOne(arguApplication_baepoDto);
			
			request.setAttribute("dto", returnApplication_baepoDto);
			
			forwardPage += "/view.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
		}//if
	}//doProc
}//Application_baepoController

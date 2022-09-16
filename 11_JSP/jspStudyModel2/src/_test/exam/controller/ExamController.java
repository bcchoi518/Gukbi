package _test.exam.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/exam_servlet/*") //url-mapping
public class ExamController extends HttpServlet {
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
		String url = request.getRequestURL().toString();
		String uri = request.getRequestURI().toString();
		
//		System.out.println("path: " + path);
//		System.out.println("url: " + url);
//		System.out.println("uri: " + uri);
		
//		if (url.indexOf("01.do") != -1) {
//			System.out.println(111);
//		} else if (url.indexOf("02.do") != -1) {
//			System.out.println(222);
//		}//if
		
//		if (url.contains("01.do")) {
//			System.out.println(333);
//		} else if (url.contains("02.do")) {
//			System.out.println(444);
//		} else {
//			System.out.println("없네..");
//		}//if
		
		String[] imsiUriArray = uri.split("/");
		String imsiUriFileName = imsiUriArray[imsiUriArray.length - 1];
		
		String forwardPage = "/WEB-INF/_test/exam";
		if (imsiUriFileName.equals("01.do")) {
			forwardPage += "/01.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (imsiUriFileName.equals("01Proc.do")) {
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String age_ = request.getParameter("age");
			if (age_ == null || age_.trim().equals("")) {
				age_ = "0";
			}//if
			int age = Integer.parseInt(age_);
			
			//결과 페이지에 값을 보내기 위해 request객체에 속성값을 설정
			request.setAttribute("name", name);
			request.setAttribute("address", address);
			request.setAttribute("age", age);
			
			//결과 페이지에서 값을 사용하기 위해서 포워딩을 해야함
			forwardPage += "/01Result.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (imsiUriFileName.equals("02.do")) {
			forwardPage += "/02.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (imsiUriFileName.equals("02Proc.do")) {
			String name = request.getParameter("name");
			String birthYear = request.getParameter("birthYear");
			int age = 2022 - Integer.parseInt(birthYear);
			
			request.setAttribute("name", name);
			request.setAttribute("birthYear", birthYear);
			request.setAttribute("age", age);
			
			forwardPage += "/02Result.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (imsiUriFileName.equals("03.do")) {
			forwardPage += "/03.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (imsiUriFileName.equals("03Proc.do")) {
			String name = request.getParameter("name");
			String regiNumber = request.getParameter("regiNumber");
			String address = request.getParameter("address");
			String gender_ = regiNumber.substring(7, 8);
			String birth = regiNumber.substring(0, 2);

			String gender = "여자";
			if (gender_.equals("1") || gender_.equals("3")) {
				gender = "남자";
			}//if
			
			int imsiValue = 2000;
			if (gender_.equals("1") || gender_.equals("2")) {
				imsiValue = 1900;
			}//if
			int age = 2022 - (imsiValue + Integer.parseInt(birth));
			
			request.setAttribute("name", name);
			request.setAttribute("regiNumber", regiNumber);
			request.setAttribute("address", address);
			request.setAttribute("gender", gender);
			request.setAttribute("age", age);
			
			forwardPage += "/03Result.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (imsiUriFileName.equals("04.do")) {
			forwardPage += "/04.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (imsiUriFileName.equals("04Proc.do")) {
			String formCounter_ = request.getParameter("formCounter");
			int formCounter = Integer.parseInt(formCounter_);

			ArrayList<String> list = new ArrayList<>();
			
			for (int i = 1; i <= formCounter; i++) {
				String name = request.getParameter("name_" + i);
				String address = request.getParameter("address_" + i);
				String age_ = request.getParameter("age_" + i);
				int age = Integer.parseInt(age_);
				
				String msg = name + "|" + address + "|" + age;
				list.add(msg);
			}//for
			
			request.setAttribute("list", list); //request 객체에 값을 담는다
			
			forwardPage += "/04Result.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (imsiUriFileName.equals("05.do")) {
			forwardPage += "/05.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (imsiUriFileName.equals("05Proc.do")) {
			String[] names = request.getParameterValues("name");
			String name = "";
			for (int i = 0; i < names.length; i++) {
				if (i != 0) {
					name += ",";
				}//if
				name += names[i];
			}//for
			String gender = request.getParameter("gender");
			String aboutAge = request.getParameter("aboutAge");
			String[] hobbys = request.getParameterValues("hobby");
			String hobby = "";
			for (int i = 0; i < hobbys.length; i++) {
				if (i != 0) {
					hobby += ",";
				}//if
				hobby += hobbys[i];
			}//for
			String age_ = request.getParameter("age");
			int age = Integer.parseInt(age_);
			String memo = request.getParameter("memo");
			String birthDay_ = request.getParameter("birthDay");
			Date birthDay = Date.valueOf(birthDay_);
			
			HashMap<String, String> map = new HashMap<>();
			map.put("name", name);
			map.put("gender", gender);
			map.put("aboutAge", aboutAge);
			map.put("hobby", hobby);
			map.put("age", age + "");
			map.put("memo", memo);
			map.put("birthDay", birthDay + "");
			
			request.setAttribute("map", map);
			
			forwardPage += "/05Result.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (imsiUriFileName.equals("06.do")) {
			forwardPage += "/06.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (imsiUriFileName.equals("06Proc.do")) {
			String testDbId = "hong";
			String testDbPw = "1234";
			
			String id = request.getParameter("id");
			String passwd = request.getParameter("passwd");
			
			String result = "X";
			if (id.trim().equals(testDbId) && passwd.trim().equals(testDbPw)) {
				result = "O";
			}//if
			
			request.setAttribute("id", id);
			request.setAttribute("result", result);
			
			forwardPage += "/06Result1.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
//			response.sendRedirect("/jspStudyModel2/exam_servlet/06Proc2.do?id=" + id + "&result=" + result);
			
		} else if (imsiUriFileName.equals("06Proc2.do")) {
			String id = request.getParameter("id");
			String result = request.getParameter("result");
			
			request.setAttribute("id", id);
			request.setAttribute("result", result);
			
			forwardPage += "/06Result2.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (imsiUriFileName.equals("07.do")) {
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String age_ = request.getParameter("age");
			
			if (name == null || name.trim().equals("")) {
				name = "";
			}//if
			if (address == null || address.trim().equals("")) {
				address = "";
			}//if
			if (age_ == null || age_.trim().equals("")) {
				age_ = "";
			}//if
//			int age = Integer.parseInt(age_);
			
			request.setAttribute("name", name);
			request.setAttribute("address", address);
			request.setAttribute("age", age_);
			
			forwardPage += "/07.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (imsiUriFileName.equals("07Proc.do")) {
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String age_ = request.getParameter("age");
			if (age_ == null || age_.trim().equals("")) {
				age_ = "0";
			}//if
			int age = Integer.parseInt(age_);
			
			request.setAttribute("name", name);
			request.setAttribute("address", address);
			request.setAttribute("age", age);
			
			forwardPage += "/07Result.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (imsiUriFileName.equals("08.do")) {
			forwardPage += "/08.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (imsiUriFileName.equals("09.do")) {
			forwardPage += "/09.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else {
			System.out.println("없네..");
		}//if
	}//doProc
}//ExamController

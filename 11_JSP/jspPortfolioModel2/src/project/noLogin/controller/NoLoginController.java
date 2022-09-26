package project.noLogin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.common.Util;
import project.member.model.dao.MemberDAO;
import project.member.model.dto.MemberDTO;

@WebServlet("/noLogin_servlet/*")
public class NoLoginController extends HttpServlet {
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
		
//serverInfo Start
		String[] serverInfo = util.getServerInfo(request);
		String referer = serverInfo[0];
		String path = serverInfo[1];
		String url = serverInfo[2];
		String uri = serverInfo[3];
		String ip = serverInfo[4];
		String ip6 = serverInfo[5];
		String folderName = serverInfo[6];
		String fileName = serverInfo[7];
		
		request.setAttribute("referer", referer);
		request.setAttribute("path", path);
		request.setAttribute("ip", ip);
		request.setAttribute("folderName", folderName);
		request.setAttribute("fileName", fileName);
//serverInfo End
		
		String forwardPage = "/WEB-INF/project/main/main.jsp";
		if (fileName.equals("login")) {
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (fileName.equals("loginProc")) {
			String id = request.getParameter("id");
			String passwd = request.getParameter("passwd");
			
			id = util.getNullBlankCheck(id);
			passwd = util.getNullBlankCheck(passwd);
			
			int failCounter = 0;
			if (id.equals("")) {
				failCounter++;
			} else if (passwd.equals("")) {
				failCounter++;
			}//if
			
			if (failCounter > 0) {
				System.out.println("failCounter: " + failCounter);
				return;
			}//if
			
			id = util.getCheckString(id);
			passwd = util.getCheckString(passwd);
			
			MemberDTO arguMemberDto = new MemberDTO();
			arguMemberDto.setId(id);
			arguMemberDto.setPasswd(passwd);
			
			MemberDAO memberDao = new MemberDAO();
			MemberDTO returnMemberDto = memberDao.getLogin(arguMemberDto);
			
			String msg = "아이디 또는 비밀번호가 다릅니다.\\n다시 이용해주세요..";
			if (returnMemberDto.getNo() > 0) {
				msg = "정상적으로 로그인되었습니다.";
				HttpSession session = request.getSession();
				//session.setMaxInactiveInterval(1*60); //초 단위
				
				session.setAttribute("sessionNo", returnMemberDto.getNo());
				session.setAttribute("sessionId", returnMemberDto.getId());
				session.setAttribute("sessionName", returnMemberDto.getName());
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
			out.println("alert('로그아웃 되었습니다.\\n즐거운 하루 되세요.');");
			out.println("location.href = '"+ path +"';");
			out.println("</script>");
			out.flush();
			out.close();
			return;
		}//if
	}//doProc

}//NoLoginController

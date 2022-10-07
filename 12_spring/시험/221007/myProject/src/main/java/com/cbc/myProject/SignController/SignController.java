package com.cbc.myProject.SignController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cbc.myProject.member.model.dto.MemberDTO;
import com.cbc.myProject.member.service.MemberService;

@Controller
public class SignController {
	
	@Inject
	MemberService memberService;
	
	@RequestMapping("/signIn")
	public String signIn(Model model) {
		
		return "signIn/signIn";
	}//signIn
	
	@RequestMapping("/signInProc")
	public String signInProc(Model model, @ModelAttribute MemberDTO arguDto, HttpSession session) {
		String id = arguDto.getId();
		String passwd = arguDto.getPasswd();
		
		int failCounter = 0;
		if (id == null || id.trim().equals("")) {
			failCounter++;
		} else if (passwd == null || passwd.trim().equals("")) {
			failCounter++;
		}//if
		
		if (failCounter > 0) {
			return "redirect:/signIn";
		}//if
		
		int result = memberService.getSignIn(arguDto);
		
		if (result > 0) {
			session.setMaxInactiveInterval(1*60);
			session.setAttribute("sessionNo", result);
		} else {
			return "redirect:/signIn";
		}//if
		
		int changePwResult = memberService.getPwCheck(arguDto);
		
		if (changePwResult >= 6) {
			return "redirect:/changePw";
		}//if
		
		return "redirect:/";
	}//signInProc
	
	@RequestMapping("/signUp")
	public String signUp(Model model) {
		
		return "member/signUp";
	}//signUp
	
	@RequestMapping("/signUpProc")
	public String signUpProc(Model model, @ModelAttribute MemberDTO arguDto) {

		int failCounter = 0;
		if (arguDto.getId().trim().equals("") ) {
			failCounter++;
		} else if (arguDto.getTempId().trim().equals("")) {
			failCounter++;
		} else if (arguDto.getPasswd().trim().equals("")) {
			failCounter++;
		} else if (arguDto.getPasswdChk().trim().equals("")) {
			failCounter++;
		} else if (arguDto.getName().trim().equals("")) {
			failCounter++;
		} else if (arguDto.getPhone1().trim().equals("")) {
			failCounter++;
		} else if (arguDto.getPhone2().trim().equals("")) {
			failCounter++;
		} else if (arguDto.getPhone3().trim().equals("")) {
			failCounter++;
		} else if (arguDto.getEmail1().trim().equals("")) {
			failCounter++;
		} else if (arguDto.getEmail2().trim().equals("")) {
			failCounter++;
		} else if (arguDto.getPostcode().trim().equals("")) {
			failCounter++;
		} else if (arguDto.getAddress().trim().equals("")) {
			failCounter++;
		} else if (arguDto.getDetailAddress().trim().equals("")) {
			failCounter++;
		} else if (arguDto.getExtraAddress().trim().equals("")) {
			arguDto.setExtraAddress("-");
		} else if (!arguDto.getPasswd().equals(arguDto.getPasswdChk())) {
			failCounter++;
		}//if
		
		if (failCounter > 0) {
			System.out.println("입력값 오류");
			return "redirect:/signUp";
		}//if
		
		int result = memberService.setInsert(arguDto);
		
		if (result <= 0) {
			return "redirect:/signUp";
		}//if
		
		return "redirect:/signIn";
	}//signUpProc
	
	@RequestMapping("/idCheck")
	public String idCheck(Model model, @ModelAttribute MemberDTO arguDto, HttpServletResponse response) {
		if (arguDto.getId().trim().equals("")) {
			return "redirect:/signUp";
		}//if
		
		int result = memberService.getIdCheck(arguDto);
		
		response.setContentType("text/html; charset=UTF-8");
		try {
			PrintWriter out = response.getWriter();
			out.println(result);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}//try-catch
		return "redirect:/signUp";
	}//idCheck
	
	@RequestMapping("/signOut")
	public String signOut(Model model, HttpSession session) {
		session.invalidate();
		
		return "redirect:/";
	}//signUp
}//SignController

package com.cbc.springPortfolio.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cbc.springPortfolio.common.Util;
import com.cbc.springPortfolio.member.model.dto.MemberDTO;
import com.cbc.springPortfolio.member.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Inject
	MemberService memberService;
	
	String folderName = "member";
	
	@RequestMapping("/list")
	public String list(Model model, @ModelAttribute MemberDTO arguDto) {
		Util util = new Util();
		
		List<MemberDTO> list = memberService.getSelectAll(arguDto);
		
		model.addAttribute("list", list);
		model.addAttribute("folderName", folderName);
		model.addAttribute("fileName", "list");
		return "main/main";
	}//list
	
	@RequestMapping("/view")
	public String view(Model model) {
		
		model.addAttribute("folderName", folderName);
		model.addAttribute("fileName", "view");
		return "main/main";
	}//view
	
	@RequestMapping("/chuga")
	public String chuga(Model model) {
		
		model.addAttribute("folderName", folderName);
		model.addAttribute("fileName", "chuga");
		return "main/main";
	}//chuga
	
	@RequestMapping("/chugaProc")
	public String chugaProc(Model model, @ModelAttribute MemberDTO arguDto) {
		
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
		} else if (arguDto.getJumin1().trim().equals("")) {
			failCounter++;
		} else if (arguDto.getJumin2().trim().equals("")) {
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
			return "redirect:/member/chuga";
		}//if
		
		int result = memberService.setInsert(arguDto);
		
		String resultLocation = "list";
		if (result <= 0) {
			resultLocation = "chuga";
		}//if
		
		return "redirect:/member/"+ resultLocation;
	}//chugaProc
	
	@RequestMapping("/sujung")
	public String sujung(Model model) {
		
		model.addAttribute("folderName", folderName);
		model.addAttribute("fileName", "sujung");
		return "main/main";
	}//sujung
	
	@RequestMapping("/sujungProc")
	public String sujungProc(Model model) {
		
		return "main/main";
	}//sujungProc
	
	@RequestMapping("/sakje")
	public String sakje(Model model) {
		
		model.addAttribute("folderName", folderName);
		model.addAttribute("fileName", "sakje");
		return "main/main";
	}//sakje
	
	@RequestMapping("/sakjeProc")
	public String sakjeProc(Model model) {
		
		return "main/main";
	}//sakjeProc
	
	@RequestMapping("/search")
	public String search(Model model, @ModelAttribute MemberDTO arguDto) {
		
		return "redirect:/member/list";
	}//search
	
	@RequestMapping("/idCheck")
	public String idCheck(Model model, @ModelAttribute MemberDTO arguDto, HttpServletResponse response) {
		if (arguDto.getId().trim().equals("")) {
			return "redirect:/member/chuga";
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
		
		return "redirect:/member/list";
	}//idCheck
}//MemberController

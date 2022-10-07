package com.cbc.myProject.member.controller;

import java.util.Optional;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cbc.myProject.member.model.dto.MemberDTO;
import com.cbc.myProject.member.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Inject
	MemberService memberService;
	
	private String folderName = "member";
	
	@RequestMapping("/view")
	public String view(Model model, @ModelAttribute MemberDTO arguDto, HttpSession session) {
		Optional<Object> opt = Optional.ofNullable(session.getAttribute("sessionNo"));
		int no = (int) opt.orElse(0);
		
		if (no <= 0) {
			return "redirect:/";
		}//if
		
		arguDto.setNo(no);
		
		MemberDTO returnDto = memberService.getSelectOne(arguDto);
		
		model.addAttribute("dto", returnDto);
		model.addAttribute("folderName", folderName);
		model.addAttribute("fileName", "view");
		return "main/main";
	}//view
	
	@RequestMapping("/sujung")
	public String sujung(Model model, @ModelAttribute MemberDTO arguDto, HttpSession session) {
		Optional<Object> opt = Optional.ofNullable(session.getAttribute("sessionNo"));
		int no = (int) opt.orElse(0);
		
		if (no <= 0) {
			return "redirect:/";
		}//if
		
		arguDto.setNo(no);
		
		MemberDTO returnDto = memberService.getSelectOne(arguDto);
		
		model.addAttribute("dto", returnDto);
		model.addAttribute("folderName", folderName);
		model.addAttribute("fileName", "sujung");
		return "main/main";
	}//sujung
	
	@RequestMapping("/sujungProc")
	public String sujungProc(Model model, @ModelAttribute MemberDTO arguDto, HttpSession session) {
		Optional<Object> opt = Optional.ofNullable(session.getAttribute("sessionNo"));
		int no = (int) opt.orElse(0);
		
		if (no <= 0) {
			return "redirect:/";
		}//if
		
		arguDto.setNo(no);
		
		MemberDTO returnDto = memberService.getSelectOne(arguDto);
		
		if (!arguDto.getPasswd().equals(returnDto.getPasswd())) {
			return "redirect:/"+ folderName +"/sujung?no="+ arguDto.getNo();
		}//if
		
		int result = memberService.setUpdate(arguDto);
		
		String resultLocation = "view";
		if (result <= 0) {
			resultLocation = "sujung";
		}//if
		
		return "redirect:/"+ folderName +"/"+ resultLocation +"?no="+ arguDto.getNo();
	}//sujungProc
	
	@RequestMapping("/sakje")
	public String sakje(Model model, @ModelAttribute MemberDTO arguDto, HttpSession session) {
		Optional<Object> opt = Optional.ofNullable(session.getAttribute("sessionNo"));
		int no = (int) opt.orElse(0);
		
		if (no <= 0) {
			return "redirect:/";
		}//if
		
		arguDto.setNo(no);
		
		MemberDTO returnDto = memberService.getSelectOne(arguDto);
		
		model.addAttribute("dto", returnDto);
		model.addAttribute("folderName", folderName);
		model.addAttribute("fileName", "sakje");
		return "main/main";
	}//sakje
	
	@RequestMapping("/sakjeProc")
	public String sakjeProc(Model model, @ModelAttribute MemberDTO arguDto, HttpSession session) {
		Optional<Object> opt = Optional.ofNullable(session.getAttribute("sessionNo"));
		int no = (int) opt.orElse(0);
		
		if (no <= 0) {
			return "redirect:/";
		}//if
		
		arguDto.setNo(no);
		
		MemberDTO returnDto = memberService.getSelectOne(arguDto);
		
		if (!arguDto.getPasswd().equals(returnDto.getPasswd())) {
			return "redirect:/"+ folderName +"/sakje?no="+ arguDto.getNo();
		}//if
		
		int result = memberService.setDelete(arguDto);
		
		if (result <= 0) {
			return "redirect:/"+ folderName +"/sakje?no="+ arguDto.getNo();
		}//if
		
		return "redirect:/signOut";
	}//sakjeProc
}//MemberController

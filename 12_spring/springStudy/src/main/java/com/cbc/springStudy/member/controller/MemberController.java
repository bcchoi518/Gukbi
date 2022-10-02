package com.cbc.springStudy.member.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cbc.springStudy.member.model.dao.MemberDAO;
import com.cbc.springStudy.member.model.dto.MemberDTO;

@Controller
@RequestMapping("/member")
public class MemberController
{
	@Inject
	MemberDAO memberDao;
	
	String returnValue = "member";
	
	@RequestMapping("/list")
	public String list(Model model)
	{
		String title = "회원목록";
		model.addAttribute("title", title);
		
		List<MemberDTO> list = memberDao.getSelectAll();
		model.addAttribute("list", list);
		
		return returnValue + "/list";
	}//list
	
	@RequestMapping("/view")
	public String view(Model model, @ModelAttribute MemberDTO dto)
	{
		String title = "회원상세보기";
		model.addAttribute("title", title);
		
		MemberDTO returnDto = memberDao.getSelectOne(dto);
		model.addAttribute("dto", returnDto);
		
		return returnValue + "/view";
	}//view
	
	@RequestMapping("/chuga")
	public String chuga(Model model)
	{
		String title = "회원등록";
		
		model.addAttribute("title", title);
		
		return returnValue + "/chuga";
	}//chuga
	
	@RequestMapping("/chugaProc")
	public String chugaProc(@ModelAttribute MemberDTO dto,	String passwdChk)
	{
		if (!dto.getPasswd().equals(passwdChk) ) {
			return "redirect:/"+ returnValue +"/chuga";
		} else if (dto.getJuso4() == null || dto.getJuso4().trim().equals("")) {
			dto.setJuso4("-");
		}//if
		
		String jumin = dto.getJumin1() + dto.getJumin2();
		dto.setJumin(jumin);
		
		int result = memberDao.setInsert(dto);
		if (result > 0) {
			return "redirect:/"+ returnValue +"/list";
		} else {
			return "redirect:/"+ returnValue +"/chuga";
		}//if
	}//chugaProc
	
	@RequestMapping("/sujung")
	public String sujung(Model model, @ModelAttribute MemberDTO dto)
	{
		String title = "회원수정";
		model.addAttribute("title", title);
		
		MemberDTO returnDto = memberDao.getSelectOne(dto);
		model.addAttribute("dto", returnDto);
		
		return returnValue + "/sujung";
	}//sujung
	
	@RequestMapping("/sujungProc")
	public String sujungProc(@ModelAttribute MemberDTO dto)
	{
		if (dto.getJuso4() == null || dto.getJuso4().trim().equals("")) {
			dto.setJuso4("-");
		}//if
		
		String jumin = dto.getJumin1() + dto.getJumin2();
		dto.setJumin(jumin);
		
		int result = memberDao.setUpdate(dto);
		if (result > 0) {
			return "redirect:/"+ returnValue +"/view?no="+ dto.getNo();
		} else {
			return "redirect:/"+ returnValue +"/sujung?no="+ dto.getNo();
		}//if
	}//sujungProc
	
	@RequestMapping("/sakje")
	public String sakje(Model model, @ModelAttribute MemberDTO dto)
	{
		String title = "회원삭제";
		model.addAttribute("title", title);
		
		MemberDTO returnDto = memberDao.getSelectOne(dto);
		model.addAttribute("dto", returnDto);
		
		return returnValue + "/sakje";
	}//sakje
	
	@RequestMapping("/sakjeProc")
	public String sakjeProc(@ModelAttribute MemberDTO dto)
	{
		int result = memberDao.setDelete(dto);
		if (result > 0) {
			return "redirect:/"+ returnValue +"/list";
		} else {
			return "redirect:/"+ returnValue +"/sakje?no="+ dto.getNo();
		}//if
	}//sakjeProc
}//MemberController

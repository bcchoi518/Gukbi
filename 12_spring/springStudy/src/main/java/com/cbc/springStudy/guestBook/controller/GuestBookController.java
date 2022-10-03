package com.cbc.springStudy.guestBook.controller;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cbc.springStudy.guestBook.model.dto.GuestBookDTO;
import com.cbc.springStudy.guestBook.service.GuestBookService;

@Controller
@RequestMapping("/guestBook")
public class GuestBookController {

	@Inject
	GuestBookService guestBookService;
	
	String returnValue = "guestBook";
	
	@RequestMapping("/list")
	public String list(Model model, @ModelAttribute GuestBookDTO arguDto)
	{
		List<GuestBookDTO> list = guestBookService.getSelectAll();
		
		model.addAttribute("title", "방명록 목록");
		model.addAttribute("list", list);
		
		return returnValue +"/list";
	}//list
	
	@RequestMapping("/view")
	public String view(Model model, @ModelAttribute GuestBookDTO arguDto)
	{
		GuestBookDTO returnDto = guestBookService.getSelectOne(arguDto);
		
		model.addAttribute("title", "방명록 상세보기");
		model.addAttribute("dto", returnDto);
		
		return returnValue +"/view";
	}//view
	
	@RequestMapping("/chuga")
	public String chuga(Model model)
	{
		model.addAttribute("title", "방명록 추가");
		
		return returnValue +"/chuga";
	}//chuga
	
	@RequestMapping("/chugaProc")
	public String chugaProc(Model model, @ModelAttribute GuestBookDTO arguDto, HttpSession session)
	{
		Optional<Object> opt = Optional.ofNullable(session.getAttribute("sessionNo"));
		
		arguDto.setMemberNo((int) opt.orElse(0));
		
		int result = guestBookService.setInsert(arguDto);
		
		if (result > 0) {
			return "redirect:/"+ returnValue +"/list";
		} else {
			return "redirect:/"+ returnValue +"/chuga";
		}//if
	}//chugaProc
	
	@RequestMapping("/sujung")
	public String sujung(Model model, @ModelAttribute GuestBookDTO arguDto)
	{
		GuestBookDTO returnDto = guestBookService.getSelectOne(arguDto);
		
		model.addAttribute("title", "방명록 수정");
		model.addAttribute("dto", returnDto);
		
		return returnValue +"/sujung";
	}//sujung
	
	@RequestMapping("/sujungProc")
	public String sujungProc(Model model, @ModelAttribute GuestBookDTO arguDto)
	{
		int result = guestBookService.setUpdate(arguDto);
		
		if (result > 0) {
			return "redirect:/"+ returnValue +"/view?no="+ arguDto.getNo();
		} else {
			return "redirect:/"+ returnValue +"/sujung?no="+ arguDto.getNo();
		}//if
	}//sujungProc
	@RequestMapping("/sakje")
	public String sakje(Model model, @ModelAttribute GuestBookDTO arguDto)
	{
		GuestBookDTO returnDto = guestBookService.getSelectOne(arguDto);
		
		model.addAttribute("title", "방명록 삭제");
		model.addAttribute("dto", returnDto);
		
		return returnValue +"/sakje";
	}//sakje
	
	@RequestMapping("/sakjeProc")
	public String sakjeProc(Model model, @ModelAttribute GuestBookDTO arguDto)
	{
		int result = guestBookService.setDelete(arguDto);
		
		if (result > 0) {
			return "redirect:/"+ returnValue +"/list";
		} else {
			return "redirect:/"+ returnValue +"/sakje?no="+ arguDto.getNo();
		}//if
	}//sakjeProc
}//GuestBookController

package com.cbc.springStudy.memo.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cbc.springStudy.memo.model.dao.MemoDAO;
import com.cbc.springStudy.memo.model.dto.MemoDTO;
import com.cbc.springStudy.memo.service.MemoService;

@Controller
@RequestMapping("/memo")
public class MemoController {

	@Inject
	MemoDAO memoDao;
	@Inject
	MemoService memoService;
	
	String returnValue = "memo";
	int imsiProcGubun = 1; //imsiProcGubun - 0: dao, imsiProcGubun - 1: service
	
	@RequestMapping("/list")
	public String list(Model model)
	{
		List<MemoDTO> list = null;
		
		if (imsiProcGubun == 0) {
			list = memoDao.getSelectAll();
		} else {
			list = memoService.getSelectAll();
		}//if
		
		model.addAttribute("title", "메모 목록");
		model.addAttribute("list", list);
		
		return returnValue +"/list";
	}//list
	
	@RequestMapping("/view")
	public String view(Model model, @ModelAttribute MemoDTO arguDto)
	{
		MemoDTO returnDto = null;
		
		if (imsiProcGubun == 0) {
			returnDto = memoDao.getSelectOne(arguDto);
		} else {
			returnDto = memoService.getSelectOne(arguDto);
		}//if
		
		model.addAttribute("title", "메모 상세보기");
		model.addAttribute("dto", returnDto);
		
		return returnValue +"/view";
	}//view
	
	@RequestMapping("/chuga")
	public String chuga(Model model)
	{
		model.addAttribute("title", "메모 등록");
		
		return returnValue +"/chuga";
	}//chuga
	
	@RequestMapping("/chugaProc")
	public String chugaProc(Model model, @ModelAttribute MemoDTO arguDto)
	{
		int result = 0;
	
		if (imsiProcGubun == 0) {
			result = memoDao.setInsert(arguDto);
		} else {
			result = memoService.setInsert(arguDto);
		}//if
		
		if (result > 0) {
			return "redirect:/"+ returnValue +"/list";
		} else {
			return "redirect:/"+ returnValue +"/chuga";
		}//if
	}//chugaProc
	
	@RequestMapping("/sujung")
	public String sujung(Model model, @ModelAttribute MemoDTO arguDto)
	{
		MemoDTO returnDto = null;
		
		if (imsiProcGubun == 0) {
			returnDto = memoDao.getSelectOne(arguDto);
		} else {
			returnDto = memoService.getSelectOne(arguDto);
		}//if
		
		model.addAttribute("title", "메모 수정");
		model.addAttribute("dto", returnDto);
		
		return returnValue +"/sujung";
	}//sujung
	
	@RequestMapping("/sujungProc")
	public String sujungProc(Model model, @ModelAttribute MemoDTO arguDto)
	{
		int result = 0;
		
		if (imsiProcGubun == 0) {
			result = memoDao.setUpdate(arguDto);
		} else {
			result = memoService.setUpdate(arguDto);
		}//if
		
		if (result > 0) {
			return "redirect:/"+ returnValue +"/view?no="+ arguDto.getNo();
		} else {
			return "redirect:/"+ returnValue +"/sujung?no"+ arguDto.getNo();
		}//if
	}//sujungProc
	
	@RequestMapping("/sakje")
	public String sakje(Model model, @ModelAttribute MemoDTO arguDto)
	{
		MemoDTO returnDto = null;
		
		if (imsiProcGubun == 0) {
			returnDto = memoDao.getSelectOne(arguDto);
		} else {
			returnDto = memoService.getSelectOne(arguDto);
		}//if
		
		model.addAttribute("title", "메모 삭제");
		model.addAttribute("dto", returnDto);
		
		return returnValue +"/sakje";
	}//sakje
	
	@RequestMapping("/sakjeProc")
	public String sakjeProc(Model model, @ModelAttribute MemoDTO arguDto)
	{
		int result = 0;
		
		if (imsiProcGubun == 0) {
			result = memoDao.setDelete(arguDto);
		} else {
			result = memoService.setDelete(arguDto);
		}//if
		
		if (result > 0) {
			return "redirect:/"+ returnValue +"/list";
		} else {
			return "redirect:/"+ returnValue +"/sakje?no"+ arguDto.getNo();
		}//if
	}//sakjeProc
}//MemoController

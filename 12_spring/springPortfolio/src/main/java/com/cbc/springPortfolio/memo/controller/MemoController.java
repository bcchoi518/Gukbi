package com.cbc.springPortfolio.memo.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cbc.springPortfolio.common.Util;
import com.cbc.springPortfolio.memo.model.dto.MemoDTO;
import com.cbc.springPortfolio.memo.service.MemoService;

@Controller
@RequestMapping("/memo")
public class MemoController {
	
	@Inject
	MemoService memoService;
	@Autowired
	Util util;
	
	String folderName = "memo";
	
	@RequestMapping("/list")
	public String list(Model model, @ModelAttribute MemoDTO arguDto, BindingResult bindingResult) {
		String searchGubun = util.getDecodedUrl(arguDto.getSearchGubun());
		String searchData = util.getDecodedUrl(arguDto.getSearchData());
		arguDto.setSearchGubun(searchGubun);
		arguDto.setSearchData(searchData);
		
		int pageNumber = arguDto.getPageNumber();
		int pageSize = 5;
		int blockSize = 10;
		int totalRecord = memoService.getTotalRecord(arguDto);
		
		Map<String, Integer> pagerMap = util.getPagerMap(pageNumber, pageSize, blockSize, totalRecord);
		pagerMap.put("blockSize", blockSize);
		
		arguDto.setStartRecord(pagerMap.get("startRecord"));
		arguDto.setLastRecord(pagerMap.get("lastRecord"));
		
		List<MemoDTO> list = memoService.getSelectAll(arguDto);
		
		model.addAttribute("pagerMap", pagerMap);
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("totalRecord", totalRecord);
		model.addAttribute("searchGubun", searchGubun);
		model.addAttribute("searchData", searchData);
		model.addAttribute("list", list);
		model.addAttribute("folderName", folderName);
		model.addAttribute("fileName", "list");
		return "main/main";
	}//list
	
	@RequestMapping("/chugaProc")
	public String chugaProc(Model model, @ModelAttribute MemoDTO arguDto, BindingResult bindingResult) {
		String writer = arguDto.getWriter();
		String content = arguDto.getContent();
		
		writer = util.getNullBlankCheck(writer);
		content = util.getNullBlankCheck(content);
		
		writer = util.getCheckString(writer);
		content = util.getCheckString(content);
		
		int failCounter = 0;
		if (writer.equals("")) {
			failCounter++;
		} else if (content.equals("")) {
			failCounter++;
		}//if
		
		if (failCounter > 0) {
			return "redirect:/"+ folderName +"/list";
		}//if
		
		arguDto.setWriter(writer);
		arguDto.setContent(content);
		
		int result = memoService.setInsert(arguDto);
		
		return "redirect:/"+ folderName +"/list";
	}//chugaProc
	
	@RequestMapping("/sujungProc")
	public String sujungProc(Model model, @ModelAttribute MemoDTO arguDto) {
		int no = arguDto.getNo();
		if (no <= 0) {
			return "redirect:/"+ folderName +"/list";
		}//if
		String writer = arguDto.getWriter();
		String content = arguDto.getContent();
		
		writer = util.getNullBlankCheck(writer);
		content = util.getNullBlankCheck(content);
		
		writer = util.getCheckString(writer);
		content = util.getCheckString(content);
		
		int failCounter = 0;
		if (writer.equals("")) {
			failCounter++;
		} else if (content.equals("")) {
			failCounter++;
		}//if
		
		if (failCounter > 0) {
			return "redirect:/"+ folderName +"/list";
		}//if
		
		arguDto.setWriter(writer);
		arguDto.setContent(content);
		
		int result = memoService.setUpdate(arguDto);
		
		return "redirect:/"+ folderName +"/list";
	}//sujungProc
	
	@RequestMapping("/sakjeProc")
	public String sakjeProc(Model model, @ModelAttribute MemoDTO arguDto) {
		int no = arguDto.getNo();
		if (no <= 0) {
			return "redirect:/"+ folderName +"/list";
		}//if
		
		int result = memoService.setDelete(arguDto);
		
		return "redirect:/"+ folderName +"/list";
	}//sakjeProc
	
	@RequestMapping("/search")
	public String search(Model model, @ModelAttribute MemoDTO arguDto, BindingResult bindingResult) {
		String searchGubun = arguDto.getSearchGubun();
		String searchData = arguDto.getSearchData();
		
		if (searchGubun.trim().equals("")) {
			searchGubun = "";
			searchData = "";
		}//if

		String searchQuery = util.getSearchQuery(searchGubun, searchData);
		
		return "redirect:/"+ folderName +"/list?pageNumber="+ arguDto.getPageNumber() +"&"+ searchQuery;
	}//search
}//MemoController

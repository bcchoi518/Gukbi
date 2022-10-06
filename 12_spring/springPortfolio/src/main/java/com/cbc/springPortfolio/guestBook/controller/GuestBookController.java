package com.cbc.springPortfolio.guestBook.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cbc.springPortfolio.common.Util;
import com.cbc.springPortfolio.guestBook.model.dto.GuestBookDTO;
import com.cbc.springPortfolio.guestBook.service.GuestBookService;

@Controller
@RequestMapping("/guestBook")
public class GuestBookController {
	
	@Inject
	GuestBookService guestBookService;
	@Inject
	Util util;
	
	String folderName = "guestBook";
	
	@RequestMapping("/list")
	public String list(Model model, @ModelAttribute GuestBookDTO arguDto, BindingResult bindingResult) {
		String searchGubun = util.getDecodedUrl(arguDto.getSearchGubun());
		String searchData = util.getDecodedUrl(arguDto.getSearchData());
		arguDto.setSearchGubun(searchGubun);
		arguDto.setSearchData(searchData);
		
		int pageNumber = arguDto.getPageNumber();
		int pageSize = 1;
		int blockSize = 10;
		int totalRecord = guestBookService.getTotalRecord(arguDto);
		
		Map<String, Integer> pagerMap = util.getPagerMap(pageNumber, pageSize, blockSize, totalRecord);
		pagerMap.put("blockSize", blockSize);
		
		arguDto.setStartRecord(pagerMap.get("startRecord"));
		arguDto.setLastRecord(pagerMap.get("lastRecord"));
		
		List<GuestBookDTO> list = guestBookService.getSelectAll(arguDto);
		
		model.addAttribute("list", list);
		model.addAttribute("pagerMap", pagerMap);
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("totalRecord", totalRecord);
		model.addAttribute("searchGubun", searchGubun);
		model.addAttribute("searchData", searchData);
		model.addAttribute("folderName", folderName);
		model.addAttribute("fileName", "list");
		return "main/main";
	}//list
	
	@RequestMapping("/chuga")
	public String chuga(Model model, @ModelAttribute GuestBookDTO arguDto) {
		
		model.addAttribute("pageNumber", arguDto.getPageNumber());
		model.addAttribute("folderName", folderName);
		model.addAttribute("fileName", "chuga");
		return "main/main";
	}//chuga
	
	@RequestMapping("/chugaProc")
	public String chugaProc(Model model, @ModelAttribute GuestBookDTO arguDto) {
		String name = arguDto.getName();
		String email1 = arguDto.getEmail1();
		String email2 = arguDto.getEmail2();
		String content = arguDto.getContent();
		
		name = util.getNullBlankCheck(name);
		email1 = util.getNullBlankCheck(email1);
		email2 = util.getNullBlankCheck(email2);
		content = util.getNullBlankCheck(content);
		
		int failCounter = 0;
		if (name.equals("")) {
			failCounter++;
		} else if (email1.equals("")) {
			failCounter++;
		} else if (email2.equals("")) {
			failCounter++;
		} else if (content.equals("")) {
			failCounter++;
		}//if
		
		String searchGubun = util.getDecodedUrl(arguDto.getSearchGubun());
		String searchData = util.getDecodedUrl(arguDto.getSearchData());
		String searchQuery = util.getSearchQuery(searchGubun, searchData);
		
		if (failCounter > 0) {
			System.out.println("입력값 오류");
			return "redirect:/"+ folderName +"/chuga?pageNumber="+ arguDto.getPageNumber() +"&"+ searchQuery;
		}//if
		
		name = util.getCheckString(name);
		email1 = util.getCheckString(email1);
		email2 = util.getCheckString(email2);
		content = util.getCheckString(content);
		String email = email1 +"@"+ email2;
		
		arguDto.setName(name);
		arguDto.setEmail(email);
		arguDto.setContent(content);
		
		int result = guestBookService.setInsert(arguDto);
		
		String linkAddr = "list";
		if (result <= 0) {
			linkAddr = "chuga?pageNumber="+ arguDto.getPageNumber() +"&"+ searchQuery;
		}//if
		
		return "redirect:/"+ folderName +"/"+ linkAddr;
	}//chugaProc
	
	@RequestMapping("/sujung")
	public String sujung(Model model, @ModelAttribute GuestBookDTO arguDto, BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors("no") || arguDto.getNo() <= 0) {
			return "redirect:/"+ folderName +"/list";
		}//if
		
		GuestBookDTO returnDto = guestBookService.getSelectOne(arguDto);
		
		model.addAttribute("dto", returnDto);
		model.addAttribute("pageNumber", arguDto.getPageNumber());
		model.addAttribute("folderName", folderName);
		model.addAttribute("fileName", "sujung");
		return "main/main";
	}//sujung
	
	@RequestMapping("/sujungProc")
	public String sujungProc(Model model, @ModelAttribute GuestBookDTO arguDto, BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors("no") || arguDto.getNo() <= 0) {
			return "redirect:/"+ folderName +"/list";
		}//if
		
		String name = arguDto.getName();
		String email1 = arguDto.getEmail1();
		String email2 = arguDto.getEmail2();
		String content = arguDto.getContent();
		
		name = util.getNullBlankCheck(name);
		email1 = util.getNullBlankCheck(email1);
		email2 = util.getNullBlankCheck(email2);
		content = util.getNullBlankCheck(content);
		
		int failCounter = 0;
		if (name.equals("")) {
			failCounter++;
		} else if (email1.equals("")) {
			failCounter++;
		} else if (email2.equals("")) {
			failCounter++;
		} else if (content.equals("")) {
			failCounter++;
		}//if
		
		String searchGubun = util.getDecodedUrl(arguDto.getSearchGubun());
		String searchData = util.getDecodedUrl(arguDto.getSearchData());
		String searchQuery = util.getSearchQuery(searchGubun, searchData);
		
		if (failCounter > 0) {
			System.out.println("입력값 오류");
			return "redirect:/"+ folderName +"/sujung?pageNumber="+ arguDto.getPageNumber() +"&no="+ arguDto.getNo() +"&"+ searchQuery;
		}//if
		
		name = util.getCheckString(name);
		email1 = util.getCheckString(email1);
		email2 = util.getCheckString(email2);
		content = util.getCheckString(content);
		String email = email1 +"@"+ email2;
		
		arguDto.setName(name);
		arguDto.setEmail(email);
		arguDto.setContent(content);
		
		int result = guestBookService.setUpdate(arguDto);
		
		String linkAddr = "list";
		if (result <= 0) {
			linkAddr = "sujung";
		}//if
		
		return "redirect:/"+ folderName +"/"+ linkAddr +"?pageNumber="+ arguDto.getPageNumber() +"&no="+ arguDto.getNo() +"&"+ searchQuery;
	}//sujungProc
	
	@RequestMapping("/sakje")
	public String sakje(Model model, @ModelAttribute GuestBookDTO arguDto, BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors("no") || arguDto.getNo() <= 0) {
			return "redirect:/"+ folderName +"/list";
		}//if
		
		GuestBookDTO returnDto = guestBookService.getSelectOne(arguDto);
		
		model.addAttribute("dto", returnDto);
		model.addAttribute("pageNumber", arguDto.getPageNumber());
		model.addAttribute("folderName", folderName);
		model.addAttribute("fileName", "sakje");
		return "main/main";
	}//sakje
	
	@RequestMapping("/sakjeProc")
	public String sakjeProc(Model model, @ModelAttribute GuestBookDTO arguDto, BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors("no") || arguDto.getNo() <= 0) {
			return "redirect:/"+ folderName +"/list";
		}//if
		
		int result = guestBookService.setDelete(arguDto);
		
		String searchGubun = util.getDecodedUrl(arguDto.getSearchGubun());
		String searchData = util.getDecodedUrl(arguDto.getSearchData());
		String searchQuery = util.getSearchQuery(searchGubun, searchData);
		
		String linkAddr = "list";
		if (result <= 0) {
			linkAddr = "sakje?pageNumber="+ arguDto.getPageNumber() +"&no="+ arguDto.getNo() +"&"+ searchQuery;
		}//if
		
		return "redirect:/"+ folderName +"/"+ linkAddr;
	}//sakjeProc
	
	@RequestMapping("/search")
	public String search(Model model, @ModelAttribute GuestBookDTO arguDto, BindingResult bindingResult) {
		String searchGubun = arguDto.getSearchGubun();
		String searchData = arguDto.getSearchData();
		
		if (searchGubun.trim().equals("")) {
			searchGubun = "";
			searchData = "";
		}//if
		
		String searchQuery = util.getSearchQuery(searchGubun, searchData);
		
		return "redirect:/"+ folderName +"/list?pageNumber="+ arguDto.getPageNumber() +"&"+ searchQuery;
	}//search
}//GuestBookController

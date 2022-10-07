package com.cbc.myProject.diary.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cbc.myProject.common.Util;
import com.cbc.myProject.diary.model.dto.DiaryDTO;
import com.cbc.myProject.diary.service.DiaryService;

@Controller
@RequestMapping("/diary")
public class DiaryController {

	@Inject
	DiaryService diaryService;
	@Autowired
	Util util;
	
	private String folderName = "diary";
	
	@RequestMapping("/index")
	public String index(Model model, @ModelAttribute DiaryDTO arguDto, HttpSession session) {
		Optional<Object> opt = Optional.ofNullable(session.getAttribute("sessionNo"));
		int memberNo = (int) opt.orElse(0);
		
		if (memberNo <= 0) {
			return "redirect:/signIn";
		} else {
			arguDto.setMemberNo(memberNo);
		}//if
		
		model.addAttribute("tbl", arguDto.getTbl());
		model.addAttribute("folderName", folderName);
		model.addAttribute("fileName", "index");
		return "main/main";
	}//index
	
	@RequestMapping("/list")
	public String list(Model model, @ModelAttribute DiaryDTO arguDto, BindingResult bindingResult, HttpSession session) {
		Optional<Object> opt = Optional.ofNullable(session.getAttribute("sessionNo"));
		int memberNo = (int) opt.orElse(0);
		
		if (memberNo <= 0) {
			return "redirect:/signIn";
		} else {
			arguDto.setMemberNo(memberNo);
		}//if
		
		String searchGubun = util.getDecodedUrl(arguDto.getSearchGubun());
		String searchData = util.getDecodedUrl(arguDto.getSearchData());
		arguDto.setSearchGubun(searchGubun);
		arguDto.setSearchData(searchData);
		
		int pageNumber = arguDto.getPageNumber();
		int pageSize = 1;
		int blockSize = 10;
		int totalRecord = diaryService.getTotalRecord(arguDto);
		
		Map<String, Integer> pagerMap = util.getPagerMap(pageNumber, pageSize, blockSize, totalRecord);
		pagerMap.put("blockSize", blockSize);
		
		arguDto.setStartRecord(pagerMap.get("startRecord"));
		arguDto.setLastRecord(pagerMap.get("lastRecord"));
		
		List<DiaryDTO> list = diaryService.getSelectAll(arguDto);
		
		model.addAttribute("list", list);
		model.addAttribute("pagerMap", pagerMap);
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("totalRecord", totalRecord);
		model.addAttribute("searchGubun", searchGubun);
		model.addAttribute("searchData", searchData);
		model.addAttribute("tbl", arguDto.getTbl());
		model.addAttribute("folderName", folderName);
		model.addAttribute("fileName", "list");
		return "main/main";
	}//list
	
	@RequestMapping("/chuga")
	public String chuga(Model model, @ModelAttribute DiaryDTO arguDto, HttpSession session) {
		Optional<Object> opt = Optional.ofNullable(session.getAttribute("sessionNo"));
		int memberNo = (int) opt.orElse(0);
		
		if (memberNo <= 0) {
			return "redirect:/signIn";
		} else {
			arguDto.setMemberNo(memberNo);
		}//if
		
		model.addAttribute("pageNumber", arguDto.getPageNumber());
		model.addAttribute("tbl", arguDto.getTbl());
		model.addAttribute("folderName", folderName);
		model.addAttribute("fileName", "chuga");
		return "main/main";
	}//chuga
	
	@RequestMapping("/chugaProc")
	public String chugaProc(Model model, @ModelAttribute DiaryDTO arguDto, HttpSession session) {
		Optional<Object> opt = Optional.ofNullable(session.getAttribute("sessionNo"));
		int memberNo = (int) opt.orElse(0);
		
		if (memberNo <= 0) {
			return "redirect:/signIn";
		} else {
			arguDto.setMemberNo(memberNo);
		}//if
		
		String title = arguDto.getTitle();
		String content = arguDto.getContent();
		
		
		title = util.getNullBlankCheck(title);
		content = util.getNullBlankCheck(content);
		
		int failCounter = 0;
		if (title.equals("")) {
			failCounter++;
		} else if (content.equals("")) {
			failCounter++;
		}//if
		
		String searchGubun = util.getDecodedUrl(arguDto.getSearchGubun());
		String searchData = util.getDecodedUrl(arguDto.getSearchData());
		String searchQuery = util.getSearchQuery(searchGubun, searchData);
		
		if (failCounter > 0) {
			System.out.println("입력값 오류");
			return "redirect:/"+ folderName +"/chuga?tbl="+ arguDto.getTbl() +"&pageNumber="+ arguDto.getPageNumber() +"&"+ searchQuery;
		}//if
		
		title = util.getCheckString(title);
		content = util.getCheckString(content);
		
		arguDto.setTitle(title);
		arguDto.setContent(content);
		
		int result = diaryService.setInsert(arguDto);
		
		String linkAddr = "list?tbl="+ arguDto.getTbl();
		if (result <= 0) {
			linkAddr = "chuga?tbl="+ arguDto.getTbl() +"&pageNumber="+ arguDto.getPageNumber() +"&"+ searchQuery;
		}//if
		
		return "redirect:/"+ folderName +"/"+ linkAddr;
	}//chugaProc
	
	@RequestMapping("/sujung")
	public String sujung(Model model, @ModelAttribute DiaryDTO arguDto, BindingResult bindingResult, HttpSession session) {
		if (bindingResult.hasFieldErrors("no") || arguDto.getNo() <= 0) {
			return "redirect:/"+ folderName +"/list?tbl="+ arguDto.getTbl();
		}//if
		
		Optional<Object> opt = Optional.ofNullable(session.getAttribute("sessionNo"));
		int memberNo = (int) opt.orElse(0);
		
		if (memberNo <= 0) {
			return "redirect:/signIn";
		} else {
			arguDto.setMemberNo(memberNo);
		}//if
		
		
		DiaryDTO returnDto = diaryService.getSelectOne(arguDto);
		
		model.addAttribute("dto", returnDto);
		model.addAttribute("pageNumber", arguDto.getPageNumber());
		model.addAttribute("tbl", arguDto.getTbl());
		model.addAttribute("folderName", folderName);
		model.addAttribute("fileName", "sujung");
		return "main/main";
	}//sujung
	
	@RequestMapping("/sujungProc")
	public String sujungProc(Model model, @ModelAttribute DiaryDTO arguDto, BindingResult bindingResult, HttpSession session) {
		if (bindingResult.hasFieldErrors("no") || arguDto.getNo() <= 0) {
			return "redirect:/"+ folderName +"/list?tbl="+ arguDto.getTbl();
		}//if
		
		Optional<Object> opt = Optional.ofNullable(session.getAttribute("sessionNo"));
		int memberNo = (int) opt.orElse(0);
		
		if (memberNo <= 0) {
			return "redirect:/signIn";
		} else {
			arguDto.setMemberNo(memberNo);
		}//if
		
		
		String title = arguDto.getTitle();
		String content = arguDto.getContent();
		
		title = util.getNullBlankCheck(title);
		content = util.getNullBlankCheck(content);
		
		int failCounter = 0;
		if (title.equals("")) {
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
		
		title = util.getCheckString(title);
		content = util.getCheckString(content);
		
		arguDto.setTitle(title);
		arguDto.setContent(content);
		
		int result = diaryService.setUpdate(arguDto);
		
		String linkAddr = "list";
		if (result <= 0) {
			linkAddr = "sujung";
		}//if
		
		return "redirect:/"+ folderName +"/"+ linkAddr +"?tbl="+ arguDto.getTbl() +"&pageNumber="+ arguDto.getPageNumber() +"&no="+ arguDto.getNo() +"&"+ searchQuery;
	}//sujungProc
	
	@RequestMapping("/sakje")
	public String sakje(Model model, @ModelAttribute DiaryDTO arguDto, BindingResult bindingResult, HttpSession session) {
		if (bindingResult.hasFieldErrors("no") || arguDto.getNo() <= 0) {
			return "redirect:/"+ folderName +"/list?tbl="+ arguDto.getTbl();
		}//if
		
		Optional<Object> opt = Optional.ofNullable(session.getAttribute("sessionNo"));
		int memberNo = (int) opt.orElse(0);
		
		if (memberNo <= 0) {
			return "redirect:/signIn";
		} else {
			arguDto.setMemberNo(memberNo);
		}//if
		
		DiaryDTO returnDto = diaryService.getSelectOne(arguDto);
		
		model.addAttribute("dto", returnDto);
		model.addAttribute("pageNumber", arguDto.getPageNumber());
		model.addAttribute("tbl", arguDto.getTbl());
		model.addAttribute("folderName", folderName);
		model.addAttribute("fileName", "sakje");
		return "main/main";
	}//sakje
	
	@RequestMapping("/sakjeProc")
	public String sakjeProc(Model model, @ModelAttribute DiaryDTO arguDto, BindingResult bindingResult, HttpSession session) {
		if (bindingResult.hasFieldErrors("no") || arguDto.getNo() <= 0) {
			return "redirect:/"+ folderName +"/list?tbl="+ arguDto.getTbl();
		}//if
		
		Optional<Object> opt = Optional.ofNullable(session.getAttribute("sessionNo"));
		int memberNo = (int) opt.orElse(0);
		
		if (memberNo <= 0) {
			return "redirect:/signIn";
		} else {
			arguDto.setMemberNo(memberNo);
		}//if
		
		int result = diaryService.setDelete(arguDto);
		
		String searchGubun = util.getDecodedUrl(arguDto.getSearchGubun());
		String searchData = util.getDecodedUrl(arguDto.getSearchData());
		String searchQuery = util.getSearchQuery(searchGubun, searchData);
		
		String linkAddr = "list?tbl="+ arguDto.getTbl();
		if (result <= 0) {
			linkAddr = "sakje?tbl="+ arguDto.getTbl() +"&pageNumber="+ arguDto.getPageNumber() +"&no="+ arguDto.getNo() +"&"+ searchQuery;
		}//if
		
		return "redirect:/"+ folderName +"/"+ linkAddr;
	}//sakjeProc
	
	@RequestMapping("/search")
	public String search(Model model, @ModelAttribute DiaryDTO arguDto, BindingResult bindingResult) {
		String searchGubun = arguDto.getSearchGubun();
		String searchData = arguDto.getSearchData();
		
		if (searchGubun.trim().equals("")) {
			searchGubun = "";
			searchData = "";
		}//if
		
		String searchQuery = util.getSearchQuery(searchGubun, searchData);
		
		return "redirect:/"+ folderName +"/list?tbl="+ arguDto.getTbl() +"&pageNumber="+ arguDto.getPageNumber() +"&"+ searchQuery;
	}//search
}//DiaryController

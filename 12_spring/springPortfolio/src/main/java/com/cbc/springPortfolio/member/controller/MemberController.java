package com.cbc.springPortfolio.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cbc.springPortfolio.common.Util;
import com.cbc.springPortfolio.member.model.dto.MemberDTO;
import com.cbc.springPortfolio.member.service.MemberService;
import com.cbc.springPortfolio.member.service.MemberServiceImpl;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Inject
	MemberService memberService;
	
	String folderName = "member";
	Util util = new Util();
	
	@RequestMapping("/list")
	public String list(Model model, @ModelAttribute MemberDTO arguDto) {
		int pageNumber = arguDto.getPageNumber();
		int pageSize = 5;
		int blockSize = 10;
		int totalRecord = memberService.getTotalRecord(arguDto);
		
		String searchGubun = arguDto.getSearchGubun();
		String searchData = arguDto.getSearchData();
		
		try {
			searchGubun = URLDecoder.decode(searchGubun, "UTF-8");
			searchData = URLDecoder.decode(searchData, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}//try-catch
		
		Util util = new Util();
		Map<String, Integer> pagerMap = util.getPagerMap(pageNumber, pageSize, blockSize, totalRecord);
		pagerMap.put("blockSize", blockSize);
		
		arguDto.setStartRecord(pagerMap.get("startRecord"));
		arguDto.setLastRecord(pagerMap.get("lastRecord"));
		
		List<MemberDTO> list = memberService.getSelectAll(arguDto);
		
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("totalRecord", totalRecord);
		model.addAttribute("pagerMap", pagerMap);
		model.addAttribute("list", list);
		model.addAttribute("searchGubun", searchGubun);
		model.addAttribute("searchData", searchData);
		model.addAttribute("folderName", folderName);
		model.addAttribute("fileName", "list");
		return "main/main";
	}//list
	
	@RequestMapping("/view")
	public String view(Model model, @ModelAttribute MemberDTO arguDto) {
		String searchGubun = arguDto.getSearchGubun();
		String searchData = arguDto.getSearchData();
		
		try {
			searchGubun = URLDecoder.decode(searchGubun, "UTF-8");
			searchData = URLDecoder.decode(searchData, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}//try-catch
		
		MemberDTO returnDto = memberService.getSelectOne(arguDto);
		
		model.addAttribute("dto", returnDto);
		model.addAttribute("pageNumber", arguDto.getPageNumber());
		model.addAttribute("searchGubun", searchGubun);
		model.addAttribute("searchData", searchData);
		model.addAttribute("folderName", folderName);
		model.addAttribute("fileName", "view");
		return "main/main";
	}//view
	
	@RequestMapping("/chuga")
	public String chuga(Model model, @ModelAttribute MemberDTO arguDto) {
		String searchGubun = arguDto.getSearchGubun();
		String searchData = arguDto.getSearchData();
		
		try {
			searchGubun = URLDecoder.decode(searchGubun, "UTF-8");
			searchData = URLDecoder.decode(searchData, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}//try-catch
		
		model.addAttribute("pageNumber", arguDto.getPageNumber());
		model.addAttribute("searchGubun", searchGubun);
		model.addAttribute("searchData", searchData);
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
		
		String searchQuery = util.getSearchQuery(arguDto.getSearchGubun(), arguDto.getSearchData());
		
		String resultLocation = "list";
		if (result <= 0) {
			resultLocation = "chuga?pageNumber="+ arguDto.getPageNumber() +"&"+ searchQuery;
		}//if
		
		return "redirect:/member/"+ resultLocation;
	}//chugaProc
	
	@RequestMapping("/sujung")
	public String sujung(Model model, @ModelAttribute MemberDTO arguDto) {
		String searchGubun = arguDto.getSearchGubun();
		String searchData = arguDto.getSearchData();
		
		try {
			searchGubun = URLDecoder.decode(searchGubun, "UTF-8");
			searchData = URLDecoder.decode(searchData, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}//try-catch
		
		MemberDTO returnDto = memberService.getSelectOne(arguDto);
		
		model.addAttribute("dto", returnDto);
		model.addAttribute("pageNumber", arguDto.getPageNumber());
		model.addAttribute("searchGubun", searchGubun);
		model.addAttribute("searchData", searchData);
		model.addAttribute("folderName", folderName);
		model.addAttribute("fileName", "sujung");
		return "main/main";
	}//sujung
	
	@RequestMapping("/sujungProc")
	public String sujungProc(Model model, @ModelAttribute MemberDTO arguDto) {
		String searchGubun = arguDto.getSearchGubun();
		String searchData = arguDto.getSearchData();
		String searchQuery = util.getSearchQuery(searchGubun, searchData);
		
		MemberDTO returnDto = memberService.getSelectOne(arguDto);
		
		if (!arguDto.getPasswd().equals(returnDto.getPasswd())) {
			return "redirect:/member/sujung?pageNumber="+ arguDto.getPageNumber() +"&no="+ arguDto.getNo() +"&"+ searchQuery;
		}//if
		
		int result = memberService.setUpdate(arguDto);
		
		String resultLocation = "view";
		if (result <= 0) {
			resultLocation = "sujung";
		}//if
		
		return "redirect:/member/"+ resultLocation +"?pageNumber="+ arguDto.getPageNumber() +"&no="+ arguDto.getNo() +"&"+ searchQuery;
	}//sujungProc
	
	@RequestMapping("/sakje")
	public String sakje(Model model, @ModelAttribute MemberDTO arguDto) {
		String searchGubun = arguDto.getSearchGubun();
		String searchData = arguDto.getSearchData();
		
		try {
			searchGubun = URLDecoder.decode(searchGubun, "UTF-8");
			searchData = URLDecoder.decode(searchData, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}//try-catch
		
		MemberDTO returnDto = memberService.getSelectOne(arguDto);
		
		model.addAttribute("dto", returnDto);
		model.addAttribute("pageNumber", arguDto.getPageNumber());
		model.addAttribute("searchGubun", searchGubun);
		model.addAttribute("searchData", searchData);
		model.addAttribute("folderName", folderName);
		model.addAttribute("fileName", "sakje");
		return "main/main";
	}//sakje
	
	@RequestMapping("/sakjeProc")
	public String sakjeProc(Model model, @ModelAttribute MemberDTO arguDto) {
		String searchGubun = arguDto.getSearchGubun();
		String searchData = arguDto.getSearchData();
		String searchQuery = util.getSearchQuery(searchGubun, searchData);
		
		MemberDTO returnDto = memberService.getSelectOne(arguDto);
		
		if (!arguDto.getPasswd().equals(returnDto.getPasswd())) {
			return "redirect:/member/sakje?pageNumber="+ arguDto.getPageNumber() +"&no="+ arguDto.getNo() +"&"+ searchQuery;
		}//if
		
		int result = memberService.setDelete(arguDto);
		
		String resultLocation = "list";
		if (result <= 0) {
			resultLocation = "sakje?pageNumber="+ arguDto.getPageNumber() +"&no="+ arguDto.getNo() +"&"+ searchQuery;
		}//if
		
		return "redirect:/member/"+ resultLocation;
	}//sakjeProc
	
	@RequestMapping("/search")
	public String search(Model model, @ModelAttribute MemberDTO arguDto) {
		String searchGubun = arguDto.getSearchGubun();
		String searchData = arguDto.getSearchData();
		String searchQuery = util.getSearchQuery(searchGubun, searchData);
		
		return "redirect:/member/list?pageNumber="+ arguDto.getPageNumber() +"&"+ searchQuery;
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
		return "redirect:/member/chuga";
	}//idCheck
	
	@RequestMapping("/idCheckWin")
	public String idCheckWin(Model model, @ModelAttribute MemberDTO arguDto, HttpServletResponse response) {
		
		return "member/idCheckWin";
	}//idCheckWin
	
	@RequestMapping("/idCheckWinProc")
	public String idCheckWinProc(Model model, @ModelAttribute MemberDTO arguDto) {
		String id = arguDto.getId();
		
		if (arguDto.getId().trim().equals("")) {
			return "member/idCheckWin";
		}//if
		
		int result = memberService.getIdCheck(arguDto);
		
		String imsiId = id;
		String msg = "사용 가능한 아이디입니다.";
		if(result > 0) {
			imsiId = "";
			msg = "사용 불가능한 아이디입니다.";	
		}//if
		
		model.addAttribute("id", id);
		model.addAttribute("imsiId", imsiId);
		model.addAttribute("msg", msg);
		
		return "member/idCheckWin";
	}//idCheckWinProc
}//MemberController

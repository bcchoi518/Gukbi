package com.cbc.springStudy.member.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cbc.springStudy._common.MultipartUpload;
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
	
	@RequestMapping("/chugaAttach")
	public String chugaAttach(Model model)
	{
		String title = "회원등록 (attach)";
		
		model.addAttribute("title", title);
		
		return returnValue + "/chugaAttach";
	}//chugaAttach
	
	@RequestMapping("/chugaAttachProc")
	public String chugaAttachProc(
			Model model, 
			HttpServletRequest request,
			@ModelAttribute MemberDTO dto,
			String passwdChk,
			@RequestParam("file") List<MultipartFile> multiFileList
			)
	{
		if (!dto.getPasswd().equals(passwdChk) ) {
			return "redirect:/"+ returnValue +"/chuga";
		} else if (dto.getJuso4() == null || dto.getJuso4().trim().equals("")) {
			dto.setJuso4("-");
		}//if
		
		String jumin = dto.getJumin1() + dto.getJumin2();
		dto.setJumin(jumin);
		
		MultipartUpload mu = new MultipartUpload();
		List<String> list = mu.attachProc(multiFileList, "/springStudy/member");
		
		String attachInfo = "";
		for (String attachFile : list) {
			attachInfo += "|" + attachFile;
		}//for
		attachInfo = attachInfo.substring(1);
		dto.setAttachInfo(attachInfo);
		
		int result = memberDao.setInsert(dto);
		if (result > 0) {
			return "redirect:/"+ returnValue +"/list";
		} else {
			return "redirect:/"+ returnValue +"/chugaAttach";
		}//if
	}//chugaAttachProc
	
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
	
	@RequestMapping("/login")
	public String login(Model model)
	{
		String title = "로그인";
		
		model.addAttribute("title", title);
		
		return returnValue +"/login";
	}//login
	
	@RequestMapping("/loginProc")
	public String loginProc(Model model, HttpSession session,@ModelAttribute MemberDTO dto)
	{
		int result = memberDao.getLogin(dto);
		
		if (result > 0) {
			session.setAttribute("sessionNo", result);
			return "redirect:/"+ returnValue +"/list";
		} else {
			return "redirect:/"+ returnValue +"/login";
		}//if
	}//loginProc
	
	@RequestMapping("/logout")
	public String logout(Model model, HttpSession session)
	{
		//session.removeAttribute("sessionNo"); //개별값만 지울수도 있음
		session.invalidate();
		
		return "redirect:/"+ returnValue +"/login";
	}//logout
}//MemberController

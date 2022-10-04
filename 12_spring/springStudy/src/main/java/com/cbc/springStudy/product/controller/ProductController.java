package com.cbc.springStudy.product.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cbc.springStudy._common.MultipartUpload;
import com.cbc.springStudy.product.model.dto.ProductDTO;
import com.cbc.springStudy.product.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Inject
	ProductService productService;
	
	String returnValue = "product";
	
	@RequestMapping("/list")
	public String list(Model model)
	{
		String title = "상품목록";
		model.addAttribute("title", title);
		
		List<ProductDTO> list = productService.getSelectAll();
		model.addAttribute("list", list);
		
		return returnValue + "/list";
	}//list
	
	@RequestMapping("/view")
	public String view(Model model, @ModelAttribute ProductDTO arguDto)
	{
		String title = "상품상세보기";
		model.addAttribute("title", title);
		
		ProductDTO returnDto = productService.getSelectOne(arguDto);
		model.addAttribute("dto", returnDto);
		
		return returnValue + "/view";
	}//view
	
	@RequestMapping("/chuga")
	public String chuga(Model model)
	{
		String title = "상품등록";
		
		model.addAttribute("title", title);
		
		return returnValue + "/chuga";
	}//chuga
	
	@RequestMapping("/chugaProc")
	public String chugaProc(@ModelAttribute ProductDTO arguDto)
	{
		int result = productService.setInsert(arguDto);
		if (result > 0) {
			return "redirect:/"+ returnValue +"/list";
		} else {
			return "redirect:/"+ returnValue +"/chuga";
		}//if
	}//chugaProc
	
	@RequestMapping("/chugaAttach")
	public String chugaAttach(Model model)
	{
		String title = "상품등록 (attach)";
		
		model.addAttribute("title", title);
		
		return returnValue + "/chugaAttach";
	}//chugaAttach
	
	@RequestMapping("/chugaAttachProc")
	public String chugaAttachProc(
			Model model,
			@ModelAttribute ProductDTO arguDto,
			@RequestParam("file") List<MultipartFile> multiFileList
			)
	{
		MultipartUpload mu = new MultipartUpload();
		List<String> list = mu.attachProc(multiFileList, "/springStudy/product");
		
		String attachInfo = "";
		if (list.size() > 0) {
			for (String attachFile : list) {
				attachInfo += "|" + attachFile;
			}//for
			attachInfo = attachInfo.substring(1);
		} else {
			attachInfo = "-";
		}//if
		arguDto.setAttachInfo(attachInfo);
		
		int result = productService.setInsert(arguDto);
		if (result > 0) {
			return "redirect:/"+ returnValue +"/list";
		} else {
			return "redirect:/"+ returnValue +"/chugaAttach";
		}//if
	}//chugaAttachProc
	
	@RequestMapping("/sujung")
	public String sujung(Model model, @ModelAttribute ProductDTO arguDto)
	{
		String title = "상품수정";
		model.addAttribute("title", title);
		
		ProductDTO returnDto = productService.getSelectOne(arguDto);
		model.addAttribute("dto", returnDto);
		
		return returnValue + "/sujung";
	}//sujung
	
	@RequestMapping("/sujungProc")
	public String sujungProc(@ModelAttribute ProductDTO arguDto)
	{
		int result = productService.setUpdate(arguDto);
		if (result > 0) {
			return "redirect:/"+ returnValue +"/view?productNo="+ arguDto.getProductNo();
		} else {
			return "redirect:/"+ returnValue +"/sujung?productNo="+ arguDto.getProductNo();
		}//if
	}//sujungProc
	
	@RequestMapping("/sakje")
	public String sakje(Model model, @ModelAttribute ProductDTO arguDto)
	{
		String title = "상품삭제";
		model.addAttribute("title", title);
		
		ProductDTO returnDto = productService.getSelectOne(arguDto);
		model.addAttribute("dto", returnDto);
		
		return returnValue + "/sakje";
	}//sakje
	
	@RequestMapping("/sakjeProc")
	public String sakjeProc(@ModelAttribute ProductDTO arguDto)
	{
		int result = productService.setDelete(arguDto);
		if (result > 0) {
			return "redirect:/"+ returnValue +"/list";
		} else {
			return "redirect:/"+ returnValue +"/sakje?productNo="+ arguDto.getProductNo();
		}//if
	}//sakjeProc
}//ProductController

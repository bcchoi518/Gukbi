package com.cbc.springStudy.cart.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cbc.springStudy.cart.model.dto.CartDTO;
import com.cbc.springStudy.cart.service.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Inject
	CartService cartService;
	
	String returnValue = "cart";
	
	@RequestMapping("/list")
	public String list(Model model)
	{
		List<CartDTO> list = cartService.getSelectAll();
		
		model.addAttribute("title", "장바구니 목록");
		model.addAttribute("list", list);
		
		return returnValue +"/list";
	}//list
	
	@RequestMapping("/chugaProc")
	public String chugaProc(Model model, @ModelAttribute CartDTO arguDto)
	{
		int result = cartService.setInsert(arguDto);
	
		if (result > 0) {
			return "redirect:/"+ returnValue +"/list";
		} else {
			return "redirect:/"+ returnValue +"/chuga";
		}//if
	}//chugaProc
	
	@RequestMapping("/sujungProc")
	public String sujungProc(Model model, HttpServletRequest request)
	{
		String totalCounter_ = request.getParameter("totalCounter");
		int totalCounter = Integer.parseInt(totalCounter_);
		
		List<String> list = new ArrayList<>();
		
		for (int i = 0; i < totalCounter; i++) {
			String cartNo_ = request.getParameter("cartNo_"+ i);
			String amount_ = request.getParameter("amount_"+ i);
			int cartNo = Integer.parseInt(cartNo_);
			int amount = Integer.parseInt(amount_);
			
			CartDTO arguDto = new CartDTO();
			arguDto.setCartNo(cartNo);
			arguDto.setAmount(amount);
			
			int imsiResult = cartService.setUpdate(arguDto);
			if (imsiResult <= 0) {
				list.add(cartNo + "," + amount); // cartNo, amount
			}//if
		}//for
		
		System.out.println(list.size());
		System.out.println(list);
		
		return "redirect:/"+ returnValue +"/list";
	}//sujungProc
	
	@RequestMapping("/sakjeProc")
	public String sakjeProc(Model model, @ModelAttribute CartDTO arguDto)
	{
		int result = cartService.setDelete(arguDto);
	
		return "redirect:/"+ returnValue +"/list";
	}//sakjeProc
	
	@RequestMapping("/cartClearProc")
	public String cartClearProc(Model model, @ModelAttribute CartDTO arguDto, HttpSession session)
	{
		Optional<Object> opt = Optional.ofNullable(session.getAttribute("sessionNo"));
		
		if (arguDto.getMemberNo() == (int) opt.orElse(0)) {
			int result = cartService.setClear(arguDto);
			System.out.println("result: "+ result);
		}//if
		
		return "redirect:/"+ returnValue +"/list";
	}//cartClearProc
}//MemoController

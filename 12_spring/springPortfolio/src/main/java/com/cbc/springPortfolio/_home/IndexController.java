package com.cbc.springPortfolio._home;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping("/")
	public String index(Model model, HttpServletRequest request) {
		
		model.addAttribute("folderName", "_home");
		model.addAttribute("fileName", "index");
		return "main/main";
	}//index
}//IndexController

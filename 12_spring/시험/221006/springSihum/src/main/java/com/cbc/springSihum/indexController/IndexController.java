package com.cbc.springSihum.indexController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("folderName", "book");
		model.addAttribute("fileName", "index");
		return "main/main";
	}//index
}//IndexController
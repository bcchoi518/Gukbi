package com.cbc.springStudy._index;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //컨트롤러로 사용하기 위해 어노테이션을 붙임
public class IndexController {
	
	@RequestMapping("/")
	public String index(Model model) { //매개변수 Model model에 값을 담아서 view와 주고받는다
		model.addAttribute("insa", "안녕하세요?");
		model.addAttribute("name", "홍길동");
		//return되는 문자열(주소) 앞뒤로 servlet-context.xml의 beans:bean:InternalResourceViewResolver의 beans:property에 prefix와 suffix가 붙음
		return "_home/index";
	}//index
	
	
}//IndexController
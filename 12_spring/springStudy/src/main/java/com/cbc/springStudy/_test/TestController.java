package com.cbc.springStudy._test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller //컨트롤러로 사용하기 위해 어노테이션을 붙임
//@RequestMapping("공통") 공통부분에서만 동작하는 컨트롤러라면 공통으로 사용되는 주소를 맵핑할수있음
public class TestController {
	
	@RequestMapping("/test01")
	public String test01() {
		return "_test/test01/exam01"; // /WEB-INF/views/_test/test01/exam01.jsp
	}//test01
	
	@RequestMapping("/test01Proc")
	public String test01Proc(
			Model model, 
			//@RequestParam() 생략 가능, defaultValue는 값이 null일때만 동작하고 빈값에는 동작하지 않는다.
			@RequestParam(value="name", defaultValue="") String name, 
			@RequestParam(value="jumin", defaultValue="") String jumin
			)
	{
//		System.out.println(name);
//		System.out.println(jumin);
		model.addAttribute("name", name);
		model.addAttribute("jumin", jumin);
		
		return "_test/test01/exam01Result";
	}//test01Proc
	
	@RequestMapping("/test02")
	public String test02() {
		return "_test/test02/exam01";
	}//test02
	
	@RequestMapping("/test02Proc")
	public String test02Proc(
			Model model, 
			@RequestParam(value="name", defaultValue="") String name,
			@RequestParam(value="gender", defaultValue="") String gender,
			@RequestParam(value="jumin", defaultValue="") String jumin
			)
	{
		model.addAttribute("title", "테스트02 Result");
		model.addAttribute("name", name);
		model.addAttribute("gender", gender);
		model.addAttribute("jumin", jumin);
		
		return "_test/test02/exam01Result";
	}//test02Proc
	
	@RequestMapping("/test03")
	public String test03(Model model) {
		model.addAttribute("title", "테스트03");
		return "_test/test03/exam01";
	}//test03
	
	@RequestMapping("/test03Proc")
	public String test03Proc(Model model, HttpServletRequest request)
	{
		String name = request.getParameter("name");
		String jumin = request.getParameter("jumin");
		String gender = request.getParameter("gender");
		String age_ = request.getParameter("age");
		int age = Integer.parseInt(age_);
		
		model.addAttribute("title", "테스트03 Result");
		model.addAttribute("name", name);
		model.addAttribute("jumin", jumin);
		model.addAttribute("gender", gender);
		model.addAttribute("age", age);
		
		return "_test/test03/exam01Result";
	}//test03Proc
	
	@RequestMapping("/test04")
	public String test04(Model model)
	{
		model.addAttribute("title", "테스트04");
		return "_test/test04/exam01";
	}//test04
	
	@RequestMapping("/test04Proc")
	public String test04Proc(Model model, @ModelAttribute Test04DTO dto)
	{
		String name = dto.getName();
		String jumin = dto.getJumin();
		String gender = dto.getGender();
		int age = dto.getAge();
		
		model.addAttribute("title", "테스트04 Result");
		model.addAttribute("name", name);
		model.addAttribute("jumin", jumin);
		model.addAttribute("gender", gender);
		model.addAttribute("age", age);
		
		return "_test/test04/exam01Result";
	}//test04Proc
	
	@RequestMapping("/test05")
	public String test05(Model model)
	{
		model.addAttribute("title", "테스트05");
		return "_test/test05/exam01";
	}//test05
	
	@RequestMapping("/test05Proc")
	public String test05Proc(Model model, @ModelAttribute Test05DTO dto)
	{
		int kor = dto.getKor();
		int eng = dto.getEng();
		int mat = dto.getMat();
		int sci = dto.getSci();
		int his = dto.getHis();
		int tot = kor + eng + mat + sci + his;
		double avg = tot / 5.0;
		
		dto.setTot(tot);
		dto.setAvg(avg);
		
		model.addAttribute("title", "테스트05 Result");
		model.addAttribute("dto", dto);
		
		return "_test/test05/exam01Result";
	}//test05Proc
	
	@RequestMapping("/test06")
	public String test06(Model model)
	{
		model.addAttribute("title", "테스트06");
		return "_test/test06/exam01";
	}//test06
	
	@RequestMapping("/test06Proc")
	public String test06Proc(Model model, @ModelAttribute Test06DTO dto)
	{
		int productSalePrice = (int) (dto.getProductPrice() * (1 - (dto.getSalePercent()/100)));
		dto.setProductSalePrice(productSalePrice);
		
		model.addAttribute("title", "테스트06 Result");
		model.addAttribute("dto", dto);
		
		return "_test/test06/exam01Result";
	}//test06Proc
	
	@RequestMapping("/test07")
	public String test07(Model model)
	{
		model.addAttribute("title", "테스트07");
		return "_test/test07/exam01";
	}//test07
	
	@RequestMapping("/test07Proc")
	public ModelAndView test07Proc(Model model, @ModelAttribute Test07DTO dto)
	{
		int productSalePrice = (int) (dto.getProductPrice() * (1 - (dto.getSalePercent()/100.0)));
		dto.setProductSalePrice(productSalePrice);
		
		String title = "테스트07 Result";
		
		Map<String, Object> map = new HashMap<>();
		map.put("title", title);
		map.put("dto", dto);
		
//		return new ModelAndView("_test/test07/exam01Result", "map", map);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("_test/test07/exam01Result");
		mv.addObject("map", map);
		return mv;
	}//test07Proc
	
	@RequestMapping("/test08")
	public String test08(Model model)
	{
		model.addAttribute("title", "테스트08");
		return "_test/test08/exam01";
	}//test08
	
	@RequestMapping("/test08Proc")
	public String test08Proc(Model model, String id, String passwd)
	{
		String dbId = "hong";
		String dbPw = "1234";
		
		String result = "";
		if (id.equals(dbId) && passwd.equals(dbPw)) {
			result = "로그인 성공";
		} else {
			result = "로그인 실패";
		}//if
		
		model.addAttribute("title", "테스트08");
		model.addAttribute("id", id);
		model.addAttribute("passwd", passwd);
		model.addAttribute("result", result);
		
		return "_test/test08/exam01Result";
	}//test08Proc
	
	@RequestMapping("/test09")
	public String test09(Model model)
	{
		model.addAttribute("title", "테스트09");
		return "_test/test09/exam01";
	}//test09
	
	@RequestMapping("/test09Proc")
	//@ResponseBody //객체를 반환할때는 @ResponseBody를 붙여야 하며 반환 타입앞에 적어도 된다
	public @ResponseBody Map<String, Object> test09Proc(String id, String name, String email)
	{
		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
		map.put("name", name);
		map.put("email", email);
		
		return map;
	}//test09Proc
	
	@RequestMapping("/test10")
	public String test10(Model model)
	{
		String attachPath = "C:/cbc/attach";
		String uploadPath = attachPath + "/imsi";
		
		ArrayList<String> list = new ArrayList<>();
		
		File f1 = new File(uploadPath);
		File[] array = f1.listFiles();
		for (int i = 0; i < array.length; i++) {
			String imsi = "";
			if (array[i].isFile()) { //파일이면..
				imsi = "파일^" + array[i].getPath();
			} else {
				imsi = "폴더^" + array[i].getPath();
			}//if
			list.add(imsi);
		}//for
		
		model.addAttribute("title", "디렉토리 목록 및 삭제");
		model.addAttribute("list", list);
		
		return "_test/test10/exam01";
	}//test10
	
	@RequestMapping("/test10Proc")
	public String test10Proc(Model model, String fileInfo)
	{
		File deleteFile = new File(fileInfo);
		if (deleteFile.exists()) {
			deleteFile.delete();
		} else {
			System.out.println("존재하지 않습니다.");
		}//if
		
		return "redirect:/test10"; //redirect에서는 path가 안붙음
	}//test10Proc
}//TestController

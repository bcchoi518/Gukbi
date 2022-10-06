package com.cbc.springSihum.book.controller;

import java.sql.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cbc.springSihum.book.model.dto.BookDTO;
import com.cbc.springSihum.book.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {

	@Inject
	BookService bookService;
	
	String folderName = "book";
	
	@RequestMapping("/list")
	public String list(Model model) {
		List<BookDTO> list = bookService.getSelectAll();
		
		model.addAttribute("list", list);
		model.addAttribute("folderName", folderName);
		model.addAttribute("fileName", "list");
		model.addAttribute("title", "도서 목록");
		return "main/main";
	}//list
	
	@RequestMapping("/view")
	public String view(Model model, @ModelAttribute BookDTO arguDto) {
		int code = arguDto.getCode();
		if (code <= 0) {
			return "redirect:/";
		}//if
		
		BookDTO returnDto = bookService.getSelectOne(arguDto);
		
		model.addAttribute("dto", returnDto);
		model.addAttribute("folderName", folderName);
		model.addAttribute("fileName", "view");
		model.addAttribute("title", "도서 정보 상세보기");
		return "main/main";
	}//view
	
	@RequestMapping("/chuga")
	public String chuga(Model model) {
		
		model.addAttribute("folderName", folderName);
		model.addAttribute("fileName", "chuga");
		model.addAttribute("title", "도서 등록");
		return "main/main";
	}//chuga
	
	@RequestMapping("/chugaProc")
	public String chugaProc(Model model, @ModelAttribute BookDTO arguDto) {
		String title = arguDto.getTitle();
		String category = arguDto.getCategory();
		String author = arguDto.getAuthor();
		String publisher = arguDto.getPublisher();
		Date publicationDate = arguDto.getPublicationDate();
		
		int failCounter = 0;
		if (title == null || title.trim().equals("")) {
			failCounter++;
		} else if (category == null || category.trim().equals("")) {
			failCounter++;
		} else if (author == null || author.trim().equals("")) {
			failCounter++;
		} else if (publisher == null || publisher.trim().equals("")) {
			failCounter++;
		} else if (publicationDate == null) {
			failCounter++;
		}//if 
		
		if (failCounter > 0) {
			return "redirect:/book/chuga";
		}//if 
		
		int result = bookService.setInsert(arguDto);
		
		String linkAddr = "list";
		if (result <= 0) {
			linkAddr = "chuga";
		}//if
		
		return "redirect:/book/"+ linkAddr;
	}//chugaProc
	
	@RequestMapping("/sujung")
	public String sujung(Model model, @ModelAttribute BookDTO arguDto) {
		int code = arguDto.getCode();
		if (code <= 0) {
			return "redirect:/";
		}//if
		
		BookDTO returnDto = bookService.getSelectOne(arguDto);
		
		model.addAttribute("dto", returnDto);
		model.addAttribute("folderName", folderName);
		model.addAttribute("fileName", "sujung");
		model.addAttribute("title", "도서 정보 수정");
		return "main/main";
	}//sujung
	
	
	@RequestMapping("/sujungProc")
	public String sujungProc(Model model, @ModelAttribute BookDTO arguDto) {
		int code = arguDto.getCode();
		if (code <= 0) {
			return "redirect:/";
		}//if
		
		String title = arguDto.getTitle();
		String category = arguDto.getCategory();
		String author = arguDto.getAuthor();
		String publisher = arguDto.getPublisher();
		Date publicationDate = arguDto.getPublicationDate();
		
		int failCounter = 0;
		if (title == null || title.trim().equals("")) {
			failCounter++;
		} else if (category == null || category.trim().equals("")) {
			failCounter++;
		} else if (author == null || author.trim().equals("")) {
			failCounter++;
		} else if (publisher == null || publisher.trim().equals("")) {
			failCounter++;
		} else if (publicationDate == null) {
			failCounter++;
		}//if 
		
		if (failCounter > 0) {
			return "redirect:/book/sujung?code="+ code;
		}//if 
		
		int result = bookService.setUpdate(arguDto);
		
		String linkAddr = "view";
		if (result <= 0) {
			linkAddr = "sujung";
		}//if
		
		return "redirect:/book/"+ linkAddr +"?code="+ code;
	}//sujungProc
	
	@RequestMapping("/sakje")
	public String sakje(Model model, @ModelAttribute BookDTO arguDto) {
		int code = arguDto.getCode();
		if (code <= 0) {
			return "redirect:/";
		}//if
		
		BookDTO returnDto = bookService.getSelectOne(arguDto);
		
		model.addAttribute("dto", returnDto);
		model.addAttribute("folderName", folderName);
		model.addAttribute("fileName", "sakje");
		model.addAttribute("title", "도서 정보 삭제");
		return "main/main";
	}//sakje
	
	@RequestMapping("/sakjeProc")
	public String sakjeProc(Model model, @ModelAttribute BookDTO arguDto) {
		int code = arguDto.getCode();
		if (code <= 0) {
			return "redirect:/";
		}//if
		
		int result = bookService.setDelete(arguDto);
		
		String linkAddr = "list";
		if (result <= 0) {
			linkAddr = "sakje?code="+ code;
		}//if
		
		return "redirect:/book/"+ linkAddr;
	}//sakjeProc
}//BookController

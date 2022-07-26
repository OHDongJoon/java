package com.lec.ch19.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lec.ch19.dto.Book;
import com.lec.ch19.service.BookService;
import com.lec.ch19.util.Paging;

@Controller
@RequestMapping(value="book")
public class BookController {
	@Autowired
	private BookService bookSerivce;
	@RequestMapping(params="method=detail", method = RequestMethod.GET)
	public String detail(int bnum , Model model) {
		model.addAttribute("bookDto",bookSerivce.getDetailBook(bnum));
		return "book/detail";
	}
	@RequestMapping(params="method=registerForm", method = RequestMethod.GET)
	public String registerForm() {
		return "book/registerForm";
	}
	@RequestMapping(params="method=register", method = RequestMethod.POST)
	public String register(MultipartHttpServletRequest mRequest, Book book, Model model) {
		model.addAttribute("registerResult", bookSerivce.registerBook(mRequest, book));
		return "redirect:book.do?method=list";
	}
	@RequestMapping(params="method=list", method = {RequestMethod.GET,RequestMethod.POST})
	public String list(String pageNum, Model model) {
		model.addAttribute("bookList" , bookSerivce.bookList(pageNum));
		model.addAttribute("paging", new Paging(bookSerivce.totCntBook(), pageNum, 3, 3));
		return "book/list";
	}
	@RequestMapping(params="method=modify", method = RequestMethod.POST)
	public String modify(MultipartHttpServletRequest mRequest, Book book, Model model) {
		model.addAttribute("modifyResult",bookSerivce.modifyBook(mRequest, book));
		System.out.println("수정 성공");
		return "redirect:book.do?method=list";
	}
	@RequestMapping(params="method=modifyForm", method = RequestMethod.GET)
	public String modifyForm(int bnum, Model model) {
		model.addAttribute("bookDto", bookSerivce.getDetailBook(bnum));
		return "book/modifyForm";
	}
}




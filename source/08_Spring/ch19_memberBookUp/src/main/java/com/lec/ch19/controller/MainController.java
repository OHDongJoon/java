package com.lec.ch19.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch19.service.BookService;

@Controller
public class MainController {
	@Autowired
	private BookService bookService;
	@RequestMapping(value="main" , method = {RequestMethod.GET,RequestMethod.POST})
		public String main(Model model /*HttpSession httpSession 세션 필요시 */) {
		 model.addAttribute("mainList", bookService.mainList());
		 return "main/main";
	}
	@RequestMapping(value="intro",method=RequestMethod.GET)
	public String intro() {
		return "main/intro";
	}
}

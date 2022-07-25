package com.lec.ch19.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch19.service.MemberService;

@Controller
@RequestMapping("member")
public class MemberController {
	@Autowired
	private MemberService memberSerivce;
	@RequestMapping(params="method=joinForm", method = RequestMethod.GET)
	public String joinView() {
		return "member/join";
	}
	@RequestMapping(value="idConfirm", method = RequestMethod.GET)
	public String idConfirm(String mid , Model model) {
		model.addAttribute("idConfirmResult" , "사용가능한 ID입니다");
		return "main/main";
	}
}

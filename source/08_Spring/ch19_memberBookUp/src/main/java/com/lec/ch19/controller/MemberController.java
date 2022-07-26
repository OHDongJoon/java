package com.lec.ch19.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch19.dto.Member;
import com.lec.ch19.service.MemberService;

@Controller
@RequestMapping(value="member")
public class MemberController {
	@Autowired
	private MemberService memberSerivce;
	//회원가입 폼
	@RequestMapping(params="method=joinForm", method = RequestMethod.GET)
	public String joinForm() {
		return "member/joinForm";
	}
	// 아디 중복검사
	 @RequestMapping(params="method=idConfirm", method = RequestMethod.GET)
	 public String idConfirm(String mid , Model model) { 
		 model.addAttribute("result" ,memberSerivce.idConfirm(mid)); 
		 return "member/idConfirm"; 
	 }
	 //회원가입 처리 
	 @RequestMapping(params="method=join", method = RequestMethod.POST)
	 public String join( @ModelAttribute("mDto") Member member , HttpSession httpSession, Model model) {
	 model.addAttribute("joinResult", memberSerivce.joinMember(member, httpSession));
	 return "forward:member.do?method=loginForm";
	 }
	 //로그인 폼
	 @RequestMapping(params="method=loginForm", method = {RequestMethod.GET ,RequestMethod.POST})
	 public String loginForm() {
		 return "member/loginForm";
	 }
	 //로그인 처리
	 @RequestMapping(params="method=login", method = RequestMethod.POST)
	 public String login(String mid , String mpw, HttpSession httpSession, Model model) {
		 model.addAttribute("loginResult", memberSerivce.loginCheck(mid, mpw, httpSession));
		 return "forward:main.do";
	 }
	 @RequestMapping(params="method=modifyForm", method ={RequestMethod.GET ,RequestMethod.POST})
	 public String modtfyForm() {
		 return "member/modifyForm";
	 }
	 @RequestMapping(params="method=modify", method=RequestMethod.POST)
	 public String modify(@ModelAttribute("mDto") Member member , HttpSession httpsession, Model model) {
		 model.addAttribute("modifyResult", memberSerivce.modifyMember(member));
		 httpsession.setAttribute("member", member);
		 return "forward:main.do";
	 }
	 @RequestMapping(params="method=logout", method=RequestMethod.GET)
	 public String logout(HttpSession httpSession) {
		 httpSession.invalidate();
		 return  "redirect:main.do";
	 }
}















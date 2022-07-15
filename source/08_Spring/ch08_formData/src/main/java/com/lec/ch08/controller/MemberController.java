package com.lec.ch08.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lec.ch08.vo.MemberDto;

@Controller
@RequestMapping("member")
public class MemberController {
	@ModelAttribute("cnt") // 모든 함수에 다 할 작업을 여기서 한번에 처리
	public int cnt() {
		return 5;
	}

	@ModelAttribute("list")
	public ArrayList<String> list() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("test1");
		list.add("test2");
		return list;

	}
	
	@RequestMapping(value = "join1") // 요청경로 : member/join1
	public String join1(HttpServletRequest request, Model model) { // 파라미터 값을 받아오기 위해 HttpServletRequest 사용
		String name = request.getParameter("name");
		String id  = request.getParameter("id");
		String pw = request.getParameter("pw");
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		model.addAttribute("name" , name);
		model.addAttribute("id" , id);
		model.addAttribute("pw" , pw);
		model.addAttribute("age" , age);
		model.addAttribute("email" ,email );
		model.addAttribute("address" , address);
		return "member/result1";
	}
	
	@RequestMapping(value="join2")
	public String join2(@RequestParam("name") String membername,  // membername 변수 에 name 값 넣어 !
			@RequestParam("id") String memberid,
			@RequestParam("pw") String memberpw,
			@RequestParam("age") int age,
			@RequestParam("email") String memberemail,
			@RequestParam("address") String memberaddress, Model model) {
		model.addAttribute("name" , membername);
		model.addAttribute("id" , memberid);
		model.addAttribute("pw" , memberpw);
		model.addAttribute("age" ,age);
		model.addAttribute("email" , memberemail);
		model.addAttribute("address" , memberaddress);
		return "member/result1";
	}
	
	@RequestMapping(value="join3")
	public String join3(String name , String id , String pw , int age, 
			String email , String address, Model model ) {
		model.addAttribute("name", name);
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		model.addAttribute("age", age);
		model.addAttribute("email", email);
		model.addAttribute("address", address);
		return "member/result1";
	}
	
	@RequestMapping("join4")
	public String join4(MemberDto memberDto, Model model) { // 따로따로 안하고 한번에 샥
		model.addAttribute("member" , memberDto);
		return "member/result4"; // 한큐에 받으니 resut1 에는 따로다로 받는 아이여서 여기는 result4로가자 
	}
	
	@RequestMapping("join5")
	public String join5(MemberDto memberDto /*, Model model*/) {
		/* model.addAttribute("memberDto" , memberDto);  디폴트로 이 짓을 해준다 */
		return "member/result5";
	}
	@RequestMapping("join6")
	public String join6(@ModelAttribute("member") MemberDto memberDto) {
		return "member/result4";
		//ModelAttribute : Controoler 메소드의 파라미터나 리턴값을 
		//Model 객체와 바인딩하기 위한 어노테이션
	}
	
}





















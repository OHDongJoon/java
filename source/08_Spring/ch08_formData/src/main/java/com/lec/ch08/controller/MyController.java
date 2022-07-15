package com.lec.ch08.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	@ModelAttribute("cnt") // 모든 함수에 다 할 작업을 여기서 한번에 처리
	public int cnt() {
		return 5;
	}

	@ModelAttribute("list") // 공통
	public ArrayList<String> list() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("test1");
		list.add("test2");
		return list;

	}

	
//	@RequestMapping(value = "/") // 요청경로 : member/join1 
//	public String studentId(Model model) { // 파라미터 값을 받아오기 위해 HttpServletRequest 사용 
//		return "member/input";
//	 }
	 
	// @RequestMapping(value="studentId/*") 
//	 public String studentId(HttpServletRequest request, Model model) throws UnsupportedEncodingException { // HttpServlet : input.jsp 에서 뭐가 들어 왔는지 알아야하니사용 
	// String uri = request.getRequestURI(); // /ch08/studentId/aaa 너 넙치된거야 이렇게들어 왔겠지 ? 하지만 우리는 id/뒤에 뭐가 들어왔는지 궁굼하다 이말이야 
	// String id = uri.substring(uri.lastIndexOf("/")+1);// substring 마지막에 있는 / +1 id =
	// URLDecoder.decode(id , "utf-8");// utf-8처리 한글 안깨지게 model.addAttribute("id" ,	 id);
	// return "studentId"; }
	 
	@RequestMapping(value = "studentId/{id}")
	public String studentId(@PathVariable("id") String id, Model model) {
		model.addAttribute("id", id);
		return "studentId";
	}
}

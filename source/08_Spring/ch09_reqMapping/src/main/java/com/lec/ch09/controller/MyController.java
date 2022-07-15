package com.lec.ch09.controller;
//get post 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	@RequestMapping(value="main.do" , method = RequestMethod.GET)
		public String main() {
		    return "main";
	}
	/*
	 * @RequestMapping(value="student") public String student(String id, Modelmodel, HttpServletRequest request) {
	 * String method = request.getMethod(); //
	 * getMethod() : post , get 확인하는 메소드 //id = request.getParameter("id");
	 * model.addAttribute("method" , method); model.addAttribute("id",id);
	 *  return "studentId";
	 *   }
	 */
	// get 방색
	@RequestMapping(value="student" , method = RequestMethod.GET)
	public String student(String id, Model model) {
		//id = request.getParameter("id");
		model.addAttribute("method" , "GET");
		model.addAttribute("id",id);
		return "studentId";
	}
	//post 방식
	@RequestMapping(value="student" , method = RequestMethod.POST)
	public ModelAndView student(String id, ModelAndView mav) {
		//id = request.getParameter("id");
		mav.addObject("method" , "POST");
		mav.addObject("id",id);
		mav.setViewName("studentId");
		return mav;
	}
	@RequestMapping(value="idConfirm", method = RequestMethod.GET)
	public String idConfirm(String id, Model model) {
		model.addAttribute("id" , id);
		if(id.equals("aaa")) {
			//return "redirect:studentOk.do"; 
			return "forward:studentOk.do"; // jsp로 가라가 아닌  / forward , redirect 새로운 요청경로 
		}
		return "redirect:studentNg.do?id="+id;
	}
	@RequestMapping(value="studentOk", method = RequestMethod.GET)
	public String studentOk() {
		return "studentOk";
	}
	@RequestMapping(value="studentNg", method=RequestMethod.GET)
		public String studentNg(){
			return "studentNg";
		}
	@RequestMapping(value="fullpath" , method = RequestMethod.GET)
	public String fullpath() {
		return "redirect:http://www.naver.com";
		}
	}














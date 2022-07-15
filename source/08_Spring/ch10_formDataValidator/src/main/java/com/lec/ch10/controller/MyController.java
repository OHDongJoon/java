package com.lec.ch10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch10.vo.Student;
import com.lec.ch10.vo.StudentValidator;

@Controller
public class MyController {
	@RequestMapping(value="inputForm.do", method = RequestMethod.GET)
	public String inputForm() {
		return "ex/inputForm";
	}
	@RequestMapping(value="input.do", method = RequestMethod.GET)
	public String input(Student student, Errors errors, Model model) {
		//검증 객체를 이용해서 검증 method 호출
		StudentValidator validator = new StudentValidator();
		validator.validate(student, errors);
		if(errors.hasErrors()) {
			if(errors.getFieldError("name") != null) {
				model.addAttribute("nameError" , "name 은 필수 입력 사항 입니다");
			}
			if(errors.getFieldError("id") != null) {
				model.addAttribute("idError" , "id는 자연수 입니다");
			}
			return "ex/inputForm";
		}
		/* if(에러를 잡았다요놈) {
		  viewPage = "ex/inputForm"
		   에러난 곳 점검 메세지 model에 add
		  }*/
		return "ex/inputResult";
	}
}

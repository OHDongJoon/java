package com.lec.ch10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lec.ch10.vo.Quiz;
import com.lec.ch10.vo.QuizValidator;

//@RequestMapping("quiz")
@Controller
public class QuizController {
	
	@ModelAttribute("cnt") // 모든 함수에 다 할 작업을 여기서 한번에 처리
	public int cnt() {
		return 4;
	}
	@RequestMapping(value="quizForm.do", method = RequestMethod.GET)
	public String quizInputForm() {
		return "quiz/quizInputForm";
	}
	@RequestMapping(value="quizForm.do", method = RequestMethod.POST)
	public String quiz(Quiz quiz, Errors errors, Model model) {
		int kor = quiz.getKor();
		int eng = quiz.getEng();
		int mat = quiz.getMat();
		int sum = kor + eng + mat ;
		double avg = sum/3.0;
		model.addAttribute("sum" , sum);
		model.addAttribute("avg" , avg);
		QuizValidator validator = new QuizValidator();
		validator.validate(quiz, errors);
		if(errors.hasErrors()) {
			if(errors.getFieldError("name") != null) {
				model.addAttribute("nameError" , "이름 1글자 이상 ");
			}
			if(errors.getFieldError("kor") != null) {
				model.addAttribute("korError" , "국어점수 0~100점사이");
			}
			if(errors.getFieldError("eng") != null) {
				model.addAttribute("engError" , "영어점수 0~100점사이");
			}
			if(errors.getFieldError("mat") != null) {
				model.addAttribute("matError" , "수학점수 0~100점사이");
			}
			return "quiz/quizInputForm";
		}
		
		return "quiz/quizResult";
	}
}


		
		
		
		

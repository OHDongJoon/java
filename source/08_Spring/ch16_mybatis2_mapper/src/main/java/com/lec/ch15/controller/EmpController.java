package com.lec.ch15.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch15.model.Emp;
import com.lec.ch15.service.EmpService;
import com.lec.ch15.util.Paging;

@Controller
public class EmpController {
	@Autowired
	private EmpService empService;
	// 1. emp 리스트 
	@RequestMapping(value = "empList", method = RequestMethod.GET)
	public String empList(String pageNum, Model model) {
		// empList.do?pageNum = 2
		model.addAttribute("empList", empService.empList(pageNum));
		model.addAttribute("paging", new Paging(empService.totCnt(), pageNum, 10, 5));
		return "empList";
	}
	
	// 2.더이데이터 
	@RequestMapping(value = "dummyDataInsert", method = RequestMethod.GET)
	public String dummyDataInsert() {
		empService.dummDataInsert50();
		return "redirect:empList.do";
	}
	//3.empDept 리스트 (GET , Post)
	@RequestMapping(value = "empDeptList", method = { RequestMethod.GET, RequestMethod.POST })
	public String empDeptList(String pageNum, Model model) {
		// empDeptList.do ,empDeptList.do?pageNum=2
		model.addAttribute("empList", empService.empDeptList(pageNum));
		model.addAttribute("paging", new Paging(empService.totCnt(), pageNum, 10, 5));
		return "empDeptList";
	}
	//4. 상세보기
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String detail(int empno, Model model) {
		model.addAttribute("empDto", empService.detail(empno));
		return "detail";
	}
	
	// 5. 수정하기 뷰  (GET ,  수정하기 실패하고 돌아올때 POST)
	@RequestMapping(value = "updateView", method = { RequestMethod.GET, RequestMethod.POST })
	public String updateView(int empno, Model model) {
		model.addAttribute("empDto", empService.detail(empno));
		return "update";
	}
	
	//6.  수정하기 db처리
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(Emp emp,  Model model) {
		try {
			model.addAttribute("updateResult", empService.update(emp));
		} catch (Exception e) {
			model.addAttribute("updateResult", "필드 값이 너무 깁니다. 수정 실패 ");
			return "forward:updateView.do";
		}
		return "forward:empDeptList.do";
	}

		//7. 삭제 
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(int empno, Model model) {
		model.addAttribute("deleteResult", empService.delete(empno));
		return "forward:empDeptList.do";
	}
	// 8. 등록하기 뷰  ( GET , 등록하기 실패후 POST 넘오옴)
	@RequestMapping(value = "writeView", method = { RequestMethod.GET, RequestMethod.POST })
	public String writeForm(Model model) {
		model.addAttribute("managerList", empService.managerList());
		model.addAttribute("deptList", empService.deptList());
		return "write";
	}

	//9.  사번 중복 
	@RequestMapping(value = "confirmNo", method = RequestMethod.GET)
	public String confirmNo(Emp emp, Model model) {
		// detail 이아이가 empno로 dto 가져오는아이인데
		if (empService.detail(emp.getEmpno()) == null) {
			model.addAttribute("msg", "사용가능한 사번입니다");
		} else {
			model.addAttribute("msg", "중복된 사번은 사용불가  합니다");
		}
		return "forward:writeView.do";
	}
	// 10. 등록하기 db처리 
	@RequestMapping(value = "write", method = RequestMethod.POST)
	public String write(Emp emp,  Model model) { // model이 emp 값 들어있음
		try {
			model.addAttribute("writeResult", empService.insert(emp));
		} catch (Exception e) {
			model.addAttribute("writeResult", "필드 값이 너무 깁니다. 등록 실패 ");
			return "forward:writeView.do";
		}
		  return "forward:empDeptList.do";
	}
	
}

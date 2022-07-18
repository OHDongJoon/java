package com.lec.ch11.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
// mvcboard/list.do, (애만원래하던방식)mbcboard/write.do writeView.do(서비스 필요없음)  db 연동 하는애만 서비스 필요함,
//mvcboard/content.do 
// mvcboard/modify.do , mvcboard/reply.do
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch11.bservice.BContentService;
import com.lec.ch11.bservice.BDeleteService;
import com.lec.ch11.bservice.BListService;
import com.lec.ch11.bservice.BModifyReplyViewService;
import com.lec.ch11.bservice.BModifyService;
import com.lec.ch11.bservice.BReplyService;
import com.lec.ch11.bservice.BWriteService;
import com.lec.ch11.bservice.Service;
import com.lec.ch11.dto.BoardDto;
@Controller
@RequestMapping("mvcboard") // 공통요청경로 설정
public class BoardController {
	private Service bservice;
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public String list(String pageNum, Model model) {
		// mvcboard/list.do 이렇게 들어 올 수도 있지만 
		// mvcboard/list.do?pageNum=2 이렇게 들어 올 수도 있다 
		model.addAttribute("pageNum" , pageNum);  // 서비스에서 pageNum 받는게 없어서 여기서 처리 
		bservice = new BListService();
		bservice.execute(model);
		return "mvcboard/list";
	}
	
	// 리스트 post 방식 
	// 기존 list 방식이 get  이여서 글 쓰기 후 list로 넘어갈때 정보가 싹 날라 가기 방지 
	@RequestMapping(value="list", method = RequestMethod.POST)
	public String list_post(String pageNum, Model model) {
		// 
		
		model.addAttribute("pageNum" , pageNum);  // 
		bservice = new BListService();
		bservice.execute(model);
		return "mvcboard/list";
	}
	
	// 글쓰기 view 
	@RequestMapping(value="writeView", method= RequestMethod.GET)
	public String writeView() {
		return "mvcboard/write";
	}
	
	// 글쓰기 
	@RequestMapping(value="write", method= RequestMethod.POST)
	public String write(@ModelAttribute("bDto") BoardDto boardDto , 
			HttpServletRequest request, Model model) {
		model.addAttribute("request", request); // 서비스단에서 ip 추출 때문에 (requeset.getRmoteAddr() ip 추출하는 함수가 request에만 있어서 
		bservice = new BWriteService();
		bservice.execute(model);
		return "forward:list.do"; // forward 사용할때는 설정한 공통요청경로 빼고 
	}
	
	
	// bid로 글 상세보기 
	@RequestMapping(value="content", method = RequestMethod.GET)
	public String content(int bid  , Model model) {
		model.addAttribute("bid" , bid);
		bservice = new BContentService();
		bservice.execute(model);
		return "mvcboard/content";
	}
	
	//  수정후 contnet로 넘어가는 POST 방식 // 조회수를 올리지 않고 dto 가져오기  
	@RequestMapping(value="content", method = RequestMethod.POST)
	public String content_post(int bid  , Model model) {
		model.addAttribute("bid" , bid);
		bservice = new BModifyReplyViewService();
		bservice.execute(model);
		return "mvcboard/content";
	}
	
	//modfy 조회수 안올리고 dto 가져오기  
	// 수정하기 view
	@RequestMapping(value="modify", method = RequestMethod.GET)
	public String modifyView(int bid, Model model) {
		model.addAttribute("bid" , bid);
		bservice = new BModifyReplyViewService();
		bservice.execute(model);
		return "mvcboard/modify";
	}
	
	// 수정 하기 
	@RequestMapping(value="modify", method = RequestMethod.POST)
	public String modify(BoardDto boardDto ,Model model , HttpServletRequest request) {
		model.addAttribute("request" , request);
		bservice = new BModifyService();
		bservice.execute(model);
		return "forward:content.do";
	}
	// 글 삭제하기
	@RequestMapping(value="delete", method = RequestMethod.GET)
	public String delete(int bid, Model model) {
		model.addAttribute("bid" ,bid);
		bservice = new BDeleteService();
		bservice.execute(model);
		return "forward:list.do";
	}
	// 답변글 view
	@RequestMapping(value="reply" , method = RequestMethod.GET)
	  public String replyView(int bid , Model model) {
		model.addAttribute("bid" , bid);
		bservice = new BModifyReplyViewService(); // bid로 dto 가져오기 (조회수 올리지 않고)!!
		bservice.execute(model);
		return "mvcboard/reply";
	}
	//답변글처리
	@RequestMapping(value="reply" , method = RequestMethod.POST)
	  public String reply(BoardDto boardDto, Model model , HttpServletRequest request) {
		model.addAttribute("request", request);
		bservice = new BReplyService();
		bservice.execute(model);
		return "forward:list.do";
	}
}















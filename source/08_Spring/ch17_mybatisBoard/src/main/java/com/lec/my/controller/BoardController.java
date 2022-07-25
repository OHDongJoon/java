package com.lec.my.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.my.model.Board;
import com.lec.my.service.BoardService;
import com.lec.my.util.Paging;

@Controller
public class BoardController {
 @Autowired
 private BoardService boardService;
 	@RequestMapping(value="boardList", method = {RequestMethod.GET,RequestMethod.POST})
 	public String bodList(String pageNum, Model model) {
 		model.addAttribute("boardList", boardService.boardList(pageNum));
 		model.addAttribute("paging", new Paging(boardService.totCnt(), pageNum, 10,5));
 		return "boardList";
 	}
 	@RequestMapping(value="writeForm", method = RequestMethod.GET)
 	public String writeView() {
 		return "write";
 	}
 	//글쓰기
 	@RequestMapping(value="write", method= RequestMethod.POST)
 	public String write(Board bod,HttpServletRequest request, Model model) {
 		bod.setBip(request.getRemoteAddr());
 		model.addAttribute("writeResult",boardService.insert(bod));
 		return "forward:boardList.do";
 	}
 	//상세보기
	@RequestMapping(value="detail", method=RequestMethod.GET)
	public String detail(int bid, Model model) {
		model.addAttribute("boardDto",boardService.detail(bid));
		return "detail";
	}
 	@RequestMapping(value="updateView", method = {RequestMethod.GET,RequestMethod.POST})
 	public String updateView(int bid , Model model) {
 		model.addAttribute("bDto", boardService.updateView(bid));
 		return "update";
 	}
 	//수정하기 db 처리 
 	@RequestMapping(value="update", method = RequestMethod.POST)
 	public String update(Board bod,HttpServletRequest request, Model model) {
 		bod.setBip(request.getRemoteAddr());
 		model.addAttribute("updateResult", boardService.update(bod));
 		return "forward:boardList.do";
 	}
 	//삭제 db 처리 
 	@RequestMapping(value="delete", method = RequestMethod.GET)
 	public String delete(int bid , Model model) {
 		model.addAttribute("deleteResult", boardService.delete(bid));
 		return "forward:boardList.do";
 	}
 	@RequestMapping(value="reply", method = RequestMethod.GET)
	public String replyView(int bid, Model model) {
		model.addAttribute("bDto",boardService.updateView(bid));
		return "reply";
	}
 	@RequestMapping(value="reply", method = RequestMethod.POST)
	public String reply(Board board, HttpServletRequest request, Model model) {
		model.addAttribute("replyResult", boardService.boardReply(board, request));
		return "forward:boardList.do";
	}
}

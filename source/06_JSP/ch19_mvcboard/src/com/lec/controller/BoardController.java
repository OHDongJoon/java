package com.lec.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.service.BContentService;
import com.lec.service.BDeleteService;
import com.lec.service.BListService;
import com.lec.service.BModifyService;
import com.lec.service.BModifyViewService;
import com.lec.service.BReplyService;
import com.lec.service.BReplyviewService;
import com.lec.service.BWriteService;
import com.lec.service.Service;

@WebServlet("*.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private boolean write_view = false;
	private boolean reply = false;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                 actionDo(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request,response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String uri = request.getRequestURI();                     // /ch19_mvcboard/list.do
	    String conPath = request.getContextPath();               //  /ch19_mvcboard/
	    String command = uri.substring(conPath.length());        // /list.do
		String viewPage = null;
		Service service = null;
		if(command.equals("/list.do")) {
			service = new BListService();
			service.execute(request, response);
			viewPage = "board/list.jsp";
		}else if(command.equals("/write_view.do")) { // 글쓰기 view
			viewPage = "board/write_view.jsp";
			write_view = true;
		}else if(command.equals("/write.do")) { // 원글 DB 저장
		 if(write_view) {
		     service = new BWriteService();
		     service.execute(request, response);
		     write_view = false;  // 이것을 하는 이유는 write_view에 들어갔을대만 글쓰기 dao가 실행되어서 
		 }
		 viewPage = "list.do";
		}else if(command.equals("/content_view.do")) {// 글 상세보기 
			service = new BContentService();
			service.execute(request, response);
			viewPage = "board/content_view.jsp";
		}else if(command.equals("/modify_view.do")) { // 글 수정 view (form태그)
			service = new BModifyViewService();
			service.execute(request, response);
			viewPage = "board/modify_view.jsp";
		}else if(command.equals("/modify.do")){
			 service = new BModifyService();
			 service.execute(request, response);
			 viewPage = "list.do";
	     }else if(command.equals("/delete.do")) { // 글 DB 삭제 
	    	 service = new BDeleteService();
	    	 service.execute(request, response);
	    	 viewPage = "list.do";
	     }else if(command.equals("/reply_view.do")) {
	    	 service = new BReplyviewService();
	    	 service.execute(request, response);
	    	 viewPage = "board/reply_view.jsp";
	    	 reply = true;
	     } else if(command.equals("/reply.do")) { // 답변글 DB 저장
		     if(reply) {
		    	 service = new BReplyService();
		    	 service.execute(request, response);
		    	 reply = false;
	    	 }
	    	 viewPage = "list.do";
	     }
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}


















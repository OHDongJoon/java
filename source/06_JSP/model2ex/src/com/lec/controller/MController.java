package com.lec.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.service.MidConfirmService;
import com.lec.service.ModifyService;
import com.lec.service.ALoginService;
import com.lec.service.BoardContentService;
import com.lec.service.BoardDeleteService;
import com.lec.service.BoardListService;
import com.lec.service.BoardModifyService;
import com.lec.service.BoardModifyViewService;
import com.lec.service.BoardReplyService;
import com.lec.service.BoardReplyViewService;
import com.lec.service.BoardWriteService;
import com.lec.service.MAllViewService;
import com.lec.service.MJoinService;
import com.lec.service.MLoginService;
import com.lec.service.MLogoutService;
import com.lec.service.MWithdrawalService;
import com.lec.service.MemailConfirmService;
import com.lec.service.Service;

@WebServlet("*.do")
public class MController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actioDo(request , response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actioDo(request , response);
	}

	private void actioDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		String viewPage = null;
		Service service = null;
		/* * * * * * * * * * *  * * * * * * * * * * * *
		 * * * * * * * * * member 관련 요청  * * * * * * *
		* * * * * * * * * * *  * * * * * * * * * * * * */
		if(com.equals("/joinView.do")) { // 회워원가입 화면
			viewPage = "member/join.jsp";
		}else if(com.equals("/idConfirm.do")) { // 아디 중복 확인
			service = new MidConfirmService();
			service.execute(request, response);
			viewPage = "member/idConfirm.jsp";
		}else if(com.equals("/mailConfirm.do")) { // 메일 중복확인
			service = new MemailConfirmService();
			service.execute(request, response);
			viewPage = "member/mailConfirm.jsp";
		}else if(com.equals("/join.do")) {   // 회원가입 db처리
			service = new MJoinService();
			service.execute(request, response);
			viewPage = "loginView.do";
		}else if(com.equals("/loginView.do")) { // 로그인 화면
			viewPage = "member/login.jsp";
		}else if(com.equals("/login.do")) { // 로그인 db및 세션 처리 
			service = new MLoginService();
			service.execute(request, response);
			viewPage = "main/main.jsp";
		}else if(com.equals("/logout.do")) { // 로그 아웃 
			service = new MLogoutService();
			service.execute(request, response);
			viewPage = "main/main.jsp";
		}else if(com.equals("/modifyView.do")) { // 정보 수정 화면
			viewPage = "member/modify.jsp";
		}else if(com.equals("/modify.do")) { //  db 정보에  수정 
			service = new ModifyService();
			service.execute(request, response);
			viewPage = "main/main.jsp";
		}else if(com.equals("/allView.do")) { //회원목록가져오기
			service = new MAllViewService();
			service.execute(request, response);
			viewPage = "member/mAllView.jsp";
		}else if(com.equals("/withdrawal.do")) { // 회원 탈퇴 
			service = new MWithdrawalService();
			service.execute(request, response);
			viewPage = "main/main.jsp";
		}else if(com.equals("/main.do")) {
			viewPage = "main/main.jsp";
		
		/* * * * * * * * * * *  * * * * * * * * * * * *
		* * * * * * * * * Admin 관련 요청  * * * * * * *
		* * * * * * * * * * *  * * * * * * * * * * * * */
		}else if(com.equals("/adminLoginView.do")) {
			viewPage = "admin/adminLogin.jsp";
		}else if(com.equals("/adminLogin.do")) {
			service = new ALoginService();
			service.execute(request, response);
			viewPage = "allView.do";
			/* * * * * * * * * * *  * * * * * * * * * * * *
			 * * * * * * * * * fileBoard 관련 요청  * * * * * * *
			* * * * * * * * * * *  * * * * * * * * * * * * */
		}else if(com.equals("/boardList.do")) { // 글목록
			service = new BoardListService();
			service.execute(request, response);
			viewPage = "freeBoard/boardList.jsp";
		}else if(com.equals("/boardWriteView.do")) { //글쓰기
			viewPage = "freeBoard/boardWrite.jsp";
		}else if(com.equals("/boardWrite.do")) {
			service = new BoardWriteService();
			service.execute(request, response);
			viewPage = "boardList.do";
		}else if(com.equals("/boardContent.do")) { // 글 상세보기
			service = new BoardContentService();
			service.execute(request, response);
			viewPage = "freeBoard/boardContent.jsp";
		}else if(com.equals("/boardModifyView.do")) { // 글 수정하기
			service = new BoardModifyViewService();
			service.execute(request, response);
			viewPage = "freeBoard/boardModify.jsp";
		}else if(com.equals("/boradModify.do")) {
			service = new BoardModifyService();
			service.execute(request, response);
			viewPage = "boardList.do";
		}else if(com.equals("/boardDelete.do")) {
			service = new BoardDeleteService();
			service.execute(request, response);
			viewPage = "boardList.do";
		}else if(com.equals("/boardReplyView.do")) {
			service = new BoardReplyViewService();
			service.execute(request, response);
			viewPage = "freeBoard/boardReply.jsp";
		}else if(com.equals("/boardReply.do")) {
			service = new BoardReplyService();
			service.execute(request, response);
			viewPage = "boardList.do";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}

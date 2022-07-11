package com.lec.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.service.MAllViewService;
import com.lec.service.MJoinService;
import com.lec.service.MLoginService;
import com.lec.service.MLogoutService;
import com.lec.service.ModifyService;
import com.lec.service.Service;

@WebServlet("*.do")
public class MController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request,response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		String viewPage = null;
		Service service = null;
		if(com.equals("/joinView.do")) { // 회원 가입 화면
			viewPage = "member/join.jsp";
		}else if(com.equals("/join.do")) { // 회원가입 db 처리
			service = new MJoinService();
			service.execute(request, response); // 클래스 execute 불러오기 
			viewPage = "loginView.do";   // 실행후 login로가라 
		}else if(com.equals("/loginView.do")) { // 로그인 화면 
			viewPage = "member/login.jsp";
		}else if(com.equals("/login.do")) { //로그인 db 및 세션 처리 
			service = new MLoginService();
			service.execute(request, response);
			viewPage = "member/main.jsp";
		}else if(com.equals("/logout.do")) {// 로그아웃 - 세션 날리기
			service = new MLogoutService();
			service.execute(request, response);
			viewPage ="member/login.jsp";
		}else if(com.equals("/modifyView.do")) { //정보수정화면
			viewPage ="member/modify.jsp";
		}else if(com.equals("/modify.do")) { // db에 정보수정
			service = new ModifyService();
			service.execute(request, response);
			viewPage = "member/main.jsp";
		}else if(com.equals("/allView.do")){ //회원목록가져오기
			service = new MAllViewService();
			service.execute(request, response);
			viewPage = "member/mAllView.jsp";
		}else if(com.equals("/main.do")) {
			viewPage = "member/main.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}

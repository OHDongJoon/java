package com.lec.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.service.MemberJoinService;
import com.lec.service.MemberListService;
import com.lec.service.Service;



@WebServlet("*.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           actionDo(request , response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request , response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String uri = request.getRequestURI(); // "ch19_mvc/memberList.do
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());
		String viewPage = null;
		Service service = null;
		if(command.equals("/memberList.do")) {
			//list 로직 수행 객체
			service = new MemberListService();
			// 객체 . 메소드 ()
			service.execute(request, response);
			//view단 설정
			viewPage = "member/memberList.jsp";
		}else if(command.equals("/memberJoin_view.do")) { //회원가입 from 
			// 애는 회원가입 form 만 제공하느 역할
			//서비스 로직을 부를일이 없음 
			//view 단 설정
			viewPage = "member/join.jsp";
		}else if (command.equals("/memberJoin.do")) {  // 회원가입 pro 
			//list 로직 수행 객체
			service = new MemberJoinService();
			// 객체 . 메소드 ()
			service.execute(request, response);
			//view 단 설정
			viewPage ="memberList.do";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}









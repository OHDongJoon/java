package com.mega.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "exam_Ex2", urlPatterns = { "/exam_Ex2" })
public class Exam2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
  

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request,response);

	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  String name = request.getParameter("name"); 
		  String address = request.getParameter("address");
		  response.setContentType("text/html; charset=utf-8"); 
		  PrintWriter out =response.getWriter(); 
		  out.println("<h4>이름은" + name +"입니다</h4>");
		 out.println("<h4>주소는" + address + "입니다</h4>");
		 
		
	}



}

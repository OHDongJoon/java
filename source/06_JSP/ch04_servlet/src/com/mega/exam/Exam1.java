package com.mega.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Exam1")
public class Exam1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String[] su = request.getParameterValues("su");
	response.setContentType("text/html; charset=utf-8");
	PrintWriter out = response.getWriter();
	for(int i=0 ; i <su.length; i ++) {
		int su2 = Integer.parseInt(su[i]);
		out.println("<h3>" +su2 + "단"+"</h3>");
		for(int idx = 1 ; idx <10 ; idx ++) {
			out.println(su2 +"X" + idx + " = " + (su2*idx) + "<br>");
		}
	}
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}

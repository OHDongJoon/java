package com.lec.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "HelloWorld", urlPatterns = { "/HW" }) //url 웹핑 꼭해줘야됨 
public class Ex1_HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
  


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청이 들어왔는데 get 방식으로 오면 여기가 실행한다 
		System.out.println("doGet호출"); // 브라우저에 안뜨고 콘솔창에 뜬다 
		//respones에 출력할것들을(보내줄것들?) 넣어줘야함 !  HTML을-respones에 넣어 
		
		//response : 응답처리객체 
		//request : 요청 처리객체
		//setContentType : 인코딩 방식을 설정?
		
		response.setContentType("text/html; charset=utf-8");
		//PrintWriter (변수명) :
		
		PrintWriter out = response.getWriter(); // 스트림 객체 생성
		out.println("<html>");
		
		out.println("<head>");
		
		out.println("<style>");
		out.println("h1 {color:blue;}");
		
		
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>안녕하세요. bts 초이진영 입니다</h1>");
		out.println("</body>");		
		
		out.println("<html>");
		out.close();

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//애는 왜있는겨?  post 방식으로 실행할때 
		//form 태그 안에 submit 눌렀을때 실행
		//실행결과  doPost 나오고  , doGet 실행 : <html> 내용들 </html>
		System.out.println("doPost호출");
		doGet(request, response);
	}

}

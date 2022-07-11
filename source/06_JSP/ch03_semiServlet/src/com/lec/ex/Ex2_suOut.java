package com.lec.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Ex2suOut", description = "sumOut", urlPatterns = { "/Ex2suOut" })
public class Ex2_suOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Ex2_suOut() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String numStr = request.getParameter("num");
		if(numStr==null || numStr.contentEquals("")) { //numStr이 null 이거나 빈스트링이면
			numStr = "1"; // numStr을 1로 만들겠다 
		}
		int num = Integer.parseInt(numStr); // 그값을 num에 할당
		int sum = 0;
		for(int i=0 ; i<=num ; i++) {
			sum += i;
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h1>1부터" + num + "까지 누적합은"+ sum +"입니다</h1>");
		out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

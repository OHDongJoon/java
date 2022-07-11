<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%



String btn = request.getParameter("btn");
int btn2 = Integer.parseInt(btn);
int random =(int)(Math.random()*3)+1;

if(btn2 == random){
	out.println("<h2>정답<h2>");
	out.println("<h2>동전이 있던 곳은" + random + "<br>");
}else{
	String msg = "<h2>Wrong! Try Again<h2>" + btn2 + "은 아니고 정답은" + random +"<h3>";
	msg = URLEncoder.encode(msg,"utf-8");
	response.sendRedirect("ex.jsp?msg=" + msg);
	}
%>
 
    </div>
</body>
</html>
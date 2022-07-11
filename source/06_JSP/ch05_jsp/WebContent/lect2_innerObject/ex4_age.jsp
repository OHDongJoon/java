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
	int age = Integer.parseInt(request.getParameter("age"));
	if(age >= 19){ // age가 19보다 크거나 같으면 if 로 
		response.sendRedirect("ex4_pass.jsp?age="+age);
	}else { // 작으면 else로 
		response.sendRedirect("ex4_ng.jsp?age="+age);
	}
%>
</body>
</html>
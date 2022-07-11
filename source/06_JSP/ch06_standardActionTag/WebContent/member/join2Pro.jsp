<%@page import="java.sql.Date"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String name       	= request.getParameter("name");
	String id     		= request.getParameter("id");
	String pw 			= request.getParameter("pw");
	String birthTemp 	= request.getParameter("birth");
	Date birth = null;
	if(!birthTemp.equals("")){ // birth가 빈스트링이 아니면 
	 birth = Date.valueOf(request.getParameter("birth"));
	}
	String[] hobby 		= request.getParameterValues("hobby");
	String gender 		= request.getParameter("gender");
	String email 		= request.getParameter("email");
	String[] mailSend 	= request.getParameterValues("mailSend");
	// DB저장
%>
	<script>
	alert('회원가입이 성공 완료되었습니다. 감사감사');
	location.href='login.jsp'; //location : 페이지 넘기기 ?
	</script>
	
</body>
</html>
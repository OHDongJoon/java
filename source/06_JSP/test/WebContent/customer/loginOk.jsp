<%@page import="com.lec.customer.CustomerDto"%>
<%@page import="com.lec.customer.CustomerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/style.css" rel="stylesheet">
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String cid = request.getParameter("cid");
	String cpw = request.getParameter("cpw");
	String cname = request.getParameter("cname");
	
	CustomerDao cDao = CustomerDao.getInstance();
	int result = cDao.loginCheck(cid, cpw);
	if(result==CustomerDao.SUCCESS){
		CustomerDto customer = cDao.getCustomer(cid);
		session.setAttribute("customer", customer);
		session.setAttribute("cname",customer.getCname());
		response.sendRedirect("main.jsp");
	}else if(result == CustomerDao.FAIL){
%>
	<script>
		alert('비밀번호를 확인하세요');
		history.back();
	</script>		
	<% }else{%>
		<script>
			alert('존재하지 않는 아이디입니다');
			history.go(-1);
		</script>
<%} %>
</body>
</html>
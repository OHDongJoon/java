<%@page import="com.lec.dto.CustomerDto"%>
<%@page import="com.lec.dao.CustomerDao"%>
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
		CustomerDao cDao = CustomerDao.getInstance();
		int result = cDao.loginCheck(cid, cpw);
		  if(result == CustomerDao.SUCCESS){
			CustomerDto dto = cDao.getCustomer(cid);
			 session.setAttribute("customer", dto);
			   response.sendRedirect("../main/main.jsp");
		    }else if(result == CustomerDao.LOGIN_FAIL){
			    response.sendRedirect("loginForm.jsp?msg=");
		}
	%>
</body>
</html>
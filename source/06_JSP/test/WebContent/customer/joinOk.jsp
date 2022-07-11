<%@page import="java.sql.Timestamp"%>
<%@page import="com.lec.customer.CustomerDao"%>
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
<%request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="dto" class="com.lec.customer.CustomerDto" scope="page"/>
<jsp:setProperty name="dto" property="*" />

<%
	String tempbirth = request.getParameter("tempbirth");
	if(!tempbirth.equals("")){
		dto.setCbirth(Timestamp.valueOf(tempbirth + " 00:00:00"));
	}
	CustomerDao cDao = CustomerDao.getInstance();
	int result = cDao.confirmId(dto.getCid()); // ID 중복체크
	if(result == CustomerDao.SUCCESS){//사용가능한 id
		result = cDao.joinCustomer(dto); // 회원가입
		if(result == CustomerDao.SUCCESS){
			session.setAttribute("cid", dto.getCid());
%>
	<script>
		alert('회원가입 감사합니다 . 로그인 후 서비스를 이용하세요');
		location.href = 'login.jsp';
	</script>
		<% }else{ // 회원가입실패%>
		<script>
			alert('회원가입 실패 ');
			location.href='join.jsp';
		</script> 
	<%}
	}else{
	%>	
	<script>
		alert('중복  id 다른 아이디 사용하세요');
		history.back();
	</script>
	<%}%>


</body>
</html>
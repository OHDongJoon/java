<%@page import="com.lec.friend.FriendDao"%>
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
%>
	<jsp:useBean id="dto" class="com.lec.friend.FriendDto" scope="page"/>
	<jsp:setProperty name="dto" property="*" />
<%
	FriendDao dao = FriendDao.getInstance();
	if(dto.getName() != null && dto.getTel() != null){
		int result = dao.insertFriend(dto);
		if(result == dao.SUCCESS){
			response.sendRedirect("friend.jsp");
		}
	}else{%>
			<script >
			alert('친구정보를 입력하세요');
			location.href="friend.jsp";
			</script>
		<%}%>
	

</body>
</html>
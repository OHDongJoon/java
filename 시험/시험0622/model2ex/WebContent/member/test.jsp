<%@page import="com.lec.memberdao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/style.css" rel="stylesheet">
</head>
<body>
<%
MemberDao dao = MemberDao.getInstance();
out.println("<h3>3.회원이메일중복체크</h3>");

if(MemberDao.EXISTENT == dao.confirmEmail("rgryun@naver.com")){
   out.println(" 중복된 이메일");
}else if(MemberDao.NONEXISTENT == dao.confirmId("rgryun@naver.com")){
   out.println("사용 가능한 이메일");
}

%>
</body>
</html>
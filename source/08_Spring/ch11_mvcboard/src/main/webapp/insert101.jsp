<%@page import="com.lec.ch11.dto.BoardDto"%>
<%@page import="com.lec.ch11.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/style.css" rel="stylesheet">
	<script src="http://code.jquery.com/jquery-3.6.0.js"></script>
	<script>
	$(document).ready(function()){
		
	});
	</script>
</head>
<body>
<%
	BoardDao boardDao = BoardDao.getInstance();
	BoardDto bDto = new BoardDto();
	for(int i=0 ; i<101 ; i++){
		bDto.setBname("손석구"+i);
		bDto.setBtitle("제목" + i);
		bDto.setBcontent("본문입니다");
		bDto.setBip("127.12.10" + i);
		int result = boardDao.write(bDto);
		System.out.println(i+"번째 : " + (result==1? "성공" : "실패"));
	}
	response.sendRedirect("mvcboard/list.do");
%>
</body>
</html>
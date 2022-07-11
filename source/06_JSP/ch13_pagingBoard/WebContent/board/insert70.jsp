<%@page import="com.lec.dto.BoardDto"%>
<%@page import="com.lec.dao.BoardDao"%>
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
//	임의로 70개 글 insert(원글) 하기    70개 for문 돌리기
	BoardDao dao = BoardDao.getInstance();
	BoardDto dto = new BoardDto();
	for(int i=0 ; i<141 ; i ++){
		dto.setWriter("오동준"+i);
		dto.setSubject("제목입니다"+i);
		dto.setContent("본문입니다"+i);
		dto.setEmail("hong"+i+"@hong.com");
		dto.setPw("1");
		dto.setIp("192.168.10."+i);
		int result = dao.insertBoard(dto); // 성공 여부 확인 result
		System.out.println(result==BoardDao.SUCCESS? i+"번째글쓰기 성공" : i+"번째 글쓰기 실패");
	}
	response.sendRedirect("list.jsp");
%>
</body>
</html>
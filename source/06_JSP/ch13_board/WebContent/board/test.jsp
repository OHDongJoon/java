<%@page import="com.lec.dto.BoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.dao.BoardDao"%>
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
	<a href="xx.jsp">xx</a>
<%
	BoardDao bDao = BoardDao.getInstance();
	out.println("<h2>1. DB 글갯수 : " +bDao.getBoardTotalCnt()+"입니다</h2>");
	out.println("<h2>2. 글목록</h2>");
	ArrayList<BoardDto> dtos = bDao.listBoard();
	for(BoardDto dto : dtos){
		out.println(dto+"<br>");
	}
	out.println("<h2>3. 원글쓰기</h2>");
	BoardDto dto = new BoardDto(0,"정임콩","글제목 n","생일\n임다", null, 0, "1",0,0,0, "127.0.0.2", null);
	int result = bDao.insertBoard(dto);
	out.println(result == BoardDao.SUCCESS ? "글쓰기  성공" : "글쓰기 실패!");
	out.println("<h2>4.5 조회수 올리고 글번호로 dto가져오기</h2>");
	bDao.readcountUp(3);
	dto = bDao.getBoardOneLine(3);
	out.println("수정전의 3번글"+dto);
	out.println("<h2>6.글수정후 </h2>");
	dto.setSubject("바뀐 제목xxxx");
	dto.setContent("바뀐 본문 yyyyy");
	result = bDao.updateBoard(dto);
	if(result == BoardDao.SUCCESS){
		dto = bDao.getBoardOneLine(3);
		out.println("수정 후의 3번글 :" + dto);
	}else{
		out.println("수정실패!!");
	}
	out.println("<h2>7.15번글 삭제</h2> ");
	result = bDao.deleteBoard(14, "1123");
	out.println(result==BoardDao.SUCCESS ? "15번글 삭제성공" : "15번글 삭제실패(비번 인위적으로 틀렸)<br>");
	result = bDao.deleteBoard(14, "1");
	out.println(result==BoardDao.SUCCESS ? "15번글 삭제성공" : "15번글 삭제실패");
	
%>  
</body>
</html>
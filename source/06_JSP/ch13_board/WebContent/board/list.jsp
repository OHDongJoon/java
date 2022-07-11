<%@page import="com.lec.dto.BoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.dao.BoardDao"%>
<%@page import="com.sun.java.swing.plaf.windows.resources.windows"%>
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
	<table>
		<caption>게시판</caption>
		<tr>
			<td><a href="<%=conPath%>/board/writeForm.jsp">글쓰기</a></td>
		</tr>
	</table>
	<table>
		<tr>
			<th>글번호</th>
			<th>글작성자</th>
			<th>글제목</th>
			<th>메일</th>
			<th>조회수</th>
		</tr>
		<%
			BoardDao dao = BoardDao.getInstance();
			int totalCnt = dao.getBoardTotalCnt(); //갯수 가져오는 
			if(totalCnt == 0){ // 갯수가 0이면
				out.println("<tr><td colspan='5'>등록된 글이 없습니다</td></tr>");
			}else{
				ArrayList<BoardDto> dtos = dao.listBoard();
				for(BoardDto dto : dtos){
					//글번호num , 작성자 writer 
					out.println("<tr><td>" + dto.getNum() + "</td><td>" + dto.getWriter()+"</td>");
					//글제목  SUBJECT 
					out.println("<td class='left'>"); //<img src='/ch13_board/img/hot.gif'>
													//	<a href='/ch13_board/board/content.jsp'>글제목</a></td>");
					if(dto.getReadcount() > 10){ //조회수가 10을 넘으면 핫 그림 출력
						out.println("<img src='"+conPath +"/img/hot.gif'>");
					}
					out.println("<a href='" + conPath + "/board/content.jsp?num="+dto.getNum()+"'>" 
							+ dto.getSubject() +"</a></td>");
					//, 메일, 조회수   READCOUNT
					out.println("<td>"+(dto.getEmail() != null ? dto.getEmail() : "") 
					+ "</td><td>" + dto.getReadcount() + "</td></tr>");
				}
			}
		%>
	</table>
</body>
</html>
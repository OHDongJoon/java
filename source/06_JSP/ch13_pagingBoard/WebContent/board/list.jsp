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
		<%  /*******************************수정부분1 ****************************************/	
			final int PAGESIZE = 10, BLOCKSIZE = 10; //변하지 않는 수들 선언  final 대문자로
			String pageNum = request.getParameter("pageNum");
			if(pageNum==null){
			pageNum = "1"; // 전달받은 pageNum 파라미터가 없으면  1페이지로 설정하겠다  String 이니
			}
			int currentPage = Integer.parseInt(pageNum); //형변환
			int startRow = (currentPage-1) * PAGESIZE + 1;
			// 3페이지 요청  -1 은 2 * pagesize(10) 하면 20 + 1 하면 21등부터 출력
			int endRow = startRow + PAGESIZE - 1;
			//             21이면 + 10 = 31 -1 = 30등까지 
			/*****************************수정부분2******************************************/		
			
			BoardDao dao = BoardDao.getInstance();
			int totalCnt = dao.getBoardTotalCnt(); //등록된 글 갯수 
			if(totalCnt == 0){ // 갯수가 0이면
				out.println("<tr><td colspan='5'>등록된 글이 없습니다</td></tr>");
			}else{
				ArrayList<BoardDto> dtos = dao.listBoard(startRow,endRow);/****************수정부분3**************************************/
				for(BoardDto dto : dtos){
					//글번호num , 작성자 writer 
					out.println("<tr><td>" + dto.getNum() + "</td><td>" + dto.getWriter()+"</td>");
					//글제목  SUBJECT 
					out.println("<td class='left'>"); //<img src='/ch13_board/img/hot.gif'>
													//	<a href='/ch13_board/board/content.jsp'>글제목</a></td>");
					if(dto.getReadcount() > 10){ //조회수가 10을 넘으면 핫 그림 출력
						out.println("<img src='"+conPath +"/img/hot.gif'>");
					}
					// <a href="content.jsp?num=글번호&pageNum=현페이지수'> 글 제목</a>+"
					out.println("<a href='" + conPath + "/board/content.jsp?num="+dto.getNum()+
							"&pageNum=" + pageNum + "'>" //pagNum 추가
									+ dto.getSubject() +"</a></td>");
					//, 메일, 조회수   READCOUNT
					out.println("<td>"+(dto.getEmail() != null ? dto.getEmail() : "") 
					+ "</td><td>" + dto.getReadcount() + "</td></tr>");
				}
			}
		%>
	</table>
	<div class="paging">
	<%
		int pageCnt = (int)Math.ceil((double)totalCnt / PAGESIZE); // 페이지 갯수 ceil은 double이여서 14.5 나오니 int 로 형변환 페이기 갯수 (다음 블록 여부)
		int startPage = ((currentPage-1)/BLOCKSIZE) * BLOCKSIZE + 1; //현제 페이지가 10이면 1
		int endPage = startPage + BLOCKSIZE - 1; // 
		if(endPage > pageCnt){ //끝페이지가 페이지보다 크면
			endPage = pageCnt; // 페이지를 끝페이지로 설정
		}
		if(startPage > BLOCKSIZE){ //이전블록이 있는지 여부  10보다 크면 이전 이 있는거고 1 .2 3. 은 이전이 없자나 <a href="list.jsp?pageNum=10"> 이전</a>
			out.println("[<a href='list.jsp?pageNum="+(startPage-1)+"'>이전블록</a> ] ");
		}
		for(int i=startPage ; i <= endPage ; i++){
			if(i==currentPage){ //페이지 수만 출력 (빨간색) <b>2</b>
				out.println("[ <b>" + i+"</b> ]");				
			}else{ //a 태그를 포함한 페이지 수 출력 <a href = 'list.jsp?pageNum=10'
				out.println("[ <a href='list.jsp?pageNum="+i+"'>" +i+ "</a> ]");
			}
		}
		if(endPage < pageCnt){ // 다음 블록이 있는지 여부 <a href='list.jsp?pageNum=다음블록첫페이지'>다음</a>
			out.println("[ <a href='list.jsp?pageNum="+ (endPage+1) + "'>다음</a> ]");
		}
	%>
	</div>
	
</body>
</html>
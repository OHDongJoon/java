<%@page import="com.lec.book.BookDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.book.BookDao"%>
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
	<table><tr>
<%
	String pageNum = request.getParameter("pageNum");//p
	if(pageNum == null) pageNum="1";//p
	int currentPage = Integer.parseInt(pageNum); // pageNum 을 숫자로 받은 currentPage 씨
	final int PAGESIZE=3, BLOCKSIZE=4;//p
	int startRow = (currentPage-1) * PAGESIZE +1;//p
	int endRow = startRow + PAGESIZE -1;//p
	BookDao bDao = BookDao.getInstance();
	ArrayList<BookDto> books = bDao.listBook(startRow,endRow);
	for(int i=0 ; i <books.size() ; i++){
%>	
		<td>
		  <a href="ex4_detail.jsp?bid=<%=books.get(i).getBid()%>&pageNum=<%=pageNum%>"> <!-- 수정 -->
		  <img src="../bookImg/<%=books.get(i).getBimage1() %>"><br>
		  <%=books.get(i).getBtitle() %><br>
		  </a>  <!--  상세보기  -->
		  <del><%=books.get(i).getBprice() %></del><br> (<%=books.get(i).getBdiscount()%>할인)<br>
		  <b><%=books.get(i).getBprice()*(100-books.get(i).getBdiscount())/100 %>원</b>
		</td>
		<%if(i%3==2) out.println("</tr><tr>"); %>
	<%}%>

</tr></table>
<div class="paging">
	<%
	int bookTotalCnt = bDao.getBookTotCnt(); // 전체 데이터베이스에 저장된 책 갯수 
	int pageCnt		=(int)Math.ceil((double)bookTotalCnt/PAGESIZE); // 페이지 갯수
	int startPage	=((currentPage-1)/BLOCKSIZE)*BLOCKSIZE +1; // 시작페이지
	int endPage		= startPage + BLOCKSIZE -1; // 끝페이지
	if(endPage > pageCnt){
		endPage = pageCnt;
	}
	// Bloksize = 4
	if(startPage > BLOCKSIZE){
		%>	
		[ <a href="ex3_list_productp.jsp?pageNum=<%=startPage-1%>">이전</a>]
	<% }
	for(int i=startPage ; i<=endPage ; i++){
		if(i==currentPage){
			out.println("[ <b> "+i+"</b>]");
		}else{
			out.println("[ <a href='ex3_list_productp.jsp?pageNum="+i+"'>"+i+"</a>]");
		}
	}
	if(endPage<pageCnt){
		%>
		[ <a href="ex3_list_productp.jsp?pageNum=<%=endPage+1%>">다음</a>]
	<% }%>
		
	</div>
</body>
</html>
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
	<script src="http://code.jquery.com/jquery-3.6.0.js"></script>
	<script>
	$(document).ready(function(){
		
	});
	function trclicked(bid){
		//bid 로 상세 보기 
		location.href = '${conPath }/detail.do?bid='+bid+'&pageNum=${paging.currentPage}';
	}
	</script>
</head>
<body>
<c:if test="${not empty writeResult }">
	<script>alert('글쓰기 성공')</script>
</c:if>
<c:if test="${not empty updateResult }">
	<script>alert('글수정 성공')</script>
</c:if>
<c:if test="${not empty deleteResult }">
	<script>alert('글삭제 성공')</script>
</c:if>
<c:if test="${not empty replyResult }">
	<script>alert('글답변 성공')</script>
</c:if>
<c:set var="num" value="${paging.totCnt - paging.startRow + 1 }"/>
	<table>
		<caption>게시판</caption>
		<tr>
		  <td colspan="6" align="right"><a href="${conPath }/writeForm.do">글쓰기</a>
		 </td>
	    </tr>
	    <tr>
	     <th>글번호</th>
	     <th>작성자</th>
	     <th>글제목</th>
	     <th>IP</th>
	     <th>작성일</th>
	     <th>조회수</th>
	    </tr>
	    <c:forEach items="${boardList }" var = "bod">
	    	<tr onclick="trclicked(${bod.bid})">
	    		<td>${bod.bid }</td>
	    		<td>${bod.bname }</td>
	    		<td class="left">
	    		<c:forEach var="i" begin="1" end="${bod.bindent }">
	    		  <c:if test="${i == bod.bindent }">
	    		  ┗ 
	    		  </c:if>
	    		  <c:if test="${i != bod.bindent }">
	    		  &nbsp; &nbsp; &nbsp;
	    		  </c:if>
	    		</c:forEach>
	    		${bod.btitle }
	    		</td>
	    		<td>${bod.bip }</td>
	    		<td>${bod.bdate }</td>
	    		<td>${bod.bhit }</td>
	    	</tr>
	    </c:forEach>
	    <tr>
	    </tr>
	   
	</table>
	<br>
	<div class="paging">
		<c:if test="${paging.startPage > paging.blockSize }">
		  [ <a href="${conPath }/boardList.do?pageNum=${paging.startPage-1}">이전</a>]
		</c:if>
		<c:forEach var="i" begin="${paging.startPage }" end="${paging.endPage }">
		   <c:if test="${i eq paging.currentPage }">
		      [<b>${i }</b>]
		   </c:if>
		   
		   <c:if test="${i != paging.currentPage }">
		     [<a href="${conPath }/boardList.do?pageNum=${i}">${i }</a>]
		   </c:if>
		</c:forEach>
		<c:if test="${paging.endPage < paging.pageCnt }">
			[<a href="${conPath }/boardList.do?pageNum=${paging.endPage+1}">다음</a>]
		</c:if>
	</div>	
</body>
</html>
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
	</script>
</head>
<body>
	   <table>
		<caption>상세보기</caption>
		<tr>
			<th>글번호</th>
			<td>${boardDto.bid }</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${boardDto.bname }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${boardDto.btitle }</td>
		</tr>
		<tr>
			<th>본문</th>
			<td>${boardDto.bcontent }</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td><fmt:formatDate value="${boardDto.bdate }"
					pattern="yy/MM/dd(E)" /></td>
		</tr>
		<tr>
			<th>IP</th>
			<td>${boardDto.bip }</td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${boardDto.bhit }</td>
		</tr>
		<tr>
		  <td colspan="2">
		     <button onclick="location='${conPath}/updateView.do?bid=${param.bid }&pageNum=${param.pageNum }'">수정</button>
		     <button onclick="location='${conPath}/delete.do?bid=${param.bid }&pageNum=${param.pageNum }'">삭제</button>
		     <button onclick="location='${conPath}/reply.do?bid=${param.bid }&pageNum=${param.pageNum }'">답변</button>
		     <button onclick="location='${conPath}/boardList.do'">목록</button>
		 </td>
		</tr>
	</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${conPath }/css/style.css" rel="stylesheet">
</head>
<body>
<c:set var="SUCCESS" value="1"></c:set>
<c:set var="FAIL" value="0"></c:set>
<c:if test="${modifyResult eq SUCCESS }">
	<script >alert('수정 성공');</script>
</c:if>
<c:if test="${modifyResult eq FAIL}">
	<script >alert('수정 실패'); history.back();</script>
</c:if>
	<%-- 이쁘게 ${bDto }  ${param.bid } ${param.pageNum } 들어옴  --%>
	<table>
		<caption>상세보기</caption>
		<tr>
			<th>글번호</th>
			<td>${bDto.bid }</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${bDto.bname }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${bDto.btitle }</td>
		</tr>
		<tr>
			<th>본문</th>
			<td>${bDto.bcontent }</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td><fmt:formatDate value="${bDto.bdate }"
					pattern="yy/MM/dd(E)" /></td>
		</tr>
		<tr>
			<th>IP</th>
			<td>${bDto.bip }</td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${bDto.bhit }</td>
		</tr>
		<tr>
		  <td colspan="2">
		     <button onclick="location='${conPath}/mvcboard/modify.do?bid=${param.bid }&pageNum=${param.pageNum }'">수정</button>
		     <button onclick="location='${conPath}/mvcboard/delete.do?bid=${param.bid }&pageNum=${param.pageNum }'">삭제</button>
		     <button onclick="location='${conPath}/mvcboard/reply.do?bid=${param.bid }&pageNum=${param.pageNum }'">답변</button>
		     <button onclick="location='${conPath}/mvcboard/list.do?pageNum=${param.pageNum }'">목록</button>
		 </td>
		</tr>
	</table>
</body>
</html>










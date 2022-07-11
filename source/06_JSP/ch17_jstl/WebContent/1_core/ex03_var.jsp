<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
 	<h2>변수 선언과 출력</h2>
 	<c:set var="varName" value="varValue"/> <!--  변수 선언 -->
       varName : ${varName }<br>
    <c:set var="varName" value="abc <varValue>"/>
     varName : ${varName }<br>
     
     <!-- 변수 출력excapeXml="true" :특수문자 인식 -->
     varName : <c:out value="${varName }" escapeXml="true"/>
     
      <c:remove var="varName"/> <!-- 변수 삭제 --> 
      varName : ${varName }<br>
      varName : ${empty varName ? "삭제되서 없음" : "남아 있음" }<br>
      varName : <c:out value="${varName }" default="없어진 변수"/>
        
</body>
</html>

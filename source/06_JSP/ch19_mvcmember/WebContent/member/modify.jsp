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
</head>
<body>
	<c:if test="${empty member }"> <!-- 로그인 전이면 로그인 페이지로 가기 -->
		<script>location.href="loginView.do";</script>
	</c:if>
	
	<form action="${conPath }/modify.do" method="post" enctype="multipart/form-data">
	<input type="hidden" name="dbmPhoto" value="${member.mphoto }">
	<table>
     <caption>정보수정</caption>
         <tr>
             <th>아이디</th>
             <td><input type="text" name="mid" value="${member.mid }" required="required"></td>
             <td rowspan="4"><img src="${conPath }/memberPhotoUp/${member.mphoto }" width="100"></td>
        </tr>
        <tr>
                <th>비밀번호</th>
                  <td><input type="password" name="mpw" value="${member.mpw }" required="required"></td>
        </tr>
        <tr>
	        <th>이름</th>
	        <td><input type="text" name="mname" value="${member.mname }" required="required"></td>
        </tr>
         <tr>
	        <th>메일</th>
	        <td><input type="email" name="memail" value="${member.memail }"></td>
        </tr>
        <tr>
				<th>사진</th>
				<td colspan="2"><input type="file" name="mPhoto"></td>
			</tr>
        
        <tr>
	        <th>생년월일</th>
	        <td><input type="date" name="mbirth" value="${member.mbirth }"></td>
        </tr>
        <tr>
	        <th>주소</th>
	        <td><input type="text" name="maddress" value="${member.maddress }"></td>
        </tr>
        <tr>
          <td colspan="3">
            <input type="submit" value="정보수정">
            <input type="reset" value="취소" >
            <input type="reset" value="이전" onclick="history.go(-1)">
          </td>	
        </tr>
	</table>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {

}
*{
  margin : 0 auto;
}
li{
 list-style: none;
  float: left;
  width: 120px;
  height: 30px;
}
a{
text-decoration: none;
 color:white;
}
header {
 text-align: center;
 width: 1200px;
 height: 70px;
 border: 1px solid black;
 background-color: blue;
 color: white;
}
nav {
 background-color: red;

 overflow: hidden;

}

</style>
</head>
<body>
	<header>
	쇼핑몰 회원관리 ver 1.0
	</header>
	<nav>
	<ul>
	  <li><a href="../memberjoin.do">회원등록</a></li>
	  <li><a href="../memberList.do">회원정보리스트</a></li>
	  <li><a href="../memberMoney.do">회원매출조회</a></li>
	  <li><a href="../main.do">홈으로</a></li>
	</ul>
	</nav>
</body>
</html>
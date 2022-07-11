<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
*{margin:0 auto;}
section{
width: 1200px;
height: 400px;
border: 1px solid black;
}
h1{
 text-align: center;
}
</style>
</head>
<body>
  <jsp:include page="main/header.jsp"/>
  <section>
    <div class="title">
      <h1>쇼핑몰회원관리프로그램</h1>
    </div>
    <div class="contnet">
     <p>쇼핑몰 회원정보의 회원매출첩보 데이터베이스를 구축하고 회원관리 플고그램을 작성하는 프로그램이다.</p>
     <p>1.회원정보 테이블을 생성한다</p>
     <p>2.매출정보 테이블을 생선한다</p>
     <p>3.회원정보,매출정보 테이블에 제시된 문서지의 참조데이터를 추가 생성한다.</p>
     <p>4.회원정보 입력  화면프로그램을 작성한다.</p>
     <p>회원정보 조회 프로그램을 작성한다.</p>
     <p>회원매출정보 조회 프로그램을 작성한다/</p>
    </div>
  </section>
  <jsp:include page="main/footer.jsp"/>
</body>
</html>
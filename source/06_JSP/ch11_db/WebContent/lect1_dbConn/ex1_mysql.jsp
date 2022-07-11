<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
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
<%!
 String driverMysql = "com.mysql.jdbc.Driver"; // mysql 연동 
 String urlMysql = "jdbc:mysql://localhost:3306/kimdb"; // url 연결?
 String uidMysql  = "root"; //id
 String upwMysql = "mysql"; // 비번
 

%>
	<table>
	<%	//jav.sql
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs	= null;
		String    sql   ="SELECT * FROM PERSONAL"; //대문자 바꾸기 컨 쉬 x  소문자 y
		//예외메세지만 보기위해서
		try{
			Class.forName(driverMysql); // 1단계 : 드라이버 로드 
			conn = DriverManager.getConnection(urlMysql, uidMysql, upwMysql); // 2단계  : DB연결 객체
			stmt = conn.createStatement(); //3단계 : sql 전송객체
			rs = stmt.executeQuery(sql); // 4단계(SQL전송) + 5 단계(전송결과 받기 )
			if(rs.next()){ //가져올거 있어 ?? 있으면 true 없으면 else  6단계 결과를 이용해서 적당한 로직수행
				out.println("<tr><th>사번</th><th>이름</th><th>직책</th><th>상사사번</th><th>입사일</th>");
				out.println("<th>급여</th><th>상여</th><th>부서번호</th></tr>"); //타이틀
				
				do{//maysql 이름과 똑같이 pno,pname 등등.. 변수이름과 db의 타이틀이름과 같게하는것을추천
					int pno 		=rs.getInt("pno");
					String pname 	= rs.getString("pname");
					String job 		= rs.getString("job") ;
					int manager		= rs.getInt("manager");
					String startdate = rs.getString("startdate");
					int pay			= rs.getInt("pay");
					int bonus		= rs.getInt("bonus");
					int dno			= rs.getInt("dno");
					out.println("<tr><td>" + pno +"</td><td>"+pname+"</td><td>"+job +"</td><td>" + manager);
					out.println("</td><td>" +startdate +"</td><td>" + pay + "</td><td>" + bonus + "</td><td>" + dno);
					out.println("</td></tr>");
				}while(rs.next());
			}else{
				out.println("<tr><td>입력된 데이터가 없습니다</td></tr>");
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			try{ // 7단계 : 연결 해제
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
	%>
	</table>
</body>
</html>







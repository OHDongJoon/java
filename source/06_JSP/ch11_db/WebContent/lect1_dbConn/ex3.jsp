<%@page import="java.sql.Timestamp"%>
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
<%
	String deptnoStr = request.getParameter("deptno");
	if(deptnoStr == null) deptnoStr = "-1";
	int deptno = Integer.parseInt(deptnoStr);
	String driver = "oracle.jdbc.driver.OracleDriver"; // mysql 연동 
	String url = "jdbc:oracle:thin:@localhost:1521:xe"; // url 연결?
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	String sql = "SELECT * FROM DEPT" ;// 하나는 부서찾는거 하나는 사원 
%>
	<form action="">
		부서번호<select name="deptno">
			<option value='0'></option>
			<!-- ...DB에서 가져온 부서번호를 option -->
			<%
			try{
				Class.forName(driver);  //1단계
				conn = DriverManager.getConnection(url, "scott" , "tiger"); //2단계
				stmt = conn.createStatement(); // 3단계 
				rs = stmt.executeQuery(sql);
				while(rs.next()){
					int deptnoDB = rs.getInt("deptno");  //  get Int로 deptno를 받아와서 deptnoDB에  10 20 30 40 을 출력해주는 값 
					String dname = rs.getString("dname");
					// <option value='10' selected='selected'>10 - SALES</option> (선택된 파리미터와 같을 때)
					// <option value='10'>10 - 'SALES' </option>
					if(deptno != deptnoDB){
					out.println("<option value='" + deptnoDB +"'>"+deptnoDB + "-" + dname + "</option>");						
					}else{
						out.println("<option value='" + deptnoDB + "'selected='selected'>" + deptnoDB + "-" + dname + "</option>");
						
					}
				}
			}catch(Exception e){
				System.out.println(e.getMessage());
			}finally{
				if(rs!=null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			}
			%>
			</select>
		<input type="submit">
		<%if (deptno != -1) {%>
		<table>
		<!--  파라미터로 받은 부서번호의  사원정보 테이블에 추가  -->
		<%
	       sql = "SELECT * FROM EMP WHERE DEPTNO ="+deptno;
		 try{
			 conn = DriverManager.getConnection(url,"scott", "tiger"); //(2)
			 stmt = conn.createStatement(); //3단계
			 rs = stmt.executeQuery(sql);
			 if(rs.next()){ // 해당부서 사원이 있는 경우 
				 out.println("<tr><th>이름</th><th>입사일</th><th>급여</th><th>부서번호</th></tr>");
			 	do{
			 		String ename = rs.getString("ename");
			 		Timestamp hiredate = rs.getTimestamp("hiredate");
			 		int sal = rs.getInt("sal");
			 		out.println("<tr><td>"+ename + "</td><td>" + hiredate + "</td><td>" + sal + "</td><td>" + deptno + "</td></tr>" );
			 	}while(rs.next());
			 }else{ // 해당 부서 사원이 없는 경우
				  out.println("<tr><td>사원이 없습니다</td></tr>");
			 }
		 }catch(Exception e){
			 System.out.println(e.getMessage());
		 }finally{
				if(rs!=null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			}
		%>
		</table>
		<%} %>
	</form>
</body>
</html>














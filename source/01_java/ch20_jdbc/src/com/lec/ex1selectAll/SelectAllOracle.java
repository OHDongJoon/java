package com.lec.ex1selectAll;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
//select문 - 결과가 여러줄

// insert, update, delete문 - 결과가 정수 

public class SelectAllOracle {
	public static void main(String[] args) {
		String driver ="oracle.jdbc.driver.OracleDriver";
		String  url	 = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null;// DB 연결 객체 변수
		Statement stmt = null;// SQL전송 객체 변수 
		ResultSet rs	= null; // SELECT문 결과 받는 객체 변수
		String query = "SELECT * FROM EMP";
		try {
			Class.forName(driver); // (1) 드라이버 로드
			conn = DriverManager.getConnection(url, "scott", "tiger"); // (2) DB 연결
			stmt = conn.createStatement(); // (3). SQL 전송 객체 생성
			rs   = stmt.executeQuery(query); // (4) SQL 전송  + (5) SQL 전송 결과 받기 
			// (6)  결과 받아 원하는 로직 수행
			System.out.println("사번\t이름\t직책\t상사사번\t입사일\t급여\t상여\t부서번호");
			while(rs.next()) {   // rs.next()
				int empno = rs.getInt("empno");
				//String 	empno = rs.getString("empno"); // sql 에 있는 empno 타이틀 
				String 	ename = rs.getString("ename");
				String 	job	 = rs.getString("job");
				int    	mgr	 = rs.getInt("mgr");
				//Date   hiredate = rs.getDate("hiredate");
				//String hiredate = rs.getString("hiredate"); 요짓안함 
				Timestamp hiredate = rs.getTimestamp("hiredate");
				int       sal  = rs.getInt("sal");
				int		  comm  = rs.getInt("comm");
				int		   deptno = rs.getInt("deptno"); // 특수문자가 있으면 엘리아스 사용하자
				if(job.length() < 8) {
				System.out.printf("%d\t%s\t%s\t%d\t%TF\t%d\t%d\t%d\n",
										empno, ename, job, mgr, hiredate, sal, comm, deptno);
				}else {
					System.out.printf("%d\t%s\t%s\t%d\t%TF\t%d\t%d\t%d\n",
							empno,ename,job,mgr,hiredate,sal,comm,deptno);
				}
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally { // (7) 연결 해제
			// 클로즈는 반대로 rs - stmt - conn
			try {
				if(rs!=null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
	}
}

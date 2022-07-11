package com.lec.ex2selectWhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/* 1. 사용자에게 부서명을 입력받아
 * 	1-1. 부서존재하는 경우 : 부서정보와 사원정보(사번, 이름, 급여, 급여등급)를 출력
 *  1-2. 부서존재하지 않는 경우 : 없다고 출력 */



public class Ex3_selectDnameEmp {
	public static void main(String[] args) {
		String driver ="oracle.jdbc.driver.OracleDriver";
		String  url	 = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs   = null;
		Scanner scanner = new Scanner(System.in);
		System.out.println("원하는 부서명은 ? ");
		String dname = scanner.next();
		String sql1 = "SELECT  * FROM DEPT WHERE DNAME  = UPPER('"+dname+"')"; // 부서 있냐고 물어봄
		
		
		sql1 = String.format(" SELECT  * FROM DEPT WHERE DNAME  = UPPER('%s')", dname); // printf 랑 비슷함
		
		String sql2 = String.format(" SELECT EMPNO, ENAME, SAL, GRADE " + 
									"    FROM EMP E, SALGRADE , DEPT D " + 
									"    WHERE SAL BETWEEN LOSAL AND HISAL AND E.DEPTNO=D.DEPTNO" +
									" AND DNAME = UPPER('%s')", dname);
		 try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger"); // 2 로그인 똑바로 됬는지 
			stmt = conn.createStatement(); // 3  로그인 똑바로 햇으면  sql 통신
			
			rs = stmt.executeQuery(sql1); // 4 + 5 ??? select 할때만 함 
			if(rs.next()) {
				System.out.println("부서번호 : " + rs.getInt("deptno"));
				System.out.println("부서이름 : " + rs.getString("dname"));
				System.out.println("부서위치 : " + rs.getString("loc"));
				rs.close();
				rs = stmt.executeQuery(sql2); // 4 + 5
				if(rs.next()) {
					do {//EMPNO, ENAME, SAL, GRADE
						int empno = rs.getInt("empno"); 
						String ename = rs. getString("ename");
						int sal = rs.getInt("sal");
						int grade = rs.getInt("grade");
						System.out.println(empno+"\t" + ename + "\t" + sal + "\t" + grade + "둥굽");
					}while(rs.next());
				}else {
					System.out.println(dname + "부서의 사원은 존재하지 않습니다");
				}
				
			}else {
				System.out.println("해당 부서이름은 유효하지 않습니다");
			}
		 } catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				
			}
		}
	}
}

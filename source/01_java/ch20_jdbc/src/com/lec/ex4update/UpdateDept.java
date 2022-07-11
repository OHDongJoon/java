package com.lec.ex4update;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class UpdateDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner scanner = new Scanner(System.in);
		Connection conn = null;
		Statement  stmt = null;
		System.out.print("������ �μ���ȣ ?");
		int deptno = scanner.nextInt();
		System.out.print("������ �μ��� ?");
		String dname = scanner.next();
		System.out.print("������ ��ġ�� ?");
		String loc = scanner.next();
		String sql = "UPDATE DEPT SET DNAME='"+dname+"', LOC='"+loc+"' WHERE DEPTNO="+deptno;
		try {
			Class.forName(driver);//(1)
			conn = DriverManager.getConnection(url, "scott", "tiger"); // (2)
			stmt = conn.createStatement(); // (3)
			int result = stmt.executeUpdate(sql); // (4)+(5)
			System.out.println(result>0? "��������":"�ش� �μ��� ���� �� ��"); // (6)
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try { // (7)
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}// main
}
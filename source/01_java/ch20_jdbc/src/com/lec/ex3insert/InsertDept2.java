package com.lec.ex3insert;
// �μ���ȣ�� �Է¹޾� �ߺ�üũ Ȯ���� �Է�����
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class InsertDept2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner scanner = new Scanner(System.in);
		Connection conn = null;
		Statement  stmt = null;
		ResultSet  rs   = null;
		System.out.print("�Է��� �μ���ȣ�� ?");
		int deptno = scanner.nextInt();
		// �μ���ȣ �ߺ�üũ
		String selectSQL = "SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO="+deptno;
		try {		
			Class.forName(driver);//(1)
			conn = DriverManager.getConnection(url, "scott","tiger"); // (2)
			stmt = conn.createStatement(); // (3)
			rs   = stmt.executeQuery(selectSQL); // (4)+(5)
			rs.next();
			int cnt = rs.getInt("cnt");
			if(cnt!=0) {
				System.out.println("�ߺ��� �μ���ȣ�� �Է��� �Ұ��մϴ�.");
			}else {
				System.out.print("�Է��� �μ��̸��� ?");
				String dname = scanner.next();
				System.out.print("�Է��� �μ���ġ�� ?");
				scanner.nextLine(); // ���� clear
				String loc = scanner.nextLine();
				String insertSql 
					= String.format("INSERT INTO DEPT VALUES (%d,'%s','%s')", deptno, dname, loc);
				int result = stmt.executeUpdate(insertSql);
				if(result>0) {
					System.out.println("�Է� ����");
				}
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println("SQL���� :" + e.getMessage());
		} finally {
			try { // (7)
				if(rs  !=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				
			}
		}
	}
}


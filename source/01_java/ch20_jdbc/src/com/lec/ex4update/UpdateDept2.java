package com.lec.ex4update;
// �����ϰ��� �ϴ� �μ���ȣ �Է� -> �����ϴ� �μ���ȣ���� üũ -> �μ���� ��ġ�� �޾� ����
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class UpdateDept2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner scanner = new Scanner(System.in);
		Connection conn = null;
		Statement  stmt = null;
		ResultSet  rs   = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			System.out.print("������ �μ���ȣ ?");
			int deptno = scanner.nextInt();
			// �Է��� �μ���ȣ�� �ִ��� üũ
			String selectSql = "SELECT * FROM DEPT WHERE DEPTNO="+deptno;
			rs = stmt.executeQuery(selectSql);
			if(rs.next()) { // ��������
				System.out.print("������ �μ��� ?");
				String dname = scanner.next();
				System.out.print("������ ��ġ�� ?");
				String loc = scanner.next();
				// ����
				String insertSql = "UPDATE DEPT SET DNAME='"+dname+"', LOC='"+
									loc+"' WHERE DEPTNO="+deptno;
				int result = stmt.executeUpdate(insertSql); 
				System.out.println(result>0? "��������":"��������");
			}else {
				System.out.println(deptno+"�� �μ���ȣ�� ��ȿ�� �μ���ȣ�� �ƴմϴ�");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try { // (7)
				if(rs!=null)   rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}// main
}
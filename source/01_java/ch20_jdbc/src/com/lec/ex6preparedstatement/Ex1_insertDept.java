package com.lec.ex6preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class Ex1_insertDept {

		public static void main(String[] args) {
			String driver = "oracle.jdbc.driver.OracleDriver";
			String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			Scanner scanner = new Scanner(System.in);
			// �߰��� ������ �ޱ�
			System.out.print("�߰��� �μ���ȣ ?");
			int deptno = scanner.nextInt();
			System.out.println("�߰��� �μ��̸�?");
			String dname = scanner.next();
			System.out.println("�߰��� �μ���ġ?");
			String loc = scanner.next();
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "INSERT INTO DEPT VALUES (?, ?, ?)";
			
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url,"scott", "tiger");
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1,  deptno); // sql�� ù���� ����ǥ�� int������ deptno�� setting
				pstmt.setString(2,  dname); // �ι��� ����ǥ�� String ������ dnamd�� setting
				pstmt.setString(3,  loc);
				int result = pstmt.executeUpdate();
				// int result = stmt.executeUpdate(sql);
				System.out.println(result > 0 ? deptno + "�μ� �Է� ����" : "�Է� ����");
				} catch (ClassNotFoundException e) {
				System.out.println(e.getMessage());
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}finally {
				try { // (7)
					if(pstmt!=null)   pstmt.close();
					if(conn!=null) conn.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
		}
}
}
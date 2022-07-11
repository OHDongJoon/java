package com.lec.ex5_QUIZ;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lec.ex4_supermarket.CustomerDao;

public class CustomerDao2 {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	private static CustomerDao2 INSTANCE = new CustomerDao2();

	public static CustomerDao2 getInstance() {
		return INSTANCE;
	}

	private CustomerDao2() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	// 1. 회원가입 
	public int insertCustomer2(String stel, String sname) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = " INSERT INTO CUSTOMER (sNO, sTEL, sNAME)" + "    VALUES (CUSTOMER_SEQ.NEXTVAL, ?, ?)";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, stel);
			pstmt.setString(2, sname);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}

	// 2.폰4자리 폰조회 
	
	public ArrayList<CustomerDto2> sTelGetCustomer2(String stel) {
		ArrayList<CustomerDto2> dtos = new ArrayList<CustomerDto2>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = " SELECT*FROM CUSTOMER " + 
				"            WHERE  sTEL LIKE'%'||? ";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, stel);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				stel = rs.getString("stel");
				String sname = rs.getString("sname");
				int spoint = rs.getInt("spoint");
				dtos.add(new CustomerDto2(stel, sname, spoint));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return dtos;
	}
	// 출력버튼을 클릭하면, 가입된 모든 회원정보를 JTextArea에 출력된다.
	public ArrayList<CustomerDto2> getCustomers(){
		ArrayList<CustomerDto2> dtos = new ArrayList<CustomerDto2>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM CUSTOMER";
		try {
			conn = DriverManager.getConnection(url,"scott","tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int sid = rs.getInt("sid");
				String stel = rs.getString("stel");
				String sname = rs.getString("sname");
				int spoint = rs.getInt("spoint");
				dtos.add(new CustomerDto2(stel, sname, spoint));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs != null)rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return dtos;
	}
}
















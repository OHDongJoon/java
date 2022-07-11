package com.lec.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.lec.dto.CustomerDto;

public class CustomerDao {
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	public static final int CUSTOMER_NONEXISTENT = 1;
	public static final int CUSTOMER_EXISTENT = 0;
	public static final int LOGIN_SUCCESS = 1;
	public static final int LOGIN_FAIL = 0;

	// 싱글톤
	private static CustomerDao instance = new CustomerDao();

	public static CustomerDao getInstance() {
		return instance;
	}

	private CustomerDao() {
	}

	// Connection 객체 얻어오는 함수
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection(); // sqlExcepton 처리
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	// 1. 회원가입시 CID 중복체크
	public int confirmCid(String cid) {
		int result = CUSTOMER_EXISTENT; // 최악 조건 초기화
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM CUSTOMER WHERE CID=?";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = CUSTOMER_EXISTENT; // 중복 id 있음
			} else {
				result = CUSTOMER_NONEXISTENT; // 중복 id 없음
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)rs.close();
				if (pstmt != null)pstmt.close();
				if (conn != null)conn.close();

			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		return result;
	}
	//2. 회원가입
	public int insertCustomer(CustomerDto dto) {
		int result = FAIL;
		Connection 		  conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO CUSTOMER(CID, CPW, CNAME, CTEL, CEMAIL, CADDRESS, CGENDER, CBIRTH)" + 
				"    VALUES (?,?,?,?,?, ?,?,?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCid());
			pstmt.setString(2,  dto.getCpw());
			pstmt.setString(3, dto.getCname());
			pstmt.setString(4, dto.getCtel());
			pstmt.setString(5,dto.getCemail());
			pstmt.setString(6, dto.getCaddress());
			pstmt.setString(7,dto.getCgender());
			pstmt.setDate(8, dto.getCbirth());
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS? "회원가입성공" : "회원가입실패");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "회원가입실패 :" + dto);
		}finally {
			try {	
				if (pstmt != null)pstmt.close();
				if (conn != null)conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	// 3. 로그인(cid / cpw)
	public int loginCheck(String cid, String cpw) {
		int result = LOGIN_FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM CUSTOMER WHERE CID=? AND CPW=?";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cid);
			pstmt.setString(2, cpw);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = LOGIN_SUCCESS; // id pw 맞암
			} else {
				result = LOGIN_FAIL; // id pw 중에하나 틀림
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)rs.close();
				if (pstmt != null)pstmt.close();
				if (conn != null)conn.close();

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	//4. CID로 DTO 가져오기
	public CustomerDto getCustomer(String cid) {
		CustomerDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM CUSTOMER WHERE CID=?";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cid);
			rs = pstmt.executeQuery();
			if (rs.next()) { // rs한줄 가져와서 객체로만들자
				// String cid;
				 String  cpw	= rs.getString("cpw");
				 String  cname	= rs.getString("cname");
				 String  ctel	= rs.getString("ctel");
				 String  cemail = rs.getString("cemail");
				 String  caddress = rs.getString("caddress");
				 String  cgender  = rs.getString("cgender");
				 Date    cbirth	  = rs.getDate("cbirth");
				 Date    crdate	   = rs.getDate("crdate");
				 dto = new CustomerDto(cid, cpw, cname, ctel, cemail, 
						 caddress, cgender, cbirth, crdate);
			} 
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)rs.close();
				if (pstmt != null)pstmt.close();
				if (conn != null)conn.close();

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return dto;
	}
	//5. 회원정보 수정하기
	public int updateCustomer(CustomerDto dto) {
		int result = FAIL;
		Connection 		  conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE CUSTOMER SET CPW=?," + 
				"                      CNAME         	=?," + 
				"                      CTEL             = ?," + 
				"                      CEMAIL         	= ?," + 
				"                      CADDRESS    		= ?," + 
				"                       CGENDER       	= ?," + 
				"                        CBIRTH         = ?" + 
				"                       WHERE CID     	= ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,  dto.getCpw());
			pstmt.setString(2, dto.getCname());
			pstmt.setString(3, dto.getCtel());
			pstmt.setString(4,dto.getCemail());
			pstmt.setString(5, dto.getCaddress());
			pstmt.setString(6,dto.getCgender());
			pstmt.setDate(7, dto.getCbirth());
			pstmt.setString(8, dto.getCid());
			result = pstmt.executeUpdate();
			System.out.println("회원수정 성공");
			System.out.println(result==SUCCESS? "회원수정성공" : "회원수정실패");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "회원수정실패 :" + dto);
		}finally {
			try {	
				if (pstmt != null)pstmt.close();
				if (conn != null)conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	//6. 회원리스트 보기(첫화면 main.jsp에서 사용할 부분 -top-n)
	public ArrayList<CustomerDto> listCustomer(int startRow , int endRow){
		ArrayList<CustomerDto> dtos = new ArrayList<CustomerDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT  *" + 
				"    FROM(SELECT ROWNUM RN, CID, CPW, CNAME, CEMAIL, CADDRESS " + 
				"                    FROM (SELECT * FROM CUSTOMER ORDER BY CID))" + 
				"    WHERE RN BETWEEN ? AND ? ";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) { // 한줄 보다 많으니 while
				 String cid		= rs.getString("cid");
				 String  cpw	= rs.getString("cpw");
				 String  cname	= rs.getString("cname");
				 String  cemail = rs.getString("cemail");
				 String  caddress = rs.getString("caddress");
				 dtos.add(new CustomerDto(cid, cpw, cname,null, cemail, caddress, null, null, null)); // Array 니가 add.
			} 
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)rs.close();
				if (pstmt != null)pstmt.close();
				if (conn != null)conn.close();

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		return dtos;
		
	}
	//7. 등록된 회원수   TOTCNT 엘리
	public int getCustomerCnt() {
		int totCnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) TOTCNT FROM CUSTOMER";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();// 무조건 한줄만 오니까 
			totCnt = rs.getInt("totcnt"); // 위에 엘리아스 TOTCNT 와 같게 
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)rs.close();
				if (pstmt != null)pstmt.close();
				if (conn != null)conn.close();

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return totCnt;
	}
}













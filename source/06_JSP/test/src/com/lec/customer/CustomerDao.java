package com.lec.customer;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class CustomerDao {
	public static final int SUCCESS = 1; //성공
	public static final int FAIL = 0;  //실패
	
	//싱글톤 객체 생성
	private static CustomerDao instance;
	public static CustomerDao getInstance() {
		if(instance==null) {
			instance = new CustomerDao();
		}
		return instance;
	}
	private CustomerDao() {}
	private  Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
		return conn;
	}
	//1. 회원가입시 ID중복체크:  public int  confirmID(String id)
	public int confirmId(String cid) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM CUSTOMER WHERE CID=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = FAIL;    // 중복 아이디 있어 사용 못해
			}else {
				result = SUCCESS;// 사용 가능 아디
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				
			}
		}
		return result;
	}
	//2.회원가입 : public int joinCustomer(CustomerDto dto)
	public int joinCustomer(CustomerDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO CUSTOMER (CID,CNAME,CPW,CTEL,CEMAIL,CADDRESS,CGENDER,CBIRTH,CRDATE)" + 
				"    VALUES(?,?,?,?,?,?,?,?,SYSDATE)";
		try {
			conn =getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCid());
			pstmt.setString(2, dto.getCname());
			pstmt.setString(3, dto.getCpw());
			pstmt.setString(4, dto.getCtel());
			pstmt.setString(5, dto.getCemail());
			pstmt.setString(6, dto.getCaddress());
			pstmt.setString(7, dto.getCgender());
			pstmt.setTimestamp(8, dto. getCbirth());
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS? "회원가입 성공" : "회원가입 실패");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("회원가입 실패 :" + dto);
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				
			}
		}
		return result;
	}
	//3.로그인(id/pw) :SELECT id,pw FROM 
	public int loginCheck(String cid, String cpw) {
		int result = FAIL; // 초기화
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT CID,CPW FROM CUSTOMER WHERE CID =?";
		try {
			conn=getConnection();
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, cid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String pwDB = rs.getString("cpw");
				if(pwDB.equals(cpw)) {
					result = SUCCESS;
				}else {
					result = FAIL;  // 비번 틀림
				}
			}else {
				result = FAIL; // 유효하지 않은 id
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
		}
		
		}
		return result;
	}
//4. ID로 dto 모든 변수값 가져오기
	public CustomerDto getCustomer(String cid) {
		CustomerDto dto = null; //불러올 값 없으면 널
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM CUSTOMER WHERE CID=?";
		try {
			conn=getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
			 String cname	= rs.getString("cname"); // 이름
			 String cpw		= rs.getString("cpw"); // 비번
			 String ctel	= rs.getString("ctel"); // 전번
			 String cemail  = rs.getString("cemail"); // 이메일
			 String caddress= rs.getString("caddress"); //주소
			 String cgender  = rs.getString("cgender");; // 성별
			 Timestamp cbirth = rs.getTimestamp("cbirth");;// 생년월일
			 Date 	  crdate  = rs.getDate("crdate");
			 dto = new CustomerDto(cid, cname, cpw, ctel, cemail, caddress, cgender, cbirth, crdate);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				
			}
		}
		return dto;
	}
	//5. 회원정보 수정:
	public int modifyCustomer(CustomerDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE CUSTOMER SET CNAME=?," + 
				"                                        CPW= 		?," + 
				"                                        CTEL= 		?," + 
				"                                        CEMAIL = 	?," + 
				"                                        CADDRESS = ?," + 
				"                                        CGENDER = 	?," + 
				"                                        CBIRTH = 	? " + 
				"                                        WHERE CID= ?";
		try {
			conn =getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCname());
			pstmt.setString(2, dto.getCpw());
			pstmt.setString(3, dto.getCtel());
			pstmt.setString(4, dto.getCemail());
			pstmt.setString(5, dto.getCaddress());
			pstmt.setString(6, dto.getCgender());
			pstmt.setTimestamp(7, dto. getCbirth());
			pstmt.setString(8, dto.getCid());
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS ? "회원수정성공" : "회원수정실패패패");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("회원수정 실패 예외" + dto);
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				
			}
		}
		return result;
	}
}









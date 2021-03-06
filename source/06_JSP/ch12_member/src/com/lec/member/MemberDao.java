package com.lec.member;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class MemberDao {
	public static final int SUCCESS = 1; // 회원가입, 정보수정 시 성공 
	public static final int FAIL = 0; // 0행 업데이트햇슴다 회원가입, 정보수정 시 실패 
	public static final int MEMBER_EXISTEMT = 0; // 중복 id일때 리턴값
	public static final int MEMBER_NONEXISTENT = 1; // 사용가능한 ID일 때 리턴값
	public static final int LOGIN_SUCCESS = 1; //로그인성공
	public static final int LOGIN_FAIL_ID = -1 ; // 로그인시 ID 오류  실패 
	public static final int LOGIN_FAIL_PW = 0 ; // 로그인시 PW 오류  실패 

	//싱글톤 private로 만들어 버리면 다른곳에서 new 못함
	private static  MemberDao instance; // 자기가 자기 클래스 참조 하는 것  초기 값 null
	public static MemberDao getInstance() {
		if(instance==null) {
			instance = new MemberDao();
		}
		return instance;
	}
	private MemberDao() {}
	// conn 객체 리턴하는 함수 
	private  Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
		return conn;
	}
	//1. 회원가입시 ID중복체크:  public int  confirmID(String id)
	public int confirmId(String id) {
		int result = MEMBER_EXISTEMT;//초기화
		//중복인지 사용가능인지 sql으로 초기화 :SELECT * FROM MEMBER WHERE ID='aaa' ;
		Connection 			conn = null;
		PreparedStatement   pstmt = null;
		ResultSet 			rs = null;
		String sql = "SELECT * FROM MEMBER WHERE ID=?" ;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, id);
			rs = pstmt.executeQuery(); // 4 + 5
			if(rs.next()) {
				result = MEMBER_EXISTEMT; //중복된 id (회원가입시 중복된 id ) 있으면 그냥 rsult 넘겨 
			}else {
				result = MEMBER_NONEXISTENT; // 없는 id (사용가능한 id) 없으면 result 넘겨
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
	//2.회원가입 :public int joinMember(MemberDto dto) 변수 
	// 0행 업데이트햇슴다 회원가입, 정보수정 시 실패 
	public int joinMember(MemberDto dto) {
		int result = FAIL;
		// dto DB에 insert 입력받는 값이니 Resultset 안씀
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO MEMBER (ID, PW, NAME, PHONE1,PHONE2,PHONE3,GENDER,EMAIL,BIRTH,RDATE,ADDRESS)" + 
				"    VALUES (?,?,?,?,?,?,?,?, ?,SYSDATE,?)";
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dto.getId());
				pstmt.setString(2, dto.getPw());
				pstmt.setString(3,dto.getName());
				pstmt.setString(4,dto.getPhone1());
				pstmt.setString(5,dto.getPhone2());
				pstmt.setString(6,dto.getPhone3());
				pstmt.setString(7,dto.getGender());
				pstmt.setString(8,dto.getEmail());
				pstmt.setTimestamp(9,dto.getBirth());
				pstmt.setString(10, dto.getAddress());	
				result = pstmt.executeUpdate();
				System.out.println(result==SUCCESS? "회원가입성공" : "회원가입실패");
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("회원가입 실패 : " + dto); //dto.toString
			}finally {
				try {
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				}catch(Exception e) {
					
				}
			}
			
			return result;
		
	}
	
	
	//3.로그인 (id/pw) : SELECT id,pw FROM MEMBER WHERE ID ='aaa';
	// LOGIN_FAIL_ID = -1 ; // 로그인시 ID 오류  실패 
	public int loginCheck(String id, String pw) {
		int result = LOGIN_FAIL_ID; // 최악조건 초기화
		//
		Connection 			conn = null;
		PreparedStatement   pstmt = null;
		ResultSet 			rs = null;
		String sql = "SELECT id, pw FROM MEMBER WHERE ID =?" ;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, id);
			rs = pstmt.executeQuery(); // 4 + 5
			if(rs.next()) { // 유효한 id를 입력
				String pwDB = rs.getString("pw"); // 입력받은 값이 유효한 pw 
				if(pwDB.equals(pw)) {
					result = LOGIN_SUCCESS;
				}else {
					result = LOGIN_FAIL_PW;      // 아이디는 잘 입력했고 비번이 틀르면
				}
			}else {  // 유효하지 않은 id 
				result = LOGIN_FAIL_ID;
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
	//4. ID로 dto(모든변수값) 가져오기 :  SELECT * FROM MEMBER WHERE ID='aaa';
	public MemberDto getMember(String id) {
		MemberDto dto = null;// 최악의경우  불러올 값이 없으면 
		Connection 			conn = null;
		PreparedStatement   pstmt = null;
		ResultSet 			rs = null;
		String sql = "SELECT * FROM MEMBER WHERE ID=?" ;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, id);
			rs = pstmt.executeQuery(); // 4 + 5
			if(rs.next()) {
				 String 	  pw 		= rs.getString("pw");
				 String 	  name		= rs.getString("name");
				 String 	  phone1	= rs.getString("phone1");
				 String 	  phone2	= rs.getString("phone2");
				 String 	  phone3	= rs.getString("phone3");
				 String 	  gender	= rs.getString("gender");
				 String 	  email		= rs.getString("email");
				 Timestamp 	  birth		= rs.getTimestamp("birth");
				 Date 	 	  rdate		= rs.getDate("rdate");
				 String 	  address	= rs.getString("address");
				 dto = new MemberDto(id, pw, name, phone1, phone2, phone3, gender, email, birth, rdate, address);
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
		return dto;
	}
	//5. 회원정보 수정  : 
	public int modifyMember(MemberDto dto) {
		int result = FAIL;
		// dto DB에 update
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE MEMBER SET PW=?," + 
				"                                NAME = ?," + 
				"                                PHONE1 = ?," + 
				"                                PHONE2=?," + 
				"                                PHONE3=?," + 
				"                                GENDER = ?," + 
				"                                EMAIL = ?," + 
				"                                BIRTH = ?," + 
				"                                ADDRESS = ?" + 
				"                            WHERE ID=?";
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dto.getPw());
				pstmt.setString(2,dto.getName());
				pstmt.setString(3,dto.getPhone1());
				pstmt.setString(4,dto.getPhone2());
				pstmt.setString(5,dto.getPhone3());
				pstmt.setString(6,dto.getGender());
				pstmt.setString(7,dto.getEmail());
				pstmt.setTimestamp(8,dto.getBirth());
				pstmt.setString(9, dto.getAddress());
				pstmt.setString(10, dto.getId());
				result = pstmt.executeUpdate();
				System.out.println(result==SUCCESS? "회원가입성공" : "회원가입실패");
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("회원가입 실패 : " + dto); //dto.toString
			}finally {
				try {
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				}catch(Exception e) {
					
				}
			}
			
			return result;
		
	}
}


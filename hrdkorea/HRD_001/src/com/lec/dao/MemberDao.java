package com.lec.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lec.dto.MemberDto;

public class MemberDao {
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	// 싱글톤
	private static MemberDao instance = new MemberDao();

	public static MemberDao getInstance() {
		return instance;
	}

	public static Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
		return conn;
	}

	// 1.회원등록
	int custno;
	String custname;
	String phone;
	String address;
	Date joindate;
	String grade;
	String city;

	public int joinMember(MemberDto member) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO MEMBER_TBL_02"
				+ "	VALUES (MEMBER_SEQ.NEXTVAL , ? , ?,?,TO_DATE(?,'YYYYMMDD'), ?, ?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getCustname());
			pstmt.setString(2, member.getPhone());
			pstmt.setString(3, member.getAddress());
			pstmt.setDate(4, member.getJoindate());
			pstmt.setString(5, member.getGrade());
			pstmt.setString(6, member.getCity());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	// 2.회원목록조회
	public ArrayList<MemberDto> allMember(){
		ArrayList<MemberDto> members = new ArrayList<MemberDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet 		rs = null;
		String sql ="SELECT * FROM MEMBER_TBL_02";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				 int custno = rs.getInt("custno") ;
				String custname = rs.getString("custname");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				Date joindate = rs.getDate("joindate");
				String grade = rs.getString("grade");
				String city = rs.getString("city");
				members.add(new MemberDto(custno, custname, phone, address, joindate, grade, city));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null)  conn.close();
			}catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return members;
	}
	// 3.회원정보수정
	public int modifyMember(MemberDto member) {
		int result =FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE MEMBER_TBL_02 SET CUSTNAME =?," + 
				"						 PHONE =?," + 
				"						 ADDRESS = ?," + 
				"						 JOINDATE = ?," + 
				"						 GRADE  = ?," + 
				"						 CITY =?" + 
				"						 WHERE CUSTNO = ?";
		try {
			conn=getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getCustname());
			pstmt.setString(2, member.getPhone());
			pstmt.setString(3, member.getAddress());
			pstmt.setDate(4, member.getJoindate());
			pstmt.setString(5, member.getGrade());
			pstmt.setString(6, member.getCity());
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS ? "수정성공" : "수정실패");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
	         try {
	             if (pstmt != null)
	                pstmt.close();
	             if (conn != null)
	                conn.close();
	          } catch (Exception e) {

	          }
	       }
		return result;
	}
	//4. custno로 dto 가져오기
	public MemberDto getMember(int custno) {
		MemberDto member = null;
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		String sql = "	SELECT * FROM MEMBER_TBL_02 where custno = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, custno);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String custname =  rs.getString("custname");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				Date joindate = rs.getDate("joindate");
				String grade = rs.getString("grade");
				String city =  rs.getString("city");
				member = new MemberDto(custno, custname, phone, address, joindate, grade, city);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
	         try {
	             if (rs != null)
	                rs.close();
	             if (pstmt != null)
	                pstmt.close();
	             if (conn != null)
	                conn.close();
	          } catch (Exception e) {

	          }
	       }
		
		return member;
	}
	// 5. 회원매출 조회
}

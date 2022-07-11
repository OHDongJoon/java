package com.lec.friend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.lec.member.MemberDao;
import com.lec.member.MemberDto;


public class FriendDao {
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	
	private static FriendDao instance;
	public static FriendDao getInstance() {
		if(instance==null) {
			instance = new FriendDao();
		}
		return instance;
	}
	private FriendDao() {} 
	private  Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			 conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
		} catch (Exception e) {
			System.out.println("드라이버 오류");
		}
		
		return conn;
	}
	//1.친구추가
	public int insertFriend(FriendDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO FRIEND (NO, NAME, TEL)" + 
				"    VALUES (FRIEND_SEQ.NEXTVAL ,? ,?)";
	
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getTel());
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS? "친구추가성공" : "친구추가실패");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("친구추가 실패 : " + dto);
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				
			}
		}
		return result;
	}
	//2. 모든정보출력
	public ArrayList<FriendDto> getFriend() {
		ArrayList<FriendDto> dto = new ArrayList<FriendDto>();
		Connection 			conn = null;
		Statement   		stmt = null;
		ResultSet 			rs = null;
		String sql = "SELECT * FROM FRIEND" ;
			try {
				conn=getConnection();
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				while(rs.next()) {
					int no = rs.getInt("no");
					String name = rs.getString("name");
					String tel = rs.getString("tel");
					dto.add(new FriendDto(no,name,tel));
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			
			}finally {
				try {
					if(rs != null) rs.close();
					if(stmt != null) stmt.close();
					if(conn != null) conn.close();
				}catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			return dto;
		
	}
	// c친구검색
	public ArrayList<FriendDto> selectSearchFriend(String name,String tel){
		ArrayList<FriendDto> dtos = new ArrayList<FriendDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet    rs = null;
		String sql ="SELECT * FROM FRIEND WHERE NAME=? AND TEL=?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,name);
			pstmt.setString(2, tel);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int no = rs.getInt("no");
				name = rs.getString("name");
				tel = rs.getString("tel");
				dtos.add(new FriendDto(no, name, tel));
				
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e2) {
				
			}
		}
		return dtos;
	}
}
	
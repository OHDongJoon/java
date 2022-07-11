package com.lec.memberdao;

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

import com.lec.memberdao.MemberDao;
import com.lec.memberdto.MemberDto;

public class MemberDao {
   public static final int EXISTENT    = 0;
   public static final int NONEXISTENT = 1;
   public static final int LOGIN_FAIL    =0;
   public static final int LOGIN_SUCCESS = 1;
   public static final int FAIL = 0;
   public static final int SUCCESS = 1;
   // 싱글톤
   private static MemberDao instance = new MemberDao(); // 내자신을 가르키는 변수

   public static MemberDao getInstance() {
      return instance;
   }

   private MemberDao() {
   }

   // Connection 객체를 받아오는 함수 : getConnection()
   private Connection getConnection() throws SQLException {
      Connection conn = null;
      try {
         Context ctx = new InitialContext();
         DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
         conn = ds.getConnection();
      } catch (NamingException e) {
         System.out.println(e.getMessage());
      }
      return conn;

   }

   // 1.로그인
   public int loginCheck(String mid, String mpw) {
      int result = LOGIN_FAIL;
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      String sql = "SELECT * FROM MVC_MEMBER WHERE MID=? AND MPW=?";

      try {
         conn = getConnection();
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, mid);
         pstmt.setString(2, mpw);
         rs = pstmt.executeQuery();
         if (rs.next()) { 
            result = LOGIN_SUCCESS;
         }else {
            result = LOGIN_FAIL;
         }
            
      }catch(Exception e) {
         System.out.println(e.getMessage());
      }finally {
         try {
            if(rs    != null) rs.close();
            if(pstmt != null) pstmt.close();
            if(conn  != null) conn.close();
         } catch (Exception e) {
            System.out.println(e.getMessage());
         }
      }
      return result;
   }

   // 2.mID로 DTO 가져오기
   public MemberDto getMember(String mid) {
      MemberDto member  = null;// 최악의경우 불러올 값이 없으면
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      String sql = "SELECT * FROM MVC_MEMBER WHERE MID = ?";

      try {
         conn = getConnection();
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, mid);
         rs = pstmt.executeQuery(); // 4 + 5
         if (rs.next()) {
            // String mid;
            String mpw = rs.getString("mpw");
            String mname = rs.getString("mname");
            String memail = rs.getString("memail");
            String mphoto = rs.getString("mphoto");
            Date mbirth = rs.getDate("mbirth");
            String maddress = rs.getString("maddress");
            Date mrdate = rs.getDate("mrdate");
            member  = new MemberDto(mid, mpw, mname, memail, mphoto, mbirth, maddress, mrdate);
         }

      } catch (Exception e) {
         System.out.println(e.getMessage());
      } finally {
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

   // 3.회원중복id체크
   public int confirmId(String mid) {
      int result = EXISTENT;// 초기화
      // 중복인지 사용가능인지 sql으로 초기화 :SELECT * FROM MEMBER WHERE ID='aaa' ;
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      String sql = "SELECT * FROM MVC_MEMBER WHERE MID=?";

      try {
         conn = getConnection();
         pstmt = conn.prepareStatement(sql);
         pstmt.setNString(1, mid);
         rs = pstmt.executeQuery(); // 4 + 5
         if (rs.next()) {
            result = EXISTENT; // 중복된 id (회원가입시 중복된 id ) 있으면 그냥 rsult 넘겨
         } else {
            result = NONEXISTENT; // 없는 id (사용가능한 id) 없으면 result 넘겨
         }
      } catch (Exception e) {
         System.out.println(e.getMessage());
      } finally {
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
      return result;
   }

   // 4.회원가입
   public int joinMember(MemberDto member) {
      int result = FAIL;
      // dto DB에 insert 입력받는 값이니 Resultset 안씀
      Connection conn = null;
      PreparedStatement pstmt = null;
      String sql = "INSERT INTO MVC_MEMBER(MID, MPW, MNAME, MEMAIL, MPHOTO,MBIRTH, MADDRESS)"
            + "          VALUES (?,?,?,?,?,?,?)";
      try {
         conn = getConnection();
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, member.getMid());
         pstmt.setString(2, member.getMpw());
         pstmt.setString(3, member.getMname());
         pstmt.setString(4, member.getMemail());
         pstmt.setString(5, member.getMphoto());
         pstmt.setDate(6, member.getMbirth());
         pstmt.setString(7, member.getMaddress());
         result = pstmt.executeUpdate();
         System.out.println(result == SUCCESS ? "회원가입성공" : "회원가입실패");
      } catch (Exception e) {
         System.out.println(e.getMessage());
         System.out.println("회원가입 실패 : " + member); // dto.toString
      } finally {
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
   // 5. 회원정보수정
   public int modifyMember(MemberDto member) {
      int result = FAIL;
      // dto DB에 update
      Connection conn = null;
      PreparedStatement pstmt = null;
      String sql = " UPDATE MVC_MEMBER SET MPW =?," + 
            "                                            MNAME =?," + 
            "                                            MEMAIL = ?," + 
            "                                            MPHOTO = ?," + 
            "                                            MBIRTH = ?," + 
            "                                            MADDRESS = ?" + 
            "                                            WHERE MID     = ?";
         try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, member.getMpw());
            pstmt.setString(2, member.getMname());
            pstmt.setString(3, member.getMemail());
            pstmt.setString(4, member.getMphoto());
            pstmt.setDate  (5,member.getMbirth());
            pstmt.setString(6, member.getMaddress());
            pstmt.setString(7, member.getMid());
            result = pstmt.executeUpdate();
            System.out.println(result==SUCCESS? "회원정보성공" : "회원정보실패");
         } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("회원가입 실패 : " + member); //dto.toString
         }finally {
            try {
               if(pstmt != null) pstmt.close();
               if(conn != null) conn.close();
            }catch(Exception e) {
               
            }
         }
         
         return result;
      
   }
   // 6.회원리스트top-n구문
   public ArrayList<MemberDto> allMember(int startRow, int endRow){
      ArrayList<MemberDto> dtos = new ArrayList<MemberDto>();
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      String sql = "SELECT * FROM (SELECT ROWNUM RN, A.* FROM " + 
            "                        (SELECT * FROM MVC_MEMBER ORDER BY mRDATE DESC) A)" + 
            "        WHERE RN BETWEEN ? AND ?";
      try {
         conn = getConnection();
         pstmt = conn.prepareStatement(sql);
         pstmt.setInt(1, startRow);
         pstmt.setInt(2, endRow);
         rs = pstmt.executeQuery(); // 4 + 5
         while (rs.next()) {
            String mid = rs.getString("mid");
            String mpw = rs.getString("mpw");
            String mname = rs.getString("mname");
            String memail = rs.getString("memail");
            String mphoto = rs.getString("mphoto");
            Date mbirth = rs.getDate("mbirth");
            String maddress = rs.getString("maddress");
            Date mrdate = rs.getDate("mrdate");
            
            dtos.add(new MemberDto(mid, mpw, mname, memail, mphoto, mbirth, maddress, mrdate));
         }

      } catch (Exception e) {
         System.out.println(e.getMessage());
      } finally {
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
      return dtos;
   }
   
   // 7.회원수
   public int getMemberTotCnt() {
      int totCnt = 0;
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      String sql = "SELECT COUNT (*) TOTCNT FROM MVC_MEMBER";
      try {
         conn = getConnection();
         pstmt = conn.prepareStatement(sql);
         rs = pstmt.executeQuery();
         if(rs.next()) {
            totCnt = rs.getInt("totcnt");
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
      return totCnt;
   }
}


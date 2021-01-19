package com.mvc.member.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.mvc.common.jdbc.JDBCTemplate.*;
import com.mvc.member.model.vo.Member;

public class MemberDao {

   public MemberDao() {
   }

   public Member findMemberByIdAndPwd(String id, String pwd) {
      Member member = null;
      Connection conn = null;
      String query= null;
      ResultSet rset = null;
      PreparedStatement pstmt = null;
      
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","FD","FD");
         query = "SELECT * FROM MEMBER WHERE USER_ID=? AND USER_PWD=? AND USER_STATUS='Y'";
         pstmt= conn.prepareStatement(query);
            
            pstmt.setString(1, id);
            pstmt.setString(2, pwd);
            
            rset = pstmt.executeQuery();
            
            if(rset.next()) {
               System.out.println(rset.getString("USER_ID") + ", " + rset.getString("USER_PWD"));
               
               member = new Member(
                     rset.getInt("USER_NO"),
                     rset.getString("USER_ID"),
                     rset.getString("USER_PWD"),
                     rset.getString("USER_NAME"),
                     rset.getString("PHONE"),
                     rset.getString("EMAIL"),
                     rset.getString("ADDRESS"),
                     rset.getDate("USER_ENROLL_DATE"),
                     rset.getDate("USER_MODIFY_DATE"),
                     rset.getString("USER_STATUS"),
                     rset.getString("USER_ROLE"),
                     rset.getInt("USER_COIN")
                     );
            }
         } catch (ClassNotFoundException e) {
            e.printStackTrace();
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         try {
            rset.close();
            pstmt.close();
            conn.close();
         } catch(SQLException e) {
            e.printStackTrace();
         }
   }
      return member;
   }

   /** 
		insertMember 매개변수 내에 Connection 추가 후 Connection 변수 제거.
*/

   public int insertMember(Connection conn, Member member){
	   int result = 0;
	   String query= null;
	   PreparedStatement pstmt = null;

      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","FD","FD");
         
         query =    "INSERT INTO MEMBER VALUES(SEQ_UNO.NEXTVAL,?, ?, ?, ?, ?, ?, SYSDATE, SYSDATE, DEFAULT, DEFAULT, DEFAULT)";
         pstmt = conn.prepareStatement(query);
         
         pstmt.setNString(1, member.getUserId());
         pstmt.setNString(2, member.getUserPwd());
         pstmt.setNString(3, member.getUserName());
         pstmt.setNString(4, member.getPhone());
         pstmt.setNString(5, member.getEmail());
         pstmt.setNString(6, member.getAddress());
         
         result = pstmt.executeUpdate();

      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      } catch (SQLException e) {
         e.printStackTrace();
      }finally {
         try {
            pstmt.close();
            conn.close();
         } catch(SQLException e) {
            e.printStackTrace();
         }
   }
      return result;
   }
   
	public int Pwd(Connection conn, String id, String pwd) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement("UPDATE MEMBER SET USER_PWD=? WHERE USER_ID=?");
			
			pstmt.setString(1, pwd);
			pstmt.setString(2, id);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
				
		return result;
	}
	
	   /** 
		Member findMemberById 추가.  
	    */
	public Member findMemberById(Connection conn, String userId) {
		Member member = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
	
		try {
		
			pstmt = conn.prepareStatement("SELECT * FROM MEMBER WHERE USER_ID=?");
			
			pstmt.setString(1, userId);
	
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				System.out.println(rset.getString("USER_ID") + ", " + rset.getString("USER_PWD"));
				member = new Member(
					rset.getInt("USER_NO"),
	                rset.getString("USER_ID"),
	                rset.getString("USER_PWD"),
	                rset.getString("USER_NAME"),
	                rset.getString("PHONE"),
                    rset.getString("EMAIL"),
                    rset.getString("ADDRESS"),
                    rset.getDate("USER_ENROLL_DATE"),
                    rset.getDate("USER_MODIFY_DATE"),
                    rset.getString("USER_STATUS"),
                    rset.getString("USER_ROLE"),
                    rset.getInt("USER_COIN")
                    );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return member;
	}
}
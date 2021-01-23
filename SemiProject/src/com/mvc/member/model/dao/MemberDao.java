package com.mvc.member.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.mvc.common.jdbc.JDBCTemplate.*;
import com.mvc.member.model.vo.Member;
import com.mvc.member.model.vo.Payer;

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
   
   // (은주) 1/20일 변경 <------ 1/23일  주석 부분 지워주세요~ (중복코드입니다.)

	
	   // (은주) 1/21일 pwd부분/주석20일에 해둔거 다 지우시고 이걸로 변경해주세요.
		public Member pwd(Connection conn, String id, String pon) {
		      Member member = null;
		      String query= null;
		      ResultSet rset = null;
		      PreparedStatement pstmt = null;
		      try {
		          Class.forName("oracle.jdbc.driver.OracleDriver");
		          conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","FD","FD");
		          query = "SELECT * FROM MEMBER WHERE USER_ID=? AND PHONE=?";
		          pstmt= conn.prepareStatement(query);
		             
		             pstmt.setString(1, id);
		             pstmt.setString(2, pon);
		             
		             rset = pstmt.executeQuery();
		             
		             if(rset.next()) {
		                System.out.println(rset.getString("USER_ID"));
		                
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
	
	/** 1/20 원상 회원정보 수정 관련 메소드 추가 */

	public int editUserInfo(Connection conn, Member member) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement("UPDATE MEMBER SET USER_NAME=?,PHONE=?,EMAIL=?,ADDRESS=?,USER_MODIFY_DATE=SYSDATE WHERE USER_ID=?");
			
			pstmt.setString(1, member.getUserName());			
			pstmt.setString(2, member.getPhone());
			pstmt.setString(3, member.getEmail());
			pstmt.setString(4, member.getAddress());
			pstmt.setString(5, member.getUserId());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	/** 1/20 원상 비밀번호 변경 관련 메소드 추가 */
	
	public int changePassword(Connection conn, String id, String pwd) {
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
	
	// 2021/01/20 (이슬) 포인트 충전하기 후 나오는 폼에서 입력한 정보 받아오기
	public int insertPointInfo(Connection conn, Payer payer) {
		int result = 0;
		String query = "";
		PreparedStatement pstmt = null;
		
		try {
			query = "INSERT INTO POINT_CHARGING VALUES(SEQ_PAYMENT_NO.NEXTVAL, ?, ?, ?, SYSDATE, SYSDATE, 'Y', ?)";
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, payer.getPaymentAmount());
			pstmt.setString(2, payer.getBankName());
			pstmt.setInt(3, payer.getAccountNumber());
			pstmt.setInt(4, payer.getPayerNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}
	
	/** 1월 21일 원상 회원탈퇴 관련 코드 추가 */

	public int updateMemberStatus(Connection conn, String id, String status) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement("UPDATE MEMBER SET USER_STATUS=? WHERE USER_ID=?");
			
			pstmt.setString(1, status);
			pstmt.setString(2, id);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	//(은주) 1/21일 id찾기 작업중 <------ 1/23일  주석 부분 지워주세요~ (중복코드입니다.)
	
	// 2021/01/21 이슬 user_coin에 포인트 업데이트할 updatePoint 개발 중 
	// 2021/01/22 이슬 updatePoint 매개변수 변경 try catch문 작성했으나 넘어가질않음..
	// 01.23 승현 일단 구현이 되도록 만들기는 하겠는데... 아마 이렇게 하면 안될거에요~ 다음에 공부하고 수정해보기로 해요.
	public int updatePoint(Connection conn, int userNo, int PaymentAmount) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "";
		
		try {
//			query = "UPDATE MEMBER SET USER_COIN = (SELECT SUM(PAYMENT_AMOUNT) FROM POINT_CHARGING WHERE PAYER_NO = ?) WHERE USER_NO = ?";
			query = "UPDATE MEMBER SET USER_COIN=(USER_COIN+?) WHERE USER_NO=?";
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, PaymentAmount);
			pstmt.setInt(2, userNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	// 01.22 승현 후원하기에 필요한 member정보를 가져오는 dao쪽 메소드
	public Member findMemberForfunding(Connection conn, int userNo) {
		Member member = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
	
		try {
		
			pstmt = conn.prepareStatement("SELECT * FROM MEMBER WHERE USER_NO=?");
			
			pstmt.setInt(1, userNo);
	
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
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
	
	// 1.22 승현 project funding 값을 업데이트 하는 dao
	public int updateFunding(Connection conn, int userNo, int fundingPrice) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement("UPDATE MEMBER SET USER_COIN=(USER_COIN-?) WHERE USER_NO=?");
			
			pstmt.setInt(1, fundingPrice);			
			pstmt.setInt(2, userNo);			
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	// 은주 1/22일 수정 다시 수정해야함.
	// 은주 1/23일 id찾기 완료!
	public Member idfind(Connection conn, String name, String email) {
		Member member = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
	
		try {
		
			pstmt = conn.prepareStatement("SELECT * FROM MEMBER WHERE USER_NAME=? AND EMAIL=?");
			
			pstmt.setString(1, name );
			pstmt.setString(2, email );
	
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
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
package com.mvc.project.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mvc.common.util.PageInfo;
import com.mvc.project.model.vo.CarryProject;
import com.mvc.project.model.vo.ProjectReward;

import static com.mvc.common.jdbc.JDBCTemplate.*;

public class ProjectDAO {
	
	// 1.19 프로젝트 게시판 번호 빼오기
	public CarryProject findProjectByNo(Connection conn, int projectNo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CarryProject project = null;
		
		String query =
			  "SELECT P.PROJECT_NO, P.PROJECT_TITLE, M.USER_ID, P.PROJECT_COMPANY, P.TARGET_AMOUNT, P.REACH_AMOUNT, P.PROJECT_ENROLL_DATE, P.PROJECT_MODIFY_DATE, P.PROJECT_END_DATE, P.IMG_ORIGINAL_NAME, P.IMG_RENAMED_NAME, P.PROJECT_CONTENT, P.PROJECT_COUNT, P.PROJECT_LIKE\r\n"
			  + "FROM CARRYFUNDING_PROJECT P\r\n"
			  + "JOIN MEMBER M ON(P.CREATOR_NO = M.USER_NO)\r\n"
			  + "WHERE P.PROJECT_STATUS = 'Y' AND P.PROJECT_CHECK = 'Y' AND P.PROJECT_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, projectNo);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				project = new CarryProject();
				
				project.setProjectNo(rs.getInt("PROJECT_NO"));
				project.setProjectTitle(rs.getString("PROJECT_TITLE"));
				project.setUserId(rs.getString("USER_ID"));
				project.setProjectCompany(rs.getString("PROJECT_COMPANY"));
				project.setTargetAmount(rs.getInt("TARGET_AMOUNT"));
				project.setReachAmount(rs.getInt("REACH_AMOUNT"));
				
				// 1.21 승현 date -> string으로 변환
//				project.setProjectEnrolldate(rs.getDate("PROJECT_ENROLL_DATE"));
//				project.setProjectModifydate(rs.getDate("PROJECT_MODIFY_DATE"));
//				project.setProjectEnddate(rs.getDate("PROJECT_END_DATE"));
				
				project.setProjectEnrolldate(rs.getString("PROJECT_ENROLL_DATE"));
				project.setProjectModifydate(rs.getString("PROJECT_MODIFY_DATE"));
				project.setProjectEnddate(rs.getString("PROJECT_END_DATE"));
				
				project.setImgOriginalName(rs.getString("IMG_ORIGINAL_NAME"));
				project.setImgRenamedName(rs.getString("IMG_RENAMED_NAME"));
				project.setProjectContent(rs.getString("PROJECT_CONTENT"));
				project.setProjectCount(rs.getInt("PROJECT_COUNT"));
				project.setProjectLike(rs.getInt("PROJECT_LIKE"));
//				project.setCreateNo(rs.getInt("CREATOR_NO"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		System.out.println("project : " + project);
		
		return project;
	}

	public List<CarryProject> findAll(Connection conn, PageInfo info) {
		
		List<CarryProject> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = "SELECT *\r\n"
				+ "FROM (\r\n"
				+ "    SELECT ROWNUM AS RNUM, PROJECT_NO, PROJECT_TITLE, USER_ID, PROJECT_COMPANY, TARGET_AMOUNT, REACH_AMOUNT, TRIM((REACH_AMOUNT/TARGET_AMOUNT)*100), PROJECT_ENROLL_DATE, PROJECT_MODIFY_DATE, PROJECT_END_DATE, IMG_ORIGINAL_NAME, IMG_RENAMED_NAME, PROJECT_CONTENT, PROJECT_COUNT, PROJECT_LIKE\r\n"
				+ "    FROM (SELECT  P.PROJECT_NO, P.PROJECT_TITLE, M.USER_ID, P.PROJECT_COMPANY, P.TARGET_AMOUNT, P.REACH_AMOUNT, TRIM((P.REACH_AMOUNT/P.TARGET_AMOUNT)*100), P.PROJECT_ENROLL_DATE, P.PROJECT_MODIFY_DATE, P.PROJECT_END_DATE, P.IMG_ORIGINAL_NAME, P.IMG_RENAMED_NAME, P.PROJECT_CONTENT, P.PROJECT_COUNT, P.PROJECT_LIKE\r\n"
				+ "        FROM CARRYFUNDING_PROJECT P\r\n"
				+ "        JOIN MEMBER M ON(P.CREATOR_NO = M.USER_NO)\r\n"
				+ "        WHERE P.PROJECT_STATUS = 'Y' AND P.PROJECT_CHECK = 'Y' ORDER BY TRIM((P.REACH_AMOUNT/P.TARGET_AMOUNT)*100) DESC\r\n"
				+ "        )\r\n"
				+ "   ) WHERE RNUM BETWEEN ? AND ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, info.getStartList());
			pstmt.setInt(2, info.getEndList());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				CarryProject project = new CarryProject();
				
				project.setProjectNo(rs.getInt("PROJECT_NO"));
				project.setRowNum(rs.getInt("RNUM"));
				project.setProjectTitle(rs.getString("PROJECT_TITLE"));
				project.setUserId(rs.getString("USER_ID"));
				project.setProjectCompany(rs.getString("PROJECT_COMPANY"));
				project.setTargetAmount(rs.getInt("TARGET_AMOUNT"));
				project.setReachAmount(rs.getInt("REACH_AMOUNT"));
				project.setAttainmentPercent(rs.getInt("TRIM((REACH_AMOUNT/TARGET_AMOUNT)*100)"));
				
				// 1.21 승현 date -> string으로 변환
//				project.setProjectEnrolldate(rs.getDate("PROJECT_ENROLL_DATE"));
//				project.setProjectModifydate(rs.getDate("PROJECT_MODIFY_DATE"));
//				project.setProjectEnddate(rs.getDate("PROJECT_END_DATE"));
				
				project.setProjectEnrolldate(rs.getString("PROJECT_ENROLL_DATE"));
				project.setProjectModifydate(rs.getString("PROJECT_MODIFY_DATE"));
				project.setProjectEnddate(rs.getString("PROJECT_END_DATE"));
				
				project.setImgOriginalName(rs.getString("IMG_ORIGINAL_NAME"));
				project.setImgRenamedName(rs.getString("IMG_RENAMED_NAME"));
				project.setProjectContent(rs.getString("PROJECT_CONTENT"));
				project.setProjectCount(rs.getInt("PROJECT_COUNT"));
				project.setProjectLike(rs.getInt("PROJECT_LIKE"));
//				project.setCreateNo(rs.getInt("CREATOR_NO"));
				
				list.add(project);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(conn);
		}
		
		System.out.println("list : " + list);
		
		return list;
	}

	public int getProjectCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		String query = "SELECT COUNT(*) FROM CARRYFUNDING_PROJECT WHERE PROJECT_STATUS = 'Y' AND PROJECT_CHECK = 'Y'";
				
		try {
			pstmt = conn.prepareStatement(query);

			rset = pstmt.executeQuery();

			if(rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return result;				
				
	}
	
	// 1월 20일 승현 프로젝트 게시판 sql에 입력 추가(저장기능)
	public int insertProject(Connection conn, CarryProject project) {
		PreparedStatement pstmt = null;
		int result = 0;		
		
		try {
			pstmt = conn.prepareStatement("INSERT INTO CARRYFUNDING_PROJECT VALUES(\r\n"
					+ "    SEQ_PROJECT_NO.NEXTVAL,?,?,?,0,?,DEFAULT,?,\r\n"
					+ "    ?,?,?,'N',DEFAULT,DEFAULT,DEFAULT,?\r\n"
					+ ")");
			
//			// 날짜 무시하고 데이터 입력하기
//			pstmt = conn.prepareStatement("INSERT INTO CARRYFUNDING_PROJECT VALUES(\r\n"
//					+ "    SEQ_PROJECT_NO.NEXTVAL,?,?,?,0,DEFAULT,DEFAULT,SYSDATE,\r\n"
//					+ "    ?,?,?,'N',DEFAULT,DEFAULT,DEFAULT,?\r\n"
//					+ ")");
			
//			pstmt.setString(1, "SEQ_PROJECT_NO.NEXTVAL");
			pstmt.setString(1, project.getProjectTitle());
			pstmt.setString(2, project.getProjectCompany());
			pstmt.setInt(3, project.getTargetAmount());
			pstmt.setString(4, project.getProjectEnrolldate());
			pstmt.setString(5, project.getProjectEnddate());
			pstmt.setString(6, project.getImgOriginalName());
			pstmt.setString(7, project.getImgRenamedName());
			pstmt.setString(8, project.getProjectContent());
			pstmt.setInt(9, project.getCreateNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	// 1.21 승현 리워드 저장 메소드 추가
	public int insertReward(Connection conn, ProjectReward reward) {
		PreparedStatement pstmt = null;
		int result = 0;	
		
		try {
			pstmt = conn.prepareStatement("INSERT INTO REWARD VALUES(\r\n"
					+ "    SEQ_REWARD_NO.NEXTVAL, ?, ?, ?\r\n"
					+ ")");
			pstmt.setString(1, reward.getRewardName());
			pstmt.setInt(2, reward.getRewardPrice());
			pstmt.setInt(3, reward.getProNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

}













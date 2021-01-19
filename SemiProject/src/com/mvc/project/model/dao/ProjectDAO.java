package com.mvc.project.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mvc.project.model.vo.CarryProject;

import static com.mvc.common.jdbc.JDBCTemplate.*;

public class ProjectDAO {

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
				project.setProjectEnrolldate(rs.getDate("PROJECT_ENROLL_DATE"));
				project.setProjectModifydate(rs.getDate("PROJECT_MODIFY_DATE"));
				project.setProjectEnddate(rs.getDate("PROJECT_END_DATE"));
				project.setImgOriginalName(rs.getString("IMG_ORIGINAL_NAME"));
				project.setImgRenamedName(rs.getString("IMG_RENAMED_NAME"));
				project.setProjectContent(rs.getString("PROJECT_CONTENT"));
				project.setProjectCount(rs.getInt("PROJECT_COUNT"));
				project.setProjectLike(rs.getInt("PROJECT_LIKE"));
				project.setCreateNo(rs.getInt("CREATOR_NO"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
//		System.out.println(project);
		
		return project;
	}

	public List<CarryProject> findAll(Connection conn) {
		
		List<CarryProject> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = "SELECT P.PROJECT_NO, P.PROJECT_TITLE, M.USER_ID, P.PROJECT_COMPANY, P.TARGET_AMOUNT, P.REACH_AMOUNT, P.PROJECT_ENROLL_DATE, P.PROJECT_MODIFY_DATE, P.PROJECT_END_DATE, P.IMG_ORIGINAL_NAME, P.IMG_RENAMED_NAME, P.PROJECT_CONTENT, P.PROJECT_COUNT, P.PROJECT_LIKE, P.CREATOR_NO\r\n"
				  + "FROM CARRYFUNDING_PROJECT P\r\n"
				  + "JOIN MEMBER M ON(P.CREATOR_NO = M.USER_NO)\r\n"
				  + "WHERE P.PROJECT_STATUS = 'Y' AND P.PROJECT_CHECK = 'Y'";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				CarryProject project = new CarryProject();
				
				project.setProjectNo(rs.getInt("PROJECT_NO"));
				project.setProjectTitle(rs.getString("PROJECT_TITLE"));
				project.setUserId(rs.getString("USER_ID"));
				project.setProjectCompany(rs.getString("PROJECT_COMPANY"));
				project.setTargetAmount(rs.getInt("TARGET_AMOUNT"));
				project.setReachAmount(rs.getInt("REACH_AMOUNT"));
				project.setProjectEnrolldate(rs.getDate("PROJECT_ENROLL_DATE"));
				project.setProjectModifydate(rs.getDate("PROJECT_MODIFY_DATE"));
				project.setProjectEnddate(rs.getDate("PROJECT_END_DATE"));
				project.setImgOriginalName(rs.getString("IMG_ORIGINAL_NAME"));
				project.setImgRenamedName(rs.getString("IMG_RENAMED_NAME"));
				project.setProjectContent(rs.getString("PROJECT_CONTENT"));
				project.setProjectCount(rs.getInt("PROJECT_COUNT"));
				project.setProjectLike(rs.getInt("PROJECT_LIKE"));
				project.setCreateNo(rs.getInt("CREATOR_NO"));
				
				list.add(project);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(conn);
		}
		
//		System.out.println(list);
		
		return list;
	}

}

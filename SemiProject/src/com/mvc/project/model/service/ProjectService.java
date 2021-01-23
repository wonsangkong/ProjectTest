package com.mvc.project.model.service;

import java.sql.Connection;
import java.util.List;

import com.mvc.common.util.PageInfo;
import com.mvc.project.model.dao.ProjectDAO;
import com.mvc.project.model.vo.CarryProject;
import com.mvc.project.model.vo.ProjectReward;
import com.mvc.project.model.vo.projectFunding;

import static com.mvc.common.jdbc.JDBCTemplate.*;


public class ProjectService {

	public CarryProject getProject(int projectNo) {
//		int result = 0;
		Connection conn = getConnection();
		CarryProject project = new ProjectDAO().findProjectByNo(conn, projectNo);
		
		close(conn);
		
		return project;
	}

	// 1.19 PageInfo 매개변수 추가
	public List<CarryProject> getProjectList(PageInfo info) {
		Connection conn = getConnection();
		
		List<CarryProject> list = new ProjectDAO().findAll(conn, info);
		
		close(conn);
		
		return list;
	}
	
	// 1.19 프로젝트 게시글 총 수 구하는 메소드 추가
	public int getProjectCount() {
		Connection conn = getConnection();

		int result = new ProjectDAO().getProjectCount(conn);

		close(conn);

		return result;
	}
	
	// 1.20 프로젝트 게시글 db에 저장하는 메소드 추가
	public int saveProject(CarryProject project) {
		int result = 0;
		
		Connection conn = getConnection();
		
		// 나중 update 구현 시 반영 : 글쓰기에는 첫 번호가 없다 -> insert실행, 글수정에는 기존 번호가 있다 -> update실행 
//		if(project.getProjectNo() != 0) {
//			result = new ProjectDAO().updateProject(conn, board);
//		} else {
//			result = new ProjectDAO().insertProject(conn, project);
//		}
		
		result = new ProjectDAO().insertProject(conn, project);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}
	
	// 1.21 승현 리워드 객체 받아서 dao에서 처리하도록 요청하는 서비스 메소드 추가
	public int saveReward(ProjectReward reward) {
		int result = 0;
		
		Connection conn = getConnection();
		
		result = new ProjectDAO().insertReward(conn, reward);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int saveFunding(projectFunding funding) {
		int result = 0;
		
		Connection conn = getConnection();
		
		result = new ProjectDAO().insertFunding(conn, funding);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}
	
	// 1.22 승현
	public int updateFunding(int projectNo, int fundingPrice) {
		Connection conn = getConnection();
		int result = new ProjectDAO().updateFunding(conn, projectNo, fundingPrice);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return  result;
	}
	
	/** 1월 22일 원상 상품 삭제 및 Admin 관련 메소드 정리 (이하 전부) */
	
	public int deleteProject(String projectNo) {
		
			Connection conn = getConnection();
			int result = new ProjectDAO().updateProjectStatus(conn, projectNo, "N");
			
			if(result > 0) {
				commit(conn);
			} else {
				rollback(conn);
			}
			
			close(conn);
			
			return result;
	}
	
	public int getAdminProjectCount() {
		Connection conn = getConnection();

		int result = new ProjectDAO().getAdminProjectCount(conn);

		close(conn);

		return result;
	}
	
	public CarryProject getAdminProject(int projectNo) {
//		int result = 0;
		Connection conn = getConnection();
		CarryProject project = new ProjectDAO().findAdminProjectByNo(conn, projectNo);
		
		close(conn);
		
		return project;
	}
	
	public List<CarryProject> getAdminProjectList(PageInfo info) {
		Connection conn = getConnection();
		
		List<CarryProject> list = new ProjectDAO().adminFindAll(conn, info);
		
		close(conn);
		
		return list;
	}
	
	public int confirmProject(String projectNo) {
		
		Connection conn = getConnection();
		int result = new ProjectDAO().updateProjectCheckStatus(conn, projectNo, "Y");
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

}

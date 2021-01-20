package com.mvc.project.model.service;

import java.sql.Connection;
import java.util.List;

import com.mvc.common.util.PageInfo;
import com.mvc.project.model.dao.ProjectDAO;
import com.mvc.project.model.vo.CarryProject;

import static com.mvc.common.jdbc.JDBCTemplate.*;


public class ProjectService {

	public CarryProject getProject(int projectNo) {
//		int result = 0;
		Connection conn = getConnection();
		CarryProject board = new ProjectDAO().findProjectByNo(conn, projectNo);
		
		close(conn);
		
		return board;
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
		
		// 글쓰기에는 첫 번호가 없다 -> insert실행, 글수정에는 기존 번호가 있다 -> update실행 
		if(project.getProjectNo() != 0) {
//			result = new ProjectDAO().updateProject(conn, board);
		} else {
			result = new ProjectDAO().insertProject(conn, project);
		}
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}

}

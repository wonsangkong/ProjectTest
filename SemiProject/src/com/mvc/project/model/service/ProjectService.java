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

}

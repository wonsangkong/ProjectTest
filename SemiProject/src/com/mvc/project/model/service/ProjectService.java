package com.mvc.project.model.service;

import java.sql.Connection;
import java.util.List;

import com.mvc.project.model.dao.ProjectDAO;
import com.mvc.project.model.vo.CarryProject;

import static com.mvc.common.jdbc.JDBCTemplate.*;


public class ProjectService {

	public com.mvc.project.model.vo.CarryProject getProject(int projectNo) {
		int result = 0;
		Connection conn = getConnection();
		CarryProject board = new ProjectDAO().findProjectByNo(conn, projectNo);
		
		close(conn);
		
		return board;
	}

	public List<CarryProject> getProjectList() {
		Connection conn = getConnection();
		
		List<CarryProject> list = new ProjectDAO().findAll(conn);
		
		close(conn);
		
		return list;
	}

	

}

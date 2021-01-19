package com.mvc.project.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.project.model.service.ProjectService;
import com.mvc.project.model.vo.CarryProject;


@WebServlet("/project/list")
public class ProjectListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProjectListServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<CarryProject> list = null;
		
		list = new ProjectService().getProjectList();
		
//		System.out.println(list);
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/views/project/list.jsp").forward(request, response);
		
	}

}

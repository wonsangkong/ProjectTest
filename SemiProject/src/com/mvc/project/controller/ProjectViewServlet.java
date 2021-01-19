package com.mvc.project.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.project.model.service.ProjectService;
import com.mvc.project.model.vo.CarryProject;


@WebServlet("/project/view")
public class ProjectViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProjectViewServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int projectNo = Integer.parseInt(request.getParameter("projectNo"));
		CarryProject project = null;
		
		project = new ProjectService().getProject(projectNo);
		
		request.setAttribute("project", project);
		request.getRequestDispatcher("/views/project/view.jsp").forward(request, response);
	}

}

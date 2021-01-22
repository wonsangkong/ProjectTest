
/** 1월 22일 원상 신규 Servlet 생성 */

package com.mvc.project.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.common.util.PageInfo;
import com.mvc.project.model.service.ProjectService;
import com.mvc.project.model.vo.CarryProject;

@WebServlet("/project/adminList")
public class ProjectAdminListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ProjectAdminListServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int page = 0;
		int listCount = 0;
		PageInfo info = null;
		List<CarryProject> list = null;	
		
		try {
			page = Integer.parseInt(request.getParameter("page"));
		}catch(NumberFormatException e) {
			page = 1;
		}	
				
		listCount = new ProjectService().getAdminProjectCount();
		info = new PageInfo(page, 10, listCount, 4);		
		list = new ProjectService().getAdminProjectList(info);
				
		request.setAttribute("list", list);
		request.setAttribute("pageInfo", info);
		request.getRequestDispatcher("/views/project/adminList.jsp").forward(request, response);
				
	}
}

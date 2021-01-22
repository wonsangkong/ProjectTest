
/** 1월 22일 원상 상품삭제 관련 서블릿입니다. */

package com.mvc.project.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.project.model.service.ProjectService;

@WebServlet("/project/delete")
public class ProjectDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ProjectDeleteServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String projectNo = request.getParameter("projectNo");
		int result = new ProjectService().deleteProject(projectNo);
		String msg = "";
		String loc = "";
		
		if(result > 0) {
			msg = "정상적으로 삭제되었습니다.";
			loc = "/project/adminList";
		} else {
			msg = "상품 삭제가 정상적으로 이루어지지 않았습니다. 다시 시도해주세요.";
			loc = "/project/adminView?projectNo=" + projectNo;
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("location", loc);
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
	}
}

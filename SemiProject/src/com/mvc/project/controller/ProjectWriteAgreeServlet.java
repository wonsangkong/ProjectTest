package com.mvc.project.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/project/projectwriteagree")
public class ProjectWriteAgreeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProjectWriteAgreeServlet() {
    }
    
    // 1.20 승현 header에서 writeagree 호출하는 과정
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/project/writeagree.jsp").forward(request, response);
	}
	
	// 1.21 승현 writeagree에서 체크박스에 동의하면 post로 projectWrite.jsp 보내는 서블릿
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/project/projectWrite.jsp").forward(request, response);
	}

}

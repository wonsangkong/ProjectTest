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


@WebServlet("/project/list")
public class ProjectListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProjectListServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.19 게시글 달성률 내림차순으로 정렬, 페이지 처리 추가
		int page = 0;
		int listCount = 0;
		PageInfo info = null;
		List<CarryProject> list = null;
		
		// url에 잘못된 값이 입력되어도 처음 1page가 나올수 있게끔 구현된 코드
		try {
			page = Integer.parseInt(request.getParameter("page"));
		}catch(NumberFormatException e) {
			page = 1;
		}	
		
		// jsp 파라미터에 &size=? 이런식으로 숫자를 부여하고, select 박스 생성해서 5개, 10개, 15개 이런식으로 조회가 될 수 있도록 구현해보기
		listCount = new ProjectService().getProjectCount();
		info = new PageInfo(page, 10, listCount, 8);		
		list = new ProjectService().getProjectList(info);
		
//		System.out.println(list);
		
		request.setAttribute("list", list);
		request.setAttribute("pageInfo", info);
		
		request.getRequestDispatcher("/views/project/list.jsp").forward(request, response);
		
	}

}

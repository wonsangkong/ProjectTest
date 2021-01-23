package com.mvc.project.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.project.model.service.ProjectService;
import com.mvc.project.model.vo.CarryProject;
import com.mvc.project.model.vo.ProjectReward;

@WebServlet("/project/projectReward")
public class ProjectRewardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProjectRewardServlet() {
    }
    
    // 1.21 승현 프로젝트 등록 다음 프로젝트에 해당하는 리워드를 등록, 일단 무한루프 돌려서 계속 추가할 수 있도록??
    // 1.23 승현 리워드 주석처리 -> 추후 구현예정
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		ProjectReward reward = new ProjectReward();
//		
//		String rewardName = request.getParameter("rewardName");
//		int rewardPrice = Integer.parseInt(request.getParameter("rewardPrice"));
//		int proNo = Integer.parseInt(request.getParameter("proNo"));
//		
//		CarryProject project = new ProjectService().getProject(proNo);
//		reward.setProNo(project.getProjectNo());
//		reward.setRewardName(rewardName);
//		reward.setRewardPrice(rewardPrice);
//		
//		int result = new ProjectService().saveReward(reward);
//		String msg = null;
//		
//		if(result > 0) {
//			msg = "리워드 등록 성공";
//			HttpSession session = request.getSession();
//			session.setAttribute("project", project);
			
//			request.setAttribute("location", "/views/project/setReward.jsp");
//		} else {
//			msg = "리워드 등록 실패";
//			request.setAttribute("location", "/");
//		}
		
//		request.setAttribute("msg", msg);
//		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);

		
		
	}

}

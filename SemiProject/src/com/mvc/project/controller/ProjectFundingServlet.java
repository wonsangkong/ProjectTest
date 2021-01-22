package com.mvc.project.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.member.model.service.MemberService;
import com.mvc.member.model.vo.Member;
import com.mvc.project.model.service.ProjectService;
import com.mvc.project.model.vo.CarryProject;
import com.mvc.project.model.vo.projectFunding;

@WebServlet("/project/funding")
public class ProjectFundingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProjectFundingServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		projectFunding funding = new projectFunding();
		
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		int projectNo = Integer.parseInt(request.getParameter("projectNo"));
		int fundingPrice = Integer.parseInt(request.getParameter("fundingPrice"));
		
		Member member = new MemberService().findMemberForfunding(userNo);
		CarryProject project = new ProjectService().getProject(projectNo);
		
		funding.setFundingPrice(fundingPrice);
		funding.setFundingUser(member.getUserNo());
		funding.setFundingProject(project.getProjectNo());
		
		int result = new ProjectService().saveFunding(funding);
		
		String msg = null;
		
		if(result > 0) {
			msg = "다음페이지에서 확인 버튼을 누르시면 펀딩이 완료됩니다.";
			
			HttpSession session = request.getSession();
			session.setAttribute("funding", funding);
			
			request.setAttribute("location", "/views/project/funding.jsp");
		} else {
			msg = "펀딩 실패, 메인화면으로 넘어갑니다.";
			request.setAttribute("location", "/");
		}
		
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
		
	}

}

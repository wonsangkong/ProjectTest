package com.mvc.project.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.member.model.service.MemberService;
import com.mvc.member.model.vo.Member;
import com.mvc.project.model.service.ProjectService;
import com.mvc.project.model.vo.CarryProject;

@WebServlet("/project/updatefund")
public class UpdateFundServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateFundServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg = "";
		
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		int projectNo = Integer.parseInt(request.getParameter("projectNo"));
		int fundingPrice = Integer.parseInt(request.getParameter("fundingPrice"));
		
		Member member = new MemberService().findMemberForfunding(userNo);
		CarryProject project = new ProjectService().getProject(projectNo);
		
		int orimemberPrice = member.getUserCoin();
		int oriprojectPrice = project.getReachAmount();
		
		int num1 = orimemberPrice - fundingPrice;
		int num2 = oriprojectPrice + fundingPrice;
		
		int result1 = new MemberService().updateFunding(member.getUserNo(), num1);
		int result2 = new ProjectService().updateFunding(project.getProjectNo(), num2);
		
		if(result1 > 0 && result2 > 0) {
			msg = "펀딩이 완료되었습니다.";
			
			request.setAttribute("location", "/views/project/list");
		} else {
			msg = "펀딩이 실패했습니다.";
			
			request.setAttribute("location", "/views/project/list");
		}
		
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
		
	}

}

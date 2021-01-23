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
		
		// 1.23 승현 복잡하게 구성된 서블릿 기능 제거 이 때문에 list랑 db가 꼬이는것 같아서 일단 주석처리
//		Member member = new MemberService().findMemberForfunding(userNo);
//		CarryProject project = new ProjectService().getProject(projectNo);
		
//		int orimemberPrice = member.getUserCoin();
//		int oriprojectPrice = project.getReachAmount();
		
//		int num1 = orimemberPrice - fundingPrice;
//		int num2 = oriprojectPrice + fundingPrice;
		
		int result1 = new MemberService().updateFunding(userNo, fundingPrice);
		int result2 = new ProjectService().updateFunding(projectNo, fundingPrice);
		
		if(result1 > 0 && result2 > 0) {
			msg = "펀딩이 완료되었습니다.";
			
			request.setAttribute("location", "/");
		} else {
			msg = "펀딩이 실패했습니다.";
			
			request.setAttribute("location", "/");
		}
		
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
		
	}

}

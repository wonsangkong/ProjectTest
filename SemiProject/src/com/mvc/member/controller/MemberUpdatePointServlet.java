package com.mvc.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.member.model.service.MemberService;
// 2021/01/21 이슬 point update를 위한 서블릿 개발 중 

@WebServlet("/member/pointUpdate")
public class MemberUpdatePointServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public MemberUpdatePointServlet() {
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/views/member/pointUpdate.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg = "";
		String location="/";
		String script = null;
		int payerNo = Integer.parseInt(request.getParameter("payerNumber"));
		int userPoint = Integer.parseInt(request.getParameter("userCoin"));
		
		int result = new MemberService().updatePoint(payerNo, userPoint);
		
		if(result > 0) {
			msg = "포인트가 정상적으로 충전되었습니다.";
			script = "self.close()";
		} else {
			msg = "포인트 충전이 실패하였습니다. 다시 시도해주세요.";
			location = "/member/point";
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("script", script);
		request.setAttribute("location", location);		
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
	}
}

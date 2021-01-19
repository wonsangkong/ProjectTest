package com.mvc.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.member.model.service.MemberService;


@WebServlet("/member/Pwd")
public class MemberPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MemberPwdServlet() {
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/member/Pwd.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String msg = "";
		String loc = "/";
		String script = null;
		
		System.out.println("userId : " + userId + ", userPwd : " + userPwd);
		
		int result = new MemberService().Pwd(userId, userPwd);		
		
		if(result > 0) {
			msg = "비밀번호가 정상적으로 변경되었습니다.";
			script = "self.close()";
		} else {
			msg = "비밀번호 변경이 실패했습니다.";
			loc= "/member/Pwd?userId=" + userId;
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("script", script);
		request.setAttribute("location", loc);
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
	
	}

}

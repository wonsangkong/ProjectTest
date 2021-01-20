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
		
		System.out.println("userId : " + userId + ", userPwd : " + userPwd);
		
		int result = new MemberService().Pwd(userId, userPwd);		
		
		System.out.println("userPwd : " + userPwd);
		//(은주) 1/20일 변경할 패스워드 부분 다시 작업(changePwd 부분 하면 에러나지만 값은 변경됨 다시 작업해야함)
//		int change = new MemberService().changePwd(userId,userPwd);		
		
		request.getRequestDispatcher("/views/member/Pwd.jsp").forward(request, response);
	
	}

}

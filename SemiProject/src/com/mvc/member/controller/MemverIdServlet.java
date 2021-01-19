package com.mvc.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.member.model.service.MemberService;
import com.mvc.member.model.vo.Member;


@WebServlet("/member/Id")
public class MemverIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MemverIdServlet() {
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/member/IdAndPwd.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Member member = new Member();
//		String msg = null;
//		
//		member.setUserId(request.getParameter("userId"));
//		member.setUserName(request.getParameter("userName"));
//		member.setPhone(request.getParameter("phone"));
//		member.setEmail(request.getParameter("email"));
//		
//		System.out.println(member);
//		
//
//		
//		request.setAttribute("msg", "오오!!");
//		request.setAttribute("location", "/");
//		
//		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
	}
	

}

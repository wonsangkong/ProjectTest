package com.mvc.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		String name = request.getParameter("userName");
		String email = request.getParameter("email");
		Member member = null;

		member = new MemberService().idfind(name,email);
		HttpSession session = request.getSession();
			
			session.setAttribute("member", member);
			if(member != null) {
				request.getRequestDispatcher("/views/member/findid.jsp").forward(request, response);
				
			} else {
		
				RequestDispatcher dispatcher = request.getRequestDispatcher("/views/member/findid.jsp");
				dispatcher.forward(request, response);
			}	
	}	
}



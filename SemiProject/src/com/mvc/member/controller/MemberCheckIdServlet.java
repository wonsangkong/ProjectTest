
/** 새로 추가한 Servlet 입니다. Member > controller 안에 추가해주세요. */

package com.mvc.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.member.model.service.MemberService;

@WebServlet("/member/checkId")
public class MemberCheckIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberCheckIdServlet() {
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		
		System.out.println("UserId : " + userId);
		
		boolean valid = new MemberService().validate(userId);
		
		request.setAttribute("valid", valid);
		
		request.getRequestDispatcher("/views/member/checkId.jsp").forward(request, response);
	}
}
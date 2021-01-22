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
				
				String id = new MemberService().idfind(name,email);
				request.setAttribute("id", id);
				System.out.println("id : "+id);
				
				if(id == null) {
					request.getRequestDispatcher("/views/member/findid.jsp").forward(request, response);
				}
				
		}
	}	
		
		
//RequestDispatcher dispatcher = request.getRequestDispatcher("/views/member/findid.jsp");
//dispatcher.forward(request, response);
		
		
		
		
		//		//(은주)1/21일 	값을 가져와서 DB에 있는 값인지 확인하고 전달하는지 작업.
//		Member member = new Member();
//				
//				System.out.println("userName : " + userName);
//		
//				
//				boolean userN = new MemberService().idfind(userName,phone,email);
//			if(member != null) {
//				request.setAttribute("userN", userN);
//				
//				request.getRequestDispatcher("/views/member/findid.jsp").forward(request, response);
//			}else {
//				request.setAttribute("msg", "잘못입력하셨습니다~ 다시입력해주세요.");
//				request.setAttribute("location", "/views/member/IdAndPwd.jsp");
//				RequestDispatcher dispatcher = request.getRequestDispatcher("/views/common/msg.jsp");
//				dispatcher.forward(request, response);
//			}


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

//(은주) 1/21일 변경. 다 지우고 복사붙여넣기하시면 됩니다.

@WebServlet("/member/Pwd")
public class MemberPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//(은주) 1/21일 doget 지우고 post로 패스워드 완료.
    public MemberPwdServlet() {
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userId = request.getParameter("userId");
		String phone =request.getParameter("phone");
		Member member = null;
		System.out.println("userId : " + userId);
		member = new MemberService().pwd(userId,phone);
		
		if(member != null) {
			HttpSession session = request.getSession();
			
			session.setAttribute("pwd", member);
			// 아이디 폰번호 확인시 비밀번호변경 페이지로 이동 
			RequestDispatcher dispatcher = request.getRequestDispatcher("/views/member/changePwd.jsp");
			dispatcher.forward(request, response);
			
		} else {
			request.setAttribute("msg", "잘못입력하셨습니다~ 다시입력해주세요.");
			request.setAttribute("location", "/views/member/IdAndPwd.jsp");
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/views/common/msg.jsp");
			dispatcher.forward(request, response);
		}
	}

	}


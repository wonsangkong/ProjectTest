
/** 1/20 원상 새로 추가한 Servlet */

package com.mvc.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.member.model.service.MemberService;
import com.mvc.member.model.vo.Member;

@WebServlet("/member/editUserInformation")
public class MemberEditUserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberEditUserInfoServlet() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/views/member/editUserInformation.jsp").forward(request, response);
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String msg = "";
		int result = 0;
		Member member = new Member();

		member.setUserId(request.getParameter("userId"));
		member.setUserPwd(request.getParameter("userPwd"));
		member.setUserName(request.getParameter("userName"));
		member.setPhone(request.getParameter("phone"));
		member.setEmail(request.getParameter("email"));
		member.setAddress(request.getParameter("address"));
		
		System.out.println(member);	
		
		result = new MemberService().editUserInfo(member);
		
		if(result > 0) {
			msg = "성공적으로 수정되었습니다.";
		} else {
			msg = "회원정보 수정에 실패하였습니다. 다시 시도해주세요.";
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("location", "/");
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
	}

}

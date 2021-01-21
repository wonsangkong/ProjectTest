
/** [1월 21일] 원상 새로 추가한 회원탈퇴 관련 서블릿입니다. */

package com.mvc.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.member.model.service.MemberService;

@WebServlet("/member/delete")
public class MemberDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MemberDeleteServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		int result = new MemberService().deleteMember(userId);
		String msg = "";
		String loc = "";
		
		if(result > 0) {
			msg = "정상적으로 탈퇴되었습니다.";
			loc = "/logout";
		} else {
			msg = "회원 탈퇴가 정상적으로 이루어지지 않았습니다. 다시 시도해주세요.";
			loc = "/member/editUserInformation?userId=" + userId;
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("location", loc);
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
	}
}

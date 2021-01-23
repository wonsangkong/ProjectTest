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
		// 2021/01/22 포인트 update 서블릿 개발 ..길을 잃음..
//		Payer payer = new Payer();
//		int payerNo = Integer.parseInt(request.getParameter("payerNumber"));
//		int userPoint = Integer.parseInt(request.getParameter("userCoin"));
//		HttpSession session = request.getSession();
//		Member loginMember = (Member)session.getAttribute("loginMember");
//		session.setAttribute("payer", payer);
		
//		int result = new MemberService().updatePoint(payerNo, userPoint);
		
		// 01.23 승현 위의 내용과 거의 비슷한데 제가 추가한 부분하고 비교해 보시라고 여기에 코드 다 넣을께요~
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		int PaymentAmount = Integer.parseInt(request.getParameter("PaymentAmount"));
		
		int result = new MemberService().updatePoint(userNo, PaymentAmount);
		
		if(result > 0) {
			msg = "포인트가 정상적으로 충전되었습니다. 다시 로그인해 주세요.";
			location = "/";
		} else {
			msg = "포인트 충전이 실패하였습니다. 다시 시도해주세요.";
			location = "/member/point";
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("script", script);
		request.setAttribute("location", location);
//		request.setAttribute("payer", payer);
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
	}
}

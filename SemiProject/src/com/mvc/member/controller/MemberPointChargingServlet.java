package com.mvc.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.member.model.service.MemberService;
import com.mvc.member.model.vo.Member;
import com.mvc.member.model.vo.Payer;


// 2021/01/20 이슬 포인트충전하기-> 기입한 정보를 -> db에 저장하는 서블릿
@WebServlet("/member/point")
public class MemberPointChargingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public MemberPointChargingServlet() {
      
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.getRequestDispatcher("/views/member/point.jsp").forward(request, response);
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg = "";
		String location = "";
		Payer payer = new Payer();
		int paymentAmount = Integer.parseInt(request.getParameter("paymentAmount"));
		int accountNumber = Integer.parseInt(request.getParameter("accountNumber"));
		HttpSession session = request.getSession(false);
		Member loginMember = session != null ? (Member)session.getAttribute("loginMember") : null;
		
		payer.setPayerNo(loginMember.getUserNo());
		payer.setPaymentAmount(paymentAmount);
		payer.setBankName(request.getParameter("bankName"));
		payer.setAccountNumber(accountNumber);
		
		
		int result = new MemberService().insertPointInfo(payer);
		
		System.out.println(payer);
		
		if(result > 0) {
			msg ="포인트 충전에 성공했습니다.";
			location = "/";
			
		} else {
			msg ="포인트 충전에 실패하였습니다.";
			location ="/member/point";	
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("location", location);
		
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
	}
}
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
    
    // 01.23 승현 userNo를 바로 불러와서 적용하기, Member를 따로 불러오니까 db쪽 에러가 나는것 같아서 일단 이렇게 해볼께요~
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg = "";
		String location = "";
		Payer payer = new Payer();
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		int paymentAmount = Integer.parseInt(request.getParameter("paymentAmount"));
		int accountNumber = Integer.parseInt(request.getParameter("accountNumber"));
		String bankName = request.getParameter("bankName");
		// 2021/01/22 이슬 session 부분 조금 수정/ payer session 추가
		
//		Member loginMember = (Member)session.getAttribute("loginMember");
        
		payer.setPayerNo(userNo);
		payer.setPaymentAmount(paymentAmount);
		payer.setBankName(bankName);
		payer.setAccountNumber(accountNumber);
		
		int result = new MemberService().insertPointInfo(payer);
		
		System.out.println(payer);
		// 2021/01/21 이슬 msg 내용 변경 / 포인트충전에 성공했습니다-> 다음단계로 넘어갑니다. / 포인트충전에 실패하였습니다 -> 다시 시도해 주세요.
		if(result > 0) {
			msg ="다음단계로 넘어갑니다.";
			// 2021/01/22 이슬 location 경로 변경
			
			// 1.23 승현 payer에 해당하는 session추가
			HttpSession session = request.getSession();
			session.setAttribute("payer", payer);
			
			location = "/member/pointUpdate";
		} else {
			msg ="다시 시도해 주세요.";
			location ="/member/point";	
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("location", location);
//		request.setAttribute("paymentAmount", paymentAmount);
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
	}
}
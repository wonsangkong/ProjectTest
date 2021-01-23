package com.mvc.member.model.service;

import java.sql.Connection;

import static com.mvc.common.jdbc.JDBCTemplate.*;
import com.mvc.member.model.dao.MemberDao;
import com.mvc.member.model.vo.Member;
import com.mvc.member.model.vo.Payer;

public class MemberService {
	private MemberDao dao = new MemberDao();
	
	public Member login(String id, String pwd) {
		return dao.findMemberByIdAndPwd(id, pwd);
	}
	
	/**
	signupMember 내 Connection 객체 생성.
	commit 및 rollback 관련 코드 추가.
	return 변경.
	 */
	public int signupMember(Member member) {
		Connection conn = getConnection();
		int result = dao.insertMember(conn, member);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return result;
	}
	
	//(은주) 1/20일 변경.
	public int Pwd(String id) {
		Connection conn = getConnection();
		int result = dao.Pwd(conn, id);
		
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
				
		close(conn);
		
		return result;
	}
	
	//(은주) 1/21일 변경.
	public Member pwd(String Id, String pon) {
		Connection conn = getConnection();
		return dao.pwd(conn, Id , pon);
	}
	
//	public int changePwd(String id, String pwd) {
//		Connection conn = getConnection();
//		int change = dao.changePwd(conn, id, pwd);
//		
//		if (change > 0) {
//			commit(conn);
//		} else {
//			rollback(conn);
//		}
//				
//		close(conn);
//		
//		return change;
//	}
	
	/**
	validate 메소드 추가.(아이디 중복 관련 메소드, Dao 클래스와 연결)
	*/
	public boolean validate(String userId) {
		Connection conn = getConnection();
		
		Member member = dao.findMemberById(conn, userId);
		
		close(conn);
		
		return member != null;
	}

	// 1.20 승현 projectwrite에서 필요한 member 부분 메소드 추가	
	public Member findMemberForPro(String userId) {
		Connection conn = getConnection();
		
		Member member = dao.findMemberById(conn, userId);
		
		close(conn);
		
		return member;
	}
	
	/** 1/20 원상 회원정보 수정 관련 메소드 추가 */
	
	public int editUserInfo(Member member) {
		Connection conn = getConnection();
		int result = dao.editUserInfo(conn, member);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	/** 1/20 원상 비밀번호 변경 관련 메소드 추가 */

	public int changePassword(String id, String pwd) {
		Connection conn = getConnection();
		int result = dao.changePassword(conn, id, pwd);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	// 2021/01/20 (이슬) 포인트 충전하기 후 나오는 폼에서 입력한 정보 받아오기
	public int insertPointInfo(Payer payer) {
		Connection conn = getConnection();
		int result = dao.insertPointInfo(conn, payer);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	/** 1월 21일 원상 회원탈퇴 관련 코드 추가 */
	
	public int deleteMember(String id) {
		Connection conn = getConnection();
		int result = dao.updateMemberStatus(conn, id, "N");
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	//(은주) 1/21일 id찾기 
	public boolean idfind(String userName, String phone, String email) {
		Connection conn = getConnection();
		
		Member member = dao.idfind(conn, userName, phone, email);
		
		close(conn);
		
		return member != null;
	}
	
	// 2021/01/21 이슬 user_coin에 포인트 업데이트할 updatePoint 개발 중 
	// 2021/01/22 이슬 updatePoint 매개변수 변경 했으나 안됨..
	public int updatePoint(int payerNo, int userNo) {
		Connection conn = getConnection();
		int result = dao.updatePoint(conn, payerNo, userNo);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return  result;
	}
	
	// 1.22 승현 후원하는 과정에서 user 정보를 가져오는 서비스
	public Member findMemberForfunding(int userNo) {
		Connection conn = getConnection();
		
		Member member = dao.findMemberForfunding(conn, userNo);
		
		close(conn);
		
		return member;
	}
	
	// 1.22 승현 project funding 값을 업데이트 하는 서비스
	public int updateFunding(int userNo, int fundingPrice) {
		Connection conn = getConnection();
		int result = dao.updateFunding(conn, userNo, fundingPrice);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return  result;
	}
	
	//(은주) 1/22일 수정
	public String idfind(String name, String email) {
		
		Connection conn = getConnection();
		return dao.idfind(conn, name , email);		
	}

}




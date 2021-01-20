package com.mvc.member.model.service;

import java.sql.Connection;

import static com.mvc.common.jdbc.JDBCTemplate.*;
import com.mvc.member.model.dao.MemberDao;
import com.mvc.member.model.vo.Member;

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
	

}




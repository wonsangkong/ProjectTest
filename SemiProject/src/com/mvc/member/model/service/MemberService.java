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
	
	public int Pwd(String id, String pwd) {
		Connection conn = getConnection();
		int result = dao.Pwd(conn, id, pwd);
		
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
				
		close(conn);
		
		return result;
	}
	
	/**
	validate 메소드 추가.(아이디 중복 관련 메소드, Dao 클래스와 연결)
	*/
	public boolean validate(String userId) {
		Connection conn = getConnection();
		
		Member member = dao.findMemberById(conn, userId);
		
		close(conn);
		
		return member != null;
	}
}




package com.mvc.board.model.dao;

import static com.mvc.common.jdbc.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mvc.board.model.vo.Board;

public class BoardDao {

	public List<Board> findAll(Connection conn) {
		List<Board> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = 
				 "SELECT B.BOARD_NO,B.BOARD_TITLE,M.USER_ID,B.BOARD_CREATE_DATE,B.BOARD_ORIGINAL_FILENAME,B.BOARD_READCOUNT "
				+ "FROM BOARD B JOIN MEMBER M ON(B.BOARD_WRITER_NO = M.USER_NO) WHERE B.STATUS = 'Y' ORDER BY BOARD_NO DESC";
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while (rset.next()) {
				Board board = new Board(); 
				
				board.setBoardNo(rset.getInt("BOARD_NO"));
				board.setBoardTitle(rset.getString("BOARD_TITLE"));
				board.setUserId(rset.getString("USER_ID"));
				board.setBoardCreateDate(rset.getDate("BOARD_CREATE_DATE"));
				board.setBoardOriginalFileName(rset.getString("BOARD_ORIGINAL_FILENAME"));
				board.setBoardReadCount(rset.getInt("BOARD_READCOUNT"));
				
				list.add(board);				
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}				
		return list;
	}


}

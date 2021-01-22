package com.mvc.board.model.service;

import static com.mvc.common.jdbc.JDBCTemplate.close;
import static com.mvc.common.jdbc.JDBCTemplate.commit;
import static com.mvc.common.jdbc.JDBCTemplate.getConnection;
import static com.mvc.common.jdbc.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.mvc.board.model.dao.BoardDao;
import com.mvc.board.model.vo.Board;

public class BoardService {

	public List<Board> getBoardList() {
		Connection conn = getConnection();

		List<Board> list = new BoardDao().findAll(conn);
		
		close(conn);
		return list;
	}





}

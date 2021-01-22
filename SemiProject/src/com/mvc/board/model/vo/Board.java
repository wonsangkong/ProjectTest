package com.mvc.board.model.vo;

import java.sql.Date;

public class Board {
	private int boardNo;
	private int boardWriteNo;
	private String userId;	
	private String boardTitle;
	private String boardContent;
	private String boardOriginalFileName;
	private String boardRenamedFileName;
	private int boardReadCount;
	private String status;
	private Date boardCreateDate;
	private Date boardModifyDate;
	
	public Board() {
	}	

	public Board(int boardNo, int boardWriteNo, String userId, String boardTitle, String boardContent,
			String boardOriginalFileName, String boardRenamedFileName, int boardReadCount, String status,
			Date boardCreateDate, Date boardModifyDate) {
		this.boardNo = boardNo;
		this.boardWriteNo = boardWriteNo;
		this.userId = userId;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardOriginalFileName = boardOriginalFileName;
		this.boardRenamedFileName = boardRenamedFileName;
		this.boardReadCount = boardReadCount;
		this.status = status;
		this.boardCreateDate = boardCreateDate;
		this.boardModifyDate = boardModifyDate;
	}
	
	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public int getBoardWriteNo() {
		return boardWriteNo;
	}

	public void setBoardWriteNo(int boardWriteNo) {
		this.boardWriteNo = boardWriteNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getBoardOriginalFileName() {
		return boardOriginalFileName;
	}

	public void setBoardOriginalFileName(String boardOriginalFileName) {
		this.boardOriginalFileName = boardOriginalFileName;
	}

	public String getBoardRenamedFileName() {
		return boardRenamedFileName;
	}

	public void setBoardRenamedFileName(String boardRenamedFileName) {
		this.boardRenamedFileName = boardRenamedFileName;
	}

	public int getBoardReadCount() {
		return boardReadCount;
	}

	public void setBoardReadCount(int boardReadCount) {
		this.boardReadCount = boardReadCount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getBoardCreateDate() {
		return boardCreateDate;
	}

	public void setBoardCreateDate(Date boardCreateDate) {
		this.boardCreateDate = boardCreateDate;
	}

	public Date getBoardModifyDate() {
		return boardModifyDate;
	}

	public void setBoardModifyDate(Date boardModifyDate) {
		this.boardModifyDate = boardModifyDate;
	}

	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", userId=" + userId + ", boardTitle=" + boardTitle
				+ ", boardContent=" + boardContent + ", boardOriginalFileName=" + boardOriginalFileName
				+ ", boardRenamedFileName=" + boardRenamedFileName + ", boardReadCount=" + boardReadCount + ", status="
				+ status + ", boardCreateDate=" + boardCreateDate + ", boardModifyDate=" + boardModifyDate + "]";
	}
}

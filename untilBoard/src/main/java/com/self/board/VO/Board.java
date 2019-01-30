package com.self.board.VO;

import java.sql.Date;

public class Board {
	 private int boardseqs;
	 private String id;
	 private String boardtitle;
	 private String boardcontext;
	 private Date indate;
	 private int hitcount;
	public Board() {
		super();
	}
	public Board(int boardseqs, String id, String boardtitle, String boardcontext, Date indate, int hitcount) {
		super();
		this.boardseqs = boardseqs;
		this.id = id;
		this.boardtitle = boardtitle;
		this.boardcontext = boardcontext;
		this.indate = indate;
		this.hitcount = hitcount;
	}
	public int getBoardseqs() {
		return boardseqs;
	}
	public void setBoardseqs(int boardseqs) {
		this.boardseqs = boardseqs;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBoardtitle() {
		return boardtitle;
	}
	public void setBoardtitle(String boardtitle) {
		this.boardtitle = boardtitle;
	}
	public String getBoardcontext() {
		return boardcontext;
	}
	public void setBoardcontext(String boardcontext) {
		this.boardcontext = boardcontext;
	}
	public Date getIndate() {
		return indate;
	}
	public void setIndate(Date indate) {
		this.indate = indate;
	}
	public int getHitcount() {
		return hitcount;
	}
	public void setHitcount(int hitcount) {
		this.hitcount = hitcount;
	}
	@Override
	public String toString() {
		return "Board [boardseqs=" + boardseqs + ", id=" + id + ", boardtitle=" + boardtitle + ", boardcontext="
				+ boardcontext + ", indate=" + indate + ", hitcount=" + hitcount + "]";
	}

	 
}	

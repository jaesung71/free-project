package com.forth.prac.VO;


public class Board {
	private String boardseq;
	private String id;
	private String boardtitle;
	private String boardcontent;
	private String indate;
	private int hitcount;
	private int rownum;
	private int boardGrade;
	public Board(String boardseq, String id, String boardtitle, String boardcontent, String indate, int hitcount,
			int rownum, int boardGrade) {
		super();
		this.boardseq = boardseq;
		this.id = id;
		this.boardtitle = boardtitle;
		this.boardcontent = boardcontent;
		this.indate = indate;
		this.hitcount = hitcount;
		this.rownum = rownum;
		this.boardGrade = boardGrade;
	}
	public Board() {
		super();
	}
	@Override
	public String toString() {
		return "Board [boardseq=" + boardseq + ", id=" + id + ", boardtitle=" + boardtitle + ", boardcontent="
				+ boardcontent + ", indate=" + indate + ", hitcount=" + hitcount + ", rownum=" + rownum
				+ ", boardGrade=" + boardGrade + "]";
	}
	public String getBoardseq() {
		return boardseq;
	}
	public void setBoardseq(String boardseq) {
		this.boardseq = boardseq;
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
	public String getBoardcontent() {
		return boardcontent;
	}
	public void setBoardcontent(String boardcontent) {
		this.boardcontent = boardcontent;
	}
	public String getIndate() {
		return indate;
	}
	public void setIndate(String indate) {
		this.indate = indate;
	}
	public int getHitcount() {
		return hitcount;
	}
	public void setHitcount(int hitcount) {
		this.hitcount = hitcount;
	}
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	public int getBoardGrade() {
		return boardGrade;
	}
	public void setBoardGrade(int boardGrade) {
		this.boardGrade = boardGrade;
	}
	
	
	
}

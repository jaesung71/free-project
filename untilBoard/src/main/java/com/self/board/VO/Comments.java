package com.self.board.VO;

import java.sql.Date;
import java.util.ArrayList;

public class Comments {
	private int commentsseq;
	private int boardseq;
	private String id;
	private String comments;
	private Date indate;
	private int parentseq;
	private ArrayList<Comments> cList;
	public Comments(int commentsseq, int boardseq, String id, String comments, Date indate, int parentseq,
			ArrayList<Comments> cList) {
		super();
		this.commentsseq = commentsseq;
		this.boardseq = boardseq;
		this.id = id;
		this.comments = comments;
		this.indate = indate;
		this.parentseq = parentseq;
		this.cList = cList;
	}
	public Comments() {
		super();
	}
	public int getCommentsseq() {
		return commentsseq;
	}
	public void setCommentsseq(int commentsseq) {
		this.commentsseq = commentsseq;
	}
	public int getBoardseq() {
		return boardseq;
	}
	public void setBoardseq(int boardseq) {
		this.boardseq = boardseq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Date getIndate() {
		return indate;
	}
	public void setIndate(Date indate) {
		this.indate = indate;
	}
	public int getParentseq() {
		return parentseq;
	}
	public void setParentseq(int parentseq) {
		this.parentseq = parentseq;
	}
	public ArrayList<Comments> getcList() {
		return cList;
	}
	public void setcList(ArrayList<Comments> cList) {
		this.cList = cList;
	}
	@Override
	public String toString() {
		return "Comments [commentsseq=" + commentsseq + ", boardseq=" + boardseq + ", id=" + id + ", comments="
				+ comments + ", indate=" + indate + ", parentseq=" + parentseq + ", cList=" + cList + "]";
	}
	
	
	
}

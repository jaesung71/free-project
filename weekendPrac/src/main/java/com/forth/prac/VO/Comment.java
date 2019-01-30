package com.forth.prac.VO;

import java.sql.Date;

public class Comment {
    private String commentseq;
	private String boardseq;
	private String id;
	private String comments;
	private Date indate;
	private String parentseq;
	public Comment(String commentseq, String boardseq, String id, String comments, Date indate, String parentseq) {
		super();
		this.commentseq = commentseq;
		this.boardseq = boardseq;
		this.id = id;
		this.comments = comments;
		this.indate = indate;
		this.parentseq = parentseq;
	}
	public Comment() {
		super();
	}
	public String getCommentseq() {
		return commentseq;
	}
	public void setCommentseq(String commentseq) {
		this.commentseq = commentseq;
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
	public String getParentseq() {
		return parentseq;
	}
	public void setParentseq(String parentseq) {
		this.parentseq = parentseq;
	}
	@Override
	public String toString() {
		return "Comment [commentseq=" + commentseq + ", boardseq=" + boardseq + ", id=" + id + ", comments=" + comments
				+ ", indate=" + indate + ", parentseq=" + parentseq + "]";
	}

	
}

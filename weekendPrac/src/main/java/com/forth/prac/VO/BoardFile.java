package com.forth.prac.VO;

public class BoardFile {
	private String boardfileseq;
	private String boardseq;
	private String dbName;
	private String orgName;
	public BoardFile(String boardfileseq, String boardseq, String dbName, String orgName) {
		super();
		this.boardfileseq = boardfileseq;
		this.boardseq = boardseq;
		this.dbName = dbName;
		this.orgName = orgName;
	}
	public BoardFile() {
		super();
	}
	public String getBoardfileseq() {
		return boardfileseq;
	}
	public void setBoardfileseq(String boardfileseq) {
		this.boardfileseq = boardfileseq;
	}
	public String getBoardseq() {
		return boardseq;
	}
	public void setBoardseq(String boardseq) {
		this.boardseq = boardseq;
	}
	public String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	@Override
	public String toString() {
		return "BoardFile [boardfileseq=" + boardfileseq + ", boardseq=" + boardseq + ", dbName=" + dbName
				+ ", orgName=" + orgName + "]";
	}
	
	
	
}

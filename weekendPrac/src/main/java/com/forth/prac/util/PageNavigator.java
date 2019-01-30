package com.forth.prac.util;

public class PageNavigator {
	//조건
	private int boardPerPage; //페이지당 글 목록수 
	private int pagePerGroup; //그룹당페이지수
	private int currentPage;  //현재페이지
	private int totalBoard;   //전체레코드수 = 전체글의갯수
	private int totalPage;    //전체페이지
	private int currentPageGroup;//현재페이지 그룹
	//구하려는 것
	private int startPageGroup;//현재그룹첫페이지    jsp에서 뿌려줄때 사용
	private int endPageGroup; //현재그룹마지막페이지 jsp에서 뿌려줄때 사용
	private int startBoardCurrentPage;//현재페이지의 첫글 위치 db에서 셀렉할때사용

	
	public PageNavigator(int boardPerPage,int pagePerGroup, int currentPage,int totalBoard) {
		this.boardPerPage = boardPerPage;
		this.pagePerGroup = pagePerGroup;
		//전체 페이지수 = (총글 레코드수+페이지당 글목록수-1)/페이지당 글목록수;
		totalPage = (totalBoard+boardPerPage-1)/boardPerPage;
		
		//현재 페이지(p) =  p<1=1, p>전체페이지=전체페이지 
		if(currentPage<1) {
			this.currentPage=1;
		}else if(currentPage>totalPage) {
			this.currentPage = totalPage;
		}else {
			this.currentPage = currentPage;
		}

		//현재 그룹 = (현재페이지-1)/그룹당 페이지수  (0부터 시작하기때문에 -1)
		currentPageGroup = (this.currentPage-1)/pagePerGroup;
		
		
		//현재그룹 스타트페이지 = (현재그룹*그룹당페이지수)+1
		startPageGroup = currentPageGroup*pagePerGroup+1;
		if(startPageGroup<1) {
			startPageGroup=1;
		}
		
		//현재그룹 끝페이지 = 스타트페이지+그룹당페이지수-1
		endPageGroup = startPageGroup+pagePerGroup-1;
		if(endPageGroup>totalPage) {
			endPageGroup= totalPage;
		}
		
		//현재페이지의 첫 글위치 = (현재페이지-1)*페이지당 글목록수
		startBoardCurrentPage = (this.currentPage-1)*boardPerPage;
	
	}
	
	@Override
	public String toString() {
		return "PageNavigator [boardPerPage=" + boardPerPage + ", pagePerGroup=" + pagePerGroup + ", currentPage="
				+ currentPage + ", totalBoard=" + totalBoard + ", currentPageGroup=" + currentPageGroup
				+ ", startPageGroup=" + startPageGroup + ", endPageGroup=" + endPageGroup + ", startBoardCurrentPage="
				+ startBoardCurrentPage + "]";
	}
	public int getBoardPerPage() {
		return boardPerPage;
	}
	public void setBoardPerPage(int boardPerPage) {
		this.boardPerPage = boardPerPage;
	}
	public int getPagePerGroup() {
		return pagePerGroup;
	}
	public void setPagePerGroup(int pagePerGroup) {
		this.pagePerGroup = pagePerGroup;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalBoard() {
		return totalBoard;
	}
	public void setTotalBoard(int totalBoard) {
		this.totalBoard = totalBoard;
	}
	public int getCurrentPageGroup() {
		return currentPageGroup;
	}
	public void setCurrentPageGroup(int currentPageGroup) {
		this.currentPageGroup = currentPageGroup;
	}
	public int getStartPageGroup() {
		return startPageGroup;
	}
	public void setStartPageGroup(int startPageGroup) {
		this.startPageGroup = startPageGroup;
	}
	public int getEndPageGroup() {
		return endPageGroup;
	}
	public void setEndPageGroup(int endPageGroup) {
		this.endPageGroup = endPageGroup;
	}
	public int getStartBoardCurrentPage() {
		return startBoardCurrentPage;
	}
	public void setStartBoardCurrentPage(int startBoardCurrentPage) {
		this.startBoardCurrentPage = startBoardCurrentPage;
	}
	
}

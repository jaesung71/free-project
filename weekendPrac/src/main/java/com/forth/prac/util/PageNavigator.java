package com.forth.prac.util;

public class PageNavigator {
	//����
	private int boardPerPage; //�������� �� ��ϼ� 
	private int pagePerGroup; //�׷����������
	private int currentPage;  //����������
	private int totalBoard;   //��ü���ڵ�� = ��ü���ǰ���
	private int totalPage;    //��ü������
	private int currentPageGroup;//���������� �׷�
	//���Ϸ��� ��
	private int startPageGroup;//����׷�ù������    jsp���� �ѷ��ٶ� ���
	private int endPageGroup; //����׷츶���������� jsp���� �ѷ��ٶ� ���
	private int startBoardCurrentPage;//������������ ù�� ��ġ db���� �����Ҷ����

	
	public PageNavigator(int boardPerPage,int pagePerGroup, int currentPage,int totalBoard) {
		this.boardPerPage = boardPerPage;
		this.pagePerGroup = pagePerGroup;
		//��ü �������� = (�ѱ� ���ڵ��+�������� �۸�ϼ�-1)/�������� �۸�ϼ�;
		totalPage = (totalBoard+boardPerPage-1)/boardPerPage;
		
		//���� ������(p) =  p<1=1, p>��ü������=��ü������ 
		if(currentPage<1) {
			this.currentPage=1;
		}else if(currentPage>totalPage) {
			this.currentPage = totalPage;
		}else {
			this.currentPage = currentPage;
		}

		//���� �׷� = (����������-1)/�׷�� ��������  (0���� �����ϱ⶧���� -1)
		currentPageGroup = (this.currentPage-1)/pagePerGroup;
		
		
		//����׷� ��ŸƮ������ = (����׷�*�׷����������)+1
		startPageGroup = currentPageGroup*pagePerGroup+1;
		if(startPageGroup<1) {
			startPageGroup=1;
		}
		
		//����׷� �������� = ��ŸƮ������+�׷����������-1
		endPageGroup = startPageGroup+pagePerGroup-1;
		if(endPageGroup>totalPage) {
			endPageGroup= totalPage;
		}
		
		//������������ ù ����ġ = (����������-1)*�������� �۸�ϼ�
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

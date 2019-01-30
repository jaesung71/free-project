package com.self.board.DAO;

import java.util.ArrayList;

import com.self.board.VO.Board;

public interface BoardMapper {
	public int insertBoard(Board b);
	public ArrayList<Board> roadBoard();
	public Board oneSelect(Board b);
	public void updateHitcount(Board b);
	public int deleteBoard(Board b);
	public void modify(Board b);
}

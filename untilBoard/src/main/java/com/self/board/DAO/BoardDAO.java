package com.self.board.DAO;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.self.board.VO.Board;

@Repository
public class BoardDAO {
	@Autowired
	SqlSession sqlSession;
	
	public int insertBoard(Board b) {
		int result = 0;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {
			result = mapper.insertBoard(b);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	public ArrayList<Board> roadBoard(){
		ArrayList<Board> bList = null;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {
			bList = mapper.roadBoard();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bList;
	}
	
	public Board oneSelect(Board b) {
		Board board = null;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {
			board = mapper.oneSelect(b);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return board;
	}
	public void updateHitcount(Board b) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {
			mapper.updateHitcount(b);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public int deleteBoard(Board b) {
		int result = 0;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {
			result = mapper.deleteBoard(b);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public void modify(Board b) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {
			mapper.modify(b);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

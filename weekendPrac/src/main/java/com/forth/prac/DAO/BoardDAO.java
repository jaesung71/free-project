package com.forth.prac.DAO;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.forth.prac.VO.Board;
import com.forth.prac.VO.BoardFile;
import com.forth.prac.VO.Comment;
import com.forth.prac.util.PageNavigator;

@Repository
public class BoardDAO {
	@Autowired
	SqlSession sqlSession;
	
	public int writeBoard(Board board) {
		int result = 0;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {
			result = mapper.writeBoard(board);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	public ArrayList<Board> selectBoardList(PageNavigator pn){
		ArrayList<Board> bList = null;
		
		RowBounds rb = new RowBounds(pn.getStartBoardCurrentPage(),pn.getBoardPerPage()); 
		//어디위치부터 몇개를 가져올지 적는다
		
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {
			bList = mapper.selectBoardList(rb);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bList;
	}
	public ArrayList<Board> selectGradeBoard(int boardGrade,PageNavigator pn){
		ArrayList<Board> bList = null;
		
		RowBounds rb = new RowBounds(pn.getStartBoardCurrentPage(),pn.getBoardPerPage()); 
		
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {
			bList = mapper.selectGradeBoard(boardGrade, rb);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bList;
	}
	public ArrayList<Board> selectBoardAll(){
		ArrayList<Board> bList = null;
		
		
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {
			bList = mapper.selectBoardAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bList;
	}
	public ArrayList<Board> selectBoardList(PageNavigator pn,HashMap<String, String> map){
		ArrayList<Board> bList = null;
		
		RowBounds rb = new RowBounds(pn.getStartBoardCurrentPage(),pn.getBoardPerPage()); 
		//어디위치부터 몇개를 가져올지 적는다
		
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {
			bList = mapper.selectBoardList(rb,map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bList;
	}
	public void upHitcount(String boardseq) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {
			mapper.upHitcount(boardseq);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Board innerSelect(String boardseq) {
		Board board = null;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {
			board = mapper.innerSelect(boardseq);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return board;
	}
	public void modifyBoard(Board board) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {
			mapper.modifyBoard(board);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void deleteBoard(String boardseq) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {
			mapper.deleteBoard(boardseq);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public int insertComment(Comment c) {
		int result = 0;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {
			result = mapper.insertComment(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public int insertRComment(Comment c) {
		int result = 0;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {
			result = mapper.insertRComment(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public ArrayList<Comment> selectCommentList(String boardseq){
		ArrayList<Comment> cList = null;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {
			cList = mapper.selectCommentList(boardseq);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cList;
	}

	public void deleteComment(String commentseq) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {
			mapper.deleteComment(commentseq);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void deleterComment(String commentseq) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {
			mapper.deleterComment(commentseq);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void modifyComment(Comment c) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {
			mapper.modifyComment(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public int insertboardFile(BoardFile bf) {
		int result = 0;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {
			result = mapper.insertboardFile(bf);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public ArrayList<BoardFile> selectBoardFile(String boardseq){
		ArrayList<BoardFile> bfList = null;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {
			bfList = mapper.selectBoardFile(boardseq);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bfList;
	}
	public void deleteBoardFile(String boardseq) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {
			mapper.deleteBoardFile(boardseq);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void deleteOneBoardFile(String boardfileseq) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {
			mapper.deleteOneBoardFile(boardfileseq);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public int modifyInsertBF(BoardFile bf) {
		int result = 0;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {
			result = mapper.modifyInsertBF(bf);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public int countRecord() {
		int result=0;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {
			result = mapper.countRecord();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	public int countGradeRecord(int boardGrade) {
		int result=0;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {
			result = mapper.countGradeRecord(boardGrade);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	public int countRecord(HashMap<String, String> map) {
		int result=0;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {
			result = mapper.countRecord(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}

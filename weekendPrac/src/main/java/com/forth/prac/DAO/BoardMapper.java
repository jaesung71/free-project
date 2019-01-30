package com.forth.prac.DAO;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;

import com.forth.prac.VO.Board;
import com.forth.prac.VO.BoardFile;
import com.forth.prac.VO.Comment;

public interface BoardMapper {
	public int writeBoard(Board board);
	public ArrayList<Board> selectBoardList(RowBounds rb);
	public ArrayList<Board> selectBoardList(RowBounds rb,HashMap<String, String> map);
	public void upHitcount(String boardseq);
	public Board innerSelect(String boardseq);
	public void modifyBoard(Board board);
	public void deleteBoard(String boardseq);
	public int insertComment(Comment c);
	public ArrayList<Comment> selectCommentList(String boardseq);
	public void deleteComment(String commentseq);
	public void modifyComment(Comment c);
	public int insertboardFile(BoardFile bf);
	public ArrayList<BoardFile> selectBoardFile(String boardseq);
	public void deleteBoardFile(String boardseq);
	public void deleteOneBoardFile(String boardfileseq);
	public int modifyInsertBF(BoardFile bf);
	public int countRecord();
	public int countRecord(HashMap<String, String> map);
	public int insertRComment(Comment c);
	public void deleterComment(String commentseq);
	public ArrayList<Board> selectBoardAll();
	public ArrayList<Board> selectGradeBoard(int boardGrade,RowBounds rb);
	public int countGradeRecord(int boardGrade);
}

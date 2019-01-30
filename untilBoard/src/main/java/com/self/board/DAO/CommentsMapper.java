package com.self.board.DAO;

import java.util.ArrayList;

import com.self.board.VO.Comments;

public interface CommentsMapper {
	public int insertComments(Comments c);
	public ArrayList<Comments> selectComments();
	public void deleteComments(Comments c);
	public Comments selectComment(Comments c);
}

package com.self.board.DAO;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.self.board.VO.Comments;

@Repository
public class CommentsDAO {
	@Autowired
	SqlSession sqlSession;
	
	public int insertComments(Comments c) {
		int result = 0;
		CommentsMapper mapper = sqlSession.getMapper(CommentsMapper.class);
		try {
			result = mapper.insertComments(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	public ArrayList<Comments> selectComments(){
		ArrayList<Comments> cList = null;
		CommentsMapper mapper = sqlSession.getMapper(CommentsMapper.class);
		try {
			cList = mapper.selectComments();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cList;
	}
	public void deleteComments(Comments c) {
		CommentsMapper mapper = sqlSession.getMapper(CommentsMapper.class);
		ArrayList<Comments> cList = selectComments();
		try {
			mapper.deleteComments(c);
			for(Comments com : cList) {
				if(com.getcList()!=null) {
					com.setcList(null);
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public Comments selectComment(Comments c) {
		Comments com = null;
		CommentsMapper mapper = sqlSession.getMapper(CommentsMapper.class);
		try {
			com = mapper.selectComment(c);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("selectComment errer");
		}
		return com;
	}
	
}

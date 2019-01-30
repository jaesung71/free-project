package com.self.board.DAO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.self.board.VO.Member;

@Repository
public class MemberDAO {
	@Autowired
	SqlSession sqlSession;
	
	public int insertMember(Member m) {
		int result = 0;
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		try {
			result = mapper.insertMember(m);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	public Member loginMember(Member m) {
		Member member = null;
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		
		try {
			member = mapper.loginMember(m);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return member;
	}
}

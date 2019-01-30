package com.forth.prac.DAO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.forth.prac.VO.Member;

@Repository
public class MemberDAO {
	@Autowired
	SqlSession sqlSession;
	
	public int touroku(Member mem) {
		int result = 0;
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		try {
			result = mapper.touroku(mem);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public Member login(Member mem) {
		Member member = null;
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		try {
			member = mapper.login(mem);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return member;
	}
}

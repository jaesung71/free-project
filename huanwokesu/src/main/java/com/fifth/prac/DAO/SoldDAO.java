package com.fifth.prac.DAO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fifth.prac.VO.Sold;

@Repository
public class SoldDAO {
	@Autowired
	SqlSession sqlSession;
	
	public int inserthistory(Sold s) {
		int result= 0;
		SoldMapper mapper = sqlSession.getMapper(SoldMapper.class);
		try {
			result = mapper.inserthistory(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}

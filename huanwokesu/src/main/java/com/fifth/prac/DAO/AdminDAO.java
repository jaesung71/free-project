package com.fifth.prac.DAO;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fifth.prac.VO.Admin;
import com.fifth.prac.VO.Customer;
import com.fifth.prac.util.PageNavigator;

@Repository
public class AdminDAO {
	
	@Autowired
	SqlSession sqlSession;
	
	public Admin aLogin(Admin admin) {
		Admin ad = null;
		AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
		try {
			ad = mapper.aLogin(admin);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ad;
	}
	public ArrayList<Customer> customerList(PageNavigator navi){
		ArrayList<Customer> cList = null;
		RowBounds rb = new RowBounds(navi.getStartBoardCurrentPage(),navi.getBoardPerPage());
		AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
		try {
			cList = mapper.customerList(rb);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cList;
	}
	public int customerRecord() {
		int result = 0;
		AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
		try {
			result = mapper.customerRecord();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	public int customerResearchRecord(HashMap<String,Object> map) {
		int result = 0;
		AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
		try {
			result = mapper.customerResearchRecord(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	public ArrayList<Customer> customerResearchList(HashMap<String,Object> map,PageNavigator navi){
		ArrayList<Customer> cList = null;
		RowBounds rb = new RowBounds(navi.getStartBoardCurrentPage(),navi.getBoardPerPage());
		AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
		try {
			cList = mapper.customerResearchList(map, rb);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cList;
	}
}

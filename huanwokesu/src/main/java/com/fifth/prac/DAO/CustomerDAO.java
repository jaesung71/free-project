package com.fifth.prac.DAO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fifth.prac.VO.Customer;

@Repository
public class CustomerDAO {
	@Autowired
	SqlSession sqlSession;
	
	public int registCustomer(Customer c) {
		int result=0;
		CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
		try {
			result = mapper.registCustomer(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public Customer login(Customer c) {
		Customer customer = null;
		CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
		try {
			customer = mapper.login(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}
	
}

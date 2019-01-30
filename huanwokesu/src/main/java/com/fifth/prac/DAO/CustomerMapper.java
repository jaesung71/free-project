package com.fifth.prac.DAO;

import com.fifth.prac.VO.Customer;

public interface CustomerMapper {
	public int registCustomer(Customer c);
	public Customer login(Customer c);
}

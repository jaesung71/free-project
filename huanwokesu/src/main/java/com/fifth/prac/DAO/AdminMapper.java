package com.fifth.prac.DAO;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;

import com.fifth.prac.VO.Admin;
import com.fifth.prac.VO.Customer;

public interface AdminMapper {
	public Admin aLogin(Admin admin);//관리자 로그인
	public ArrayList<Customer> customerList(RowBounds rb);//
	public int customerRecord();
	public int customerResearchRecord(HashMap<String,Object> map);
	public ArrayList<Customer> customerResearchList(HashMap<String,Object> map,RowBounds rb);
}

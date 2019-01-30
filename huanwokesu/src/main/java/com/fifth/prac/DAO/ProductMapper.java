package com.fifth.prac.DAO;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;

import com.fifth.prac.VO.Product;

public interface ProductMapper {
	public int registProduct(Product p);
	public ArrayList<Product> productList(RowBounds rb);
	public void qutityUpdate(HashMap<String,Object> map);
	public Product productdetail(String productseq);
	public void buyProduct(HashMap<String,Object> map);
	public ArrayList<HashMap<String,Object>> soldList(String customerid,RowBounds rb);
	public int countRecord();
	public int countRecordSearch(HashMap<String, String> map);
	public int soldListRecord(String loginId);
	public ArrayList<Product> productListSearch(RowBounds rb,HashMap<String,String> map);
	public int soldListRecordSearch(HashMap<String,Object> map);
	public ArrayList<HashMap<String,Object>> soldListSearch(RowBounds rb,HashMap<String,Object> map);
	public ArrayList<HashMap<String,Object>> soldListPrice(String customerid);
	public ArrayList<HashMap<String,Object>> soldListSearchPrice(HashMap<String,Object> map);
}

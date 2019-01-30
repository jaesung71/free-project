package com.fifth.prac.DAO;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fifth.prac.VO.Product;
import com.fifth.prac.util.PageNavigator;

@Repository
public class ProductDAO {
	@Autowired
	SqlSession sqlSession;
	
	public int registProduct(Product p) {
		int result = 0;
		ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
		try {
			result = mapper.registProduct(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	public ArrayList<Product> productList(PageNavigator navi){
		ArrayList<Product> pList= null;
		ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
		RowBounds rb = new RowBounds(navi.getStartBoardCurrentPage(),navi.getBoardPerPage());
		try {
			pList = mapper.productList(rb);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pList;
	}
	public ArrayList<Product> productListSearch(PageNavigator navi,HashMap<String,String> map){
		ArrayList<Product> pList= null;
		ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
		RowBounds rb = new RowBounds(navi.getStartBoardCurrentPage(),navi.getBoardPerPage());
		 try {
			 pList = mapper.productListSearch(rb, map);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return pList;
	}
	public void qutityUpdate(HashMap<String,Object> map) {
		ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
		try {
			mapper.qutityUpdate(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Product productdetail(String productseq) {
		Product p = null;
		ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
		try {
			p = mapper.productdetail(productseq);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}
	public void buyProduct(HashMap<String,Object> map) {
		ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
		try {
			mapper.buyProduct(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ArrayList<HashMap<String, Object>> soldList(String customerid,PageNavigator navi){
		ArrayList<HashMap<String,Object>> bList = null;
		ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
		RowBounds rb = new RowBounds(navi.getStartBoardCurrentPage(),navi.getBoardPerPage());
		try {
			bList = mapper.soldList(customerid,rb);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bList;
	}
	public ArrayList<HashMap<String,Object>> soldListPrice(String customerid){
		ArrayList<HashMap<String,Object>> bList = null;
		ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
		try {
			bList = mapper.soldListPrice(customerid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bList;
	}
	public int countRecord() {
		int result = 0;
		ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
		try {
			result = mapper.countRecord();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	public int countRecordSearch(HashMap<String,String> map) {
		int result = 0;
		ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
		try {
			mapper.countRecordSearch(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return result;
	}
	public int soldListRecord(String loginId) {
		int result = 0;
		ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
		try {
			result = mapper.soldListRecord(loginId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public int soldListRecordSearch(HashMap<String,Object> map) {
		int result = 0;
		ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
		try {
			result = mapper.soldListRecordSearch(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public ArrayList<HashMap<String,Object>> soldListSearch(PageNavigator navi,HashMap<String,Object> map){
		ArrayList<HashMap<String,Object>> bList = null;
		ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
		RowBounds rb = new RowBounds(navi.getStartBoardCurrentPage(),navi.getBoardPerPage());
		try {
			bList = mapper.soldListSearch(rb, map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bList;
	}
	public ArrayList<HashMap<String,Object>> soldListSearchPrice(HashMap<String,Object> map){
		ArrayList<HashMap<String,Object>> bList = null;
		ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
		try {
			bList = mapper.soldListSearchPrice(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bList;
	}
}

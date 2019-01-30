package com.fifth.prac;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fifth.prac.DAO.ProductDAO;
import com.fifth.prac.DAO.SoldDAO;
import com.fifth.prac.VO.Product;
import com.fifth.prac.VO.Sold;
import com.fifth.prac.util.PageNavigator;


@Controller
public class ProductController {
	
	@Autowired
	ProductDAO dao;
	@Autowired
	SoldDAO sdao;
	private static final int boardPerPage = 5;
	private static final int pagePerGroup = 3;
	
	@RequestMapping(value="goProductManagement",method=RequestMethod.GET)
	public String goProductManagement(Model model,HttpSession session
			,@RequestParam(value="page",defaultValue="1")int page
			,@RequestParam(value="selectType",defaultValue="")String selectType
			,@RequestParam(value="select",defaultValue="")String select) {
		PageNavigator navi = null;
		ArrayList<Product> pList = null;
		HashMap<String,String> map = null;
		int totalBoard = 0;
		map = new HashMap<String,String>();
		map.put("selectType", selectType);
		map.put("select", select);
		totalBoard = dao.countRecord();
		navi = new PageNavigator(boardPerPage,pagePerGroup,page,totalBoard);
		
		if(select.equals("")||select==null) {
			pList = dao.productList(navi);
		}else if(select!=null) {
			totalBoard = dao.countRecordSearch(map);
			navi = new PageNavigator(boardPerPage,pagePerGroup,page,totalBoard);
			pList = dao.productListSearch(navi,map);
			model.addAttribute("map", map);
		}
		
		
		model.addAttribute("navi", navi);
		model.addAttribute("pList", pList);
		
		return "/admin/productManagement";
	}
	
	@RequestMapping(value="goRegistProductForm",method=RequestMethod.GET)
	public String goRegistProductForm() {
		return "/admin/registProductForm";
	}
	
	@RequestMapping(value="registProduct",method=RequestMethod.POST)
	public String registProduct(Product p,Model model) {
		
		if(dao.registProduct(p)==0) {
			model.addAttribute("warning", "상품등록실패");
		}else {
			model.addAttribute("complete","상품등록 성공");
		}
		
		return "redirect:goProductManagement";
	}
	@RequestMapping(value="goQuantityUpdate",method=RequestMethod.GET)
	public String goQuantityUpdate(String productseq,HttpSession session,Model model
			,@RequestParam(value="page",defaultValue="1")int page
			,@RequestParam(value="selectType",defaultValue="")String selectType
			,@RequestParam(value="select",defaultValue="")String select) {
		session.setAttribute("quantityUpdate", 1);
		session.setAttribute("productseqs", productseq);
		
//		int totalBoard = dao.countRecord();
//		PageNavigator navi = new PageNavigator(boardPerPage,pagePerGroup,page,totalBoard);
//		ArrayList<Product> pList = dao.productList(navi);
//		model.addAttribute("navi", navi);
//		model.addAttribute("pList", pList);
		
		
		
		return "forward:goProductManagement";
	}
	@RequestMapping(value ="qutityUpdate",method=RequestMethod.GET)
	public String qutityUpdate(String productseq,String quantity,Model model
			,HttpSession session
			,@RequestParam(defaultValue="1")int page
			,@RequestParam(value="selectType",defaultValue="")String selectType
			,@RequestParam(value="select",defaultValue="")String select) {
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("productseq", productseq);
		map.put("quantity", quantity);
		dao.qutityUpdate(map);
		model.addAttribute("productseqs", null);
		session.setAttribute("quantityUpdate", null);
		return "forward:goProductManagement";
	}
	@RequestMapping(value="goProductList",method=RequestMethod.GET)
	public String goProductList(Model model
			,@RequestParam(value="page",defaultValue="1")int page
			,@RequestParam(value="selectType",defaultValue="")String selectType
			,@RequestParam(value="select",defaultValue="")String select) {
		int totalBoard =0;
		PageNavigator navi = null;
		ArrayList<Product> pList = null;
		HashMap<String,String> map = null;
		map = new HashMap<String,String>();
		map.put("selectType", selectType);
		map.put("select", select);
		totalBoard = dao.countRecord();
		navi = new PageNavigator(boardPerPage,pagePerGroup,page,totalBoard);
//		System.out.println(navi);
		if(select.equals("")||select ==null) {
			pList = dao.productList(navi);
		}else if(select != null) {
			totalBoard = dao.countRecordSearch(map);
			navi = new PageNavigator(boardPerPage,pagePerGroup,page,totalBoard);
			pList = dao.productListSearch(navi,map);
			model.addAttribute("map", map);
		}
		model.addAttribute("pList", pList);
		model.addAttribute("navi", navi);
		
		return "/customer/productList";
	}
	@RequestMapping(value="productdetail",method=RequestMethod.GET)
	public String productdetail(String productseq,Model model
			,@RequestParam(value="page",defaultValue="1")int page) {
		Product product = dao.productdetail(productseq);
	
			model.addAttribute("product", product);
			model.addAttribute("page", page);
			return "/customer/productdetail";
		
	}
	@RequestMapping(value="buyProduct",method=RequestMethod.GET)
	public String buyProduct(String productseq,
			@RequestParam(defaultValue="")String quantity
			,@RequestParam(defaultValue="1")int page
			,Model model,HttpSession session) {
		
		if(quantity=="") {
			model.addAttribute("warning", "수량을 입력하세요.");
			return "forward:productdetail";
		}
		Product p = dao.productdetail(productseq);
		if(p.getQuantity()<Integer.parseInt(quantity)) {
			model.addAttribute("warning", "상품의 남은 수량보다 구매하려는 양이 많습니다.");
			return "forward:productdetail";
		}
		//상품의 수량을 줄이고
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("productseq", productseq);
		map.put("quantity",quantity);
		dao.buyProduct(map);
		//상품구매내역에 인서트
		Sold sold = new Sold();
		sold.setCustomerid((String)session.getAttribute("loginId"));
		sold.setProductseq(productseq);
		sold.setQuantity(Integer.parseInt(quantity));
		sdao.inserthistory(sold);
		return "forward:goProductList";
	}
	@RequestMapping(value="goSoldList",method=RequestMethod.GET)
	public String goSoldList(Model model,HttpSession session
			,@RequestParam(defaultValue="1")int page
			,@RequestParam(defaultValue="")String selectType
			,@RequestParam(defaultValue="")String select) {
		int totalBoard =0;
		BigDecimal plus =new BigDecimal("0");
		PageNavigator navi = null;
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("selectType", selectType);
		map.put("select",select);
		String customerid = (String)session.getAttribute("loginId");
		map.put("customerid",customerid);
		ArrayList<HashMap<String,Object>> bList = null;
		ArrayList<HashMap<String,Object>> priceList = null;
		if(select.equals("")||select==null) {
			totalBoard= dao.soldListRecord(customerid);
			navi = new PageNavigator(boardPerPage,pagePerGroup,page,totalBoard);
			bList = dao.soldList((String)session.getAttribute("loginId"),navi);
			priceList = dao.soldListPrice(customerid);
			for (HashMap<String, Object> hashMap : priceList) {
				BigDecimal price= (BigDecimal)hashMap.get("PRICE");
				plus = plus.add(price.multiply((BigDecimal) hashMap.get("QUANTITY")));
			}
		}else if(select!=null) {
			totalBoard = dao.soldListRecordSearch(map);
			navi = new PageNavigator(boardPerPage,pagePerGroup,page,totalBoard);
			bList = dao.soldListSearch(navi, map);
			model.addAttribute("map", map);
			priceList = dao.soldListSearchPrice(map);
			for (HashMap<String, Object> hashMap : priceList) {
				BigDecimal price= (BigDecimal)hashMap.get("PRICE");
				plus = plus.add(price.multiply((BigDecimal) hashMap.get("QUANTITY")));
			}
		}
		model.addAttribute("plus", plus);
		model.addAttribute("navi", navi);
		model.addAttribute("bList", bList);
		return "/customer/soldList";
	}
}

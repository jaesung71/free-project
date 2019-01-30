package com.fifth.prac;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fifth.prac.DAO.AdminDAO;
import com.fifth.prac.VO.Admin;
import com.fifth.prac.VO.Customer;
import com.fifth.prac.util.PageNavigator;


@Controller
public class AdminController {
	
//	@RequestMapping("/admin")
	
	@Autowired
	AdminDAO dao;

	private static final int boardPerPage = 5;
	private static final int pagePerGroup = 3;
	
	@RequestMapping(value="goAhome",method=RequestMethod.GET)
	public String goAhome() {
		return "/admin/ahome";
	}
	@RequestMapping(value="goAdminLogin",method=RequestMethod.GET)
	public String goAdminLogin() {
		return "/admin/aLogin";
	}
	@RequestMapping(value="adminlogin",method=RequestMethod.POST)
	public String adminlogin(Admin admin,HttpSession session) {
		
		if(dao.aLogin(admin)==null) {
			return "/admin/aLogin";
		}else {
			session.setAttribute("AdminloginId", dao.aLogin(admin).getAdminid());
		}
		
		return "/admin/ahome";
	}
	@RequestMapping(value="adminlogout",method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.setAttribute("AdminloginId", null);
		return "/admin/ahome";
	}
	@RequestMapping(value="goCustomerManagement",method=RequestMethod.GET)
	public String goCustomerManagement(Model model,
			@RequestParam(defaultValue="1")int page,
			@RequestParam(defaultValue="")String selectType,
			@RequestParam(defaultValue="")String select) {
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("selectType", selectType);
		map.put("select", select);
		int totalBoard =0;
		ArrayList<Customer> cList = null;
		PageNavigator navi = null;
		if(select.equals("")||select==null) {
			totalBoard = dao.customerRecord();
			navi = new PageNavigator(boardPerPage,pagePerGroup,page,totalBoard);
			cList = dao.customerList(navi);
		}else if(select!=null) {
			totalBoard = dao.customerResearchRecord(map);
			navi = new PageNavigator(boardPerPage,pagePerGroup,page,totalBoard);
			cList = dao.customerResearchList(map, navi);
			model.addAttribute("map", map);
		}
		model.addAttribute("navi", navi);
		model.addAttribute("cList", cList);
		return "/admin/customerManagement";
	}
}

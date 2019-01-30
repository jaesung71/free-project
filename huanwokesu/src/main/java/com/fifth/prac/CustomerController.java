package com.fifth.prac;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fifth.prac.DAO.CustomerDAO;
import com.fifth.prac.VO.Customer;


@Controller
public class CustomerController {
	@Autowired
	CustomerDAO dao;
	
	@RequestMapping(value="goChome",method=RequestMethod.GET)
	public String goChome() {
		return "/customer/chome";
	}
	@RequestMapping(value="goRegistCustomer",method=RequestMethod.GET)
	public String goRegist() {
		return "/customer/registCustomerForm";
	}
	@RequestMapping(value="/goLogin",method=RequestMethod.GET)
	public String goLogin() {
		
		return "/customer/login";
	}
	@RequestMapping(value="logout",method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.setAttribute("loginId", null);
		return "/customer/chome";
	}
	
	@RequestMapping(value="registCustomer",method=RequestMethod.POST)
	public String registCustomer(Customer c,HttpSession session,Model model) {
		if(dao.registCustomer(c)==0) {
			model.addAttribute("warning", "��Ͻ���");
			return "/customer/chome";
		}else {
			model.addAttribute("complete", "��ϼ���");
		}
		return "/customer/chome";
	}
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String login(Customer c,HttpSession session,Model model) {
		if(dao.login(c)==null) {
			model.addAttribute("warning", "�α��� ����");
		}else {
			model.addAttribute("complete", "�α��μ���");
			session.setAttribute("loginId", dao.login(c).getCustomerid());
		}
		
		return "/customer/chome";
	}
	
}

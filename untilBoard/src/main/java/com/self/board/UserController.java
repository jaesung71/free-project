package com.self.board;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.self.board.DAO.MemberDAO;
import com.self.board.VO.Member;

@Controller
public class UserController {
	@Autowired
	MemberDAO dao;
	
//	ȸ�������������� �̵�
	@RequestMapping(value="goRegist",method=RequestMethod.GET)
	public String goRegist() {
		
		return "regist";
	}
//	�α����������� �̵�
	@RequestMapping(value="goLogin",method=RequestMethod.GET)
	public String goLogin() {
		
		return "login";
	}
//	�α׾ƿ�
	@RequestMapping(value="logout",method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.setAttribute("loginId", null);
		return "home";
	}
	
//	ȸ������
	@RequestMapping(value="regist",method=RequestMethod.POST)
	public String regist(Member m,Model model) {
		
		if(dao.insertMember(m)==0) {
			model.addAttribute("warning", "��Ͻ���");
		}else {
			model.addAttribute("complete", "��ϼ���");
		}
		
		return "home";
	}
	
//	�α���
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String login(Member m,Model model,HttpSession session) {
		
		if(dao.loginMember(m)==null) {
			model.addAttribute("warning", "�α��� ����");
		}else {
			model.addAttribute("complete", "�α��� ����");
			session.setAttribute("loginId", m.getId());
		}
		
		return "home";
	}
}

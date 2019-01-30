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
	
//	회원가입페이지로 이동
	@RequestMapping(value="goRegist",method=RequestMethod.GET)
	public String goRegist() {
		
		return "regist";
	}
//	로그인페이지로 이동
	@RequestMapping(value="goLogin",method=RequestMethod.GET)
	public String goLogin() {
		
		return "login";
	}
//	로그아웃
	@RequestMapping(value="logout",method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.setAttribute("loginId", null);
		return "home";
	}
	
//	회원가입
	@RequestMapping(value="regist",method=RequestMethod.POST)
	public String regist(Member m,Model model) {
		
		if(dao.insertMember(m)==0) {
			model.addAttribute("warning", "등록실패");
		}else {
			model.addAttribute("complete", "등록성공");
		}
		
		return "home";
	}
	
//	로그인
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String login(Member m,Model model,HttpSession session) {
		
		if(dao.loginMember(m)==null) {
			model.addAttribute("warning", "로그인 실패");
		}else {
			model.addAttribute("complete", "로그인 성공");
			session.setAttribute("loginId", m.getId());
		}
		
		return "home";
	}
}

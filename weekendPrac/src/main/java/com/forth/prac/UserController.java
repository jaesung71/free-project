package com.forth.prac;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.forth.prac.DAO.MemberDAO;
import com.forth.prac.VO.Member;

@Controller
public class UserController {
	
	@Autowired
	MemberDAO dao;
	
	@RequestMapping(value="goTouroku",method=RequestMethod.GET)
	public String goTouroku() {
		return "touroku";
	}
	@RequestMapping(value="goLogin",method=RequestMethod.GET)
	public String goLogion() {
		return "login";
	}
	@RequestMapping(value="logout",method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.setAttribute("loginId", null);
		return "home";
	}
	@RequestMapping(value="touroku", method=RequestMethod.POST)
	public String touroku(Member mem,Model model) {
		if(dao.touroku(mem)==0) {
			model.addAttribute("warning", "등록실패");
		}else {
			model.addAttribute("complete", "등록성공");
		}
		return "home";
	}
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String login(Member mem,HttpSession session,Model model) {
		Member member = dao.login(mem);
		
		if(member!=null) {
//			System.out.println(member.getGrade());
			session.setAttribute("loginId", member.getId());
			session.setAttribute("grade", member.getGrade());
			if(member.getId().equals("JJS7")) {
				session.setAttribute("god", member.getId());
			}
		}else {
			model.addAttribute("warning", "응 실패");
		}
		return "home";
	}
}

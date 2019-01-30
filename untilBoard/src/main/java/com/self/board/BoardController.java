package com.self.board;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.self.board.DAO.BoardDAO;
import com.self.board.DAO.CommentsDAO;
import com.self.board.VO.Board;
import com.self.board.VO.Comments;

@Controller
public class BoardController {
	@Autowired
	BoardDAO dao;
	@Autowired
	CommentsDAO cdao;
//	�Խ��ǰ���
	@RequestMapping(value = "goBoard", method = RequestMethod.GET)
	public String goBoard(Model model) {
		ArrayList<Board> bList;
		bList = dao.roadBoard();
		if (bList != null) {
			model.addAttribute("bList", bList);
		}
		return "board";
	}

//	�Խñ��ۼ�������
	@RequestMapping(value = "writeBoard", method = RequestMethod.GET)
	public String writeBoard(HttpSession session) {
		if(session.getAttribute("loginId")==null) {
			return "login";
		}
		return "writeBoard";
	}

//	�Խñ� �ۼ�
	@RequestMapping(value = "writing", method = RequestMethod.GET)
	public String writing(Board b, Model model) {
		if (dao.insertBoard(b) == 0) {
			model.addAttribute("warning", "�Խý���");
		} else {
			model.addAttribute("complete", "�Խü���");
		}

		return "redirect:/goBoard";
	}

//	�Խñ� ����
	@RequestMapping(value = "innerBoard", method = RequestMethod.GET)
	public String innserBoard(Board b, HttpSession session, Model model) {
		Board board = dao.oneSelect(b);

		if (board != null) {
			dao.updateHitcount(b);
			Board board2 = dao.oneSelect(b);
			model.addAttribute("board", board2);
		} else {
			return "redirect:/goBoard";
		}

		return "innerBoard";
	}

//	�� ����������
	@RequestMapping(value = "alterBoard", method = RequestMethod.GET)
	public String alterBoard(Board b, Model model) {
		Board board = dao.oneSelect(b);
		model.addAttribute("board", board);
		return "alterBoardForm";
	}
// �� ����
	@RequestMapping(value="deleteBoard",method=RequestMethod.GET)
	public String deleteBoard(Board b) {
		dao.deleteBoard(b);
		return "redirect:/goBoard";
	}
//	�� ����
	@RequestMapping(value="modify",method=RequestMethod.GET)
	public String modify(Board board) {
		dao.modify(board);
		
		return "redirect:/goBoard";
	}
	
	@RequestMapping(value="/insertComments", method=RequestMethod.GET)
	public String insertComments(Comments c,HttpSession session,Model model) {
		if(session.getAttribute("loginId")==null) {
			return "login";
		}
		Board b = new Board();
		b.setBoardseqs(c.getBoardseq());
		Board board = dao.oneSelect(b);
		if(cdao.insertComments(c)==0) {
			model.addAttribute("warning", "��۵�Ͻ���");
			model.addAttribute("board", board);
			ArrayList<Comments> cList = cdao.selectComments();
			model.addAttribute("cList", cList);
		}else {
			model.addAttribute("complete", "��۵�ϼ���");
			model.addAttribute("board", board);
			ArrayList<Comments> cList = cdao.selectComments();
			model.addAttribute("cList", cList);
		}
		return "innerBoard";
	}
	
	@RequestMapping(value="/deleteComments", method=RequestMethod.GET)
	public String deleteComments(Comments c,HttpSession session,Model model) {
		if(session.getAttribute("loginId")==null) {
			return "login";
		}
		Board b = new Board();
		b.setBoardseqs(c.getBoardseq());
		cdao.deleteComments(c);
		Board board = dao.oneSelect(b);
		model.addAttribute("board", board);
		ArrayList<Comments> cList = cdao.selectComments();
		model.addAttribute("cList", cList);
		
		return "innerBoard";
	}
}

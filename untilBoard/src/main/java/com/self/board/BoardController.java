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
//	게시판가기
	@RequestMapping(value = "goBoard", method = RequestMethod.GET)
	public String goBoard(Model model) {
		ArrayList<Board> bList;
		bList = dao.roadBoard();
		if (bList != null) {
			model.addAttribute("bList", bList);
		}
		return "board";
	}

//	게시글작성란가기
	@RequestMapping(value = "writeBoard", method = RequestMethod.GET)
	public String writeBoard(HttpSession session) {
		if(session.getAttribute("loginId")==null) {
			return "login";
		}
		return "writeBoard";
	}

//	게시글 작성
	@RequestMapping(value = "writing", method = RequestMethod.GET)
	public String writing(Board b, Model model) {
		if (dao.insertBoard(b) == 0) {
			model.addAttribute("warning", "게시실패");
		} else {
			model.addAttribute("complete", "게시성공");
		}

		return "redirect:/goBoard";
	}

//	게시글 보기
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

//	글 수정란가기
	@RequestMapping(value = "alterBoard", method = RequestMethod.GET)
	public String alterBoard(Board b, Model model) {
		Board board = dao.oneSelect(b);
		model.addAttribute("board", board);
		return "alterBoardForm";
	}
// 글 삭제
	@RequestMapping(value="deleteBoard",method=RequestMethod.GET)
	public String deleteBoard(Board b) {
		dao.deleteBoard(b);
		return "redirect:/goBoard";
	}
//	글 수정
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
			model.addAttribute("warning", "댓글등록실패");
			model.addAttribute("board", board);
			ArrayList<Comments> cList = cdao.selectComments();
			model.addAttribute("cList", cList);
		}else {
			model.addAttribute("complete", "댓글등록성공");
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

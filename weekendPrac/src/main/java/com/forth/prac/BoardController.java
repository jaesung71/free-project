package com.forth.prac;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.forth.prac.DAO.BoardDAO;
import com.forth.prac.VO.Board;
import com.forth.prac.VO.BoardFile;
import com.forth.prac.VO.Comment;
import com.forth.prac.util.PageNavigator;

@Controller
public class BoardController {

	@Autowired
	BoardDAO dao;
	private static final String UPLOADPATH = "D:/newUpload/";
	private static final int boardPerPage = 5;
	private static final int pagePerGroup = 3;
	
	@RequestMapping(value="goBoard",method=RequestMethod.GET)
	public String goBoard(Model model,
			@RequestParam(value="page",defaultValue="1")int page, //goBoard액션실행시 파라미터로 page를 주지 않았을때
													 //디폴트 값으로 1을 준다
			@RequestParam(value="search",defaultValue="")String search,
			@RequestParam(value="searchType",defaultValue="")String searchType,
			HashMap<String, String> map,
			@RequestParam(value="boardGrade",defaultValue="0")int boardGrade,
			HttpSession session) {
//		ArrayList<Board> bList = dao.selectBoardList();
//		model.addAttribute("bList",bList);
		int totalBoard = 0; //전체레코드수
		ArrayList<Board> bList = null;
		ArrayList<Board> bList2 = null;
		PageNavigator pn = null;
		map.put("searchType", searchType);
		map.put("search", search);
		totalBoard = dao.countRecord();
		pn = new PageNavigator(boardPerPage,pagePerGroup,page,totalBoard);
		if(search.equals("")||search==null) {
			bList = dao.selectBoardList(pn);
			bList2 = dao.selectBoardAll();
			model.addAttribute("navi", pn);
			
		}else if(search!=null){
			totalBoard =dao.countRecord(map);
			pn = new PageNavigator(boardPerPage,pagePerGroup,page,totalBoard);
			bList = dao.selectBoardList(pn,map);
			model.addAttribute("map", map);
			model.addAttribute("navi", pn);
		}
		if(boardGrade!=0) {
			if(session.getAttribute("loginId")==null) {
				return "login";
			}else {
			int grade = (Integer)session.getAttribute("grade");
			if(grade<boardGrade) {
				model.addAttribute("warning", "본인의 회원등급을 확인하세요.");
				return "redirect:goBoard";
			}
			totalBoard = dao.countGradeRecord(boardGrade);
			pn = new PageNavigator(boardPerPage,pagePerGroup,page,totalBoard);
			bList = dao.selectGradeBoard(boardGrade, pn);
			model.addAttribute("gradeValue",grade);
			model.addAttribute("navi", pn);
			}
		}
	
		
		model.addAttribute("bList2", bList2);
		model.addAttribute("bList", bList);
		model.addAttribute("search", search);
		return "board";
	}

	
	@RequestMapping(value="/goWriteForm",method=RequestMethod.GET)
	public String writeBoard() {
//		if(session.getAttribute("loginId")==null) {
//			return "login";
//		}
		return "writeForm";
	}
	
	@RequestMapping(value="writeBoard",method=RequestMethod.POST)
	public String writeBoard(Board board,Model model,MultipartHttpServletRequest rq) {
		dao.writeBoard(board);
		for (MultipartFile file : rq.getFiles("upLoadFile")) {
			BoardFile bf = new BoardFile();
			String orgname = file.getOriginalFilename();
			long now = System.currentTimeMillis();
			String DBName = now+orgname;
			bf.setOrgName(orgname);
			bf.setDbName(DBName);
			dao.insertboardFile(bf);
			try {
				file.transferTo(new File(UPLOADPATH + DBName));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return "redirect:goBoard";
	}
	@RequestMapping(value="goInnerBoard",method=RequestMethod.GET)
	public String goInnerBoard(String boardseq,Model model,HttpSession session) {
		dao.upHitcount(boardseq);
		if(dao.innerSelect(boardseq)!=null) {
			model.addAttribute("board", dao.innerSelect(boardseq));
			ArrayList<Comment> cList = dao.selectCommentList(boardseq);
			model.addAttribute("cList",cList);
			session.setAttribute("mForm", null);
			ArrayList<BoardFile> bfList = dao.selectBoardFile(boardseq);
			model.addAttribute("bfList", bfList);
			ArrayList<Comment> rcList = dao.selectCommentList(boardseq);
			model.addAttribute("rcList", rcList);
			session.setAttribute("rCom", null);
		}else {
			return "redirect:goBoard?page=1";
		}
		
		return "innerBoard";
	}
	@RequestMapping(value="/goModifyForm",method=RequestMethod.GET)
	public String goModifyForm(String boardseq,Model model) {
//		if(session.getAttribute("loginId")==null) {
//			return "login";
//		}
		Board board = dao.innerSelect(boardseq);
		model.addAttribute("board",board);
		ArrayList<BoardFile> bfList = dao.selectBoardFile(boardseq);
		model.addAttribute("bfList",bfList);
		return "modifyForm";
	}
	@RequestMapping(value="modifyBoard",method=RequestMethod.POST)
	public String modifyBoard(Board b,Model model,MultipartHttpServletRequest rq, String[] orgName,String[] boardfileseq) {
//		if(session.getAttribute("loginId")==null) {
//			return "login";
//		}
		if (orgName != null) {
			if (orgName.length != 0) {
				for (int i = 0; i < orgName.length; i++) {
					if (orgName[i].equals("")) {
						dao.deleteOneBoardFile(boardfileseq[i]);
					}
				}
			}
		}
		for(MultipartFile file : rq.getFiles("uploadFile")) {
			String orgName2 = file.getOriginalFilename();
			long now = System.currentTimeMillis();
			String dbName = now+orgName2;
			BoardFile bf = new BoardFile();
			bf.setDbName(dbName);
			bf.setOrgName(orgName2);
			bf.setBoardseq(b.getBoardseq());
			dao.modifyInsertBF(bf);
			
			try {
				file.transferTo(new File(UPLOADPATH + dbName));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		dao.modifyBoard(b);
		Board board = dao.innerSelect(b.getBoardseq());
		model.addAttribute("board", board);
		ArrayList<Comment> cList = dao.selectCommentList(b.getBoardseq());
		model.addAttribute("cList",cList);
		ArrayList<BoardFile> bfList = dao.selectBoardFile(b.getBoardseq());
		model.addAttribute("bfList", bfList);
		return "innerBoard";
	}
	@RequestMapping(value="deleteBoard",method=RequestMethod.GET)
	public String deleteBoard(String boardseq,Model model) {
		dao.deleteBoard(boardseq);
		dao.deleteBoardFile(boardseq);
		return "redirect:goBoard?page=1";
	}
	@RequestMapping(value="insertComment",method=RequestMethod.POST)
	public String insertComment(String boardseq,Comment c,Model model,HttpSession session) {
//		if(session.getAttribute("loginId")==null) {
//			return "login";
//		}
		if(dao.insertComment(c)!=0) {
			Board b = dao.innerSelect(boardseq);
			model.addAttribute("board", b);
			ArrayList<Comment> cList = dao.selectCommentList(boardseq);
			model.addAttribute("cList",cList);
			ArrayList<BoardFile> bfList = dao.selectBoardFile(boardseq);
			ArrayList<Comment> rcList = dao.selectCommentList(boardseq);
			model.addAttribute("rcList", rcList);
			model.addAttribute("bfList", bfList);
			session.setAttribute("rCom", null);
		}
		return "innerBoard";
	}
	@RequestMapping(value="rCommentOpen",method=RequestMethod.POST)
	public String rCommentOpen(String boardseq,Comment c,Model model,HttpSession session,String commentsseq) {
		session.setAttribute("rCom", 1);
		
		Board b = dao.innerSelect(boardseq);
		model.addAttribute("board", b);
		ArrayList<Comment> cList = dao.selectCommentList(boardseq);
		model.addAttribute("cList",cList);
		ArrayList<Comment> rcList = dao.selectCommentList(boardseq);
		model.addAttribute("rcList", rcList);
		ArrayList<BoardFile> bfList = dao.selectBoardFile(boardseq);
		model.addAttribute("bfList", bfList);
		return "innerBoard";
	}
	@RequestMapping(value="insertRComment",method=RequestMethod.POST)
	public String insertRComment(String boardseq,Comment c,Model model,HttpSession session,String commentsseq) {
//		if(session.getAttribute("loginId")==null) {
//			return "login";
//		}
		c.setParentseq(commentsseq);
		if(dao.insertRComment(c)!=0) {
			Board b = dao.innerSelect(boardseq);
			model.addAttribute("board", b);
			ArrayList<Comment> cList = dao.selectCommentList(boardseq);
			model.addAttribute("cList",cList);
			ArrayList<Comment> rcList = dao.selectCommentList(boardseq);
			model.addAttribute("rcList", rcList);
			session.setAttribute("rCom", null);
			ArrayList<BoardFile> bfList = dao.selectBoardFile(boardseq);
			model.addAttribute("bfList", bfList);
		}
		return "innerBoard";
	}
	
	@RequestMapping(value="deleteComment",method=RequestMethod.GET)
	public String deleteComment(String boardseq,String commentseq,Model model,HttpSession session) {
		dao.deleteComment(commentseq);
		Board board = dao.innerSelect(boardseq);
		ArrayList<Comment> cList = dao.selectCommentList(boardseq);
		model.addAttribute("board",board);
		model.addAttribute("cList",cList);
		dao.deleterComment(commentseq);
		ArrayList<Comment> rcList = dao.selectCommentList(boardseq);
		model.addAttribute("rcList", rcList);
		ArrayList<BoardFile> bfList = dao.selectBoardFile(boardseq);
		model.addAttribute("bfList", bfList);
		session.setAttribute("rCom", null);
		session.setAttribute("mForm",null);
		return "innerBoard";
	}
	@RequestMapping(value="upmodifyForm",method=RequestMethod.GET)
	public String upmodifyForm(String boardseq,String commentseq,Model model,HttpSession session) {
		Board board = dao.innerSelect(boardseq);
		ArrayList<Comment> cList = dao.selectCommentList(boardseq);
		model.addAttribute("board",board);
		model.addAttribute("cList",cList);
		session.setAttribute("mForm", 1);
		ArrayList<Comment> rcList = dao.selectCommentList(boardseq);
		model.addAttribute("rcList", rcList);
		ArrayList<BoardFile> bfList = dao.selectBoardFile(boardseq);
		model.addAttribute("bfList", bfList);
		
		return "innerBoard";
	}
	@RequestMapping(value="modifyComment",method=RequestMethod.GET)
	public String modifyComment(String boardseq,Comment c,Model model,HttpSession session) {
		dao.modifyComment(c);
		Board board = dao.innerSelect(boardseq);
		ArrayList<Comment> cList = dao.selectCommentList(boardseq);
		model.addAttribute("board",board);
		model.addAttribute("cList",cList);
		session.setAttribute("mForm", null);
		ArrayList<Comment> rcList = dao.selectCommentList(boardseq);
		model.addAttribute("rcList", rcList);
		ArrayList<BoardFile> bfList = dao.selectBoardFile(boardseq);
		model.addAttribute("bfList", bfList);
		session.setAttribute("rCom", null);
		return "innerBoard";
	}
	@RequestMapping(value = "fileDownload", method = RequestMethod.GET)
	public void fileDownload(HttpServletResponse response, String downLoadFile,String orgName) { // html로 돌려주는게 아니라 파일을 다운하는 것이므로 리턴값이
																					// 없다. or return null
			response.setHeader("Content-Disposition", "attachment;filename=" + orgName);
		// 다운받아지는 이름
		FileInputStream fis;
		ServletOutputStream sos;
		try {
			fis = new FileInputStream(UPLOADPATH + downLoadFile);
			// 실제로 db에 저장된이름(파일명)
			sos = response.getOutputStream();
			
			FileCopyUtils.copy(fis, sos);

			fis.close();
			sos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

package com.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.board.domain.Board;
import com.board.domain.Users;
import com.board.service.BoardService;


@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService; 

	// 글 등록 페이지 이동
	@GetMapping("/insertBoardView")
	public String insertBoardView() {
		return "insertBoard";
	}
	
	// 글 등록
	@PostMapping("/insertBoard")
	public String insertBoard(Board board, Model model) throws Exception {
		boardService.insertBoard(board);
		model.addAttribute("boardList", boardService.findAllByWriter(board.getWriter()));
		return "getBoardList";
	}
	
	// 글 수정
	@PostMapping("/updateBoard")
	public String updateBoard(Board board, Model model){
		boardService.updateBoard(board);
		model.addAttribute("boardList", boardService.findAllByWriter(board.getWriter()));
		return "getBoardList";
	}
	
	// 글 삭제
	@PostMapping("/deleteBoard")
	public String deleteBoard(Board board) {
		boardService.deleteBoard(board);
		return "forward:getBoardList";
	}
	
	// 사용자 별 글 목록 조회
	@RequestMapping("/getBoardList")
	public String getBoardList(Users user, Model model) {
		model.addAttribute("boardList", boardService.findAllByWriter(user.getId()));
		return "getBoardList";
	}
	
	// 사용자 별 글 목록 조회 (Back)
	@RequestMapping("/getBoardListByWriter")
	public String getBoardList(String writer, Model model) {
		model.addAttribute("boardList", boardService.findAllByWriter(writer));
		return "getBoardList";
	}
	
	// 글 상세 조회
	@GetMapping("/getBoard")
	public String getBoard(Board board, Model model) {
		model.addAttribute("board", boardService.getBoard(board));
		return "getBoard";
	}
	
}

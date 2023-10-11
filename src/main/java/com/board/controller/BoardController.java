package com.board.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.board.domain.Board;
import com.board.domain.Users;
import com.board.service.BoardService;


@Controller
@SessionAttributes("board")
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
	public String insertBoard(Board board) throws Exception {
		boardService.insertBoard(board);
		// 리턴되는 View이름 앞에 "forward:"이나 "redirect:"을 붙이면 ViewResovler가 동작하지 않는다.
		return "redirect:getBoardList";
	}
	
	// 글 수정
	@PostMapping("/updateBoard")
	public String updateBoard(Board board){
		boardService.updateBoard(board);
		return "redirect:getBoardList";
	}
	
	// 글 삭제
	@PostMapping("/deleteBoard")
	public String deleteBoard(Board board) {
		boardService.deleteBoard(board);
		return "forward:getBoardList";
	}
	
	// 글 목록 조회
	@RequestMapping("/getBoardList")
	public String getBoardList(Users user, Model model) {
		model.addAttribute("boardList", boardService.findAllByWriter(user.getId()));
		return "getBoardList";
	}
	
	// 글 상세 조회
	@GetMapping("/getBoard")
	public String getBoard(Board board, Model model) {
		model.addAttribute("board", boardService.getBoard(board));
		return "getBoard";
	}
	
}

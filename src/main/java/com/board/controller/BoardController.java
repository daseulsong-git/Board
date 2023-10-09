package com.board.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import com.board.domain.Board;
import com.board.service.BoardService;


@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService; 

	// 글 등록
	public String insertBoard(Board board, @RequestBody MultipartFile uploadFile) throws Exception {
		boardService.insertBoard(board);
		// 리턴되는 View이름 앞에 "forward:"이나 "redirect:"을 붙이면 ViewResovler가 동작하지 않는다.
		return "redirect:getBoardList";
	}
	// 글 수정
	// 글 삭제
	// 글 목록 조회
	// 글 상세 조회
	
	
}

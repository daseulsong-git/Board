package com.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.board.domain.Board;
import com.board.persistence.BoardRepository;

public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardRepository boardRepository;
	
	// 글 등록
	public void insertBoard(Board board) {
		boardRepository.save(board);
	};
	
	// 글 수정
	public void updateBoard(Board board) {
		boardRepository.save(board);
	};
	
	// 글 삭제
	public void deleteBoard(Board board) {
		boardRepository.delete(board);
	};
	
	// 글 목록 조회
	public List<Board> getBoardList(Board board){
		return boardRepository.findAll();
	};
	
	// 글 상세 조회
	public Board getBoard(Board board) {
		return boardRepository.findById(board.getSeq()).get();
	};
}

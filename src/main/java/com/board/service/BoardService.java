package com.board.service;

import java.util.List;

import com.board.domain.Board;

public interface BoardService {
	
	// 글 등록
	void insertBoard(Board board);
	
	// 글 수정
	void updateBoard(Board board);
	
	// 글 삭제
	void deleteById(Integer seq);
	
	// 사용자 별 글 목록 조회
	List<Board> findAllByWriter(String writer);
	
	// 글 상세 조회
	Board getBoard(Board board);
	
	// 게시글 카운드
	void updateCount(Integer seq);
}

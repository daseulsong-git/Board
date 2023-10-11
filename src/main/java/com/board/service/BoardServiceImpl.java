package com.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.domain.Board;
import com.board.persistence.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardRepository boardRepository;
	
	// 글 등록
	public void insertBoard(Board board) {
		boardRepository.save(board);
	}
	
	// 글 수정
	public void updateBoard(Board board) {
		boardRepository.save(board);
	}
	
	// 글 삭제
	public void deleteBoard(Board board) {
		boardRepository.delete(board);
	}
	
	// 사용자 별 글 목록 조회
	public List<Board> findAllByWriter(String writer){
		return boardRepository.findAllByWriter(writer);
	}
	
	// 글 상세 조회
	public Board getBoard(Board board) {
		return boardRepository.findById(board.getSeq()).get();
	}

}

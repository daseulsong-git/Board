package com.board.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.board.domain.Board;

import jakarta.transaction.Transactional;


public interface BoardRepository extends JpaRepository<Board, Integer> {

	List<Board> findAllByWriter(String writer);
	
	@Transactional
	@Modifying
	@Query("update Board b set b.cnt = b.cnt + 1 where b.seq = :seq")
	void updateCount(Integer seq);

}

package com.board.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import com.board.domain.Board;


public interface BoardRepository extends JpaRepository<Board, Integer> {

}

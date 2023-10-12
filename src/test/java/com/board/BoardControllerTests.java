package com.board;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.board.domain.Board;
import com.board.service.BoardService;
import com.board.service.UserService;

@WebMvcTest
class BoardControllerTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	BoardService boardService;
	
	@MockBean
	UserService userService;

	@DisplayName("게시글 등록")
	@Test
	void testInsertBoard() {
		fail("Not yet implemented");
	}
	
	@DisplayName("게시글 수정")
	@Test
	void testUpdateBoard() {
		fail("Not yet implemented");
	}
	
	@DisplayName("게시글 삭제")
	@Test
	void testDeleteBoard() {
		fail("Not yet implemented");
	}

	@DisplayName("Id로 게시글 목록 조회")
	@Test
	void testGetBoardListUsersModel() {
		fail("Not yet implemented");
	}
	
	@Disabled("우선 사용X")
	@DisplayName("Writer로 게시글 목록 조회")
	@Test
	void testGetBoardListStringModel() {
		fail("Not yet implemented");
	}

	@DisplayName("게시글 상세 조회")
	@Test
	void testGetBoard() {
		fail("Not yet implemented");
	}

}

package com.board;

import static org.assertj.core.api.Assertions.assertThat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.Transactional;

import com.board.domain.Board;
import com.board.domain.Users;
import com.board.service.BoardService;
import com.board.service.UserService;

@SpringBootTest(properties = {"user.id=TEST", 
        "user.name=테스터", 
        "user.password=1234",
        "user.role=ADMIN",
        "board.title=TEST_TITLE",
        "board.content=TEST_CONTENT",
        "board.writer=TEST"})

@AutoConfigureMockMvc
@Transactional
class BoardApplicationTests {
	
	@Autowired
	BoardService boardService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	private Environment env;
	
	@Test
	void 회원가입_로그인(){
		
		System.out.println("회원가입_로그인");
		
		//given
		Users user = new Users();
		user.setId(env.getProperty("user.id"));
		user.setName(env.getProperty("user.name"));
		user.setPassword(env.getProperty("user.password"));
		user.setRole(env.getProperty("user.role"));
		 
		//when
		userService.signUp(user);
		Users login_user = userService.getUser(user);
		
		//then
		assertThat(login_user)
		.isNotNull()
		.isEqualTo(user);
	
	}

	@Test
	void 게시글등록_상세조회() {
		
		System.out.println("게시글등록_상세조회");
		
		//given
		String dateStr = "2023-10-13 16:28:00";
        SimpleDateFormat dateTemp = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        Date date = null;
		try {
			date = dateTemp.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
        
		Board board = new Board();
		board.setTitle(env.getProperty("board.title"));
		board.setContent(env.getProperty("board.content"));
		board.setRegDate(date);
		board.setWriter(env.getProperty("board.writer"));
		board.setCnt(0);
		
		//when
		boardService.insertBoard(board);
		Board insert_board = boardService.getBoard(board);
		
		//then
		assertThat(insert_board).isNotNull();
		assertThat(insert_board.getWriter()).isEqualTo(env.getProperty("board.writer"));
		assertThat(insert_board.getContent()).isEqualTo(env.getProperty("board.content"));
		
	}
	
	@Test
	void 게시글수정() {
		
	}
	
	@Test
	void 게시글삭제() {
		System.out.println("게시글삭제");	
	}
	
	@Test
	void 게시글전체조회() {
		
		//given
		Integer num = 5;
		Integer cnt = 0;
		
		String dateStr = "2023-10-13 16:28:00";
        SimpleDateFormat dateTemp = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        Date date = null;
		try {
			date = dateTemp.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		List<Board> boardList = new ArrayList<Board>();
		Board board = new Board();
        for(int i=0; i<num; i++) {
        	board = new Board();
        	board.setTitle(env.getProperty("board.title")+i);
        	board.setContent(env.getProperty("board.content")+i);
        	board.setRegDate(date);
        	board.setWriter(env.getProperty("board.writer"));
        	board.setCnt(0);
        	boardList.add(board);
        	boardService.insertBoard(board);
        }

		//when
		List<Board> getBoardList = boardService.findAllByWriter(env.getProperty("board.writer"));
		
		//then
		assertThat(boardList).isNotNull();
		assertThat(boardList.size()).isEqualTo(num);
		
		for(Board tempBoard : getBoardList) {
			assertThat(tempBoard.getTitle()).isEqualTo(boardList.get(cnt).getTitle());
			System.out.println(boardList.get(cnt));
			cnt ++;
        }
	}

	

}

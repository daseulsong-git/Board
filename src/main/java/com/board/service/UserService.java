package com.board.service;

import com.board.domain.Users;

public interface UserService {
	
	// 회원 등록
	void makeUser(Users user);
	// 로그인
	Users getUser(Users user);
	
}

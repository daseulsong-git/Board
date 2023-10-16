package com.board.service;

import java.util.List;

import com.board.domain.Users;

public interface UserService {
	
	// 회원 등록
	void signUp(Users user);

	Users getUser(Users user);
	
	String validateDuplicateUser(Users user);
	
}

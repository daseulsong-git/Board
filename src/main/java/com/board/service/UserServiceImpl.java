package com.board.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.domain.Users;
import com.board.persistence.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	// 회원 등록
	public void makeUser(Users user) {
		userRepository.save(user);
	}
	
	// 로그인
	public Users getUser(Users user) {
		Optional<Users> findUser = userRepository.findById(user.getId());
		if(findUser.isPresent()) {
			return findUser.get();
		} 
		return null;
	}
	}


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
	public void signUp(Users user) {
		validateDuplicateUser(user); //중복 회원 확인
		userRepository.save(user);
	}
	
	// ID 중복 체크 (회원등록용)
	private void validateDuplicateUser(Users user) {
        Optional<Users> findUser = userRepository.findById(user.getId());
        if (!findUser.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }
	
	// 회원 정보 체크 (로그인용)
	public Users getUser(Users user) {
		Optional<Users> findUser = userRepository.findById(user.getId());
		if(findUser.isPresent()) {
			return findUser.get();
		} 
		return null;
	}
}


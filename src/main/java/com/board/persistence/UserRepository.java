package com.board.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.board.domain.Users;

public interface UserRepository extends JpaRepository<Users, String>{

}

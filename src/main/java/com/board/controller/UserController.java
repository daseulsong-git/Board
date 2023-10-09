package com.board.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.board.domain.Users;
import com.board.persistence.UserRepository;
import com.board.service.UserService;

@Controller
@SessionAttributes("user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/loginView")
	public String loginView() {
		return "login";
	}
	
	@GetMapping("/signUpView")
	public String signUpView() {
		return "signUp";
	}
	
	@PostMapping("/login")
	public String login(Users user, Model model) {
		Users findUser = userService.getUser(user);
		if(findUser != null && findUser.getPassword().equals(user.getPassword())) {
			model.addAttribute("user", findUser);
			return "forward:getBoardList";
		} 
		return "redirect:loginView";		
	}


	
	@GetMapping("/logout")
	public String logout(SessionStatus status) {
		status.setComplete();
		return "redirect:/";
	}
}

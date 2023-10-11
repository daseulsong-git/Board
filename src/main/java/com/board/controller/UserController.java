package com.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.board.domain.Users;
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
	
	@GetMapping("/signUpView")
	public String signUpView() {
		return "signUp";
	}
	
	@PostMapping("/signUp")
	public String signUp(Users user) {
		userService.signUp(user);
		return "redirect:loginView";
	}
}

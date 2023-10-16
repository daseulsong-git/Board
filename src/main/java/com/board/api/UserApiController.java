package com.board.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.board.domain.Users;
import com.board.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserApiController {
	
	private final UserService userService;
	
	// 회원가입
	@PostMapping("/api/signUp")
	public CreateUserResponse signUp(@RequestBody CreateUserRequest request) {
		
		Users user = new Users();
		user.setId(request.getId());
		user.setName(request.getName());
		user.setPassword(request.getPassword());
		user.setRole(request.getRole());
		
		userService.signUp(user);
		
		return new CreateUserResponse(request.getId());
	}
	
	@Data
	@AllArgsConstructor
	static class CreateUserRequest{
		private String id;
		private String name;
		private String password;
		private String role;
	}

	@Data
	static class CreateUserResponse{
		
		private String id;
		
		public CreateUserResponse(String id) {
            this.id = id;
        }
	}
}

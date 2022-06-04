package com.mng.mycoin.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mng.mycoin.domain.User;
import com.mng.mycoin.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	
	@PostMapping("/getUsers")
	public List<User> getAllUsers() {
		return userService.findUsers();
	}
	
	@PostMapping("/getUserById")
	public Optional<User> getUserByUserId(String userId) {
		return userService.findOneUser(userId);
	}
	
	@PostMapping("/join")
	public User insertUser() {
		User user = new User(1L,"현");
		return userService.joinUser(user);
	}
	
	@PostMapping("/updateUser")
	public void updateUser() {
		User user = new User(100L,"현");
		userService.updateUser(user);
	}
	
	@PostMapping("/deleteUser")
	public void deleteUser(Long userSeq) {
		userService.deleteUser(userSeq);
	}
	
}
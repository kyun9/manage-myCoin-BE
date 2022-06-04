package com.mng.mycoin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
		return userService.getAllUsers();
	}
	
	@PostMapping("/getUserById")
	public User getUserByUserId(Long userId) {
		return userService.getUserByUserId(userId);
	}
	
	@PostMapping("/insertUser")
	public User insertUser() {
		User user = new User();
		return userService.insertUser(user);
	}
	
	@PostMapping("/updateUser")
	public void updateUser(String userId) {
		userService.updateUser(userId);
	}
	
	@PostMapping("/deleteUser")
	public void deleteUser(String userId) {
		userService.deleteUser(userId);
	}
	
}
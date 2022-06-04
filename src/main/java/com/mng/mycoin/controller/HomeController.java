package com.mng.mycoin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mng.mycoin.domain.User;
import com.mng.mycoin.service.UserService;

@RestController
@RequestMapping("/")
public class HomeController {
	private final UserService userService;
	
	@Autowired
	public HomeController(UserService userService) {
		this.userService = userService;
	}
	
	
	@PostMapping("")
	public User home() {
		User member =  new User(1L, "현");
		
		return member;
	}
}
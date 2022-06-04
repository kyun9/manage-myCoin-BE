package com.mng.mycoin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.mng.mycoin.repository.UserRepository;
import com.mng.mycoin.service.UserService;

public class IUserService implements UserService {
	private final UserRepository userRepository;
	
	@Autowired
	public IUserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
}

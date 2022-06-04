package com.mng.mycoin.service;

import java.util.List;
import java.util.Optional;

import com.mng.mycoin.domain.User;

public interface UserService {
	List<User> findUsers();
	
	Optional<User> findOneUser(String userId);
	
	User joinUser(User user);
	
	void updateUser(User user);
	
	void deleteUser(Long userId);
}

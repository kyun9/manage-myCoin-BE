package com.mng.mycoin.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.mng.mycoin.domain.User;
import com.mng.mycoin.repository.UserRepository;

public class IUserRepository implements UserRepository{
	// DB연결전 임시 데이터 ====================================
	public static List<User> users;
	
	static {
		users = new ArrayList<>();
		users.add(new User(100L, "kim1"));
		users.add(new User(200L, "kim2"));
		users.add(new User(300L, "kim3"));
		users.add(new User(400L, "kim4"));
		users.add(new User(500L, "kim5"));
		users.add(new User(600L, "kim6"));
	}
	// ====================================================

	@Override
	public List<User> getAllUsers(){
		System.out.println("사용자 전체보기");
		return users;
	}
	
	@Override
	public Optional<User> getUserByUserId(Long userId) {
		System.out.println("사용자 상세보기");
		
		return Optional.ofNullable(users.stream()
									.filter(user -> user.getUserId() == userId)
									.findAny()
									.orElse(new User(0L, "no User")));
	}
	
	@Override
	public Optional<User> insertUser(User user) {
		System.out.println("사용자 등록");
		
		users.add(user);
		return Optional.ofNullable(user);
	}
	
	@Override
	public void updateUser(User user) {
		System.out.println("사용자 수정");
		
		users.stream()
						.filter(item -> item.getUserId() == user.getUserId())
						.findAny()
						.orElse(new User(0L, "no User"))
						.setUserName(user.getUserName());
	}
	
	@Override
	public void deleteUser(Long userId) {
		System.out.println("사용자 삭제");
		
		users.removeIf(user -> user.getUserId() == userId);
	}
	
}
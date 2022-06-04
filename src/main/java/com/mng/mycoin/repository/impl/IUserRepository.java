package com.mng.mycoin.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.mng.mycoin.domain.User;
import com.mng.mycoin.repository.UserRepository;

@Repository
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
	public List<User> findAllUsers(){
		System.out.println("사용자 전체보기");
		return users;
	}
	
	@Override
	public Optional<User> findByUserId(String userId) {
		System.out.println("사용자 아이디 상세보기");
		
		return Optional.ofNullable(users.stream()
									.filter(user -> user.getUserId() == userId)
									.findAny()
									.orElse(new User(0L, "no User")));
	}
	
	@Override
	public Optional<User> findByUserSeq(Long userSeq) {
		System.out.println("사용자 시퀀스 상세보기");
		
		return Optional.ofNullable(users.stream()
				.filter(user -> user.getUserSeq() == userSeq)
				.findAny()
				.orElse(new User(0L, "no User")));
	}
	
	@Override
	public User saveUser(User user) {
		System.out.println("사용자 등록");
		
		users.add(user);
		return user;
	}
	
	@Override
	public void updateUser(User user) {
		System.out.println("사용자 수정");
		
		users.stream()
						.filter(item -> item.getUserId() == user.getUserId())
						.findAny()
						.orElse(new User(0L, "no User"))
						.setUserId(user.getUserId());
	}
	
	@Override
	public void deleteUser(Long userSeq) {
		System.out.println("사용자 삭제");
		
		users.removeIf(user -> user.getUserSeq() == userSeq);
	}



	
}
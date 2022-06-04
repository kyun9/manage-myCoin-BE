package com.mng.mycoin.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.mng.mycoin.domain.User;

@Repository
public interface UserRepository {
	
	/* 사용자 전체보기  */
	List<User> getAllUsers();
	
	/* 사용자 상세보기  */
	 Optional<User> getUserByUserId(Long userId);
	 
	 /* 사용자 등록  */
	 Optional<User> insertUser(User user);
	 
	 /* 사용자 수정  */
	 void updateUser(User user);
	 
	 /* 사용자 삭제  */
	 void deleteUser(Long userId);
	 
}

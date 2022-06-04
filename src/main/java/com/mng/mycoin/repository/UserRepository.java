package com.mng.mycoin.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.mng.mycoin.domain.User;

public interface UserRepository {
	
	/* 사용자 전체보기  */
	List<User> findAllUsers();
	
	/* 사용자 상세보기  */
	 Optional<User> findByUserId(String userId);
	 
	 /* 사용자 시퀀스  */
	 Optional<User> findByUserSeq(Long userSeq);
	 
	 /* 사용자 등록  */
	 User saveUser(User user);
	 
	 /* 사용자 수정  */
	 void updateUser(User user);
	 
	 /* 사용자 삭제  */
	 void deleteUser(Long userSeq);
	 
}

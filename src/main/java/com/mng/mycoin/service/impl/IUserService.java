package com.mng.mycoin.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mng.mycoin.domain.User;
import com.mng.mycoin.repository.UserRepository;
import com.mng.mycoin.service.UserService;

@Service
public class IUserService implements UserService {
	private final UserRepository userRepository;
	
	@Autowired
	public IUserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<User> findUsers() {
		return userRepository.findAllUsers();
	}

	@Override
	public Optional<User> findOneUser(String userId) {
		return userRepository.findByUserId(userId);
	}

	@Override
	public User joinUser(User user) {
		validateDuplicateMember(user); // 중복 회원 검증
		return userRepository.saveUser(user);
	}
	
	private void validateDuplicateMember(User user) {
		// ifPresent : 만일 값이 있으면 (Optional)
		// orElseGet : 많이 값이 있으면 꺼내고, 없으면 메소드 및 default값을 실행해
		userRepository.findByUserSeq(user.getUserSeq()).ifPresent(m -> {
			throw new IllegalStateException("이미 존재하는 회원입니다.");
		});
	}
	

	@Override
	public void updateUser(User user) {
		userRepository.updateUser(user);
	}

	@Override
	public void deleteUser(Long userSeq) {
		userRepository.deleteUser(userSeq);
	}
	
}

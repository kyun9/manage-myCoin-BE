package com.mng.mycoin.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mng.mycoin.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserRepositoryTest {
	@Autowired
	private UserRepository userRepository;

	@Test
	public void 전부조회() {
		List<User> users = userRepository.findAllUsers();
		assertEquals(3, users.size());
	}

	// other methods
	@Test
	public void id로조회() {
		User user = userRepository.findByUserId("kim1").get();
		assertTrue(user.getUserId().contains("kim"));
	}
}
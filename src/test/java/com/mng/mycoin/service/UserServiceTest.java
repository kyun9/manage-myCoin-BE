package com.mng.mycoin.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mng.mycoin.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceTest {
	@Autowired
	private UserService userSevice;

	@Test
	public void 회원등록() {
		User user = new User(999L ,"gus");
		
		User saveUser = userSevice.joinUser(user);
		
		assertEquals("gus", saveUser.getUserId());
	}

}
package com.mng.mycoin.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mng.mycoin.domain.Member;

@RestController
public class HomeController {
	
	@PostMapping("/")
	public Member home() {
		Member member =  new Member();

		member.setId((long) 1);
		member.setName("현");
		
		return member;
	}
}
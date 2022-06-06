package com.mng.mycoin.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mng.mycoin.service.SecurityService;

@RestController
@RequestMapping("/")
public class HomeController {
	private final SecurityService securityService;

	@Autowired
	public HomeController(SecurityService securityService) {
		this.securityService = securityService;
	}

	@GetMapping("/security/generate/token")
	public Map<String, Object> generateToken(@RequestParam(value = "subject") String subject) {
		String token = securityService.createToken(subject, (2 * 1000 * 60));
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("usrId", subject);
		map.put("result", token); 
		return map;
	}

	@ResponseBody
	@GetMapping("/security/get/subject")
	public Map<String, Object> getSubject(@RequestParam("token") String token) {
		String subject = securityService.getSubject(token);
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("result", subject);
		return map;
	}
}
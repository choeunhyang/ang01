package com.ang.back.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ang.back.HomeController;
import com.ang.back.config.JWTFactory;
import com.ang.back.service.AngUserService;
import com.ang.back.vo.UserVO;

@RestController
public class AngUserController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private AngUserService aus;
	
	private JWTFactory jf = new JWTFactory();
	
	@PostMapping("/api/login")
	public UserVO login (@RequestBody UserVO log,HttpSession session) {
		logger.info("session id=>{}",session.getId());
		UserVO au = aus.login(log);
		if(au!=null) {
			String token = jf.generateJWT(log.getId());
			au.setToken(token);
		}
		return au;
	}
	
	@GetMapping("/api/user")
	public List<UserVO> userList(@RequestBody UserVO us) {
		return aus.userList(us);
	}
}

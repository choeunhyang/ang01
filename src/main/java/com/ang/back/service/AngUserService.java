package com.ang.back.service;

import java.util.List;

import com.ang.back.vo.UserVO;

public interface AngUserService {
	public UserVO login (UserVO log);
	public List<UserVO> userList (UserVO us);
}

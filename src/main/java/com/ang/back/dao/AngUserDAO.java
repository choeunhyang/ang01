package com.ang.back.dao;

import java.util.List;

import com.ang.back.vo.UserVO;

public interface AngUserDAO {
	public UserVO login (UserVO log);
	public List<UserVO> userList (UserVO us);
}

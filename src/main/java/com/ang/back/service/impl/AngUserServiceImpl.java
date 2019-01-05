package com.ang.back.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ang.back.dao.AngUserDAO;
import com.ang.back.service.AngUserService;
import com.ang.back.vo.UserVO;

@Service
public class AngUserServiceImpl implements AngUserService{

	@Autowired
	private AngUserDAO audao;
	
	@Override
	public UserVO login(UserVO log) {
		/*UserVO uv = audao.login(log);
		if(log.getId()==null) {
			return null;
		}
		if(log.getPwd().equals(uv.getPwd())) {
			return uv;
		}
		return null;*/
		return audao.login(log);
	}

	@Override
	public List<UserVO> userList(UserVO us) {
		return audao.userList(us);
	}
}

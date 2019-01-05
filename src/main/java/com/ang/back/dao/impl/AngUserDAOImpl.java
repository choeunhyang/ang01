package com.ang.back.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ang.back.dao.AngUserDAO;
import com.ang.back.vo.UserVO;

@Repository
public class AngUserDAOImpl implements AngUserDAO {

	@Autowired
	private SqlSession ss;
	
	@Override
	public UserVO login(UserVO log) {
		return ss.selectOne("com.ang.back.ANGUSER.AngUser",log);
	}

	@Override
	public List<UserVO> userList(UserVO us) {
		return ss.selectList("com.ang.back.ANGUSER.userList",us);
	}

}

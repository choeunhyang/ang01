package com.ang.back.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ang.back.dao.AngBoardDAO;
import com.ang.back.vo.AngBoard;

@Repository
public class AngBoardDAOImpl implements AngBoardDAO {

	@Autowired
	private SqlSession ss;
	
	@Override
	public List<AngBoard> angBoardlist(AngBoard ab) {
		return ss.selectList("com.ang.back.ANGBOARD.angboardlist",ab);
	}

	@Override
	public int insertAng(AngBoard ab) {
		return ss.insert("com.ang.back.ANGBOARD.insertang",ab);
	}

	@Override
	public AngBoard selectang(Integer abnum) {
		return ss.selectOne("com.ang.back.ANGBOARD.selectang",abnum);
	}

	@Override
	public Integer deleteAng(List<Integer> abnum) {
		return ss.delete("com.ang.back.ANGBOARD.deleteang", abnum);
	}

}

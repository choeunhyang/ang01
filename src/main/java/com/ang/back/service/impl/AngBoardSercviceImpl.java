package com.ang.back.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ang.back.dao.AngBoardDAO;
import com.ang.back.service.AngBoardService;
import com.ang.back.vo.AngBoard;

@Service
public class AngBoardSercviceImpl implements AngBoardService {

	@Autowired
	private AngBoardDAO abdao;
	
	@Override
	public List<AngBoard> angBoardlist(AngBoard ab) {
		return abdao.angBoardlist(ab);
	}

	@Override
	public int insertang(AngBoard ab) {
		return abdao.insertAng(ab);
	}

	@Override
	public AngBoard selectang(Integer abnum) {
		return abdao.selectang(abnum);
	}

	@Override
	public Integer deleteAng(List<Integer> abnum) {
		return abdao.deleteAng(abnum);
	}

}

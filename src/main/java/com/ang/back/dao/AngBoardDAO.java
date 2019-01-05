package com.ang.back.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ang.back.vo.AngBoard;

public interface AngBoardDAO {
	public List<AngBoard> angBoardlist(AngBoard ab);
	public AngBoard selectang(Integer abnum);
	public int insertAng(AngBoard ab);
	public Integer deleteAng(List<Integer> abnum);
}

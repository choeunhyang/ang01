package com.ang.back.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ang.back.vo.AngBoard;

public interface AngBoardService {
	public List<AngBoard> angBoardlist(AngBoard ab);
	public AngBoard selectang(Integer abnum);
	public int insertang(AngBoard ab);
	public Integer deleteAng(List<Integer> abnum);
}

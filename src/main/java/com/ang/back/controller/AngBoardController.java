package com.ang.back.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ang.back.HomeController;
import com.ang.back.service.AngBoardService;
import com.ang.back.vo.AngBoard;

import lombok.Delegate;

@RestController
public class AngBoardController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private AngBoardService abs;

	@GetMapping(value = "/api/angboard")
	public List<AngBoard> angboardlist(@ModelAttribute AngBoard ab) {
		logger.info("params=>{}", ab);
		return abs.angBoardlist(ab);
	}

	@GetMapping(value = "/api/angboard/{num}")
	public AngBoard selectAng(@ModelAttribute Integer abnum) {
		return abs.selectang(abnum);
	}

	@PostMapping(value = "/api/angboard")
	public Map<String, String> insertang(@RequestBody AngBoard ab, HttpSession session) {
		int result = abs.insertang(ab);
		Map<String, String> map = new HashMap<>();
		map.put("msg", "성공");
		if (result != 1) {
			map.put("msg", "실패");
		}
		return map;
	}

	@DeleteMapping("/api/angboards")
	public Integer deleteAngBoards(@RequestBody List<Integer> abnum) {
		System.out.println("왜 안되나요" + abnum);
		return abs.deleteAng(abnum);
	}

}

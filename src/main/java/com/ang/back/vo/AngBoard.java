package com.ang.back.vo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class AngBoard {
	private Integer num;
	private String title;
	private String content;
	private String wdate;
	private Integer writer;
	private Integer cnt;
}

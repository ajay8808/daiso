package com.daiso.service;

import java.util.Map;

import com.daiso.vo.ReviewVO;


public interface ReviewService {
	void select(Map map);
	void create(ReviewVO reviewVO);
	void delete(int r_num);
}

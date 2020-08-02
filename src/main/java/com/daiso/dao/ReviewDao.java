package com.daiso.dao;

import java.util.Map;

import com.daiso.vo.BoardVO;
import com.daiso.vo.ReviewVO;

public interface ReviewDao {
	void create(ReviewVO review);

	void read(Map map);
	
	void readAll(Map map);
	
	void update(ReviewVO review);
	
	void delete(int r_num);
	
}

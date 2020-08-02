package com.daiso.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daiso.dao.ReviewDao;
import com.daiso.vo.ReviewVO;
@Service("reviewService")
public class ReviewServiceImpl implements ReviewService {
	@Autowired
	private ReviewDao reviewDao;

	@Override
	public void select(Map map) {
		this.reviewDao.read(map);
		
	}

	@Override
	public void create(ReviewVO review) {
		// TODO Auto-generated method stub
		this.reviewDao.create(review);
	}

	@Override
	public void delete(int r_num) {
		this.reviewDao.delete(r_num);
		
	}

	
}

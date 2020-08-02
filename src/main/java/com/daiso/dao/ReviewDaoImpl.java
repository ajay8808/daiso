package com.daiso.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daiso.vo.ReviewVO;
@Repository("reviewDao")
public class ReviewDaoImpl implements ReviewDao{

	@Autowired
	private SqlSession sqlsession;
	@Override
	public void create(ReviewVO review) {
		this.sqlsession.insert("ReviewInsert" ,review);
		
	}

	@Override
	public void read(Map map) {
		List<Object> list =  this.sqlsession.selectList("replySelectAll", map);
		map.put("replyResult",list);
	}
	
	@Override
	public void readAll(Map map) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(ReviewVO review) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int r_num) {
		this.sqlsession.delete("delReview", r_num);
		
	}

}

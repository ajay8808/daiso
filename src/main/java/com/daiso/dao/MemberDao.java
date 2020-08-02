package com.daiso.dao;

import java.util.Map;

import com.daiso.vo.MemberVO;

public interface MemberDao {
	
	int create(MemberVO member);
	

	MemberVO getUserByUserid(String username);
	 
	//void create(MemberVO member);

	//void read(Map map);

//	void readAll(Map map);

//	void update(MemberVO member);

//	void delete(String memail);
}

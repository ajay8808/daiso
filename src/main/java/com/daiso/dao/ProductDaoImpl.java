package com.daiso.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daiso.vo.ProductVO;


@Repository("productDao")
public class ProductDaoImpl implements ProductDao{
	@Autowired
	private SqlSession sqlsession;
	@Override
	public int readId(String name) {
		return this.sqlsession.selectOne("selectString", name);
	}

	@Override
	public String readSrc(int id) {
		return this.sqlsession.selectOne("selectSrc",id);
	}

	@Override
	public ProductVO read(int id) {
		return this.sqlsession.selectOne("selectRead" ,id);
	}
}

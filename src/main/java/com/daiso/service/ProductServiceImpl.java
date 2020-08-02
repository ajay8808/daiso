package com.daiso.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daiso.dao.ProductDao;
import com.daiso.vo.ProductVO;


@Service("productService")
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDao productDao;

	
	
	@Override
	public ProductVO selectProduct(int id) {
		return this.productDao.read(id);
	}



	@Override
	public String selectProductSrc(int id) {
	return	this.productDao.readSrc(id);
	}



	@Override
	public int selectProductId(String name) {
		return this.productDao.readId(name);
	}

	
}

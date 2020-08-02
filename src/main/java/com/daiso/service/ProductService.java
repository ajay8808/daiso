package com.daiso.service;

import java.util.Map;

import com.daiso.vo.BoardVO;
import com.daiso.vo.ProductVO;

public interface ProductService {
	ProductVO selectProduct(int id);

	int selectProductId(String name);

	String selectProductSrc(int id);
	
}

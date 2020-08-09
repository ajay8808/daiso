package com.daiso.dao;

import java.util.Map;

import org.springframework.ui.Model;

import com.daiso.vo.BoardVO;
import com.daiso.vo.PagenationVO;

public interface BoardDao {
	void create(BoardVO board);
	void read(Map map);
	void readAll(Map map);
	void update(BoardVO board);
	void delete(int b_num);
	int prevnext(int num);
//	void List<BoardVO> void selectBoardList(PagenationVO page);
//
//	public int selectBoardTotalCount(Criteria criteria);
}

package com.daiso.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.daiso.vo.BoardVO;
import com.mapper.mapper.BoardMapper;


@Repository("boardDao")
public class BoardDaoImpl implements BoardDao {
	@Autowired
	private SqlSession sqlSession;
	@Autowired
	BoardMapper boardMapper;
	@Override
	public void create(BoardVO board) {
	//this.sqlSession.insert("boardInsert" ,board);
		boardMapper.insertBoard(board);
	}
	
	@Override
	public void read (Map map) {
//		List<Object> list = this.sqlSession.selectList("boardSelectOne", map );
//		System.out.println(list);
//		map.put("selectResult" , list);
		
		Map<String, Object> mapping =   (Map<String, Object>) this.sqlSession.selectOne("boardSelectOne" ,map);
		//("boardSelectOne" ,map).get(0);
		//System.out.println(mapping);
		map.put("selectResult", mapping); 		
	}

	@Override
	public void readAll(Map map) {
		
		List<Object> list = this.sqlSession.selectList("selectAll",map);
		//System.out.println(list); 
		map.put("results", list); //맵에 results 키에 list값넣어줌
	}

	@Override
	public void update(BoardVO board) {
//		this.sqlSession.update("boardUpdate", board);
		boardMapper.updateBoard(board);
	}

	@Override
	public void delete(int b_num) {
		this.sqlSession.delete("boardDel", b_num);

	}

	@Override
	public int prevnext(int num) {
		// TODO Auto-generated method stub
		return boardMapper.prevnext(num);
	}


}

package com.daiso.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.daiso.service.ReviewService;
import com.daiso.vo.ReviewVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ReviewController {
	@Autowired
	private ReviewService reviewService;
	
	
	@RequestMapping(value="/reply", method=RequestMethod.POST)
	public Map replyInsert(@RequestBody ReviewVO reviewVO) {
	String m_userid = reviewVO.getM_userid();
//		String r_comment = reviewVO.getR_comment();
	reviewVO.setM_userid(m_userid);
		//reviewVO.setR_comment(r_comment);
		this.reviewService.create(reviewVO);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", "success");
		return map;
	}
	
//	private String convert(String oldStr) {
//		String newStr = oldStr.replace("'", "''");
//		newStr = newStr.replace("<", "&lt;");
//		newStr = newStr.replace(">", "&gt;");
//		newStr = newStr.replace("\n", "<br />");
//		return newStr;
//	}
	
	@RequestMapping(value="/reply/{b_num}", method=RequestMethod.GET)
	public Map replylist(@PathVariable int b_num) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("b_num",b_num);
		this.reviewService.select(map);
		List<ReviewVO> list = (List<ReviewVO>)map.get("replyResult");
		map.remove("replyResult");
		map.remove("b_num");
		map.put("code", "success");
		map.put("data", list);
		return map;
	}
	
	@DeleteMapping(value="/reply/{r_num}")
	public Map replyDel(@PathVariable int r_num) {
		this.reviewService.delete(r_num);
		Map<String, Object> map = new HashMap<String, Object>(); 
		map.put("code", "success");
		return map;
	}
}

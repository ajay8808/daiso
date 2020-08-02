package com.daiso.main;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.daiso.service.BoardService;
import com.daiso.service.ProductService;
import com.daiso.service.ReviewService;
import com.daiso.vo.BoardVO;
import com.daiso.vo.ProductVO;
import com.daiso.vo.ReviewVO;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	@Autowired
	private ProductService productService;
	
	
	
	// Select All
	@RequestMapping(value = "/board", method = RequestMethod.GET)
	// @ResponseBody
	public String selectBoAll(Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		this.boardService.selectAllBoards(map);
		// map.put("code", "success");
		// select all 된 map 키 results에 list 가져옴 dao에서 results
		List<BoardVO> list = (List<BoardVO>) map.get("results");
		// map.remove("results");
		// map.put("data", list);
		// return map;
		model.addAttribute("code", "success");
		model.addAttribute("datas", list);
		return "board"; // board.html
	}

	@GetMapping("/board/{b_num}") // 글 하나 보기
	public String boardSelectOne(@PathVariable("b_num") int b_num, Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("b_num", b_num);
		this.boardService.selectBoard(map);
		// log.info("b_num"+b_num);
		Map<String, Object> mapping = (Map<String, Object>) map.get("selectResult");
		model.addAttribute("board", mapping);
		return "boarddetail";
	}

//	@GetMapping("/boarddetail/{b_num}")
//	@ResponseBody
//	public Map<String, Object> boarddetail(@PathVariable(value="b_num", required=false) int b_num ) {
//		log.info("b_num"+b_num);
//		Map<String, Object> map = new HashMap<String, Object>();
//		this.boardService.selectBoard(map);
//		List<BoardVO> list = (List<BoardVO>)map.get("result");
//		BoardVO board = list.get(0);
//		//ProductVO product = productService.selectProduct(list.get(0).getP_productid());
//		map.put("code", "success");
//		map.put("board", board);
//		//map.put("product", product);
//		return map;	
//	}

	@RequestMapping(value = "/boarddetail", method = RequestMethod.GET)
	public String getboardDt() throws Exception {
		return "boarddetail"; // 2 boarddetail.html 페이지로 감
	}

	@RequestMapping(value = "/boardWrite", method = RequestMethod.GET)
	public String getboardWt() throws Exception {
		return "boardWrite";
	}

	@RequestMapping(value = "/board", method = RequestMethod.POST)
	@ResponseBody
	public Map insert(@RequestBody BoardVO board) {
		this.boardService.insertBoard(board);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", "success");
		return map;
	}

	// 글 삭제
	@GetMapping("/delete/{b_num}")
	public String boardDelete(@PathVariable("b_num") int b_num) {
		this.boardService.deleteBoard(b_num);
		Map<String, Object> map = new HashMap<String, Object>(); 
		map.put("code", "success");
		return "redirect:/board";
	}

//	@PutMapping("/update/{b_num}") // 글 업데이트
//	public Map boardUpdate(@PathVariable int b_num) {
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("b_num", b_num);
//		this.boardService.selectBoard(map);
//		Map<String, Object> mapping = (Map<String, Object>) map.get("boardResult");
//		map.put("boardResult", mapping);
//		return map;
//	}
//	@PutMapping("/member")
//	public Map<String, Object> update(@RequestBody MemberVO member) {
//		Map<String, Object> map = new HashMap<String, Object>();
//		log.info("" + member);
//		this.memberService.updateMember(member);
//
//		map.put("code", "success");
//		map.put("memberResult", member);
//		return map;
//	}
	@GetMapping("/update/{b_num}")
	public String boardupdate(@PathVariable int b_num,Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("b_num", b_num);
		this.boardService.selectBoard(map);
		Map<String, Object> mapping = (Map<String, Object>) map.get("selectResult");
		model.addAttribute("board", mapping);
		return "boardupdate";
	}
	
	@PutMapping("/boarddetail")
	public String update(HttpServletRequest http) {
		BoardVO vo = new BoardVO();
		log.info("디버그 = " + (String)http.getParameter("image"));
		log.info(http.getParameter("id"));
		log.info(http.getParameter("title"));
		log.info(http.getParameter("content"));
		log.info(http.getParameter("num"));
		log.info(http.getParameter("productid"));
		vo.setM_userid((String)http.getParameter("id")); //id 가 오브젝트 객체라 스트링형변환
		vo.setB_title((String) http.getParameter("title"));
		vo.setB_writing((String) http.getParameter("content"));
		/* vo.setP_productid(http.getParameter("product")); */
		int num = Integer.parseInt((String)http.getParameter("num"));
		vo.setB_num(num);
		int productid = Integer.parseInt((String)http.getParameter("productid"));
		vo.setP_productid(productid);
		boardService.updateBoard(vo);
		return "redirect:/board";
	}
	
	
	

}
	 


package com.daiso.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.daiso.service.MemberService;
import com.daiso.vo.MemberVO;

@Controller

public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String getRegister() throws Exception {
		logger.info("get register");
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String postRegister(MemberVO member) throws Exception {
		logger.info("post resister");
		memberService.insertMember(member);

		return "redirect:/";
	}

	@GetMapping("/login")
	public void login() {
	} // templates/login.html

	@GetMapping("/loginSuccess")
	public void loginSuccess() {
	} // templates/loginSuccess.html

	@GetMapping("/logout")
	public void logout() {
	} // templates/logout.html

	@GetMapping("/accessDenied")
	public void accessDenied() {
	} // templates/accessDenied.html
}

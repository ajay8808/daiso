package com.daiso.service;

import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.daiso.vo.MemberVO;

public interface MemberService {
	void insertMember(MemberVO member); //회원가입
//	void selectMember(Map map);
//	void selectAllMembers(Map map);
//	void updateMember(MemberVO member); // 회원정보수정 -> 나중에
//	void deleteMember(String m_userid); 
	UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

}

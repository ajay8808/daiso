package com.daiso.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberVO {
	private String m_userid;
	private String m_password;
	private String m_nickname;
	private String m_email;
	private String m_role;
	
}

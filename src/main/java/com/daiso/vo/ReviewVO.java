package com.daiso.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReviewVO {
	private int r_num;
	private String r_comment;
	private Date r_date;
	private int b_num;
	private String m_userid;
}

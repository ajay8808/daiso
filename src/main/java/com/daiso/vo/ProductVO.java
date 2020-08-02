package com.daiso.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductVO {
	private int p_productid;
	private String p_name;
	private int p_price;
	private String p_img;
}

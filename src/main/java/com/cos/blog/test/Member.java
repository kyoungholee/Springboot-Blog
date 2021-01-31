package com.cos.blog.test;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor //생성자


public class Member {
	private int id;
	private String username;
	private String password;
	private String email;
	
}

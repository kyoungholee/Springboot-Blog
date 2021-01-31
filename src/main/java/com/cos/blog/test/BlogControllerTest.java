package com.cos.blog.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
 
//사용자 -> 응답 (HtML) Controller 

//사용자가 ->응답 (data)
@RestController

public class BlogControllerTest {
	@GetMapping("/test/hello")
	public String hello() {
		return"hellow";
	}
	

}

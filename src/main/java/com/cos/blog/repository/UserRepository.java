package com.cos.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.blog.model.User;

//DAO
//자동으로 bean이 등록이 된다.

public interface UserRepository extends JpaRepository<User, Integer>{
		//Integert : 숫자
		//User : user테이블에서 관리
	

}

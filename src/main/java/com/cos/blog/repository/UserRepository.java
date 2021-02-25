package com.cos.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository; 
import com.cos.blog.model.User;;

//DAO
//자동으로 bean이 등록이 된다.
//Integert : 숫자
//User : user테이블에서 관리 

public interface UserRepository extends JpaRepository<User, Integer>{
	Optional<User> findByUsername(String username);
	
}




//JPA Naming 쿼리
	//SElECT * from user WHERE username = ? AND password =? 
	//User findByUsernameAndpassword(String username, String password);
	

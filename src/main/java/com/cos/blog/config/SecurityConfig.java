package com.cos.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean; 
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.sun.xml.bind.v2.runtime.output.Encoded;

import auth.PrincipalDetail;
import auth.PrincipalDetailService;


//bean 등록 의미는 스프링 컨테이너에서 객체를 관리할 수 있다.
@Configuration //빈등록 (Ioc 관리)
@EnableWebSecurity //시큐리티 필터가 등록된다.
@EnableGlobalMethodSecurity(prePostEnabled = true) // 특정 주소로 접근을 하면 권한 및 인증을 미리 체크
// 3개는 세트다 
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
	private PrincipalDetailService principalDetailService;
	
	
	@Bean
	public BCryptPasswordEncoder encodePWD() {
		return new BCryptPasswordEncoder();
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(principalDetailService).passwordEncoder(encodePWD());
		
	}

	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable() //csrf 토큰 비활성화 (테스트시 걸어주는게 좋다)
			.authorizeRequests()
				.antMatchers("/", "/auth/**", "/js/**", "/css/**", "/image/**")
				.permitAll()
				.anyRequest()
				.authenticated()
			.and()
				.formLogin()
				.loginPage("/auth/loginForm")
				.loginProcessingUrl("/auth/loginProc") 
				.defaultSuccessUrl("/");//스프링 시큐리티가 해당주소로 요청하는 로그인을 가로채서 대신 로그인
	}
}

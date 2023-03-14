package com.trillon.camp.common.config;

import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/*import org.springframework.boot.autoconfigure.security.servlet.PathRequest;*/
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity // Spring Security�쓽 湲곕낯 �꽕�젙 ���떊 �궗�슜�옄媛� 而ㅼ뒪�꽣留덉씠吏뺥븳 �꽕�젙�쓣 �떆�걧由ы떚�뿉 �쟻�슜
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	private final DataSource dataSource;
	/* private final UserDetailsService userDetailsService; */
	
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers(HttpMethod.GET,  "/").permitAll()
		.antMatchers(HttpMethod.GET,  "/sample/admin").permitAll()
		.antMatchers(HttpMethod.GET,  "/index").permitAll()
		.antMatchers(HttpMethod.GET,  "/elements").permitAll()
		
		.antMatchers(HttpMethod.GET,  "/suggest/**").permitAll() 
		.antMatchers(HttpMethod.POST, "/suggest/**").permitAll()
		
		.antMatchers(HttpMethod.GET,  "/schedule/calendar").permitAll()
		.antMatchers(HttpMethod.GET,  "/schedule/schedulePopUp").permitAll()
		.antMatchers(HttpMethod.GET,  "/schedule/get.do").permitAll()
		.antMatchers(HttpMethod.POST, "/schedule/**").permitAll()
		
		.antMatchers(HttpMethod.GET,  "/sample/admin").permitAll()
		.antMatchers(HttpMethod.POST, "/member/signup").permitAll()
		.antMatchers(HttpMethod.POST, "/mail").permitAll()
		.antMatchers(HttpMethod.GET, "/comewithme/comeWithMeList", "/comewithme/comeWithMeSelect", "/comewithme/comeWithMeBoard").permitAll()
		.antMatchers(HttpMethod.GET,  "/members/login").permitAll()
		.antMatchers(HttpMethod.GET,  "/board/list", "/board/detail", "/board/download").permitAll()
		.antMatchers(HttpMethod.GET,  "/sample/member").hasAuthority("ROLE_MEMBER")
		.anyRequest().authenticated();
		
	  http.formLogin() .loginProcessingUrl("/members/login")
	  .loginPage("/members/login") .usernameParameter("userId")
	  //.successHandler(authSuccessHandler) //.failureHandler(authFailureHandler)
	  // /members/login-> /index濡� 怨좎낀�쓬 �굹以묒뿉 �떎�떆 濡쒓렇�씤�쑝濡� �빐�빞�븿
	  .permitAll();
		 
		http.logout()
			.logoutUrl("/members/logout")
			.logoutSuccessUrl("/members/login");
		
		/*
		 * http.rememberMe() .userDetailsService(userDetailsService)
		 * .tokenRepository(tokenRepository());
		 */
		
		// csrf : post�슂泥��씪 �븣 �닔�뻾�빐�빞 �븯�뒗 csrf �넗�겙 寃�利앹쓣 �걫
		//http.csrf().disable();
		http.csrf().ignoringAntMatchers("/mail");
	}
	
	@Override
	public void configure(WebSecurity web) {
		web.ignoring().antMatchers(HttpMethod.GET,"/resources/**");
	}
	
	@Bean
	public PersistentTokenRepository tokenRepository() {
		JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
		tokenRepository.setDataSource(dataSource);
		return tokenRepository;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

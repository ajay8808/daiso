package com.daiso.config;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;
   
import com.daiso.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private MemberService memberService;
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws java.lang.Exception{
		log.info("called configure()");
		http.authorizeRequests().antMatchers("/").permitAll();
		http.authorizeRequests().antMatchers("/board/**").authenticated();
		
		http.authorizeRequests().antMatchers("/user/**").hasRole("USER");
		http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");
		
		http.formLogin().loginPage("/login").defaultSuccessUrl("/", true);
		http.exceptionHandling().accessDeniedPage("/accessDenied");
		http.logout().logoutUrl("/logout").invalidateHttpSession(true).logoutSuccessUrl("/");
		http.csrf().ignoringAntMatchers("/board/**").and();
		http.csrf().ignoringAntMatchers("/reply/**").and(); 
		http.userDetailsService((UserDetailsService) memberService);
		
	}
	 
	  @Bean public SpringSecurityDialect springSecurityDialect(){ 
		  return new SpringSecurityDialect(); }
	 
	
//	  protected void configure(AuthenticationManagerBuilder auth) throws
//	  java.lang.Exception{ String sql1 ="SELECT m_userid , m_password  FROM membertable " + "WHERE m_userid = ?"; 
//	  String sql2 = "SELECT m_userid, role FROM membertable WHERE m_userid = ?";
//	  auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery(sql1)
//	  .authoritiesByUsernameQuery(sql2); }
	 
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//	}
}






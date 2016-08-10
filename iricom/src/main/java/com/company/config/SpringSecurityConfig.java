package com.company.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.company.service.LoginService;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
	

	@Autowired
	DataSource dataSource;
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		web.ignoring().antMatchers("/**/*.js").antMatchers("/**/*.css").antMatchers("/images/*");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		//hasRole(String)은 prefix = "ROLE_"이 붙음
		http.authorizeRequests().antMatchers("/admin/**").hasAuthority("0")
								.antMatchers("/test").hasAuthority("5")
		                        .antMatchers("/login").anonymous()
		                        .antMatchers("/list").authenticated()
		                        .antMatchers("/main").permitAll()
		                        .antMatchers("/**").permitAll()
		                        .and()
		                        .formLogin().usernameParameter("loginid")
		                                    .passwordParameter("loginpw")
		                                    .loginPage("/user/login")
		                                   // .successForwardUrl("/main")
		                                    .failureUrl("/login?fail=true")
		                                    .successHandler(dbgAuthenticationSuccessHandler())
		                        .and()
		                        .logout()
		                                 .logoutSuccessUrl("/main")
		                        		 .deleteCookies("JSESSIONID")
		                        .and()
		                        .exceptionHandling().accessDeniedHandler(dbgAccessDeniedHandler());
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(loginService());
		//auth.inMemoryAuthentication().withUser("user1").password("user1password").authorities("ROLE_USER").and()
		//.withUser("admin").password("password").authorities("ROLE_USER","ROLE_ADMIN");
	}
	@Bean 
	public LoginService loginService(){
		LoginService loginService = new LoginService();
		loginService.setDataSource(dataSource);
		loginService.setRolePrefix("");
		loginService.setUsersByUsernameQuery("SELECT user_id, password, user_name FROM DBG_USER_TB where user_id = ?");
		loginService.setAuthoritiesByUsernameQuery("SELECT user_id, authority FROM DBG_USER_TB where user_id = ?");
		
		return loginService;
	}
	@Bean 
	public DbgAuthenticationSuccessHandler dbgAuthenticationSuccessHandler(){
		DbgAuthenticationSuccessHandler dbgAuthenticationSuccessHandler = new DbgAuthenticationSuccessHandler();
		dbgAuthenticationSuccessHandler.setTargetUrlParameter("loginRedirect");
		dbgAuthenticationSuccessHandler.setDefaultUrl("/main");
		
		return dbgAuthenticationSuccessHandler;
	}
	@Bean
	public DbgAccessDeniedHandler dbgAccessDeniedHandler(){
		DbgAccessDeniedHandler dbgAccessDeniedHandler = new DbgAccessDeniedHandler();
		dbgAccessDeniedHandler.setErrorPage("/accessDenied");
		
		return dbgAccessDeniedHandler;
	}

}

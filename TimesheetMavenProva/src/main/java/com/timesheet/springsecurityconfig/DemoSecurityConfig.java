package com.timesheet.springsecurityconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
@ComponentScan(basePackages="com.timesheet")
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// add our users for in memory authentication
		
		UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
			.withUser(users.username("Lara").password("test123").roles("EMPLOYEE"))
			.withUser(users.username("Simone").password("test123").roles("EMPLOYEE","MANAGER"))
			.withUser(users.username("Diego").password("test123").roles("EMPLOYEE","MANAGER"))
			.withUser(users.username("Lisa").password("test123").roles("EMPLOYEE","ADMIN"))
		    .withUser(users.username("Babbo").password("test123").roles("EMPLOYEE","ADMIN"));
	}


	@Override
	
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		.antMatchers("/").hasRole("EMPLOYEE")
		.antMatchers("/leaders/**").hasRole("MANAGER")
		.antMatchers("/systems/**").hasRole("ADMMIN")
		.and()
		.formLogin().loginPage("/showMyLoginPage")
		.loginProcessingUrl("/authenticateTheUser").permitAll()
		.and()
		.logout().permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/access-denied");
	}
	
	
}







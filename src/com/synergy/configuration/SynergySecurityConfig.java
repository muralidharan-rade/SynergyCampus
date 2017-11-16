package com.synergy.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@EnableWebSecurity
@PropertySource(value = { "classpath:application.properties" })
public class SynergySecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private Environment env;
	@Autowired
	private SynergyAuthenticationEntryPoint restAuthenticationEntryPoint;
	private String USER = "user";
	private String ADMIN = "admin";
	private String ROLE_USER = "ROLE_USER";
	private String ROLE_ADMIN = "ROLE_ADMIN";

	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * http.authorizeRequests().antMatchers("/api").permitAll(); }
	 */

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("security config :: configure ***************");
		http.authorizeRequests().anyRequest().authenticated().and().httpBasic()
				.and().exceptionHandling()
				.authenticationEntryPoint(restAuthenticationEntryPoint).and()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

	@Autowired
	void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println("configure GLobal **************");
		auth.inMemoryAuthentication().withUser(USER)
				.password(env.getRequiredProperty(USER)).authorities(ROLE_USER)
				.and().withUser(ADMIN).password(env.getRequiredProperty(ADMIN))
				.authorities(ROLE_USER, ROLE_ADMIN);
	}

}

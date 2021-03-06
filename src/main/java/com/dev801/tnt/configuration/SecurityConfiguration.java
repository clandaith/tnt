package com.dev801.tnt.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	DataSource dataSource;

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		//authorize requests	
		httpSecurity.authorizeRequests()
						.antMatchers("/", "/index", "/about801dev", "/roadmap", "/forgotpassword", "/register").permitAll()
						.antMatchers("/warbands", "/warband", "/character", "/print", "/verify_logout", "/userinfo").access("hasRole('USER') or hasRole('ADMIN')")
						.antMatchers("/admin/**", "/manage/**").access("hasRole('ADMIN')")
						.anyRequest().authenticated()
							.and()
							.formLogin()
								.loginPage("/login")
									.usernameParameter("multipassName")
									.passwordParameter("multipassIdent")
							.permitAll()
							.and()
							.logout()
								.permitAll();
	}

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
						.usersByUsernameQuery("select username, password, enabled from users where username = ?")
						.authoritiesByUsernameQuery("select username, role from user_roles where username = ?")
						.passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}

package br.com.ribeiro.fernando.springsecuritydemo.ports.security.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.ribeiro.fernando.springsecuritydemo.ports.controllers.ControllersURIs;

@Configuration
public class ProjectSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers(ControllersURIs.ACCOUNT).authenticated()
			.antMatchers(ControllersURIs.BALANCE).authenticated()
			.antMatchers(ControllersURIs.CARD).authenticated()
			.antMatchers(ControllersURIs.LOAN).authenticated()
			.antMatchers(ControllersURIs.NOTICE).permitAll()
			.antMatchers(ControllersURIs.CONTACT).permitAll()
			.and().formLogin()
			.and().httpBasic();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}

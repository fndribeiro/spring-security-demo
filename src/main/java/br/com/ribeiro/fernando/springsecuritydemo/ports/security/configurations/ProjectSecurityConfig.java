package br.com.ribeiro.fernando.springsecuritydemo.ports.security.configurations;

import java.util.Collections;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import br.com.ribeiro.fernando.springsecuritydemo.ports.controllers.ControllersURIs;

@Configuration
public class ProjectSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.cors()
			.configurationSource(new CorsConfigurationSource() {
			@Override
			public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
				CorsConfiguration config = new CorsConfiguration();
				config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
				config.setAllowedMethods(Collections.singletonList("*"));
				config.setAllowCredentials(true);
				config.setAllowedHeaders(Collections.singletonList("*"));
				config.setMaxAge(3600L);
				return config;
				}
			})
			.and()
				.csrf()
				.ignoringAntMatchers(ControllersURIs.CONTACT)
				.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
			.and().authorizeRequests()
			.antMatchers(ControllersURIs.ACCOUNT).authenticated()
			.antMatchers(ControllersURIs.BALANCE).authenticated()
			.antMatchers(ControllersURIs.CARD).authenticated()
			.antMatchers(ControllersURIs.LOAN).authenticated()
			.antMatchers(ControllersURIs.USER).authenticated()
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

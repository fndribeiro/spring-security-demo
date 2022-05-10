package br.com.ribeiro.fernando.springsecuritydemo.ports.security.configurations;

import java.util.Arrays;
import java.util.Collections;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import br.com.ribeiro.fernando.springsecuritydemo.domain.valueobjects.UserAuthorities;
import br.com.ribeiro.fernando.springsecuritydemo.domain.valueobjects.UserRole;
import br.com.ribeiro.fernando.springsecuritydemo.ports.controllers.ControllersURIs;
import br.com.ribeiro.fernando.springsecuritydemo.ports.security.filters.JWTTokenGeneratorFilter;
import br.com.ribeiro.fernando.springsecuritydemo.ports.security.filters.JWTTokenValidationFilter;
import br.com.ribeiro.fernando.springsecuritydemo.ports.security.filters.UsernameValidationFilter;

@Configuration
public class ProjectSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
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
					config.setExposedHeaders(Arrays.asList(HttpHeaders.AUTHORIZATION));
					return config;
					}
				})
			.and()
				.csrf()
				.disable()
			.addFilterBefore(new UsernameValidationFilter(), BasicAuthenticationFilter.class)
			.addFilterBefore(new JWTTokenValidationFilter(), BasicAuthenticationFilter.class)
			.addFilterAfter(new JWTTokenGeneratorFilter(), BasicAuthenticationFilter.class)
			.authorizeRequests()
			.antMatchers(ControllersURIs.ACCESS).authenticated()
			.antMatchers(ControllersURIs.AUTHENTICATED).authenticated()
			.antMatchers(ControllersURIs.HAS_AUTHORITY).hasAuthority(UserAuthorities.WRITE.name())
			.antMatchers(ControllersURIs.HAS_ROLE).hasRole(UserRole.ADMIN.name())
			.antMatchers(ControllersURIs.PERMIT_ALL).permitAll()
			.and()
				.formLogin()
			.and()
				.httpBasic();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}

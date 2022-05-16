package br.com.ribeiro.fernando.springsecuritydemo.ports.security.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;

import br.com.ribeiro.fernando.springsecuritydemo.ports.security.constants.Oauth2GithubContants;

@Configuration
public class Oauth2GithubConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.anyRequest()
			.authenticated()
			.and()
			.oauth2Login();
	}
	
	/*
	private ClientRegistration clientRegistration() {
		return CommonOAuth2Provider
				.GITHUB
				.getBuilder(Oauth2GithubContants.REGISTRATION_ID)
				.clientId(Oauth2GithubContants.CLIENT_ID)
				.clientSecret(Oauth2GithubContants.CLIENT_SECRET)
				.build();
	}
	*/
	
	/*
	@Bean
	public ClientRegistrationRepository clientRepository() {
		return new InMemoryClientRegistrationRepository(clientRegistration());
	}
	*/
	
}

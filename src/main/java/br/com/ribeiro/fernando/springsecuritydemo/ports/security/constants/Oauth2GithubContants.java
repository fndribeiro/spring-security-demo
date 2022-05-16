package br.com.ribeiro.fernando.springsecuritydemo.ports.security.constants;

public class Oauth2GithubContants {

	public static final String REGISTRATION_ID = "GITHUB";
	public static final String CLIENT_ID = System.getenv("GITHUB_CLIENT_ID");
	public static final String CLIENT_SECRET = System.getenv("GITHUB_CLIENT_SECRET");
	
}

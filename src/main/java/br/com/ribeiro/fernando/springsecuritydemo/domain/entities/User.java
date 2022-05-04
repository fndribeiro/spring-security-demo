package br.com.ribeiro.fernando.springsecuritydemo.domain.entities;

import java.util.Set;

import br.com.ribeiro.fernando.springsecuritydemo.domain.valueobjects.UserAuthorities;
import br.com.ribeiro.fernando.springsecuritydemo.domain.valueobjects.UserRole;

public class User {

	private String username;
	private String password;
	private String name;
	private String mobileNumber;
	private String email;
	private UserRole role;
	private Set<UserAuthorities> authorities;
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public UserRole getRole() {
		return role;
	}
	
	public void setRole(UserRole role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<UserAuthorities> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<UserAuthorities> authorities) {
		this.authorities = authorities;
	}

}

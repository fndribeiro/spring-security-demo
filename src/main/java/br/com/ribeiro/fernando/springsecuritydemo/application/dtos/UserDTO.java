package br.com.ribeiro.fernando.springsecuritydemo.application.dtos;

import br.com.ribeiro.fernando.springsecuritydemo.domain.entities.User;
import br.com.ribeiro.fernando.springsecuritydemo.domain.valueobjects.UserRole;

public class UserDTO {

	private String username;
	private UserRole role;
	private String name;
	private String mobileNumber;
	private String email;
	
	public UserDTO(User user) {
		this.username = user.getUsername();
		this.role = user.getRole();
		this.name = user.getName();
		this.mobileNumber = user.getMobileNumber();
		this.email = user.getEmail();
	}

	public String getUsername() {
		return username;
	}

	public UserRole getRole() {
		return role;
	}

	public String getName() {
		return name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public String getEmail() {
		return email;
	}

}

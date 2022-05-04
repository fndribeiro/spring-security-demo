package br.com.ribeiro.fernando.springsecuritydemo.application.dtos;

import br.com.ribeiro.fernando.springsecuritydemo.domain.entities.User;

public class UserDTO {

	private String username;
	private String role;
	private String name;
	private String mobileNumber;
	private String email;
	private String statusCd;
	private String statusMsg;
	private String authStatus;
	
	public UserDTO(User user) {
		this.username = user.getUsername();
		this.role = user.getRole();
		this.name = user.getName();
		this.mobileNumber = user.getMobileNumber();
		this.email = user.getEmail();
		this.statusCd = user.getStatusCd();
		this.statusMsg = user.getStatusMsg();
		this.authStatus = user.getAuthStatus();
	}

	public String getUsername() {
		return username;
	}

	public String getRole() {
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

	public String getStatusCd() {
		return statusCd;
	}

	public String getStatusMsg() {
		return statusMsg;
	}

	public String getAuthStatus() {
		return authStatus;
	}
	
}

package com.bridgelabz.UserManagement.dto;

import javax.validation.constraints.NotEmpty;

/**
 * @author Tejashree Surve
 * @Purpose : This is Data Transfer Object that holds Data for login dto.
 */
public class LoginDto {
	@NotEmpty
	private String userName;
	@NotEmpty
	private String userPassword;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
}

package com.bridgelabz.UserManagement.dto;

/**
 * @author Tejashree Surve
 * @Purpose : This is Data Transfer Object that holds Data for login dto.
 */
public class LoginDto {

	private String userName;
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

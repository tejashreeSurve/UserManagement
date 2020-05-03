package com.bridgelabz.UserManagement.dto;

import javax.validation.constraints.NotEmpty;
/**
 * @author Tejashree Surve
 * @Purpose : This is Data Transfer Object class for Reset password Api's.
 */
public class ResetPasswordDto {
	@NotEmpty
	private String userPassword;
	@NotEmpty
	private String confirmPassword;

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
}

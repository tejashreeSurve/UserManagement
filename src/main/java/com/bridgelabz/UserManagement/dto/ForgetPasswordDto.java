package com.bridgelabz.UserManagement.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
/**
 * @author Tejashree Surve
 * @Purpose : This is Data Transfer Object class for forget password Api's.
 */
public class ForgetPasswordDto {
	@NotEmpty
	@Pattern(regexp = "\\w+\\@\\w+\\.\\w+", message = "Please Enter valide Email")
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}

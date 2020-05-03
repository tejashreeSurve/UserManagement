package com.bridgelabz.UserManagement.exception;

/**
 * @author Tejashree Surve
 * @Purpose : This is customize Exception.
 */
public class InvalideUser extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalideUser(String message) {
		super(message);
	}
}

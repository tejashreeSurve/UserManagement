package com.bridgelabz.UserManagement.exception;

/**
 * @author Tejashree Surve
 * @Purpose : This is customize Exception.
 */
public class InvalideToken extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalideToken(String message) {
		super(message);
	}

}

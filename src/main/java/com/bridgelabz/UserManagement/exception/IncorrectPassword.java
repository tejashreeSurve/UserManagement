package com.bridgelabz.UserManagement.exception;

/**
 * @author Tejashree Surve
 * @Purpose : This is customize Exception.
 */
public class IncorrectPassword extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public IncorrectPassword(String message) {
		super(message);
	}

}

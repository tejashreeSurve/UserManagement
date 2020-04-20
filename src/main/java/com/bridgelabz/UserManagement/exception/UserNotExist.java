package com.bridgelabz.UserManagement.exception;

/**
 * @author Tejashree Surve
 * @Purpose : This is customize Exception.
 */
public class UserNotExist extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UserNotExist(String message) {
		super(message);
	}

}

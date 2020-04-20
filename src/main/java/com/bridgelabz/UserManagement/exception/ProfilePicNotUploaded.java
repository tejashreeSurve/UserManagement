package com.bridgelabz.UserManagement.exception;

/**
 * @author Tejashree Surve
 * @Purpose : This is customize Exception.
 */
public class ProfilePicNotUploaded extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ProfilePicNotUploaded(String message) {
		super(message);
	}
}

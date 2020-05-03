package com.bridgelabz.UserManagement.exception;

/**
 * @author Tejashree Surve
 * @Purpose : This is customize Exception.
 */
public class PermissionDeniedError extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PermissionDeniedError(String message) {
		super(message);
	}
}

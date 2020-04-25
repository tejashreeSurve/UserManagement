package com.bridgelabz.UserManagement.exception;

public class PermissionDeniedError extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PermissionDeniedError(String message) {
		super(message);
	}
}

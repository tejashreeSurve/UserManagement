package com.bridgelabz.UserManagement.exception;

public class PermissionAlreadyProvided extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public PermissionAlreadyProvided(String message) {
		super(message);
	}
}

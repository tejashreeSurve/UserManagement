package com.bridgelabz.UserManagement.exception;

/**
 * @author Tejashree Surve
 * @Purpose : This is customize Exception.
 */
public class PermissionAlreadyProvided extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PermissionAlreadyProvided(String message) {
		super(message);
	}
}

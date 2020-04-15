package com.bridgelabz.UserManagement.exception;

public class UserAlreadyExsist extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	 
	public UserAlreadyExsist(String message) {
		super(message);
	}
}

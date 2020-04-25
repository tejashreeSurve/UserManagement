package com.bridgelabz.UserManagement.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bridgelabz.UserManagement.message.MessageInfo;
import com.bridgelabz.UserManagement.response.Response;

/**
 * @author Tejashree Surve
 * @Purpose : This is Global Exception.
 */
@ControllerAdvice
public class GlobalException {

	@Autowired
	MessageInfo message;

	@ExceptionHandler(UserAlreadyExsist.class)
	public ResponseEntity<Response> UserAlreadyExsist(Exception e) {
		return new ResponseEntity<Response>(
				new Response(Integer.parseInt(message.Bad_Request), e.getMessage(), "Please try again!!!"),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(IncorrectPassword.class)
	public ResponseEntity<Response> IncorrectPassword(Exception e) {
		return new ResponseEntity<Response>(
				new Response(Integer.parseInt(message.Bad_Request), e.getMessage(), "Please try again!!!"),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(UserNotExist.class)
	public ResponseEntity<Response> UserNotExist(Exception e) {
		return new ResponseEntity<Response>(
				new Response(Integer.parseInt(message.Bad_Request), e.getMessage(), "Please try again!!!"),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(InvalideToken.class)
	public ResponseEntity<Response> InvalideToken(Exception e) {
		return new ResponseEntity<Response>(
				new Response(Integer.parseInt(message.Bad_Request), e.getMessage(), "Please try again!!!"),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(FileIsEmpty.class)
	public ResponseEntity<Response> FileIsEmpty(Exception e) {
		return new ResponseEntity<Response>(
				new Response(Integer.parseInt(message.Bad_Request), e.getMessage(), "Please try again!!!"),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ProfilePicNotUploaded.class)
	public ResponseEntity<Response> ProfilePicNotUploaded(Exception e) {
		return new ResponseEntity<Response>(
				new Response(Integer.parseInt(message.Bad_Request), e.getMessage(), "Please try again!!!"),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(InvlideLogin.class)
	public ResponseEntity<Response> InvlideLogin(Exception e) {
		return new ResponseEntity<Response>(
				new Response(Integer.parseInt(message.Bad_Request), e.getMessage(), "Please try again!!!"),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(PermissionAlreadyProvided.class)
	public ResponseEntity<Response> PermissionAlreadyProvided(Exception e) {
		return new ResponseEntity<Response>(
				new Response(Integer.parseInt(message.Bad_Request), e.getMessage(), "Please try again!!!"),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(PermissionDeniedError.class)
	public ResponseEntity<Response> PermissionDeniedError(Exception e) {
		return new ResponseEntity<Response>(
				new Response(Integer.parseInt(message.Bad_Request), e.getMessage(), "Please try again!!!"),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(InvalideUser.class)
	public ResponseEntity<Response> InvalideUser(Exception e) {
		return new ResponseEntity<Response>(
				new Response(Integer.parseInt(message.Bad_Request), e.getMessage(), "Please try again!!!"),
				HttpStatus.BAD_REQUEST);
	}
}

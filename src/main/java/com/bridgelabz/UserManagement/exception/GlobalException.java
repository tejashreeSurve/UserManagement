package com.bridgelabz.UserManagement.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.bridgelabz.UserManagement.message.MessageInfo;
import com.bridgelabz.UserManagement.response.Response;


@ControllerAdvice
public class GlobalException {
	
	Environment environment;
	
	@Autowired
	MessageInfo message;

	public  ResponseEntity<Response> UserAlreadyExsist(Exception e){
		return new ResponseEntity<Response>(new Response(Integer.parseInt(message.Bad_Request),
				e.getMessage(),"Please try again!!!"),HttpStatus.BAD_REQUEST);
	}
}

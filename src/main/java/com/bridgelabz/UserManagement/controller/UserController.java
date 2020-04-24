package com.bridgelabz.UserManagement.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bridgelabz.UserManagement.dto.ForgetPasswordDto;
import com.bridgelabz.UserManagement.dto.LoginDto;
import com.bridgelabz.UserManagement.dto.ResetPasswordDto;
import com.bridgelabz.UserManagement.dto.UserDto;
import com.bridgelabz.UserManagement.response.Response;
import com.bridgelabz.UserManagement.services.IUserServices;

/**
 * @author Tejashree Surve
 * @Purpose : Rest Api's Controller for User Operation.
 */
@RestController
@RequestMapping("/UserOperation")
public class UserController {

	@Autowired
	IUserServices userService;

	// create new user
	@PostMapping("/addNewUser")
	public ResponseEntity<Response> createNewUser(@Valid @RequestBody UserDto userDto) {
		Response response = userService.newUser(userDto);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	// get user list
	@GetMapping("/userList")
	public ResponseEntity<Response> userList() {
		Response response = userService.getUserList();
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	// set user profile pic
	@PostMapping("/setProfilePic")
	public ResponseEntity<Response> setProfilePic(@RequestHeader String token, MultipartFile file) {
		Response response = userService.addProfilePic(token, file);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	// login
	@PostMapping("/login")
	public ResponseEntity<Response> login(@Valid @RequestBody LoginDto loginDto) {
		Response response = userService.login(loginDto);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	// logout
	@PostMapping("/logout")
	public ResponseEntity<Response> logout(@RequestHeader String token) {
		Response response = userService.logout(token);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	// validate user
	@GetMapping("/valiateUser/{token}")
	public ResponseEntity<Response> validateUser(@PathVariable String token) {
		Response response = userService.validateUser(token);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	// forget Password Rest Api
	@PostMapping("/forgetPassword")
	public ResponseEntity<Response> forgetPassword(@Valid @RequestBody ForgetPasswordDto forgetPasswordDto) {
		Response response = userService.forgetPassword(forgetPasswordDto);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	// Reset Password Rest Api
	@PutMapping("/resetPassword")
	public ResponseEntity<Response> resetPassword(@RequestHeader String token,
			@Valid @RequestBody ResetPasswordDto resetPasswordDto) {
		Response response = userService.resetPassword(token, resetPasswordDto);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	// Get User Details Rest Api
	@GetMapping("/getUserDetail")
	public ResponseEntity<Response> getUserProfileDetail(@RequestHeader String token){
		Response response = userService.getUserProfileDetail(token);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	// Add Permission to user Rest Api
	@PostMapping("/addPermissions")
	public ResponseEntity<Response> addPermissions(@RequestHeader String token){
		Response response = userService.addPermissions(token);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
}

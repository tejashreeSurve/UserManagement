
package com.bridgelabz.UserManagement.services;

import org.springframework.web.multipart.MultipartFile;

import com.bridgelabz.UserManagement.dto.EditUserDto;
import com.bridgelabz.UserManagement.dto.ForgetPasswordDto;
import com.bridgelabz.UserManagement.dto.LoginDto;
import com.bridgelabz.UserManagement.dto.ResetPasswordDto;
import com.bridgelabz.UserManagement.dto.UserDto;
import com.bridgelabz.UserManagement.response.Response;

/**
 * @author Tejashree Surve
 * @Purpose : This is IDashboardServices Interface which contains every method
 *          of services class.
 */
public interface IUserServices {

	// add new user while sign-up
	Response newUser(UserDto userDto);

	// get user list
	Response getUserList(String token);

	// validate user 
	Response validateUser(String token);

	// add profile pic for user
	Response addProfilePic(String token, MultipartFile profileImage);

	// login
	Response login(LoginDto loginDto);

	// logout
	Response logout(String token);

	// forget password 
	Response forgetPassword(ForgetPasswordDto forgetPasswordDto);

	// reset user password
	Response resetPassword(String token, ResetPasswordDto resetPasswordDto);

	// get user profile details
	Response getUserProfileDetail(String token);

	// provide permission to user
	Response addPermissions(String token);

	// edit user profile details
	Response editUserProfile(String token, EditUserDto editUserDto);

	// add new user by admin user
	Response addNewUserByUser(String token, UserDto userDto);
}

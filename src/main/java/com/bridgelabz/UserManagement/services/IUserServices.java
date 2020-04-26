
package com.bridgelabz.UserManagement.services;

import org.springframework.web.multipart.MultipartFile;

import com.bridgelabz.UserManagement.dto.EditUserDto;
import com.bridgelabz.UserManagement.dto.ForgetPasswordDto;
import com.bridgelabz.UserManagement.dto.LoginDto;
import com.bridgelabz.UserManagement.dto.ResetPasswordDto;
import com.bridgelabz.UserManagement.dto.UserDto;
import com.bridgelabz.UserManagement.response.Response;

public interface IUserServices {

	Response newUser(UserDto userDto);

	Response getUserList(String token);

	Response validateUser(String token);

	Response addProfilePic(String token, MultipartFile profileImage);

	Response login(LoginDto loginDto);

	Response logout(String token);

	Response forgetPassword(ForgetPasswordDto forgetPasswordDto);

	Response resetPassword(String token, ResetPasswordDto resetPasswordDto);

	Response getUserProfileDetail(String token);

	Response addPermissions(String token);

	Response editUserProfile(String token, EditUserDto editUserDto);

	Response addNewUserByUser(String token, UserDto userDto);
}

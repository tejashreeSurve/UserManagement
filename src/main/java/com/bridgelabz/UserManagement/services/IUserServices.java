package com.bridgelabz.UserManagement.services;

import org.springframework.web.multipart.MultipartFile;

import com.bridgelabz.UserManagement.dto.LoginDto;
import com.bridgelabz.UserManagement.dto.UserDto;
import com.bridgelabz.UserManagement.response.Response;

public interface IUserServices {

	Response newUser(UserDto userDto);
	
	Response getUserList();
	
	Response validateUser(String token);
	
	Response addProfilePic(String token,MultipartFile profileImage );
	
	Response login(LoginDto loginDto);
	
	Response logout(String token);
}

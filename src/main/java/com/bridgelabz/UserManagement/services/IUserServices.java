package com.bridgelabz.UserManagement.services;

import com.bridgelabz.UserManagement.dto.UserDto;
import com.bridgelabz.UserManagement.response.Response;

public interface IUserServices {

	Response newUser(UserDto userDto);
}

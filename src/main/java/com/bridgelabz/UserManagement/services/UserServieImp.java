package com.bridgelabz.UserManagement.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.UserManagement.dto.UserDto;
import com.bridgelabz.UserManagement.message.MessageInfo;
import com.bridgelabz.UserManagement.model.UsersEntity;
import com.bridgelabz.UserManagement.repository.UserRepository;
import com.bridgelabz.UserManagement.response.Response;
import com.sun.istack.logging.Logger;

@Service
public class UserServieImp implements IUserServices {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private MessageInfo message;
	
	private static final Logger LOGGER = Logger.getLogger(UserServieImp.class);
	
	@Override
	public Response newUser(UserDto userDto) {
	UsersEntity userEmail = userRepository.findByEmail(userDto.getEmail());
	UsersEntity userName = userRepository.findByUserName(userDto.getUserName());
		return null;
	}

}

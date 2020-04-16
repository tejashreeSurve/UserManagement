package com.bridgelabz.UserManagement.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.bridgelabz.UserManagement.dto.UserDto;
import com.bridgelabz.UserManagement.exception.UserAlreadyExsist;
import com.bridgelabz.UserManagement.message.MessageInfo;
import com.bridgelabz.UserManagement.model.UserEntity;
import com.bridgelabz.UserManagement.repository.UserRepository;
import com.bridgelabz.UserManagement.response.Response;
import com.sun.istack.logging.Logger;

@Service
public class UserServiceImp implements IUserServices {

	Environment environment;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private MessageInfo message;

	private static final Logger LOGGER = Logger.getLogger(UserServiceImp.class);

	@Override
	public Response newUser(UserDto userDto) {
		UserEntity userName = userRepository.findByUserName(userDto.getUserName());
		UserEntity userEmail = userRepository.findByEmail(userDto.getEmail());
		if (userName != null || userEmail != null)
			throw new UserAlreadyExsist(message.User_Already_Exist);
		if (userDto.getUserPassword() != userDto.getConfirmPassword())
			return new Response(Integer.parseInt(environment.getProperty("success.code")),
					environment.getProperty("user.added"), message.User_Added);
		UserEntity userEntity = mapper.map(userDto, UserEntity.class);
		userRepository.save(userEntity);
		return new Response(Integer.parseInt(environment.getProperty("success.code")),
				environment.getProperty("user.added"), message.User_Added);

	}
}
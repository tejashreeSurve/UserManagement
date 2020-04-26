package com.bridgelabz.UserManagement.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.bridgelabz.UserManagement.Utility.JwtToken;
import com.bridgelabz.UserManagement.exception.PermissionDeniedError;
import com.bridgelabz.UserManagement.exception.UserNotExist;
import com.bridgelabz.UserManagement.message.MessageInfo;
import com.bridgelabz.UserManagement.model.UserEntity;
import com.bridgelabz.UserManagement.repository.UserRepository;
import com.bridgelabz.UserManagement.response.Response;

@Component
@Service
@PropertySource("message.properties")
public class DashboardServiceImp implements IDashboardServices {

	@Autowired
	Environment environment;

	@Autowired
	private MessageInfo message;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private JwtToken jwtToken;

	@Override
	public Response getTotalUserList(String token) {
		String userName = jwtToken.getToken(token);
		UserEntity user = userRepository.findByUserName(userName);
		if (user == null)
			throw new UserNotExist(message.User_Not_Exist);
		if (user.getUserRole().equals("admin")) {
			List<Object[]> userList = userRepository.userList();
			long totalNoOfUser = userList.stream().collect(Collectors.counting());
			return new Response(Integer.parseInt(environment.getProperty("success.code")),
					"Total User : " + totalNoOfUser + " ", userList);
		}
		throw new PermissionDeniedError(message.Permission_Denied);
	}

	@Override
	public Response getTotalActiveUser(String token) {
		String userName = jwtToken.getToken(token);
		UserEntity user = userRepository.findByUserName(userName);
		if (user == null)
			throw new UserNotExist(message.User_Not_Exist);
		if (user.getUserRole().equals("admin")) {
			List<Object[]> userList = userRepository.activeUser();
			long activeUser = userList.stream().collect(Collectors.counting());
			return new Response(Integer.parseInt(environment.getProperty("success.code")),
					"Active User : " + activeUser + " ", userList);
		}
		throw new PermissionDeniedError(message.Permission_Denied);
	}

	@Override
	public Response getTotalInactiveUser(String token) {
		String userName = jwtToken.getToken(token);
		UserEntity user = userRepository.findByUserName(userName);
		if (user == null)
			throw new UserNotExist(message.User_Not_Exist);
		if (user.getUserRole().equals("admin")) {
			List<Object[]> userList = userRepository.inactiveUser();
			long inactiveUser = userList.stream().collect(Collectors.counting());
			return new Response(Integer.parseInt(environment.getProperty("success.code")),
					"Inactive User : " + inactiveUser + " ", userList);
		}
		throw new PermissionDeniedError(message.Permission_Denied);
	}

	@Override
	public Response getTotalOnlineUser(String token) {
		String userName = jwtToken.getToken(token);
		UserEntity user = userRepository.findByUserName(userName);
		if (user == null)
			throw new UserNotExist(message.User_Not_Exist);
		if (user.getUserRole().equals("admin")) {
			List<Object[]> userList = userRepository.onlineUser();
			long onlineUser = userList.stream().collect(Collectors.counting());
			return new Response(Integer.parseInt(environment.getProperty("success.code")),
					"Online User : " + onlineUser + " ", userList);
		}
		throw new PermissionDeniedError(message.Permission_Denied);
	}

	@Override
	public Response getLatestFourRegisterUser(String token) {
		// TODO Auto-generated method stub
		return null;
	}
}

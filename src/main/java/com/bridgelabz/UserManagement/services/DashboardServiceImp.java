package com.bridgelabz.UserManagement.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.bridgelabz.UserManagement.Utility.JwtToken;
import com.bridgelabz.UserManagement.dto.UserDto;
import com.bridgelabz.UserManagement.exception.PermissionDeniedError;
import com.bridgelabz.UserManagement.exception.UserNotExist;
import com.bridgelabz.UserManagement.message.MessageInfo;
import com.bridgelabz.UserManagement.model.UserEntity;
import com.bridgelabz.UserManagement.repository.UserRepository;
import com.bridgelabz.UserManagement.response.Response;

/**
 * @author Tejashree Surve
 * @Purpose : This is Service Method for DashboardServiceImp.
 */
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

	@Autowired
	private ModelMapper mapper;

	// to get total number of User with User List only for Admin User
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

	// to get total number of Active User with User List only for Admin User
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

	// to get total number of Inactive User with User List only for Admin User
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

	// to get total number of Online User with User List only for Admin User
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

	// to get latest four register User from User List only for Admin User
	@Override
	public Response getLatestFourRegisterUser(String token) {
		String userName = jwtToken.getToken(token);
		UserEntity user = userRepository.findByUserName(userName);
		if (user == null)
			throw new UserNotExist(message.User_Not_Exist);
		if (user.getUserRole().equals("admin")) {
			List<Object[]> list = userRepository.latestRegisterList();
			Object[] topThreeList = new Object[4];
			for (int i = 0; i < 4; i++) {
				topThreeList[i] = list.get(i);
			}
			return new Response(Integer.parseInt(environment.getProperty("success.code")), "Latest Registration",
					topThreeList);
		}
		throw new PermissionDeniedError(message.Permission_Denied);
	}

	// to get User Registration List from User List only for Admin User
	@Override
	public Response getLatestRegisterList(String token) {
		String userName = jwtToken.getToken(token);
		UserEntity user = userRepository.findByUserName(userName);
		if (user == null)
			throw new UserNotExist(message.User_Not_Exist);
		if (user.getUserRole().equals("admin")) {
			return new Response(Integer.parseInt(environment.getProperty("success.code")), "Latest Registration List",
					userRepository.latestRegisterList());
		}
		throw new PermissionDeniedError(message.Permission_Denied);
	}

	// to get All time Top Location List only for Admin User
	@Override
	public Response getAllTimeTopLocationList(String token) {
		String userName = jwtToken.getToken(token);
		UserEntity user = userRepository.findByUserName(userName);
		if (user == null)
			throw new UserNotExist(message.User_Not_Exist);
		if (user.getUserRole().equals("admin")) {
			return new Response(Integer.parseInt(environment.getProperty("success.code")), "Top Location List",
					userRepository.topLocationDesc());
			/*
			 * return new
			 * Response(Integer.parseInt(environment.getProperty("success.code")),
			 * "Top Location List", userRepository.topLocationDesc());
			 */
		}
		throw new PermissionDeniedError(message.Permission_Denied);

	}

	// to get All time top Three Location List
	@Override
	public Response getAllTimeTopThreeLocationList(String token) {
		String userName = jwtToken.getToken(token);
		UserEntity user = userRepository.findByUserName(userName);
		if (user == null)
			throw new UserNotExist(message.User_Not_Exist);
		if (user.getUserRole().equals("admin")) {
			List<Object[]> list = userRepository.topLocationDesc();
			Object[] topThreeList = new Object[3];
			for (int i = 0; i < 3; i++) {
				topThreeList[i] = list.get(i);
			}
			return new Response(Integer.parseInt(environment.getProperty("success.code")), "Top Location",
					topThreeList);
		}
		throw new PermissionDeniedError(message.Permission_Denied);
	}

	// to get 2020 Location List
	@Override
	public Response getTwoTwentyLocationList(String token) {
		String userName = jwtToken.getToken(token);
		UserEntity user = userRepository.findByUserName(userName);
		if (user == null)
			throw new UserNotExist(message.User_Not_Exist);
		if (user.getUserRole().equals("admin")) {
			return new Response(Integer.parseInt(environment.getProperty("success.code")), "2020 Top Location List",
					userRepository.twentyTwentyLocationList());
		}
		throw new PermissionDeniedError(message.Permission_Denied);
	}

	@Override
	public Response getTwoTwentyThreeLocation(String token) {
		String userName = jwtToken.getToken(token);
		UserEntity user = userRepository.findByUserName(userName);
		if (user == null)
			throw new UserNotExist(message.User_Not_Exist);
		if (user.getUserRole().equals("admin")) {
			List<Object[]> list = userRepository.twentyTwentyLocationList();
			Object[] topThreeList = new Object[3];
			for (int i = 0; i < 3; i++) {
				topThreeList[i] = list.get(i);
			}
			return new Response(Integer.parseInt(environment.getProperty("success.code")), "2020 Top Three Location",
					topThreeList);
		}
		throw new PermissionDeniedError(message.Permission_Denied);
	}

	// to get 2020 April Location list
	@Override
	public Response getAprilLocationList(String token) {
		String userName = jwtToken.getToken(token);
		UserEntity user = userRepository.findByUserName(userName);
		if (user == null)
			throw new UserNotExist(message.User_Not_Exist);
		if (user.getUserRole().equals("admin")) {
			return new Response(Integer.parseInt(environment.getProperty("success.code")), "April Top Location",
					userRepository.aprilLocationList());
		}
		throw new PermissionDeniedError(message.Permission_Denied);
	}

	// to get 2020 April top three location
	@Override
	public Response getAprilThreeLocation(String token) {
		String userName = jwtToken.getToken(token);
		UserEntity user = userRepository.findByUserName(userName);
		if (user == null)
			throw new UserNotExist(message.User_Not_Exist);
		if (user.getUserRole().equals("admin")) {
			List<Object[]> list = userRepository.aprilLocationList();
			Object[] topThreeList = new Object[3];
			for (int i = 0; i < 3; i++) {
				topThreeList[i] = list.get(i);
			}
			return new Response(Integer.parseInt(environment.getProperty("success.code")), "April Three Top Location",
					topThreeList);
		}
		throw new PermissionDeniedError(message.Permission_Denied);
	}

	// to get All time Gender percentage
	@Override
	public Response getAllTimeGender(String token) {
		String userName = jwtToken.getToken(token);
		UserEntity user = userRepository.findByUserName(userName);
		if (user == null)
			throw new UserNotExist(message.User_Not_Exist);
		if (user.getUserRole().equals("admin")) {
			return new Response(Integer.parseInt(environment.getProperty("success.code")), "April Three Top Location",
					userRepository.allTimeGender());
		}
		throw new PermissionDeniedError(message.Permission_Denied);
	}

	// to get 2020 Gender Percentage
	@Override
	public Response getTwoTwentyGender(String token) {
		String userName = jwtToken.getToken(token);
		UserEntity user = userRepository.findByUserName(userName);
		if (user == null)
			throw new UserNotExist(message.User_Not_Exist);
		if (user.getUserRole().equals("admin")) {
			return new Response(Integer.parseInt(environment.getProperty("success.code")), "April Three Top Location",
					userRepository.twentyTwentyGender());
		}
		throw new PermissionDeniedError(message.Permission_Denied);
	}

	// to get 2020 April Gender Percentage
	@Override
	public Response getAprilGender(String token) {
		String userName = jwtToken.getToken(token);
		UserEntity user = userRepository.findByUserName(userName);
		if (user == null)
			throw new UserNotExist(message.User_Not_Exist);
		if (user.getUserRole().equals("admin")) {
			return new Response(Integer.parseInt(environment.getProperty("success.code")), "April Three Top Location",
					userRepository.aprilGender());
		}
		throw new PermissionDeniedError(message.Permission_Denied);
	}

	// to edit user details by admin user
	@Override
	public Response editUserByAdmin(String token, int id, UserDto userDto) {
		String userName = jwtToken.getToken(token);
		UserEntity user = userRepository.findByUserName(userName);
		if (user == null)
			throw new UserNotExist(message.User_Not_Exist);
		if (user.getUserRole().equals("admin")) {
			UserEntity userExist = userRepository.findById(id)
					.orElseThrow(() -> new UserNotExist(message.User_Not_Exist));
			userExist = mapper.map(userDto, UserEntity.class);
			userRepository.save(userExist);
			return new Response(Integer.parseInt(environment.getProperty("success.code")),
					environment.getProperty("update.profileDetail"), message.Updated_Profile);
		}
		throw new PermissionDeniedError(message.Permission_Denied);
	}

	// to delete user by admin user
	@Override
	public Response deleteUserByAdmin(String token, int id) {
		String userName = jwtToken.getToken(token);
		UserEntity user = userRepository.findByUserName(userName);
		if (user == null)
			throw new UserNotExist(message.User_Not_Exist);
		if (user.getUserRole().equals("admin")) {
			userRepository.findById(id).orElseThrow(() -> new UserNotExist(message.User_Not_Exist));
			userRepository.deleteById(id);
			return new Response(Integer.parseInt(environment.getProperty("success.code")),
					environment.getProperty("delete.user"), message.User_Deleted);
		}
		throw new PermissionDeniedError(message.Permission_Denied);
	}

	// to get All time number of user in specific age group
	@Override
	public Response getAllTimeAgeGroup(String token) {
		String userName = jwtToken.getToken(token);
		UserEntity user = userRepository.findByUserName(userName);
		if (user == null)
			throw new UserNotExist(message.User_Not_Exist);
		if (user.getUserRole().equals("admin")) {
			return new Response(Integer.parseInt(environment.getProperty("success.code")), "Age Group",
					userRepository.allTimeAgeGroup());
		}
		throw new PermissionDeniedError(message.Permission_Denied);
	}
	
	// to get 2020 number of user in specific age group
	@Override
	public Response getTwentyTwentyAgeGroup(String token) {
		String userName = jwtToken.getToken(token);
		UserEntity user = userRepository.findByUserName(userName);
		if (user == null)
			throw new UserNotExist(message.User_Not_Exist);
		if (user.getUserRole().equals("admin")) {
			return new Response(Integer.parseInt(environment.getProperty("success.code")), "Age Group",
					userRepository.twentyTwentyAgeGroup());
		}
		throw new PermissionDeniedError(message.Permission_Denied);
	}
	
	// to get 2020 April number of user in specific age group
	@Override
	public Response getAprilAgeGroup(String token) {
		String userName = jwtToken.getToken(token);
		UserEntity user = userRepository.findByUserName(userName);
		if (user == null)
			throw new UserNotExist(message.User_Not_Exist);
		if (user.getUserRole().equals("admin")) {
			return new Response(Integer.parseInt(environment.getProperty("success.code")), "Age Group",
					userRepository.aprilAgeGroup());
		}
		throw new PermissionDeniedError(message.Permission_Denied);
	}
}

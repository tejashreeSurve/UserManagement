package com.bridgelabz.UserManagement.services;

import com.bridgelabz.UserManagement.dto.UserDto;
import com.bridgelabz.UserManagement.response.Response;

/**
 * @author Tejashree Surve
 * @Purpose : This is IDashboardServices Interface which contains every method
 *          of services class.
 */
public interface IDashboardServices {

	// get user list
	Response getTotalUserList(String token);

	// get active user list
	Response getTotalActiveUser(String token);

	// get inactive user list
	Response getTotalInactiveUser(String token);

	// get online user list
	Response getTotalOnlineUser(String token);

	// get latest four register user
	Response getLatestFourRegisterUser(String token);

	// get latest register user list
	Response getLatestRegisterList(String token);

	// get all time top location user list
	Response getAllTimeTopLocationList(String token);

	// get all time top three location user
	Response getAllTimeTopThreeLocationList(String token);

	// get 2020 location list
	Response getTwoTwentyLocationList(String token);

	// get 2020 top three location user
	Response getTwoTwentyThreeLocation(String token);

	// get 2020 april location list
	Response getAprilLocationList(String token);

	// get 2020 april top three location
	Response getAprilThreeLocation(String token);

	// get all time gender
	Response getAllTimeGender(String token);

	// get 2020 gender
	Response getTwoTwentyGender(String token);

	// get 2020 april gender
	Response getAprilGender(String token);

	// get all time age group number of user
	Response getAllTimeAgeGroup(String token);

	// get 2020 age group number of user
	Response getTwentyTwentyAgeGroup(String token);

	// get 2020 April age group number of user
	Response getAprilAgeGroup(String token);

	// edit user by admin user
	Response editUserByAdmin(String token, int id, UserDto userDto);

	// delete user by admin user
	Response deleteUserByAdmin(String token, int id);
}

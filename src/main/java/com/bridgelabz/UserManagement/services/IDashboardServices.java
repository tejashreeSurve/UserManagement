package com.bridgelabz.UserManagement.services;

import com.bridgelabz.UserManagement.response.Response;

public interface IDashboardServices {

	Response getTotalUserList(String token);

	Response getTotalActiveUser(String token);

	Response getTotalInactiveUser(String token);

	Response getTotalOnlineUser(String token);

	Response getLatestFourRegisterUser(String token);
}

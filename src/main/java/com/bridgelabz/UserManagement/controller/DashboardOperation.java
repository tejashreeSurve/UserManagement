package com.bridgelabz.UserManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.UserManagement.response.Response;
import com.bridgelabz.UserManagement.services.IDashboardServices;

/**
 * @author Tejashree Surve
 * @Purpose : Rest Api's Controller for DashboardOperation operation.
 */
@RestController
@RequestMapping("/DashboardOperation")
public class DashboardOperation {

	@Autowired
	IDashboardServices dashboardService;

	// Get Total User List Rest Api
	@GetMapping("/getTotalUserList")
	public ResponseEntity<Response> getTotalUserList(@RequestHeader String token) {
		Response response = dashboardService.getTotalUserList(token);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	// Get Total Active User List Rest Api
	@GetMapping("/getTotalActiveUser")
	public ResponseEntity<Response> getTotalActiveUser(@RequestHeader String token) {
		Response response = dashboardService.getTotalActiveUser(token);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	// Get Total Inactive User List Rest Api
	@GetMapping("/getTotalInactiveUser")
	public ResponseEntity<Response> getTotalInactiveUser(@RequestHeader String token) {
		Response response = dashboardService.getTotalInactiveUser(token);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	// Get Total Online User List Rest Api
	@GetMapping("/getTotalOnlineUser")
	public ResponseEntity<Response> getTotalOnlineUser(@RequestHeader String token) {
		Response response = dashboardService.getTotalOnlineUser(token);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
}

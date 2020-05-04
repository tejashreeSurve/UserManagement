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

	// Get Latest Four Register User List Rest Api
	@GetMapping("/getLatestFourRegisterUser")
	public ResponseEntity<Response> getLatestFourRegisterUser(@RequestHeader String token) {
		Response response = dashboardService.getLatestFourRegisterUser(token);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	// Get Latest Register User List Rest Api
	@GetMapping("/getLatestRegisterList")
	public ResponseEntity<Response> getLatestRegisterList(@RequestHeader String token) {
		Response response = dashboardService.getLatestRegisterList(token);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	// Get All Time Top Location Registration List Rest Api
	@GetMapping("/getAllTimeTopLocationList")
	public ResponseEntity<Response> getAllTimeTopLocationList(@RequestHeader String token) {
		Response response = dashboardService.getAllTimeTopLocationList(token);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	// Get All Time Top Three Location Registration Rest Api
	@GetMapping("/getAllTimeTopThreeLocationList")
	public ResponseEntity<Response> getAllTimeTopThreeLocationList(@RequestHeader String token) {
		Response response = dashboardService.getAllTimeTopThreeLocationList(token);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	// Get Two Twenty Location Registration List Rest Api
	@GetMapping("/getTwoTwentyLocationList")
	public ResponseEntity<Response> getTwoTwentyLocationList(@RequestHeader String token) {
		Response response = dashboardService.getTwoTwentyLocationList(token);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	// Get Two Twenty Three Location Registration Rest Api
	@GetMapping("/getTwoTwentyThreeLocation")
	public ResponseEntity<Response> getTwoTwentyThreeLocation(@RequestHeader String token) {
		Response response = dashboardService.getTwoTwentyThreeLocation(token);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	// Get All Time Gender percentage Rest Api
	@GetMapping("/getAllTimeGender")
	public ResponseEntity<Response> getAllTimeGender(@RequestHeader String token) {
		Response response = dashboardService.getAllTimeGender(token);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	// Get Two Twenty Gender percentage Rest Api
	@GetMapping("/getTwoTwentyGender")
	public ResponseEntity<Response> getTwoTwentyGender(@RequestHeader String token) {
		Response response = dashboardService.getTwoTwentyGender(token);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	// Get April Gender percentage Rest Api
	@GetMapping("/getAprilGender")
	public ResponseEntity<Response> getAprilGender(@RequestHeader String token) {
		Response response = dashboardService.getAprilGender(token);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	// Get All Time Age Group User Rest Api
	@GetMapping("/getAllTimeAgeGroup")
	public ResponseEntity<Response> getAllTimeAgeGroup(@RequestHeader String token) {
		Response response = dashboardService.getAllTimeAgeGroup(token);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	// Get 2020 Age Group User Rest Api
	@GetMapping("/getTwentyTwentyAgeGroup")
	public ResponseEntity<Response> getTwentyTwentyAgeGroup(@RequestHeader String token) {
		Response response = dashboardService.getTwentyTwentyAgeGroup(token);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	// Get 2020 April Age Group User Rest Api
	@GetMapping("/getAprilAgeGroup")
	public ResponseEntity<Response> getAprilAgeGroup(@RequestHeader String token) {
		Response response = dashboardService.getAprilAgeGroup(token);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
}

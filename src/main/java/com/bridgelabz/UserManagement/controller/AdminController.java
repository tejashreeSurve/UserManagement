package com.bridgelabz.UserManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.UserManagement.services.IAdminServices;

/**
 * @author Tejashree Surve
 * @Purpose : Rest Api's Controller for Admin operation.
 */
@RestController
@RequestMapping("/AdminOperation")
public class AdminController {
	
	@Autowired
	IAdminServices adminService;
}

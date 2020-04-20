package com.bridgelabz.UserManagement.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.bridgelabz.UserManagement.message.MessageInfo;

@Component
@Service
@PropertySource("message.properties")
public class AdminServiceImp implements IAdminServices {

	@Autowired
	Environment environment;
	
	@Autowired
	private ModelMapper mapper;

	@Autowired
	private MessageInfo message;
	
	
	

}

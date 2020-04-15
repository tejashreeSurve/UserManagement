package com.bridgelabz.UserManagement.message;

import org.springframework.stereotype.Component;

@Component
public class MessageInfo {
	
	/********************** message for Http status code *********************/

	public String Bad_Request = "400";

	public String Success_Request = "200";

	public String Redirect_Request = "300";
	
	/********************** messages for user ************************/
	
	public String User_Exist = "Please try with other Email-id";
	
	public String User_Added = "User is Added Successfully";
}

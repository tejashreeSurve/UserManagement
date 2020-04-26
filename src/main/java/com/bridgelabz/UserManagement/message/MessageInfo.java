package com.bridgelabz.UserManagement.message;

import org.springframework.stereotype.Component;

/**
 * @author Tejashree Surve
 * @Purpose : This is class which provide message to Response Entity.
 */
@Component
public class MessageInfo {

	/********************** message for Http status code *********************/

	public String Bad_Request = "400";

	public String Success_Request = "200";

	public String Redirect_Request = "300";

	/********************** messages for user ************************/

	public String User_Exist = "Please try with other Email-id";

	public String User_Added = "User is Added Successfully";

	public String Users_List_Not_Exist = "Users List Not Exist";
	
	public String User_Already_Exist = "Username or Email is Already Exist in our Records ";
	
	public String User_Not_Exist = "User Not Exist, Please try with other UserName";

	public String User_Role_Added = "New User Role is Successfully Added";
	
	/********************* message for login/logout **********************/

	public String Incorrect_Confirm_Password = "Please Enter valide Confirm Password";

	public String Invalide_Token = "Invalide Token,Access Denied";
	
	public String Token_For_ForgetPassword = "You can Reset your Password Successfully";
	
	public String Update_Password = "User Password is Updated Successfully";
	
	public String Email_Not_Verified = "Email is Not Verify";
	
	public String Verified_User = "You can logged in Successfully";
	
	public String Incorrect_Password = "Password is Incorrect";
	
	public String Login_Exception = "Invalide Username or Password";

	public String Login_Out = "Successfully Logged-out";
	
	/******************** message for Profile-Pic *******************/

	public String File_Is_Empty = "Profile Pic is not Selected";

	public String Profile_Not_Uploaded = "Profile Pic is not uploaded";

	public String Profile_Uploaded = "Profile Pic Uploaded Successfully";
	
	public String Permission = "Permission is provided Successfully";
	
	public String Permission_Already_Provided = "Permission for this User is Already Provided";
	
	public String Updated_Profile = "User Profile Details is Updated Successfully";
	
	public String Permission_Denied = "Permission Denied for User to perform this Action";
}

package com.bridgelabz.UserManagement.services;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bridgelabz.UserManagement.Utility.JwtToken;
import com.bridgelabz.UserManagement.Utility.MailSenderService;
import com.bridgelabz.UserManagement.dto.EditUserDto;
import com.bridgelabz.UserManagement.dto.ForgetPasswordDto;
import com.bridgelabz.UserManagement.dto.LoginDto;
import com.bridgelabz.UserManagement.dto.ResetPasswordDto;
import com.bridgelabz.UserManagement.dto.UserDto;
import com.bridgelabz.UserManagement.exception.FileIsEmpty;
import com.bridgelabz.UserManagement.exception.IncorrectPassword;
import com.bridgelabz.UserManagement.exception.InvalideUser;
import com.bridgelabz.UserManagement.exception.InvlideLogin;
import com.bridgelabz.UserManagement.exception.PermissionAlreadyProvided;
import com.bridgelabz.UserManagement.exception.PermissionDeniedError;
import com.bridgelabz.UserManagement.exception.ProfilePicNotUploaded;
import com.bridgelabz.UserManagement.exception.UserAlreadyExsist;
import com.bridgelabz.UserManagement.exception.UserNotExist;
import com.bridgelabz.UserManagement.message.MessageBody;
import com.bridgelabz.UserManagement.message.MessageInfo;
import com.bridgelabz.UserManagement.model.PermissionsEntity;
import com.bridgelabz.UserManagement.model.UserEntity;
import com.bridgelabz.UserManagement.repository.PermissionsRepository;
import com.bridgelabz.UserManagement.repository.UserRepository;
import com.bridgelabz.UserManagement.response.Response;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Component
@Service
@PropertySource("message.properties")
public class UserServiceImp implements IUserServices {

	@Autowired
	Environment environment;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PermissionsRepository permissionRepository;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private MessageInfo message;

	@Autowired
	private JwtToken jwtToken;

	@Autowired
	private MessageBody messageBody;

	SimpleMailMessage simpleMailMessage;

	@Autowired
	MailSenderService mailSenderService;

	@Override
	public Response login(LoginDto loginDto) {
		UserEntity user = userRepository.findByUserName(loginDto.getUserName());
		if (user == null)
			throw new InvlideLogin(message.Login_Exception);
		String token = jwtToken.generateToken(user.getUserName());
		System.out.println("USEREMAIL :--     " + token);
		user.setToken(token);
		if (user.isValidate()) {
			if ((user.getUserPassword()).equals(loginDto.getUserPassword())) {
				DateFormat dateFormat = new SimpleDateFormat("MMM dd yyyy hh:mm aa");
				String dateString = dateFormat.format(new Date()).toString();
				user.setLatestLoginTime(dateString);
				user.setUserStatus("Active");
				userRepository.save(user);
				return new Response(Integer.parseInt(environment.getProperty("success.code")),
						environment.getProperty("login.Success"), token);
			}
			throw new IncorrectPassword(message.Incorrect_Password);
		}
		throw new InvalideUser(message.Email_Not_Verified);
	}

	@Override
	public Response logout(String token) {
		String userName = jwtToken.getToken(token);
		UserEntity user = userRepository.findByUserName(userName);
		if (user == null)
			throw new UserNotExist(message.User_Not_Exist);
		user.setLogoutStatus(true);
		userRepository.save(user);
		return new Response(Integer.parseInt(environment.getProperty("success.code")),
				environment.getProperty("login.out"), message.Login_Out);
	}

	@Override
	public Response forgetPassword(ForgetPasswordDto forgetPasswordDto) {
		UserEntity user = userRepository.findByEmail(forgetPasswordDto.getEmail());
		if (user == null)
			throw new UserNotExist(message.User_Not_Exist);
		if (user.isValidate()) {
			String token = jwtToken.generateToken(user.getUserName());
			System.out.println("FROGETPASSWORD TOKEN :----          " + token);
			simpleMailMessage = messageBody.passwordReset(user.getEmail(), user.getFirstName(), token);
			mailSenderService.sendEmail(simpleMailMessage);
			return new Response(Integer.parseInt(environment.getProperty("success.code")),
					environment.getProperty("token.send"), message.Token_For_ForgetPassword);
		}
		throw new InvalideUser(message.Email_Not_Verified);
	}

	@Override
	public Response resetPassword(String token, ResetPasswordDto resetPasswordDto) {
		String userName = jwtToken.getToken(token);
		UserEntity user = userRepository.findByUserName(userName);
		if (user == null)
			throw new UserNotExist(message.User_Not_Exist);
		if (resetPasswordDto.getUserPassword().equals(resetPasswordDto.getConfirmPassword())) {
			user.setUserPassword(resetPasswordDto.getUserPassword());
			user.setConfirmPassword(resetPasswordDto.getConfirmPassword());
			userRepository.save(user);
			return new Response(Integer.parseInt(environment.getProperty("success.code")),
					environment.getProperty("reset.password"), message.Update_Password);
		}
		throw new IncorrectPassword(message.Incorrect_Password);
	}

	@Override
	public Response newUser(UserDto userDto) {
		UserEntity userName = userRepository.findByUserName(userDto.getUserName());
		UserEntity userEmail = userRepository.findByEmail(userDto.getEmail());
		if (userName != null || userEmail != null)
			throw new UserAlreadyExsist(message.User_Already_Exist);
		if (!(userDto.getConfirmPassword()).equals(userDto.getUserPassword()))
			throw new IncorrectPassword(message.Incorrect_Confirm_Password);
		UserEntity userEntity = mapper.map(userDto, UserEntity.class);
		String token = jwtToken.generateToken(userDto.getUserName());
		System.out.println("USER TOKEN:-      " + token);
		userEntity.setToken(token);
		simpleMailMessage = messageBody.verifyMail(userDto.getEmail(), userDto.getFirstName(), token);
		mailSenderService.sendEmail(simpleMailMessage);
		userRepository.save(userEntity);
		return new Response(Integer.parseInt(environment.getProperty("success.code")),
				environment.getProperty("user.added"), token);
	}

	@Override
	public Response addPermissions(String token) {
		String user = jwtToken.getToken(token);
		UserEntity userEntity = userRepository.findByUserName(user);
		if (userEntity == null)
			throw new UserNotExist(message.User_Not_Exist);
		PermissionsEntity userPermission = new PermissionsEntity();
		if (userEntity.getPermissionsEntity() != null)
			throw new PermissionAlreadyProvided(message.Permission_Already_Provided);
		if (userEntity.getUserRole().equals("admin")) {
			userPermission.setAddInDashboard(true);
			userPermission.setDeleteInDashboard(true);
			userPermission.setModifyInDashboard(true);
			userPermission.setReadInDashboard(true);
			userPermission.setAddInUserInfo(true);
			userPermission.setDeleteInUserInfo(true);
			userPermission.setModifyInUserInfo(true);
			userPermission.setReadInUserInfo(true);
			userPermission.setUserEntity(userEntity);
			permissionRepository.save(userPermission);
			return new Response(Integer.parseInt(environment.getProperty("success.code")),
					environment.getProperty("permission"), message.Permission);
		} else {
			userPermission.setAddInUserInfo(true);
			userPermission.setModifyInUserInfo(true);
			userPermission.setUserEntity(userEntity);
			permissionRepository.save(userPermission);
			return new Response(Integer.parseInt(environment.getProperty("success.code")),
					environment.getProperty("permission"), message.Permission);
		}
	}

	@Override
	public Response getUserProfileDetail(String token) {
		String userName = jwtToken.getToken(token);
		UserEntity user = userRepository.findByUserName(userName);
		if (user == null)
			throw new UserNotExist(message.User_Not_Exist);
		return new Response(Integer.parseInt(environment.getProperty("success.code")),
				environment.getProperty("profile.displayed"), userRepository.userDetails(userName));
	}

	@Override
	public Response editUserProfile(String token, EditUserDto editUserDto) {
		String userName = jwtToken.getToken(token);
		UserEntity user = userRepository.findByUserName(userName);
		if (user == null)
			throw new UserNotExist(message.User_Not_Exist);
		user.setFirstName(editUserDto.getFirstName());
		user.setMiddleName(editUserDto.getMiddleName());
		user.setLastName(editUserDto.getLastName());
		user.setAddress(editUserDto.getAddress());
		user.setBirthDate(editUserDto.getBirthDate());
		user.setCountry(editUserDto.getCountry());
		user.setPhoneNumber(editUserDto.getPhoneNumber());
		userRepository.save(user);
		return new Response(Integer.parseInt(environment.getProperty("success.code")),
				environment.getProperty("update.profileDetail"), message.Updated_Profile);
	}

	@Override
	public Response validateUser(String token) {
		String userName = jwtToken.getToken(token);
		UserEntity user = userRepository.findByUserName(userName);
		if (user == null)
			throw new UserNotExist(message.User_Not_Exist);
		user.setValidate(true);
		userRepository.save(user);
		return new Response(Integer.parseInt(environment.getProperty("success.code")),
				environment.getProperty("verified.email"), message.Verified_User);
	}

	@Override
	public Response getUserList() {
		List<Object[]> userList = userRepository.userList();
		if (userList == null)
			throw new UserNotExist(message.Users_List_Not_Exist);
		return new Response(Integer.parseInt(environment.getProperty("success.code")),
				environment.getProperty("user.list"), userList);
	}

	@Override
	public Response addProfilePic(String token, MultipartFile profileImage) {
		String userName = jwtToken.getToken(token);
		UserEntity user = userRepository.findByUserName(userName);
		// check whether user is present or not
		if (user == null)
			throw new UserNotExist(message.User_Not_Exist);
		// file is not selected to upload
		if (profileImage.isEmpty())
			throw new FileIsEmpty(message.File_Is_Empty);
		File uploadFile = new File(profileImage.getOriginalFilename());
		try {
			BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(uploadFile));
			try {
				outputStream.write(profileImage.getBytes());
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		// set all cloudinary properties
		Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap("cloud_name", "duquns9m9", "api_key",
				"691264649257271", "api_secret", "mRFRpme5AAqej5Ktef3GYVSzWtI"));
		Map<?, ?> uploadProfile;

		try {
			// this upload the image on cloudinary
			uploadProfile = cloudinary.uploader().upload(uploadFile, ObjectUtils.emptyMap());
		} catch (IOException e) {
			throw new ProfilePicNotUploaded(message.Profile_Not_Uploaded);
		}
		// set the profile-pic url in userDetail table
		user.setProfilePic(uploadProfile.get("secure_url").toString());
		userRepository.save(user);
		return new Response(Integer.parseInt(environment.getProperty("success.code")),
				environment.getProperty("upload.profilepic"), message.Profile_Uploaded);
	}

	@Override
	public Response addNewUserByUser(String token, UserDto userDto) {
		String user = jwtToken.getToken(token);
		UserEntity userEntity = userRepository.findByUserName(user);
		if (userEntity == null)
			throw new UserNotExist(message.User_Not_Exist);
		if (userEntity.isValidate()) {
			if (userEntity.getPermissionsEntity().isAddInUserInfo()) {
				UserEntity userName = userRepository.findByUserName(userDto.getUserName());
				UserEntity userEmail = userRepository.findByEmail(userDto.getEmail());
				if (userName != null || userEmail != null)
					throw new UserAlreadyExsist(message.User_Already_Exist);
				if (!(userDto.getConfirmPassword()).equals(userDto.getUserPassword()))
					throw new IncorrectPassword(message.Incorrect_Confirm_Password);
				UserEntity adduserEntity = mapper.map(userDto, UserEntity.class);
				String userToken = jwtToken.generateToken(userDto.getUserName());
				System.out.println("USER TOKEN:-      " + userToken);
				userEntity.setToken(userToken);
				simpleMailMessage = messageBody.verifyMail(userDto.getEmail(), userDto.getFirstName(), userToken);
				mailSenderService.sendEmail(simpleMailMessage);
				userRepository.save(adduserEntity);
				return new Response(Integer.parseInt(environment.getProperty("success.code")),
						environment.getProperty("user.added"), userToken);
			}
			throw new PermissionDeniedError(message.Permission_Denied);
		}
		throw new InvalideUser(message.Email_Not_Verified);
	}
}
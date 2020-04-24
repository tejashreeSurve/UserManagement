package com.bridgelabz.UserManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bridgelabz.UserManagement.model.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
	
	public static final String profileDetail = "select first_name,middle_name,last_name,phone_number,profile_pic,gender,latest_login_time,birth_date,country,email,address from user_details where user_name = :username";
	
	@Query(value = profileDetail,nativeQuery = true)
	List<Object[]> userDetails(@Param("username") String userName);

	// find user by email
	UserEntity findByEmail(String email);

	// find user by user name
	UserEntity findByUserName(String userName);
}

package com.bridgelabz.UserManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.UserManagement.model.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{

	// find user by email
	UserEntity findByEmail(String email);
	
	// find user by user name 
	UserEntity findByUserName(String userName);
}

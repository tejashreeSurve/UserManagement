package com.bridgelabz.UserManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.UserManagement.model.UsersEntity;

public interface UserRepository extends JpaRepository<UsersEntity, Integer>{

	// find user by email
	UsersEntity findByEmail(String email);
	
	// find user by user name 
	UsersEntity findByUserName(String userName);
}

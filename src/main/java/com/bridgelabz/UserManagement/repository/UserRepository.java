package com.bridgelabz.UserManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bridgelabz.UserManagement.model.UserEntity;
/**
 * @author Tejashree Surve 
 * @Purpose : This is UserRepository Interface which extends inbuilt JpaRepository.
 */
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

	// Query to select specific column records from table
	public static final String profileDetail = "select first_name,middle_name,last_name,phone_number,profile_pic,gender,latest_login_time,birth_date,country,email,address from user_details where user_name = :username";

	// call create procedure from DataBase for User Profile
	@Query(value = profileDetail, nativeQuery = true)
	List<Object[]> userDetails(@Param("username") String userName);

	// call create procedure from DataBase for User List
	@Query(value = "call userList()", nativeQuery = true)
	List<Object[]> userList();

	// call create procedure from DataBase for Active User List
	@Query(value = "call activeUser()", nativeQuery = true)
	List<Object[]> activeUser();

	// call create procedure from DataBase for Inactive User List
	@Query(value = "call inactiveUser()", nativeQuery = true)
	List<Object[]> inactiveUser();

	// call create procedure from DataBase for Online User List
	@Query(value = "call onlineUser()", nativeQuery = true)
	List<Object[]> onlineUser();
	
	// call create procedure from DataBase for Registration User List
	@Query(value = "call latestRegisterList()", nativeQuery = true)
	List<Object[]> latestRegisterList();
	
	// call create procedure from DataBase for as per User Location in Descending order
	@Query(value = "call topLocationDesc()", nativeQuery = true)
	List<Object[]> topLocationDesc();
	
	// call create procedure from DataBase for as per User Location in Ascending order
	@Query(value = "call topLocationAsc()", nativeQuery = true)
	List<Object[]> topLocationAsc();
	
	// call create procedure from DataBase for User Register in 2020 year
	@Query(value = "call twentyTwentyLocationList()", nativeQuery = true)
	List<Object[]> twentyTwentyLocationList();
	
	// call create procedure from DataBase for User Register in 2020 April as per User Location
	@Query(value = "call aprilLocationList()", nativeQuery = true)
	List<Object[]> aprilLocationList();
	
	// call create procedure from DataBase for getting Gender percentage
	@Query(value = "call AllTimeGender()", nativeQuery = true)
	List<Object[]> allTimeGender();
	
	// call create procedure from DataBase for User Register in 2020 April getting Gender percentage
	@Query(value = "call AprilGender()", nativeQuery = true)
	List<Object[]> aprilGender();
	
	// call create procedure from DataBase for User Register in 2020 getting Gender percentage
	@Query(value = "call twentyTwentyGender()", nativeQuery = true)
	List<Object[]> twentyTwentyGender();
	
	// call create procedure from DataBase for All time Age Group 
	@Query(value = "call AllTimeAgeGroup()", nativeQuery = true)
	List<Object[]> allTimeAgeGroup();
	
	// call create procedure from DataBase for 2020 Age Group 
	@Query(value = "call twentyTwentyAgeGroup()", nativeQuery = true)
	List<Object[]> twentyTwentyAgeGroup();
	
	// call create procedure from DataBase for 2020 April Age Group 
	@Query(value = "call aprilAgeGroup()", nativeQuery = true)
	List<Object[]> aprilAgeGroup();
	
	// find user by email
	UserEntity findByEmail(String email);

	// find user by user name
	UserEntity findByUserName(String userName);
}

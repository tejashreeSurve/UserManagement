package com.bridgelabz.UserManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.UserManagement.model.PermissionsEntity;
/**
 * @author Tejashree Surve 
 * @Purpose : This is PermissionsRepository Interface which extends inbuilt JpaRepository.
 */
public interface PermissionsRepository extends JpaRepository<PermissionsEntity, Integer> {

}

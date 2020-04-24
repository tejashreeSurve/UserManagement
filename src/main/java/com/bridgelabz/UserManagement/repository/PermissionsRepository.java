package com.bridgelabz.UserManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.UserManagement.model.PermissionsEntity;

public interface PermissionsRepository extends JpaRepository<PermissionsEntity, Integer> {

}

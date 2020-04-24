package com.bridgelabz.UserManagement.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "permissionDetails")
public class PermissionsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private boolean addInDashboard = false;
	private boolean deleteInDashboard = false;
	private boolean modifyInDashboard = false;
	private boolean readInDashboard = false;
	private boolean addInUserInfo = false;
	private boolean deleteInUserInfo = false;
	private boolean modifyInUserInfo = false;
	private boolean readInUserInfo = false;
	@OneToOne
	@JoinColumn(name = "user_id", nullable = false)
	private UserEntity userEntity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isAddInDashboard() {
		return addInDashboard;
	}

	public void setAddInDashboard(boolean addInDashboard) {
		this.addInDashboard = addInDashboard;
	}

	public boolean isDeleteInDashboard() {
		return deleteInDashboard;
	}

	public void setDeleteInDashboard(boolean deleteInDashboard) {
		this.deleteInDashboard = deleteInDashboard;
	}

	public boolean isModifyInDashboard() {
		return modifyInDashboard;
	}

	public void setModifyInDashboard(boolean modifyInDashboard) {
		this.modifyInDashboard = modifyInDashboard;
	}

	public boolean isReadInDashboard() {
		return readInDashboard;
	}

	public void setReadInDashboard(boolean readInDashboard) {
		this.readInDashboard = readInDashboard;
	}

	public boolean isAddInUserInfo() {
		return addInUserInfo;
	}

	public void setAddInUserInfo(boolean addInUserInfo) {
		this.addInUserInfo = addInUserInfo;
	}

	public boolean isDeleteInUserInfo() {
		return deleteInUserInfo;
	}

	public void setDeleteInUserInfo(boolean deleteInUserInfo) {
		this.deleteInUserInfo = deleteInUserInfo;
	}

	public boolean isModifyInUserInfo() {
		return modifyInUserInfo;
	}

	public void setModifyInUserInfo(boolean modifyInUserInfo) {
		this.modifyInUserInfo = modifyInUserInfo;
	}

	public boolean isReadInUserInfo() {
		return readInUserInfo;
	}

	public void setReadInUserInfo(boolean readInUserInfo) {
		this.readInUserInfo = readInUserInfo;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}
}

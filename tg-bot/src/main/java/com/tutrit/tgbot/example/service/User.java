package com.tutrit.tgbot.example.service;

import com.tutrit.tgbot.example.constants.Role;

import java.util.Objects;

public class User {
	private Role userRole;
	private Long tgId;
	private String tgFirstName;
	private String tgLastName;
	private String tgUserName;

	public User() {
	}

	public Role getUserRole() {
		return userRole;
	}

	public void setUserRole(Role userRole) {
		this.userRole = userRole;
	}

	public Long getTgId() {
		return tgId;
	}

	public void setTgId(Long tgId) {
		this.tgId = tgId;
	}

	public String getTgFirstName() {
		return tgFirstName;
	}

	public void setTgFirstName(String tgFirstName) {
		this.tgFirstName = tgFirstName;
	}

	public String getTgLastName() {
		return tgLastName;
	}

	public void setTgLastName(String tgLastName) {
		this.tgLastName = tgLastName;
	}

	public String getTgUserName() {
		return tgUserName;
	}

	public void setTgUserName(String tgUserName) {
		this.tgUserName = tgUserName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof User)) return false;
		User user = (User) o;
		return getUserRole() == user.getUserRole() && Objects.equals(getTgId(), user.getTgId()) && Objects.equals(getTgFirstName(), user.getTgFirstName()) && Objects.equals(getTgLastName(), user.getTgLastName()) && Objects.equals(getTgUserName(), user.getTgUserName());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getUserRole(), getTgId(), getTgFirstName(), getTgLastName(), getTgUserName());
	}
}

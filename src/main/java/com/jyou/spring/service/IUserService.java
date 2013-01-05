package com.jyou.spring.service;

import java.util.List;

import com.jyou.spring.model.User;

public interface IUserService {
	public List<User> getAllUsers();
	public void addUser(User user);
	public void addUsers(List<User> users);
}

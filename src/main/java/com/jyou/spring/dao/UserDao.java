package com.jyou.spring.dao;

import java.util.List;
import com.jyou.spring.model.User;

public interface UserDao {
	public List<User> getAllUsers();
	public void addUser(User user);
	public void addUsers(List<User> users);
}

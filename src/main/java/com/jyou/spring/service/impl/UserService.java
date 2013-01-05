package com.jyou.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyou.spring.dao.UserDao;
import com.jyou.spring.model.User;
import com.jyou.spring.service.IUserService;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private UserDao userDao;
	
	
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userDao.getAllUsers();
	}


	public void addUser(User user) {
		// TODO Auto-generated method stub
		userDao.addUser(user);
	}


	public void addUsers(List<User> users) {
		// TODO Auto-generated method stub
		userDao.addUsers(users);
	}

}

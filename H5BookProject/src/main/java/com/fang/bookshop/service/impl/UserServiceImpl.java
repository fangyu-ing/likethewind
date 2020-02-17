package com.fang.bookshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fang.bookshop.dao.UserDao;
import com.fang.bookshop.entity.User;
import com.fang.bookshop.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	@Override
	public void addUser(User user) {
		userDao.addUser(user);		
		
	}

	@Override
	public List<User> queryUsers() {
		
		return userDao.queryUsers();
	}

	@Override
	public void editUser(User user) {
		userDao.editUser(user);
		
	}

	@Override
	public List<User> search(String userId) {
		
		return userDao.search(userId);
	}

	@Override
	public void deleteUser(String id) {
		String[] ss = id.split(",");
	    for (String s : ss) {
	        userDao.deleteUser(s);
	    }
		
	}

}

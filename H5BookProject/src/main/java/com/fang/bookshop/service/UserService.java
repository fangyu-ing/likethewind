package com.fang.bookshop.service;

import java.util.List;

import com.fang.bookshop.entity.User;

public interface UserService {

	public void addUser(User user);
	 public List<User> queryUsers();
	 public void editUser(User user);
	 public List<User> search(String userId);
	 public void deleteUser(String id);
}

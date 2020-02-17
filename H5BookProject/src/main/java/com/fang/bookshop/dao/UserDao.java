package com.fang.bookshop.dao;

import java.util.List;

import com.fang.bookshop.entity.User;

public interface UserDao {

	public void addUser(User user);
	 public List<User> queryUsers();
	 public void editUser(User user);
	 public List<User> search(String userId);
	 public void deleteUser(String id);
}

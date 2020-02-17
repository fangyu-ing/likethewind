package com.fang.bookshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fang.bookshop.dao.LoginDao;
import com.fang.bookshop.entity.Login;
import com.fang.bookshop.service.LoginService;
@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private LoginDao loginDao;
	@Override
	public Login login(Login login) {
		
		return loginDao.login(login);
	}

}

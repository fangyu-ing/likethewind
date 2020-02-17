package com.fang.bookshop.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.fang.bookshop.entity.Login;

import com.fang.bookshop.service.LoginService;

@Controller

public class LoginController {
	@Autowired
	private LoginService loginService;
	@RequestMapping("login")
	@ResponseBody
	public Login lendBook(@RequestBody Login login)
			throws Exception {
				return loginService.login(login);  
	}
}

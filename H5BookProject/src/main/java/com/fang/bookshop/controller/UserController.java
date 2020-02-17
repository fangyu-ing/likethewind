package com.fang.bookshop.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.fang.bookshop.entity.User;
import com.fang.bookshop.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserService userService;
	@RequestMapping("addUser")
	@ResponseBody
	public JSONObject addUser(@RequestBody User user)
			throws Exception {
		System.out.println(user.getDept());
		userService.addUser(user); 
		Map<String, String> map=new HashMap<>();
		map.put("a", "成功");
		JSONObject jsonObject=(JSONObject)JSONObject.toJSON(map);
		return jsonObject;
	    
	}
	@RequestMapping("queryUsers")
	@ResponseBody
	public List<User> queryUsers() {
		List<User> users=new ArrayList<>();
		users=userService.queryUsers();
		System.out.println(users.get(0).getAddress());
		return users;
	}
	
	@RequestMapping("editUser")
	@ResponseBody
	public JSONObject editUser(@RequestBody User user)
			throws Exception {
		System.out.println(user.getUserId()+user.getUserName());
		userService.editUser(user); 
		Map<String, String> map=new HashMap<>();
		map.put("a", "成功");
		JSONObject jsonObject=(JSONObject)JSONObject.toJSON(map);
		return jsonObject;
	    
	}
	@RequestMapping("deleteUser")
	@ResponseBody
	public JSONObject deleteUser(String userId) {
		System.out.println("userid"+userId);
		userService.deleteUser(userId);
		Map<String, String> map=new HashMap<>();
		map.put("a", "成功");
		JSONObject jsonObject=(JSONObject)JSONObject.toJSON(map);
		return jsonObject;
}
	
	@RequestMapping("search")
	@ResponseBody
	public List<User> search(String userId) {
		System.out.println(userId);
		return userService.search(userId);
		
}
	
}


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
import com.fang.bookshop.entity.Lend;
import com.fang.bookshop.service.LendService;

@Controller
@RequestMapping("lend")
public class LendController {
	@Autowired
	private LendService lendService;
	@RequestMapping("lendBook")
	@ResponseBody
	public JSONObject lendBook(@RequestBody Lend lend)
			throws Exception {
		String bookId=lend.getBookId();
		int stock=lendService.searchStock(bookId);
		System.out.println(stock);
		Map<String, String> map=new HashMap<>();
		if(stock>0) {
		lendService.lend(lend);
		lendService.updateStock1(bookId);
		map.put("result", "success");
		}
		else {
			map.put("result", "error");
		}
		JSONObject jsonObject=(JSONObject)JSONObject.toJSON(map);
		return jsonObject;
		
	    
	}
	@RequestMapping("queryLends")
	@ResponseBody
	public List<Lend> queryLends() {
		List<Lend> lends=new ArrayList<>();
		lends=lendService.queryLends();
		return lends;
	}
	@RequestMapping("returnBook")
	@ResponseBody
	public JSONObject deleteBook(String bookId,String userId) {
		System.out.println(bookId+userId);
		Lend lend=new Lend();
		lend.setBookId(bookId);
		lend.setUserId(userId);
		lendService.retrun(lend);
		lendService.updateStock2(bookId);
		Map<String, String> map=new HashMap<>();
		map.put("result", "成功");
		JSONObject jsonObject=(JSONObject)JSONObject.toJSON(map);
		return jsonObject;
}
	
	
}


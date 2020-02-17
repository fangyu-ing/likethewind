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
import com.fang.bookshop.entity.Book;
import com.fang.bookshop.service.BookService;

@Controller
@RequestMapping("book")
public class BookController {
	@Autowired
	private BookService bookService;
	@RequestMapping("addBook")
	@ResponseBody
	public JSONObject addBook(@RequestBody Book book)
			throws Exception {
		System.out.println(book.toString());
		bookService.addBook(book); 
		Map<String, String> map=new HashMap<>();
		map.put("a", "成功");
		JSONObject jsonObject=(JSONObject)JSONObject.toJSON(map);
		return jsonObject;
	    
	}
	@RequestMapping("queryBooks")
	@ResponseBody
	public List<Book> queryBooks() {
		List<Book> books=new ArrayList<>();
		books=bookService.queryBooks();
		return books;
	}
	
	@RequestMapping("editBook")
	@ResponseBody
	public JSONObject editBook(@RequestBody Book book)
			throws Exception {
		System.out.println(book.getBookId()+book.getBookName());
		bookService.editBook(book); 
		Map<String, String> map=new HashMap<>();
		map.put("a", "成功");
		JSONObject jsonObject=(JSONObject)JSONObject.toJSON(map);
		return jsonObject;
	    
	}
	@RequestMapping("deleteBook")
	@ResponseBody
	public JSONObject deleteBook(String bookId) {
		System.out.println(bookId);
		bookService.deleteBook(bookId);
		Map<String, String> map=new HashMap<>();
		map.put("a", "成功");
		JSONObject jsonObject=(JSONObject)JSONObject.toJSON(map);
		return jsonObject;
}
	@RequestMapping("searchByType")
	@ResponseBody
	public List<Book> searchByType(String type) {
		return bookService.searchByType(type);
}
	@RequestMapping("search")
	@ResponseBody
	public List<Book> search(String type,String bookName) {
		System.out.println(type+bookName);
		Book book=new Book();
		book.setBookName(bookName);
		book.setType(type);
		return bookService.search(book);
		
}
	
}

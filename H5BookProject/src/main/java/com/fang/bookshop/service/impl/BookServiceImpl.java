package com.fang.bookshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fang.bookshop.dao.BookDao;
import com.fang.bookshop.entity.Book;

import com.fang.bookshop.service.BookService;

@Service
public class BookServiceImpl implements  BookService{
	@Autowired
	private BookDao bookDao;

	public void addBook(Book book) {
		bookDao.addBook(book);
	};

	

	@Override
	public List<Book> queryBooks() {
		
		return bookDao.queryBooks();
	}

	
	

	@Override
	public void editBook(Book book) {
		bookDao.editBook(book);
		
	}

	

	@Override
	public void deleteBook(String id) {
		String[] ss = id.split(",");
	    for (String s : ss) {
	        bookDao.deleteBook(s);
	    }
		
	}



	@Override
	public List<Book> searchByType(String type) {
		
		return bookDao.searchByType(type);
	}



	@Override
	public List<Book> search(Book book) {
		// TODO Auto-generated method stub
		return bookDao.search(book);
	}



	@Override
	public Book queryBookById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}

package com.fang.bookshop.service;

import java.util.List;

import com.fang.bookshop.entity.Book;


public interface BookService {
	public void addBook(Book book);
	
	 public List<Book> queryBooks();
	 public Book queryBookById(int id);
	 public void editBook(Book book);
	 public List<Book> searchByType(String type);
	 public void deleteBook(String id);

	public List<Book> search(Book book);
}

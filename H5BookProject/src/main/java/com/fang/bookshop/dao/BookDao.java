package com.fang.bookshop.dao;

import java.util.List;

import com.fang.bookshop.entity.Book;

public interface BookDao {
 public void addBook(Book book);
 public List<Book> queryBooks();
 public void editBook(Book book);
 public List<Book> searchByType(String type);
 public List<Book> search(Book book);
 public void deleteBook(String id);
}

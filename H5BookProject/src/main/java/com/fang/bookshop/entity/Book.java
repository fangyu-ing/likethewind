package com.fang.bookshop.entity;

import java.io.Serializable;

/**
 * �鼮��Ϣʵ��
 * 
 * @author fangyu
 * @date 2019��3��18��
 *
 */
public class Book implements Serializable{
	private static final long serialVersionUID = -937752014762694647L;
	
	private long bookId;
	private String bookName;
	private String writer;
	private String publisher;
	private double price;;
	private int stock;
	private String type;
	public long getBookId() {
		return bookId;
	}
	public void setBookId(long bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
	

	
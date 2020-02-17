package com.fang.bookshop.entity;

public class Lend {
private String bookId;
private String userId;
private String lendDate;
private String returnDate;
private String isReturn;
public String getBookId() {
	return bookId;
}
public String getUserId() {
	return userId;
}
public String getLendDate() {
	return lendDate;
}
public String getReturnDate() {
	return returnDate;
}
public String getIsReturn() {
	return isReturn;
}
public void setBookId(String bookId) {
	this.bookId = bookId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public void setLendDate(String lendDate) {
	this.lendDate = lendDate;
}
public void setReturnDate(String returnDate) {
	this.returnDate = returnDate;
}
public void setIsReturn(String isReturn) {
	this.isReturn = isReturn;
}
}

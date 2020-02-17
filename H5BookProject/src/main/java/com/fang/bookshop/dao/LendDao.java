package com.fang.bookshop.dao;

import java.util.List;

import com.fang.bookshop.entity.Lend;

public interface LendDao {
public List<Lend> queryLends();
public void lend(Lend lend);
public void retrun(Lend lend);
public int searchStock(String bookId);
public void updateStock1(String bookId);
public void updateStock2(String bookId);
}

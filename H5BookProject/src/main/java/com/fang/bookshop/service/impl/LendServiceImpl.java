package com.fang.bookshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fang.bookshop.dao.LendDao;
import com.fang.bookshop.entity.Lend;
import com.fang.bookshop.service.LendService;
@Service
public class LendServiceImpl implements LendService {
	@Autowired
	private LendDao lendDao;

	@Override
	public List<Lend> queryLends() {
		
		return lendDao.queryLends();
	}


	@Override
	public void lend(Lend lend) {
		lendDao.lend(lend);
		
	}

	@Override
	public void retrun(Lend lend) {
		lendDao.retrun(lend);
		
	}

	@Override
	public int searchStock(String bookId) {
		
		return lendDao.searchStock(bookId);
	}

	@Override
	public void updateStock1(String bookId) {
		lendDao.updateStock1(bookId);
		
	}

	@Override
	public void updateStock2(String bookId) {
		lendDao.updateStock2(bookId);
		
	}

}

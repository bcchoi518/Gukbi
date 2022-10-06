package com.cbc.springSihum.book.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.cbc.springSihum.book.model.dao.BookDAO;
import com.cbc.springSihum.book.model.dto.BookDTO;

@Service
public class BookServiceImpl implements BookService {

	@Inject
	BookDAO bookDao;
	
	@Override
	public List<BookDTO> getSelectAll() {
		return bookDao.getSelectAll();
	}//getSelectAll

	@Override
	public BookDTO getSelectOne(BookDTO paramDto) {
		return bookDao.getSelectOne(paramDto);
	}//getSelectOne

	@Override
	public int setInsert(BookDTO paramDto) {
		return bookDao.setInsert(paramDto);
	}//setInsert

	@Override
	public int setUpdate(BookDTO paramDto) {
		return bookDao.setUpdate(paramDto);
	}//setUpdate

	@Override
	public int setDelete(BookDTO paramDto) {
		return bookDao.setDelete(paramDto);
	}//setDelete
}//BookServiceImpl

package com.cbc.springSihum.book.model.dao;

import java.util.List;

import com.cbc.springSihum.book.model.dto.BookDTO;

public interface BookDAO {
	public List<BookDTO> getSelectAll();
	public BookDTO getSelectOne(BookDTO paramDto);
	public int setInsert(BookDTO paramDto);
	public int setUpdate(BookDTO paramDto);
	public int setDelete(BookDTO paramDto);
}//BookDAO

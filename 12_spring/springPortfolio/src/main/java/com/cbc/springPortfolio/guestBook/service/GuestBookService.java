package com.cbc.springPortfolio.guestBook.service;

import java.util.List;

import com.cbc.springPortfolio.guestBook.model.dto.GuestBookDTO;

public interface GuestBookService {
	public List<GuestBookDTO> getSelectAll(GuestBookDTO paramDto);
	public GuestBookDTO getSelectOne(GuestBookDTO paramDto);
	public int setInsert(GuestBookDTO paramDto);
	public int setUpdate(GuestBookDTO paramDto);
	public int setDelete(GuestBookDTO paramDto);
	public int getTotalRecord(GuestBookDTO paramDto);
}//GuestBookService
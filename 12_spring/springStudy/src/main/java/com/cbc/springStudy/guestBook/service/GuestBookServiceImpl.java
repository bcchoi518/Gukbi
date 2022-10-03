package com.cbc.springStudy.guestBook.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.cbc.springStudy.guestBook.model.dao.GuestBookDAO;
import com.cbc.springStudy.guestBook.model.dto.GuestBookDTO;

@Service
public class GuestBookServiceImpl implements GuestBookService {

	@Inject
	GuestBookDAO guestBookDao;
	
	@Override
	public List<GuestBookDTO> getSelectAll() {
		return guestBookDao.getSelectAll();
	}//getSelectAll

	@Override
	public GuestBookDTO getSelectOne(GuestBookDTO paramDto) {
		return guestBookDao.getSelectOne(paramDto);
	}//getSelectOne

	@Override
	public int setInsert(GuestBookDTO paramDto) {
		return guestBookDao.setInsert(paramDto);
	}//setInsert

	@Override
	public int setUpdate(GuestBookDTO paramDto) {
		return guestBookDao.setUpdate(paramDto);
	}//setUpdate

	@Override
	public int setDelete(GuestBookDTO paramDto) {
		return guestBookDao.setDelete(paramDto);
	}//setDelete
}//GuestBookServiceImpl
